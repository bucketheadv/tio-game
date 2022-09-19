package com.sven.tio.game.tcp.handler;

import com.sven.tio.common.proto.HeartBeatMessage;
import com.sven.tio.game.annotation.HandlerMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;

/**
 * @author qinglinl
 * Created on 2022/9/19 3:51 PM
 */
@Slf4j
@Component
@HandlerMapping("HeartBeatMessage")
public class HeartBeatMessageHandler extends AbstractDataHandler<HeartBeatMessage> {
	@Override
	public void onEvent(HeartBeatMessage heartBeatMessage, ChannelContext ctx) throws Exception {
		log.debug("心跳消息: {}", heartBeatMessage.getMessage());
	}
}
