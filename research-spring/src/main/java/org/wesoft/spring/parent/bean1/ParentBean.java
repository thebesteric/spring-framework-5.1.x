package org.wesoft.spring.parent.bean1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ParentBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-04 00:27
 * @since 1.0
 */
@Component
public class ParentBean {
	@Autowired
	public ParentBean() {
		System.out.println("ParentBean init");
	}
}
