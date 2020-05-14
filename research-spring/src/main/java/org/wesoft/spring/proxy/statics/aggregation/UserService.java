package org.wesoft.spring.proxy.statics.aggregation;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 13:49
 */
public class UserService implements Service {
	@Override
	public void query() {
		System.out.println("query for user");
	}
}
