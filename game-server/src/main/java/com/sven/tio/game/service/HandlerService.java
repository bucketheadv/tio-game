package com.sven.tio.game.service;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import com.google.protobuf.MessageLite;
import com.sven.tio.common.proto.HeartBeatMessage;
import com.sven.tio.game.annotation.HandlerMapping;
import com.sven.tio.game.tcp.handler.MessageHandler;
import com.sven.tio.game.tcp.buffer.MessageBuffer;
import com.sven.tio.game.tcp.buffer.QueueMessageBuffer;
import com.sven.tio.common.packet.HandlerDataModal;
import com.sven.tio.common.util.ClassUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:25 PM
 */
@Slf4j
@Component
public class HandlerService<T extends MessageLite> {
	private final Map<String, MessageHandler<T>> instanceCache = Maps.newConcurrentMap();

	private final MessageBuffer<T> buffer = new QueueMessageBuffer<>();

	private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

	private final ExecutorService executorService;

	@Value("${tio.handler.path}")
	private String tioHandlerPath;

	private final ApplicationContext applicationContext;

	@PostConstruct
	@SuppressWarnings({"unchecked"})
	public void init() {
		try {
			List<Class<?>> classList = ClassUtil.getAllClassBySubClass(MessageHandler.class, tioHandlerPath);
			for (Class<?> clazz : classList) {
				HandlerMapping annotation = clazz.getAnnotation(HandlerMapping.class);
				if (annotation != null) {
					String name = StrUtil.lowerFirst(annotation.value() + "Handler");
					instanceCache.put(annotation.value(), applicationContext.getBean(name, MessageHandler.class));
				}
			}
		} catch (Exception e) {
			log.error("", e);
		}
		doHandler();
	}

	public HandlerService(ApplicationContext applicationContext) {
		executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE, new ThreadFactory() {
			private final AtomicInteger i = new AtomicInteger(0);
			@Override
			public Thread newThread(@NonNull Runnable r) {
				Thread thread = new Thread(r);
				thread.setName("handler-thread-" + i.addAndGet(1));
				return thread;
			}
		});
		this.applicationContext = applicationContext;
	}

	public boolean offer(HandlerDataModal<T> handlerDataModal) {
		return buffer.offer(handlerDataModal);
	}

	private void doHandler() {
		for (int i = 0; i < THREAD_POOL_SIZE; i++) {
			executorService.execute(() -> {
				while (!Thread.currentThread().isInterrupted()) {
					HandlerDataModal<T> handlerDataModal = buffer.poll();
					if (handlerDataModal != null) {
						T messageLite = handlerDataModal.getMessageLite();
						if (messageLite instanceof HeartBeatMessage) {
							log.debug("收到心跳包: {}", handlerDataModal);
						} else {
							log.info("正在处理消息: {}", handlerDataModal);
						}
						MessageHandler<T> handler = getHandlerInstance(messageLite.getClass().getSimpleName());
						if (handler == null) {
							log.info("获取handler: {} 失败", messageLite.getClass().getSimpleName());
							throw new RuntimeException("handler not found");
						}
						handler.handle(messageLite, handlerDataModal.getCtx());
					}
				}
			});
		}
	}

	@PreDestroy
	public void destroy() {
		executorService.shutdown();
	}

	public MessageHandler<T> getHandlerInstance(String name) {
		return instanceCache.get(name);
	}
}
