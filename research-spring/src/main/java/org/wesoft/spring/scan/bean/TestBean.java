package org.wesoft.spring.scan.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * TestBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-23 00:30
 * @since 1.0
 */
@Component
public class TestBean {

	@Bean
	UserDao userDao() {
		System.out.println("userDao bean");
		return new UserDao() {
			@Override
			public Object[] findAll() {
				return new Object[0];
			}
		};
	}

}
