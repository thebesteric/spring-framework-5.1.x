package org.wesoft.spring.proxy.demo.bean;

import org.springframework.cglib.proxy.Proxy;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-13 23:24
 */
public class SessionFactory {

	public static <T> T getMapper(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{clazz}, new MyInvocationHandler());
	}

}
