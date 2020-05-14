package org.wesoft.spring.proxy.dynamic;


import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 13:48
 */
public class Test {

	public static void main(String[] args) {
		Service target = new UserService();
		Service proxy = MyProxy.getInstance(target, new MyInvocationHandler() {
			@Override
			public void invoke() {
				System.out.println("record log...");
			}
		});
		proxy.query("hello");
	}

}
