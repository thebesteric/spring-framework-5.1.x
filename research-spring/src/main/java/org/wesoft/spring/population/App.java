package org.wesoft.spring.population;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.observer.event.MailBean;
import org.wesoft.spring.population.service.Bar;
import org.wesoft.spring.population.service.Foo;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		ac.getBean(Foo.class).getNoAutowiredBean();
	}

}
