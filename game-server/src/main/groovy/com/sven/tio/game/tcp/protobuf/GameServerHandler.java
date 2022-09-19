package com.sven.tio.game.tcp.protobuf;

import com.google.protobuf.MessageLite;
import com.sven.tio.common.protobuf.AbstractProtobufHandler;
import com.sven.tio.common.packet.HandlerDataModal;
import com.sven.tio.game.service.HandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;

/**
 * @author qinglinl
 * Created on 2022/9/19 2:11 PM
 */
@Component
public class GameServerHandler<T extends MessageLite> extends AbstractProtobufHandler {
	@Autowired
	private HandlerService<T> handlerService;
	@Value("${proto.pkg.path}")
	private String protoClassPath;

	@Override
	public String getMessageClassPath() {
		return protoClassPath;
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void doHandler(MessageLite packet, ChannelContext channelContext) throws Exception {
		handlerService.offer(new HandlerDataModal(packet, channelContext));
	}
}
