package com.sven.tio.game.tcp.handler;

import com.sven.tio.common.proto.RegisterRoutMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tio.core.ChannelContext;

/**
 * @author qinglinl
 * Created on 2022/9/19 3:54 PM
 */
@Component
@RequestMapping("RegisterRoutMessage")
public class RegisterRoutMessageHandler extends AbstractDataHandler<RegisterRoutMessage> {
	@Override
	public void onEvent(RegisterRoutMessage registerRoutMessage, ChannelContext ctx) throws Exception {
	}
}
