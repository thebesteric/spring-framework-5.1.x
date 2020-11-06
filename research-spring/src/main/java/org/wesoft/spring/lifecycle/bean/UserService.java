package org.wesoft.spring.lifecycle.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * UserService
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-26 20:20
 * @since 1.0
 */
@Component
public class UserService {

	@Value("staging")
	private String model;

}
