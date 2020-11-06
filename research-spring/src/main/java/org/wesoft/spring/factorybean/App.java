package org.wesoft.spring.factorybean;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * App
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-19 11:12
 * @since 1.0
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println(context.getBean("myFactoryBean")); // org.wesoft.spring.factorybean.User@23faf8f2
		System.out.println(context.getBean("&myFactoryBean")); // org.wesoft.spring.factorybean.MyFactoryBean@2d6eabae

	}

	@Configuration
	@ComponentScan("org.wesoft.spring.factorybean")
	static class AppConfig {


	}

}
