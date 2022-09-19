package com.sven.tio.game.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tio.server.TioServer;
import org.tio.server.TioServerConfig;
import org.tio.server.intf.TioServerHandler;
import org.tio.server.intf.TioServerListener;

/**
 * @author qinglinl
 * Created on 2022/9/19 2:46 PM
 */
@Configuration
public class GameServerAutoConfiguration {
	@Value("${spring.application.name:tio-game}")
	private String appName;

	@Bean
	public TioServerConfig tioServerConfig(TioServerHandler tioServerHandler,
										   TioServerListener tioServerListener) {
		TioServerConfig tioServerConfig = new TioServerConfig(appName, tioServerHandler, tioServerListener);
		tioServerConfig.setHeartbeatTimeout(5000);
		return tioServerConfig;
	}

	@Bean
	public TioServer tioServer(TioServerConfig tioServerConfig) {
		return new TioServer(tioServerConfig);
	}
}
