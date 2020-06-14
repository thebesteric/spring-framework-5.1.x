package org.wesoft.spring.merge.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ChildBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-02 23:20
 * @since 1.0
 */
public class ChildBean {
	private String name;
	private String type;

	public void setRoot(RootBean rootBean){
		System.out.println(rootBean);
	}

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
