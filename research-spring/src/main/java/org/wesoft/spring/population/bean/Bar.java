package org.wesoft.spring.population.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bar extends Parent implements I {

	@Autowired
	Foo foo;

	@Autowired
	@Qualifier("foo")
	Foo foo1;

	@PostConstruct
	public void init() {
		System.out.println(this.getClass().getSimpleName() + "'s foo = " + foo);
	}

	public void setXyz(Foo foo) {
		System.out.println("setter: " + foo);
	}

}
