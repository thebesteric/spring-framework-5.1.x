package org.wesoft.spring.constructor;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 23:41
 */
@Configuration
@ComponentScan("org.wesoft.spring.constructor")
// @ImportResource("classpath:applicationContext.xml")
public class AppConfig {

	@Bean
	public DataSource getDataSource(){
		return new DriverManagerDataSource();
	}

}
