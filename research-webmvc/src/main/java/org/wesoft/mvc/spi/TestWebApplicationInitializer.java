package org.wesoft.mvc.spi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface TestWebApplicationInitializer {
    void onStartup(ServletContext servletContext) throws ServletException;
}
