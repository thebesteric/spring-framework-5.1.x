package org.wesoft.spring.proxy.statics.extend;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 10:55
 */
public class Test {
	public static void main(String[] args) {
		UserService userService = new UserServiceProxyLog();
		userService.find();
	}
}
