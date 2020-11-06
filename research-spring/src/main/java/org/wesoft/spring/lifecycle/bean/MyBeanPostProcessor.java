package org.wesoft.spring.lifecycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * MyBeanPostProcessor
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-29 00:06
 * @since 1.0
 */
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if ("bar".equals(beanName)) {
			System.out.println("实例化前");
		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if ("bar".equals(beanName)) {
			System.out.println("实例化后");
		}
		// 返回 true，表示是否继续属性填充
		return true;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		if ("bar".equals(beanName)) {
			System.out.println("填充属性后");
		}
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("bar".equals(beanName)) {
			System.out.println("初始化前");
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("bar".equals(beanName)) {
			System.out.println("初始化后");
		}
		return null;
	}
}
