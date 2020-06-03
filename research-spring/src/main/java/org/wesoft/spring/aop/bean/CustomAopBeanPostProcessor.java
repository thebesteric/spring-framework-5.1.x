package org.wesoft.spring.aop.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import org.wesoft.spring.scan.bean.UserDao;

import java.lang.reflect.Method;

/**
 * CustomAop
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-29 16:55
 * @since 1.0
 */
// @Component // 也可以使用 @Import 注入，方便扩展
public class CustomAopBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof UserService) {
			bean = CglibUtils.getProxy(bean.getClass(), new MethodInterceptor() {
				@Override
				public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
					System.out.println("aop ----------");
					Object result = methodProxy.invokeSuper(o, args);
					return result;
				}
			});
		}
		return bean;
	}
}
