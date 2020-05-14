package org.wesoft.spring.proxy.dynamic;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 17:38
 */
public class UserService implements Service {
	@Override
	public void query(String name) {
		System.out.println("query " + name);
	}
}
