package org.wesoft.spring.merge.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RootBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-02 23:20
 * @since 1.0
 */
public class RootBean {

	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
