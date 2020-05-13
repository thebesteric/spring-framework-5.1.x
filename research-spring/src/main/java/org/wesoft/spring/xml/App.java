package org.wesoft.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-08 14:45
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MyService myService = context.getBean(TestService.class).getMyService();
		System.out.println(myService);

		context.getBean(ConstructService.class).getTestService();
	}

}
