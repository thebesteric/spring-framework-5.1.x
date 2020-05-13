package org.wesoft.mvc.spi;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/*
 * 模拟 SpringServletContainerInitializer 做到 0-XML 配置的原理
 */
@HandlesTypes(TestWebApplicationInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
        for (Class<?> webAppInitializerClass : webAppInitializerClasses) {
            try {
                TestWebApplicationInitializer obj = (TestWebApplicationInitializer) webAppInitializerClass.newInstance();
                obj.show(servletContext);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
