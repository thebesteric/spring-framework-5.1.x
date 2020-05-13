package org.wesoft.spring.observer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.observer.event.MailBean;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ac.start();

		MailBean mailBean = ac.getBean(MailBean.class);
		mailBean.sendMail("今天下雪了");
	}

}
