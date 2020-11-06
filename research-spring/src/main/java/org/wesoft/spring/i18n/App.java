package org.wesoft.spring.i18n;

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
 * @date 2020-10-12 22:00
 * @since 1.0
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println(context.getMessage("login", null, new Locale("zh_CN")));
		System.out.println(context.getMessage("login", null, new Locale("en_US")));
	}

	@Configuration
	@ComponentScan("org.wesoft.spring.i18n")
	static class AppConfig {

		@Bean
		public MessageSource messageSource() {
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
			messageSource.setBasename("i18n/message");
			return messageSource;
		}


	}

}
