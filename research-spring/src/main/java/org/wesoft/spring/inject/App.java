package org.wesoft.spring.inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.inject.bean.MyFactoryBean;
import org.wesoft.spring.inject.bean.ProtoTypeBean;
import org.wesoft.spring.inject.bean.TestBean;
import org.wesoft.spring.inject.services.MyService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		// ac.getBeanFactory().registerSingleton("testBean", new TestBean());

		System.out.println(ac.getBean(TestBean.class));
		System.out.println(ac.getBean(MyFactoryBean.class));
		System.out.println(ac.getBean("myFactoryBean"));
		System.out.println(ac.getBean("&myFactoryBean"));

		System.out.println("==========================");

		ac.getBean(ProtoTypeBean.class);
		ac.getBean(ProtoTypeBean.class);
		ac.getBean(ProtoTypeBean.class);

		System.out.println("==========================");

		ac.getBean(MyService.class).isProtoType();
		ac.getBean(MyService.class).isProtoType();
		ac.getBean(MyService.class).isProtoType();

		System.out.println("==========================");

		ac.getBean(MyService.class).getProtoTypeBean();
		ac.getBean(MyService.class).getProtoTypeBean();
		ac.getBean(MyService.class).getProtoTypeBean();

		System.out.println("==========================");

		ac.getBean(MyService.class).getProtoTypeBeanForLookup();
		ac.getBean(MyService.class).getProtoTypeBeanForLookup();
		ac.getBean(MyService.class).getProtoTypeBeanForLookup();

	}

}
