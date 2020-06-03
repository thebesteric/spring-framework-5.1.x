package org.wesoft.spring.aop.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * MyAspect
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-29 21:08
 * @since 1.0
 */
@Component
@Aspect
public class NotVeryUsefulAspect {

	@Pointcut("within(org.wesoft.spring.aop.bean.OrderService)")
	private void orderServerAllMethod() {
	}

	@Pointcut("execution(String org.wesoft.spring.aop.bean.OrderService.*(..))")
	private void orderServerReturnStringMethod() {
	}

	@Before("orderServerAllMethod()")
	public void logger() {
		System.out.println("logger---------");
	}

}
