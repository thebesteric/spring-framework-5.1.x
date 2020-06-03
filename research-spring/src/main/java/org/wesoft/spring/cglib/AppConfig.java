package org.wesoft.spring.cglib;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.wesoft.spring.cglib.bean.Bar;
import org.wesoft.spring.cglib.bean.Foo;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 23:41
 */
@Configuration
@ComponentScan("org.wesoft.spring.cglib")
public class AppConfig {

	@Bean
	public Foo foo(){
		System.out.println("foo init");
		return new Foo();
	}

	@Bean
	public Bar bar(){
		System.out.println("bar init");
		foo(); // 在有 @Configuration 的情况下，foo() 被代理了，所以不会执行真正的 foo 方法
		return new Bar();
	}
}
