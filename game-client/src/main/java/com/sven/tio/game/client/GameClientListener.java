package com.sven.tio.game.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.tio.client.intf.TioClientListener;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;

/**
 * @author qinglinl
 * Created on 2022/9/19 3:35 PM
 */
@Slf4j
@Component
public class GameClientListener implements TioClientListener {
	@Override
	public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {

	}

	@Override
	public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {

	}

	@Override
	public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {

	}

	@Override
	public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {

	}

	@Override
	public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {
	}

	@Override
	public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception {

	}
}
