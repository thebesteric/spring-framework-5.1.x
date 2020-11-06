package org.wesoft.spring.properyeditor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * UserService
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-12 20:27
 * @since 1.0
 */
@Getter
@Setter
@Component
public class UserService {

	@Value("张三")
	private User user;

}
