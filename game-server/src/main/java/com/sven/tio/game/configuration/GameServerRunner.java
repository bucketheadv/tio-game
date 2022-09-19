package com.sven.tio.game.configuration;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.tio.server.TioServer;

/**
 * @author qinglinl
 * Created on 2022/9/19 2:48 PM
 */
@Component
public class GameServerRunner implements CommandLineRunner {
	@Resource
	private TioServer tioServer;
	@Value("${tio.port}")
	private Integer port;

	@Override
	public void run(String... args) throws Exception {
		tioServer.start("0.0.0.0", port);
	}
}
