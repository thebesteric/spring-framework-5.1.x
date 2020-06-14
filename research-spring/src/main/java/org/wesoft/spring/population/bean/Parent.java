package org.wesoft.spring.population.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Parent
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-07 01:45
 * @since 1.0
 */
@Component
public class Parent {
	@Autowired
	Foo foo;
}
