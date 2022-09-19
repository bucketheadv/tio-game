package com.sven.tio.common.packet;

import com.google.protobuf.MessageLite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tio.core.ChannelContext;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:44 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandlerDataModal<T extends MessageLite> {
	private T messageLite;

	private ChannelContext ctx;
}
