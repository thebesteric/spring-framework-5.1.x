package org.wesoft.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.lifecycle.bean.UserService;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-11 00:43
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		UserService userService = (UserService) ac.getBean("userService");

		// 如果继承了 Lifecycle 必须显式的调用 start 方法
		// ac.start();
		// ac.stop();
	}

}
