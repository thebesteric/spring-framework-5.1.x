package org.wesoft.spring.bdreader;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.stereotype.Repository;

/**
 * App
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-12 11:45
 * @since 1.0
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
		// int i = xmlBeanDefinitionReader.loadBeanDefinitions("applicationContext.xml");
		// System.out.println("加载了 " + i + " 个 bean");

		// AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
		// annotatedBeanDefinitionReader.registerBean(Person.class);
		// context.refresh();
		// System.out.println(context.getBean("person"));

		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
		scanner.scan("org.wesoft.spring.bdreader");
		context.refresh();
		System.out.println(context.getBean("user"));
	}

}
