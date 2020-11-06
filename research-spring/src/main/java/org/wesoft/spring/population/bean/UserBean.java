package org.wesoft.spring.population.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * UserBean
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-06 00:13
 * @since 1.0
 */
@Component
public class UserBean {

	@Autowired
	private Foo foo;

	@Autowired
	private I bar;

	@Autowired
	private List<I> list;

	@PostConstruct
	public void init() {
		for (I i : list) {
			System.out.println(i.getClass().getSimpleName());
		}
	}

}
