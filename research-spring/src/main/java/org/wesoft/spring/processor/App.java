package org.wesoft.spring.processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.inject.bean.TestBean;
import org.wesoft.spring.processor.bean.BeanService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		System.out.println(ac.getBean("beanService"));
		System.out.println(ac.getBean(TestBean.class));
	}

}
