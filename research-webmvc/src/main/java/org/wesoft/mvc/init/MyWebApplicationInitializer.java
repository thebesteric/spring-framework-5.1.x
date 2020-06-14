package org.wesoft.mvc.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.wesoft.mvc.config.AppConfig;
import org.wesoft.mvc.handler.ResourceHandlerMapping;
import org.wesoft.mvc.spi.TestWebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class MyWebApplicationInitializer implements WebApplicationInitializer {
// public class MyWebApplicationInitializer implements TestWebApplicationInitializer {

	/**
	 * Spring MVC 0-XML 配置的原理：
	 *
	 * 因为 servlet 3.0 的一个新规范（ServletContainerInitializer），
	 * 而 tomcat 也遵守了了这个规范，所以会调用 实现了 WebApplicationInitializer 的 onStartup 方法
	 *
	 * Spring 定义了一个 org.springframework.web.SpringServletContainerInitializer 类，实现了 servlet 3.0 的这个新规范
	 *
	 * Spring 实现方式
	 * spring-web\META-INF\services\javax.servlet.ServletContainerInitializer，是指需要实现的接口
	 * javax.servlet.ServletContainerInitializer 文件里面的 org.springframework.web.SpringServletContainerInitializer 是实现类
	 * @HandlesTypes(WebApplicationInitializer.class) 会由容器进行解析里面定义的接口，找出所有实现类，并回调给 Set<Class<?>> webAppInitializerClasses
	 * Spring 再对 webAppInitializerClasses 的子类进行遍历，分别调用其 onStartup 的方法
	 *
	 * @param servletContext Web上下文对象
	 * @throws ServletException
	 */
	public void onStartup(ServletContext servletContext) throws ServletException {

		System.out.println("-------onStartup-------");

		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(AppConfig.class);
		// ac.refresh();

		// Create and register the DispatcherServlet
		// DispatcherServlet 的 init 方法
		DispatcherServlet servlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("*.do");
		// registration.addMapping("/*");


		ac.register(ResourceHandlerMapping.class);



	}

}

