package com.sven.tio.game.tcp.handler;

import com.google.protobuf.MessageLite;
import org.tio.core.ChannelContext;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:26 PM
 */
public interface DataHandler<T extends MessageLite> {
	/**
	 * 消息处理方法
	 * @param t   消息对象
	 * @param ctx  channel句柄
	 */
	void handle(T t, ChannelContext ctx);
}
