package org.wesoft.spring.scan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.wesoft.spring.bd.bean.IndexService;
import org.wesoft.spring.bd.bean.UserService;
import org.wesoft.spring.scan.bean.*;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 23:41
 */
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);

		// ac.scan("org.wesoft.spring.scan");

		// ac.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
		// 	@Override
		// 	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//
		// 	}
		// });

		ac.refresh();

		System.out.println(ac.getBean(TestBean.class));

		ClassPathBeanDefinitionScanner customScanner = new ClassPathBeanDefinitionScanner(ac);
		// CustomScanner customScanner = new CustomScanner(ac);
		customScanner.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
		int scan = customScanner.scan("org.wesoft.spring.scan"); // 扫描到符合要求 bean 的数量
		System.out.println(scan);

		System.out.println(ac.getBean(Foo.class));


	}
}
