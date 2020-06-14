package org.wesoft.spring.constructor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * MyBeanFactoryProcessor
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-31 18:16
 * @since 1.0
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("indexService");
		// bd.setLenientConstructorResolution(false); // 是否使用宽松模式
		// bd.setNonPublicAccessAllowed(false); // 是否需要访问私有构造方法
		// bd.getConstructorArgumentValues().addGenericArgumentValue(beanFactory.getBean(UserService.class));
		bd.setAutowireMode(GenericBeanDefinition.AUTOWIRE_CONSTRUCTOR);
		// bd.setInstanceSupplier(() -> new IndexService(beanFactory.getBean(UserService.class)));
	}
}
