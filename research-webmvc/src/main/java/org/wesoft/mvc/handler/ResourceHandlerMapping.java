package org.wesoft.mvc.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ResourceHandler
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-12 17:27
 * @since 1.0
 */
@Component
public class ResourceHandlerMapping implements HandlerMapping {

	@Override
	public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {

		String requestURI = request.getRequestURI();
		System.out.println(requestURI);

		return null;
	}

}
