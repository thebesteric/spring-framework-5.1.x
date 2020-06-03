package org.wesoft.spring.bd.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * MyBeanFactoryPostProcessor
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-22 14:19
 * @since 1.0
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("componentBean");
		bd.setDestroyMethodName(GenericBeanDefinition.INFER_METHOD);
		// bd.setDependencyCheck(GenericBeanDefinition.DEPENDENCY_CHECK_ALL);
	}
}
