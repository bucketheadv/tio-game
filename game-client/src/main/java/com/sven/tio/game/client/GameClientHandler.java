package com.sven.tio.game.client;

import com.google.protobuf.MessageLite;
import com.sven.tio.common.packet.MessagePacket;
import com.sven.tio.common.proto.HeartBeatMessage;
import com.sven.tio.common.protobuf.AbstractProtobufHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tio.client.intf.TioClientHandler;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;

/**
 * @author qinglinl
 * Created on 2022/9/19 3:24 PM
 */
@Slf4j
@Component
public class GameClientHandler extends AbstractProtobufHandler implements TioClientHandler {
	@Value("${proto.pkg.path}")
	private String protoClassPath;

	@Override
	public Packet heartbeatPacket(ChannelContext channelContext) {
		HeartBeatMessage backMsg = HeartBeatMessage.newBuilder().setMessage("ping").build();
		return new MessagePacket(backMsg);
	}

	@Override
	public String getMessageClassPath() {
		return protoClassPath;
	}

	@Override
	public void doHandler(MessageLite packet, ChannelContext channelContext) throws Exception {
		log.info("处理消息: {}", packet.toByteString().toStringUtf8().replace("\n", ""));
	}
}
