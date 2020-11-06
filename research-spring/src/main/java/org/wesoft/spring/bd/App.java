package org.wesoft.spring.bd;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.bd.bean.IndexService;
import org.wesoft.spring.bd.bean.UserService;

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

		// RootBeanDefinition rbd = new RootBeanDefinition();
		// rbd.setScope(BeanDefinition.SCOPE_SINGLETON);
		// rbd.setLazyInit(false);
		// rbd.setAbstract(true);
		// rbd.setBeanClass(UserService.class);
		//
		// ac.registerBeanDefinition("userService", rbd);
		//
		// ChildBeanDefinition cbd = new ChildBeanDefinition("userService");
		// cbd.setBeanClass(IndexService.class);
		//
		// ac.registerBeanDefinition("indexService", cbd);

		// AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		// beanDefinition.setLazyInit(false);
		// beanDefinition.setScope(GenericBeanDefinition.SCOPE_SINGLETON);
		// beanDefinition.setBeanClass(UserService.class);

		GenericBeanDefinition rbd = new GenericBeanDefinition();
		rbd.setLazyInit(false);
		rbd.setScope(GenericBeanDefinition.SCOPE_SINGLETON);
		rbd.setBeanClass(UserService.class);

		ac.registerBeanDefinition("userService", rbd);

		GenericBeanDefinition cbd = new GenericBeanDefinition();
		cbd.setParentName("userService");
		cbd.setBeanClass(IndexService.class);

		ac.registerBeanDefinition("indexService", cbd);

		ac.refresh();

		System.out.println(ac.getBean("userService"));
		System.out.println(ac.getBean("indexService"));

		// ConfigurationClassBeanDefinition
		System.out.println(ac.getBeanDefinition("dataSource").getClass().getSimpleName());

		// ScannedGenericBeanDefinition
		System.out.println(ac.getBeanDefinition("componentBean").getClass().getSimpleName());

		// AnnotatedGenericBeanDefinition
		System.out.println(ac.getBeanDefinition("appConfig").getClass().getSimpleName());

		ac.close();
	}
}
