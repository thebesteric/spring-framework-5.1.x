package org.wesoft.spring.event;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.wesoft.spring.aop.bean.CustomAopBeanPostProcessor;

import javax.annotation.security.DenyAll;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 23:41
 */
@Configuration
@ComponentScan("org.wesoft.spring.event")
@EnableAsync
public class AppConfig {

	// beanName 必须是 applicationEventMulticaster，才会被 Spring 所接收
	@Bean("applicationEventMulticaster")
	public ApplicationEventMulticaster applicationEventMulticaster(BeanFactory beanFactory, ThreadPoolTaskExecutor executor) {
		SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
		applicationEventMulticaster.setTaskExecutor(executor);
		return applicationEventMulticaster;
	}

	@Bean
	public ThreadPoolTaskExecutor executor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		// 核心线程数
		taskExecutor.setCorePoolSize(5);
		// 最大线程数
		taskExecutor.setMaxPoolSize(10);
		// 队列大小
		taskExecutor.setQueueCapacity(100);
		// 线程池中的线程名称前缀
		taskExecutor.setThreadNamePrefix("async-task-");
		// 当 pool 已经达到 max size 的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 初始化线程池
		taskExecutor.initialize();
		return taskExecutor;
	}

}
