package org.wesoft.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.wesoft.spring.aop.bean.I;
import org.wesoft.spring.aop.bean.UserService;
import org.wesoft.spring.event.listener.AEvent;

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

		// SimpleApplicationEventMulticaster multicaster = ac.getBean(SimpleApplicationEventMulticaster.class);
		// multicaster.setTaskExecutor(ac.getBean(ThreadPoolTaskExecutor.class));

		AEvent aEvent = new AEvent(App.class);
		aEvent.setName("test");
		aEvent.setAge(18);
		ac.publishEvent(aEvent);
		System.out.println(Thread.currentThread().getName() + "publish OVER");
	}
}
