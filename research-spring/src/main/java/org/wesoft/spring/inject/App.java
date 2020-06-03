package org.wesoft.spring.inject;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.inject.bean.MyFactoryBean;
import org.wesoft.spring.inject.bean.PrimaryBean;
import org.wesoft.spring.inject.bean.ProtoTypeBean;
import org.wesoft.spring.inject.bean.TestBean;
import org.wesoft.spring.inject.services.MyService;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		System.out.println("==========================");

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(TestBean.class);
		beanDefinition.setScope(GenericBeanDefinition.SCOPE_SINGLETON);
		beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);

		ac.registerBeanDefinition("testBean", beanDefinition);
		System.out.println(ac.getBean(TestBean.class));

		System.out.println("==========================");

		// ac.getBeanFactory().registerSingleton("testBean", new TestBean());

		// System.out.println(ac.getBean(TestBean.class));
		// System.out.println(ac.getBean(MyFactoryBean.class));
		// System.out.println(ac.getBean("myFactoryBean"));
		// System.out.println(ac.getBean("&myFactoryBean"));

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

		System.out.println("==========================");

		System.out.println(ac.getBean(PrimaryBean.class));

		Object source = ac.getBeanDefinition("myService").getSource();
		System.out.println(source); // file [D:\Documents\Java\Spring\spring\spring-framework-5.1.x\research-spring\out\production\classes\org\wesoft\spring\inject\services\MyService.class]

		Object attribute = ac.getBeanDefinition("myService").getAttribute("org.springframework.context.annotation.ConfigurationClassPostProcessor.configurationClass");
		System.out.println(attribute); // lite


	}

}
