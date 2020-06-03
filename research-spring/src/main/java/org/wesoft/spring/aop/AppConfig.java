package org.wesoft.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.wesoft.spring.aop.bean.CustomAopBeanPostProcessor;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 23:41
 */
@Configuration
@ComponentScan("org.wesoft.spring.aop")
// @EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
@Import(CustomAopBeanPostProcessor.class)
public class AppConfig {

}
