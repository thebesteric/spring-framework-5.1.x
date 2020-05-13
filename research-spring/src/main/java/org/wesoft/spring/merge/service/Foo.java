package org.wesoft.spring.merge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Foo {

	@Autowired
	Bar bar;

}
