package org.wesoft.spring.scan.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 * MyBeanDefinitionRegistryPostProcessor
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-26 21:29
 * @since 1.0
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

		// ClassPathBeanDefinitionScanner customScanner = new ClassPathBeanDefinitionScanner(registry);
		// // CustomScanner customScanner = new CustomScanner(ac);
		// customScanner.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
		// int scan = customScanner.scan("org.wesoft.spring.scan"); // 扫描到符合要求 bean 的数量
		// System.out.println(scan);


		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(Foo.class);
		registry.registerBeanDefinition("foo", bd);
		System.out.println("postProcessBeanDefinitionRegistry");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("postProcessBeanFactory");
	}
}
