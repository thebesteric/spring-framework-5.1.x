package org.wesoft.spring.scan.bean;

/**
 * CustomBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-24 22:57
 * @since 1.0
 */
@MyComponent
public class CustomBean {

	public CustomBean(CustomTestBean customTestBean) {
		System.out.println(customTestBean);
	}

}
