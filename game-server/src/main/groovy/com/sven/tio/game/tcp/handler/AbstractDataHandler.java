package com.sven.tio.game.tcp.handler;

import com.google.protobuf.MessageLite;
import lombok.extern.slf4j.Slf4j;
import org.tio.core.ChannelContext;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:28 PM
 */
@Slf4j
public abstract class AbstractDataHandler<T extends MessageLite> implements DataHandler<T> {
	@Override
	public void handle(T t, ChannelContext ctx) {
		try {
			onEvent(t, ctx);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	abstract public void onEvent(T t, ChannelContext ctx) throws Exception;
}
