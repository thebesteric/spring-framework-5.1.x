package org.wesoft.spring.bd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.wesoft.spring.bd.bean.DataSource;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 23:41
 */
@Configuration
@ComponentScan("org.wesoft.spring.bd")
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		return new DataSource();
	}

}
