package org.wesoft.spring.aop.bean;

import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderService implements I {

	public OrderService() {
		System.out.println("OrderService Constructor");
	}

	public void testAop() {
		System.out.println("OrderService test aop");
	}

	public String commit() {
		System.out.println("OrderService commit");
		return "success";
	}

}
