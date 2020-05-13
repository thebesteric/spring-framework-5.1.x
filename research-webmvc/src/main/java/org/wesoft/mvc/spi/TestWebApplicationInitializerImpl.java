package org.wesoft.mvc.spi;

import javax.servlet.ServletContext;

public class TestWebApplicationInitializerImpl implements TestWebApplicationInitializer {
    @Override
    public void show(ServletContext servletContext) {
        System.out.println("This is my TestWebApplicationInitializer show " + servletContext);
    }
}
