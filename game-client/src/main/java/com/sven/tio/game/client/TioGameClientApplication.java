package com.sven.tio.game.client;

import com.sven.tio.common.packet.MessagePacket;
import com.sven.tio.common.proto.LoginMessage;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tio.client.ClientChannelContext;
import org.tio.client.TioClient;
import org.tio.client.TioClientConfig;
import org.tio.client.intf.TioClientHandler;
import org.tio.client.intf.TioClientListener;
import org.tio.core.Node;
import org.tio.core.Tio;

/**
 * @author qinglinl
 * Created on 2022/9/19 3:23 PM
 */
@SpringBootApplication
public class TioGameClientApplication implements CommandLineRunner {
	@Resource
	private TioClientHandler tioClientHandler;
	@Resource
	private TioClientListener tioClientListener;
	@Value("${tio.port}")
	private Integer port;

	@Override
	public void run(String... args) throws Exception {
		TioClientConfig tioClientConfig = new TioClientConfig(tioClientHandler, tioClientListener);
		tioClientConfig.setHeartbeatTimeout(5000);
		TioClient tioClient = new TioClient(tioClientConfig);
		ClientChannelContext clientChannelContext = tioClient.connect(new Node("127.0.0.1", port));
		LoginMessage backMsg = LoginMessage.newBuilder().setName("Abc").setPassword("1234").build();
		Tio.send(clientChannelContext, new MessagePacket(backMsg));
	}

	public static void main(String[] args) {
		SpringApplication.run(TioGameClientApplication.class, args);
	}
}
