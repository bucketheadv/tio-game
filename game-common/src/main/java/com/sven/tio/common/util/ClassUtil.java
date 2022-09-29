package com.sven.tio.common.util;

import org.nutz.lang.*;
import org.nutz.resource.Scans;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qinglinl
 * Created on 2022/9/19 2:11 PM
 */
public class ClassUtil {
	/**
	 * 获取一个接口或者父类的所有子类(不含接口和抽象类)
	 *
	 * @param clazz     接口类或者父类
	 * @param findInJar 是否需要从jar包中查找
	 * @param packages  限定寻找的包名，前缀匹配模式 findInJar为true时建议一定要限制包名提升速度和避免出错！
	 * @return
	 */
	public static List<Class<?>> getAllClassBySubClass(Class<?> clazz, String... packages) {
		return getClasspathAllClass(packages).stream().filter(c -> !c.isInterface()).filter(c -> !Modifier.isAbstract(c.getModifiers())).filter(c -> clazz.isAssignableFrom(c)).collect(Collectors.toList());
	}

	/**
	 * 获取所有classpath下所有全限定名以packages开头的的class
	 *
	 * @return
	 */
	private static List<Class<?>> getClasspathAllClass(String... packages) {
		List<Class<?>> classes = new ArrayList<>();
		Scans scans = Scans.me();
		Lang.each(packages, (Each<String>) (index, pkg, length) -> classes.addAll(scans.scanPackage(pkg)));
		return classes;
	}
}
