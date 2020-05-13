package org.wesoft.spring.population.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bar {

	@Autowired
	Foo foo;

	@PostConstruct
	public void init() {
		System.out.println(this.getClass().getSimpleName() + "'s foo = " + foo);
	}

}
