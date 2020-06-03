package org.wesoft.spring.cycle.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * OrderService
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-27 23:27
 * @since 1.0
 */
@Service
public class OrderService {

	@Autowired
	private UserService userService;

	public OrderService() {
		System.out.println("OrderService Constructor");
	}

}
