package org.wesoft.spring.constructor;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.constructor.bean.ConstructorBean;
import org.wesoft.spring.constructor.bean.IndexService;
import org.wesoft.spring.constructor.bean.UserService;

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

		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(ConstructorBean.class);
		bd.getConstructorArgumentValues().addGenericArgumentValue("org.wesoft.spring.constructor.bean.UserService");
		// bd.setLenientConstructorResolution(false); // 构造方法是否采取宽松模式
		ac.registerBeanDefinition("constructorBean", bd);

		ac.refresh();

		System.out.println(ac.getBean("constructorBean"));
	}
}
