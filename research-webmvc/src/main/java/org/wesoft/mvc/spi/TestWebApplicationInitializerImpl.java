package org.wesoft.mvc.spi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class TestWebApplicationInitializerImpl implements TestWebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("This is my TestWebApplicationInitializer show " + servletContext);
    }
}
