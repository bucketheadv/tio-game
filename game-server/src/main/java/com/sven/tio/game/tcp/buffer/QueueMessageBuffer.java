package com.sven.tio.game.tcp.buffer;

import com.google.protobuf.MessageLite;
import com.sven.tio.common.packet.HandlerDataModal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:45 PM
 */
public class QueueMessageBuffer<T extends MessageLite> implements MessageBuffer<T> {
	private static final int MAX_LENGTH = 5000;

	private final BlockingQueue<HandlerDataModal<T>> queue = new LinkedBlockingQueue<>();

	@Override
	public boolean offer(HandlerDataModal<T> handlerDataModal) {
		if (queue.size() >= MAX_LENGTH) {
			return false;
		}
		return queue.offer(handlerDataModal);
	}

	@Override
	public HandlerDataModal<T> poll() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int size() {
		return queue.size();
	}
}
