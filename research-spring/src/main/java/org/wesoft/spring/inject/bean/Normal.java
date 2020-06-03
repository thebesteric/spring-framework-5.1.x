package org.wesoft.spring.inject.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-10 01:04
 */
@Component
public class Normal {

	@Autowired
	private Bar bar;

	// @Autowired
	TestBean testBean;

	@Autowired
	private Other other;

}
