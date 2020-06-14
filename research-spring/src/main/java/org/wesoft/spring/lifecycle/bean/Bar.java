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

	@PostConstruct
	private void postConstruct() {
		// 1
		System.out.println("Bar PostConstruct");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		// 2
		System.out.println("Bar afterPropertiesSet");
	}

	private void initMethod() {
		// 3
		System.out.println("Bar initMethod");
	}

}
