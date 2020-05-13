package org.wesoft.spring.inject.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy
public class Foo implements Other {

	static Bar bar;

	@Autowired
	public void setBar(Bar bar) {
		Foo.bar = bar;
	}

	@PostConstruct
	public void init() {
		System.out.println("static bar = " + bar);
	}

}
