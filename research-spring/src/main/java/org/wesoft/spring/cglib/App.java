package org.wesoft.spring.cglib;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.wesoft.spring.cglib.bean.Foo;
import org.wesoft.spring.scan.bean.MyComponent;
import org.wesoft.spring.scan.bean.TestBean;

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
		ac.refresh();

		// 如果加上 @Configuration 那么 这个类就被代理了
		System.out.println(ac.getBean(AppConfig.class)); // org.wesoft.spring.cglib.AppConfig$$EnhancerBySpringCGLIB$$623e8cd1@711f39f9
		System.out.println(ac.getBean(Foo.class));
	}
}
