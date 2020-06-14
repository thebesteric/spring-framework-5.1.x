package org.wesoft.spring.lifecycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * MyBeanFactoryPostPorcessor
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-08 19:41
 * @since 1.0
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("bar");
		bd.setInitMethodName("initMethod");
	}
}
