package com.sven.tio.common.packet;

import com.google.protobuf.MessageLite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.tio.core.intf.Packet;

/**
 * @author qinglinl
 * Created on 2022/9/19 1:38 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MessagePacket extends Packet {
	private static final long serialVersionUID = 2882423146949127826L;

	private MessageLite messageLite;

	public Class<?> getMessageClass() {
		return messageLite.getClass();
	}
}
