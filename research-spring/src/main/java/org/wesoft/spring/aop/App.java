package org.wesoft.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.aop.bean.I;
import org.wesoft.spring.aop.bean.OrderService;
import org.wesoft.spring.aop.bean.UserService;

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

		ac.getBean(UserService.class).testAop();

		I orderService = ac.getBean(I.class);
		orderService.testAop();

		// OrderService orderService = ac.getBean(OrderService.class);
		// orderService.testAop();
	}
}
