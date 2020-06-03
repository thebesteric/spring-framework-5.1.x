package org.wesoft.spring.cglib;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.wesoft.spring.cglib.AppConfig;
import org.wesoft.spring.cglib.bean.A;

import java.lang.reflect.Method;

/**
 * CGLIB
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-27 00:46
 * @since 1.0
 */
public class CGLIB {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(A.class); // 设置父类
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println("cglib begin");
				Object returnType = methodProxy.invokeSuper(o, objects);
				System.out.println("cglib end");
				return returnType;
			}
		});
		A proxy = (A) enhancer.create();
		proxy.print();
	}
}
