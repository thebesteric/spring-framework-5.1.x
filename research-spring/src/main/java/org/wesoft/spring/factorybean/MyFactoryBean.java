package org.wesoft.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * MyFactoryBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-19 11:15
 * @since 1.0
 */
@Component
public class MyFactoryBean implements FactoryBean<User> {
	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
