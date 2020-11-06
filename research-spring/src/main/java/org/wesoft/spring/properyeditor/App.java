package org.wesoft.spring.properyeditor;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;

import java.beans.PropertyEditor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * App
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-12 20:25
 * @since 1.0
 */
public class App {

	public static void main(String[] args) {


		// StringToUserPropertyEditor stringToUserPropertyEditor = new StringToUserPropertyEditor();
		// stringToUserPropertyEditor.setAsText("张三");
		// User user = (User) stringToUserPropertyEditor.getValue();
		// System.out.println(user.getName());

		// DefaultConversionService conversionService = new DefaultConversionService();
		// conversionService.addConverter(new StringToUserConverter());
		// User user = conversionService.convert("张三", User.class);
		// System.out.println(user.getName());

		SimpleTypeConverter typeConverter = new SimpleTypeConverter();
		typeConverter.registerCustomEditor(User.class, new StringToUserPropertyEditor());
		// typeConverter.setConversionService(conversionService);
		User user = typeConverter.convertIfNecessary("张三", User.class);
		System.out.println(user.getName());

		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// context.register(AppConfig.class);
		// context.refresh();
		//
		// UserService userService = context.getBean("userService", UserService.class);
		// System.out.println(userService.getUser().getName());

	}

	@Configuration
	@ComponentScan("org.wesoft.spring.properyeditor")
	static class AppConfig {

		// @Bean
		public CustomEditorConfigurer customEditorConfigurer() {
			CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
			Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
			customEditors.put(User.class, StringToUserPropertyEditor.class);
			customEditorConfigurer.setCustomEditors(customEditors);
			return customEditorConfigurer;
		}

		@Bean
		public ConversionServiceFactoryBean conversionService() {
			ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
			conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConverter()));
			return conversionServiceFactoryBean;
		}


	}

}
