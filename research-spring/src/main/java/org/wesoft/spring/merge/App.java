package org.wesoft.spring.merge;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.merge.bean.ChildBean;
import org.wesoft.spring.merge.bean.RootBean;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);

		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
		rootBeanDefinition.setBeanClass(RootBean.class);
		rootBeanDefinition.getPropertyValues().add("name", "image");
		rootBeanDefinition.getPropertyValues().add("type", "movie");
		ac.registerBeanDefinition("root", rootBeanDefinition);

		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setParentName("root");
		genericBeanDefinition.setBeanClass(ChildBean.class);
		genericBeanDefinition.getPropertyValues().add("name", "枪火");
		ac.registerBeanDefinition("child", genericBeanDefinition);

		ac.refresh();

		System.out.println(ac.getBean(ChildBean.class).getName());
		System.out.println(ac.getBean(ChildBean.class).getType());
	}

}
