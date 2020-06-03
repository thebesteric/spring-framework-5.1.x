package org.wesoft.spring.bd.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ComponentBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-22 01:20
 * @since 1.0
 */
@Component
public class ComponentBean {

	private String name;

	// 默认 close or shutdown 方法
	public void close() {
		System.out.println("default destroy method");
	}

	public void setName(String name) {
		this.name = name;
	}
}
