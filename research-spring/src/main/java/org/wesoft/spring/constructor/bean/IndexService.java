package org.wesoft.spring.constructor.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 23:43
 */
@Component
// @DependsOn("userService")
// @Scope("singleton")
public class IndexService {

	// 当存在多个构造方法的时候，且没有手动指定 @Autowired
	// 默认情况下，会使用默认构造方法来创建实例
	// public IndexService(){
	// 	System.out.println("IndexService using default constructor");
	// }

	// @Autowired(required = false)
	public IndexService(OrderService orderService){
		System.out.println("IndexService using orderService constructor");
	}

	// @Autowired(required = false)
	public IndexService(UserService userService){
		System.out.println("IndexService using userService constructor");
	}

	// @Autowired(required = false)
	public IndexService(UserService userService, Object orderService){
		System.out.println("IndexService using userService & objectService constructor" + orderService);
	}

	// @Autowired(required = false)
	// @Autowired
	// 情况一、当存在多个构造方法时，如果需要让 Spring 指定使用那个构造方法的话，需要手动加 @Autowired 注解
	// 情况二、由于 @Component 标记的类默认 DB 的注入模型是 autowireMode = 0，如果修改了 autowireMode = AUTOWIRE_CONSTRUCTOR，就会默认使用参数最长的构造方法
	// public IndexService(UserService userService, OrderService orderService){
	// 	System.out.println("IndexService using userService & orderService constructor");
	// }

}
