package com.sven.tio.game.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandlerMapping {
	/**
	 * 消息类型的名字 即protobuf idl文件里的message类型
	 */
	String value();
}
