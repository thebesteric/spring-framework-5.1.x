package org.wesoft.spring.cycle;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.wesoft.spring.cglib.bean.Foo;
import org.wesoft.spring.cycle.bean.UserService;

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

		// 关闭循环依赖
		// DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ac.getBeanFactory();
		// beanFactory.setAllowCircularReferences(false);

		ac.refresh();

		System.out.println(ac.getBean(UserService.class));
	}
}
