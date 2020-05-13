package org.wesoft.mvc.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.wesoft.mvc.resovler.UserParamResolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan("org.wesoft.mvc")
@EnableWebMvc // 相当于 XML 中的 <mvc:annotation-driven/>
public class AppConfig implements WebMvcConfigurer {

	/*
	Apache Commons FileUpload
	To use Apache Commons FileUpload,
	you can configure a bean of type CommonsMultipartResolver with a name of multipartResolver.
	You also need to have commons-fileupload as a dependency on your classpath.
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		return commonsMultipartResolver;
	}

	// 会在 Spring mvc 环境初始化完成之后，加载这个方法
	@Autowired
	public void iniArgumentsResolvers(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
		List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>(requestMappingHandlerAdapter.getArgumentResolvers());
		List<HandlerMethodArgumentResolver> customArgumentResolvers = requestMappingHandlerAdapter.getCustomArgumentResolvers();
		argumentResolvers.removeAll(customArgumentResolvers);
		argumentResolvers.addAll(0, customArgumentResolvers);
		requestMappingHandlerAdapter.setArgumentResolvers(argumentResolvers);
	}

	/**
	 * 视图处理
	 *
	 * @param registry
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/page/", ".html");
	}

	/**
	 * 添加消息解析器
	 *
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		converters.add(fastJsonHttpMessageConverter);
	}

	/**
	 * 添加参数解析器
	 *
	 * @param resolvers initially an empty list
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// 这里其实是传过来一个空集合，对应着 customArgumentResolvers
		// 也就是我们其实是在 customArgumentResolvers 里添加自定义方法
		// 然后 spring mvc 会将这个集合合并到 argumentResolvers 中，所以并不能保证执行顺序
		resolvers.add(new UserParamResolver());
	}
}
