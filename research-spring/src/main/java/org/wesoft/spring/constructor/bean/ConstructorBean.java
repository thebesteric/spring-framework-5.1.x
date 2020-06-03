package org.wesoft.spring.constructor.bean;

/**
 * ConstructorBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-01 13:17
 * @since 1.0
 */
public class ConstructorBean {

	Class<?> clazz;

	public ConstructorBean(Class<?> clazz){
		System.out.println(clazz.getSimpleName());
	}

}
