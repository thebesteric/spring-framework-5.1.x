package org.wesoft.spring.aop.bean;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

import java.util.function.Supplier;

/**
 * CglibUtils
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-29 16:58
 * @since 1.0
 */
public class CglibUtils {

	public static Object getProxy(Class<?> clazz, Callback callback) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setUseFactory(false);
		enhancer.setCallback(callback);
		return enhancer.create();
	}

}
