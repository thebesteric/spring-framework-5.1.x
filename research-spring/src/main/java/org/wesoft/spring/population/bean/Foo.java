package org.wesoft.spring.population.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Foo implements I{

	@Autowired
	Bar bar;

	NoAutowiredBean noAutowiredBean;

	@PostConstruct
	public void init() {
		System.out.println(this.getClass().getSimpleName() + "'s bar = " + bar);
	}

	public void setNoAutowiredBean(NoAutowiredBean noAutowiredBean) {
		this.noAutowiredBean = noAutowiredBean;
	}

	public void getNoAutowiredBean() {
		System.out.println("noAutowiredBean = " + noAutowiredBean);
	}

}
