package org.wesoft.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewResolverMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;
import org.wesoft.mvc.annotation.UserParam;
import org.wesoft.mvc.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
Spring 的 handlerMappings 会识别两种 Controller
1、@Controller：RequestMappingHandlerMapping
	对应存放 mapping 的是 urlLookup
2、以 beanName 声明的 URL bean：BeanNameUrlHandlerMapping
	对应存放 mapping 的是 handlerMap
 */

// RequestMappingHandlerMapping 类型的 Controller
@Controller
// @RequestMapping("/test")
public class TestController {

	/*
	有一个 handler（RequestResponseBodyMethodProcessor） 去判断上面有没有 @ResponseBody 注解
	如果有，就由当前的 handler 来处理
	先判断返回值类型是不是 String，如果是 String 直接进行返回
	否则，则执行消息类型转换，会尝试寻找一个用户自定的消息转换器，并由消息转换器实现消息输出
	 */
	@RequestMapping("/test.do")
	@ResponseBody
	public Object test(String name, HttpServletRequest req, HttpServletResponse resp, UserEntity userEntity, @UserParam Map loginUser) {
		System.out.println("name = " + name);
		System.out.println("req = " + req);
		System.out.println("resp = " + resp);
		System.out.println("userEntity = " + userEntity);
		System.out.println("loginUser = " + loginUser);
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("userEntity", userEntity);
		return map;
	}

	// ModelAndViewResolverMethodReturnValueHandler
	@RequestMapping("/index.do")
	public ModelAndView index() {
		System.out.println("-----index 执行了-----");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.getModel().put("name", "eric");
		return mav;
	}

	// ViewNameMethodReturnValueHandler
	@RequestMapping("/file.do")
	public String file() {
		System.out.println("-----file 执行了-----");
		return "file";
	}

}
