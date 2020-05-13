package org.wesoft.spring.inject.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import org.wesoft.spring.observer.example.Test;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-12 23:26
 */
@Component
public class MyFactoryBean implements FactoryBean<TestBean> {

	@Override
	public TestBean getObject() throws Exception {
		return new TestBean();
	}

	@Override
	public Class<?> getObjectType() {
		return TestBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
