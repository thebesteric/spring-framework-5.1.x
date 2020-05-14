package org.wesoft.spring.proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.proxy.demo.bean.SessionFactory;
import org.wesoft.spring.proxy.demo.dao.UserDao;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-13 23:12
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		UserDao mapper = SessionFactory.getMapper(UserDao.class);
		mapper.query();
	}

}
