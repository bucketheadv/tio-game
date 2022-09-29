package com.sven.tio.game.tcp.handler.biz;

import com.sven.tio.common.proto.LoginMessage;
import com.sven.tio.game.annotation.HandlerMapping;
import com.sven.tio.common.packet.MessagePacket;
import com.sven.tio.game.tcp.handler.AbstractMessageHandler;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:36 PM
 */
@Component
@HandlerMapping("LoginMessage")
public class LoginMessageHandler extends AbstractMessageHandler<LoginMessage> {
	@Override
	public void onEvent(LoginMessage loginMessage, ChannelContext ctx) throws Exception {
		LoginMessage backMsg = LoginMessage.newBuilder().setName("Hello").setPassword("World").build();
		Tio.send(ctx, new MessagePacket(backMsg));
	}
}
