package org.wesoft.spring.proxy.statics.extend;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 10:54
 */
public class UserServiceProxyLog extends UserService {

	@Override
	public void find() {
		System.out.println("record log");
		super.find();
	}
}
