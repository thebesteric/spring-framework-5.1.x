package org.wesoft.spring.processor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import org.wesoft.spring.inject.bean.TestBean;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-15 19:27
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	/*
	在 put 完 beanDefinitionMap 之后，调用 postProcessBeanFactory
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("beanService");
		beanDefinition.setBeanClass(TestBean.class);
	}
}
