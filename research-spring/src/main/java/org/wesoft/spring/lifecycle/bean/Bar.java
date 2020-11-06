package org.wesoft.spring.lifecycle.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Bar
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-08 19:39
 * @since 1.0
 */
@Component
public class Bar implements InitializingBean {

	@Autowired
	private UserService userService;

	@PostConstruct
	private void postConstruct() {
		// 第一执行
		System.out.println("Bar PostConstruct");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		// 第二执行
		System.out.println("Bar afterPropertiesSet");
	}

	private void initMethod() {
		// 第三执行
		System.out.println("Bar initMethod");
	}

}
