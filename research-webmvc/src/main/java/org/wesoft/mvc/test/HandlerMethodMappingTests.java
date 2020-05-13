// /*
//  * Copyright 2002-2018 the original author or authors.
//  *
//  * Licensed under the Apache License, Version 2.0 (the "License");
//  * you may not use this file except in compliance with the License.
//  * You may obtain a copy of the License at
//  *
//  *      https://www.apache.org/licenses/LICENSE-2.0
//  *
//  * Unless required by applicable law or agreed to in writing, software
//  * distributed under the License is distributed on an "AS IS" BASIS,
//  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  * See the License for the specific language governing permissions and
//  * limitations under the License.
//  */
//
// package org.wesoft.mvc.test;
//
// import org.springframework.context.support.StaticApplicationContext;
// import org.springframework.stereotype.Controller;
// import org.springframework.util.AntPathMatcher;
// import org.springframework.util.PathMatcher;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.method.HandlerMethod;
// import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
// import org.springframework.web.servlet.handler.HandlerMethodMappingNamingStrategy;
// import org.springframework.web.util.UrlPathHelper;
//
// import javax.servlet.http.HttpServletRequest;
// import java.lang.reflect.Method;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.Set;
//
//
// /**
//  * Test for {@link AbstractHandlerMethodMapping}.
//  *
//  * @author Arjen Poutsma
//  * @author Rossen Stoyanchev
//  */
// @SuppressWarnings("unused")
// public class HandlerMethodMappingTests {
//
// 	public static void main(String[] args) {
// 		HandlerMethodMappingTests test = new HandlerMethodMappingTests();
// 		test.detectHandlerMethodsInAncestorContexts();
// 	}
//
//
// 	public void detectHandlerMethodsInAncestorContexts() {
// 		// 父容器
// 		StaticApplicationContext parent = new StaticApplicationContext();
// 		parent.registerSingleton("myHandler", MyHandler.class);
//
// 		// 子容器
// 		StaticApplicationContext child = new StaticApplicationContext(parent);
//
// 		AbstractHandlerMethodMapping<String> mapping1 = new MyHandlerMethodMapping();
// 		mapping1.setApplicationContext(child);
// 		mapping1.afterPropertiesSet();
// 		// 默认 spring mvc 已经禁用了 父子容器了，所以会打印 0
// 		System.out.println(mapping1.getHandlerMethods().size()); // 0
//
// 		AbstractHandlerMethodMapping<String> mapping2 = new MyHandlerMethodMapping();
// 		// 开启允许从父容器中查找
// 		mapping2.setDetectHandlerMethodsInAncestorContexts(true);
// 		mapping2.setApplicationContext(child);
// 		mapping2.afterPropertiesSet();
//
// 		System.out.println(mapping2.getHandlerMethods().size()); // 2
// 	}
//
//
// 	private static class MyHandlerMethodMapping extends AbstractHandlerMethodMapping<String> {
//
// 		private UrlPathHelper pathHelper = new UrlPathHelper();
//
// 		private PathMatcher pathMatcher = new AntPathMatcher();
//
//
// 		public MyHandlerMethodMapping() {
// 			setHandlerMethodMappingNamingStrategy(new SimpleMappingNamingStrategy());
// 		}
//
// 		@Override
// 		protected String getMappingForMethod(Method method, Class<?> handlerType) {
// 			String methodName = method.getName();
// 			return methodName.startsWith("handler") ? methodName : null;
// 		}
//
// 		@Override
// 		protected boolean isHandler(Class<?> beanType) {
// 			return true;
// 		}
//
// 		@Override
// 		protected Set<String> getMappingPathPatterns(String key) {
// 			return (this.pathMatcher.isPattern(key) ? Collections.<String>emptySet() : Collections.singleton(key));
// 		}
//
// 		@Override
// 		protected CorsConfiguration initCorsConfiguration(Object handler, Method method, String mapping) {
// 			CorsConfiguration corsConfig = new CorsConfiguration();
// 			corsConfig.setAllowedOrigins(Collections.singletonList("http://" + handler.hashCode() + method.getName()));
// 			return corsConfig;
// 		}
//
// 		@Override
// 		protected String getMatchingMapping(String pattern, HttpServletRequest request) {
// 			String lookupPath = this.pathHelper.getLookupPathForRequest(request);
// 			return this.pathMatcher.match(pattern, lookupPath) ? pattern : null;
// 		}
//
// 		@Override
// 		protected Comparator<String> getMappingComparator(HttpServletRequest request) {
// 			String lookupPath = this.pathHelper.getLookupPathForRequest(request);
// 			return this.pathMatcher.getPatternComparator(lookupPath);
// 		}
//
// 	}
//
// 	private static class SimpleMappingNamingStrategy implements HandlerMethodMappingNamingStrategy<String> {
//
// 		@Override
// 		public String getName(HandlerMethod handlerMethod, String mapping) {
// 			return handlerMethod.getMethod().getName();
// 		}
// 	}
//
// 	@Controller
// 	static class MyHandler {
//
// 		public MyHandler(){
// 			System.out.println("MyHandler init");
// 		}
//
// 		@RequestMapping
// 		public void handlerMethod1() {
// 		}
//
// 		@RequestMapping
// 		public void handlerMethod2() {
// 		}
// 	}
// }
