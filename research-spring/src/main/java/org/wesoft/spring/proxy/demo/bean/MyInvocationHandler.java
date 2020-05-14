package org.wesoft.spring.proxy.demo.bean;


import org.springframework.cglib.proxy.InvocationHandler;
import org.wesoft.spring.proxy.demo.anno.Select;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-13 23:27
 */
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
		System.out.println("db connection...");
		Select annotation = method.getAnnotation(Select.class);
		String sql = annotation.value();
		System.out.println("execute sql: " + sql);
		Class<?> returnType = method.getReturnType();
		return null;
	}
}
