package org.wesoft.mvc.spi;

import javax.servlet.ServletContext;

public interface TestWebApplicationInitializer {
    void show(ServletContext servletContext);
}
