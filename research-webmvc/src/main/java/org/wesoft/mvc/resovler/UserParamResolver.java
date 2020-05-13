package org.wesoft.mvc.resovler;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.wesoft.mvc.annotation.UserParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义解析器，请注意（重写）执行顺序
 * 如：返回 Map 对象，会提前给 Spring 自带的 Map 解析器给解析了
 */
@Component
public class UserParamResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(UserParam.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// 从 request 或 redis 中获取用户逻辑...
		System.out.println("---从 request 或 redis 中获取用户逻辑---");
		Map<String, Object> map = new HashMap<>();
		map.put("id", "123456");
		map.put("name", "eric");
		return map;
	}
}
