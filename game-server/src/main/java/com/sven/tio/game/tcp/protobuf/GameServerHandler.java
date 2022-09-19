package com.sven.tio.game.tcp.protobuf;

import com.google.protobuf.MessageLite;
import com.sven.tio.common.packet.MessagePacket;
import com.sven.tio.common.proto.ServerBusyMessage;
import com.sven.tio.common.protobuf.AbstractProtobufHandler;
import com.sven.tio.common.packet.HandlerDataModal;
import com.sven.tio.game.service.HandlerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;

/**
 * @author qinglinl
 * Created on 2022/9/19 2:11 PM
 */
@Component
public class GameServerHandler<T extends MessageLite> extends AbstractProtobufHandler {
	private final HandlerService<T> handlerService;
	@Value("${proto.pkg.path}")
	private String protoClassPath;

	public GameServerHandler(HandlerService<T> handlerService) {
		this.handlerService = handlerService;
	}

	@Override
	public String getMessageClassPath() {
		return protoClassPath;
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void doHandler(MessageLite packet, ChannelContext channelContext) throws Exception {
		boolean success = handlerService.offer(new HandlerDataModal(packet, channelContext));
		if (!success) {
			ServerBusyMessage serverBusyMessage = ServerBusyMessage.newBuilder()
					.setMessage("服务器繁忙，请稍后重试!!")
					.build();
			Tio.send(channelContext, new MessagePacket(serverBusyMessage));
		}
	}
}
