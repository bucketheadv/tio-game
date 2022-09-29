package com.sven.tio.game.tcp.buffer;

import com.google.protobuf.MessageLite;
import com.sven.tio.common.packet.HandlerDataModal;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:43 PM
 */
public interface MessageBuffer<T extends MessageLite> {
	/**
	 * 放入一条数据
	 * @param handlerDataModal 数据
	 * @return
	 */
	boolean offer(HandlerDataModal<T> handlerDataModal);

	/**
	 * 取出一条数据
	 * @return
	 */
	HandlerDataModal<T> poll();

	/**
	 * 队列长度
	 * @return
	 */
	int size();
}
