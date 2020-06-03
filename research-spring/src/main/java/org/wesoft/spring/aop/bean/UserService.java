package org.wesoft.spring.aop.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * UserService
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-27 23:27
 * @since 1.0
 */
@Service
public class UserService {

	public void testAop() {
		System.out.println("UserService test aop");
	}

}
