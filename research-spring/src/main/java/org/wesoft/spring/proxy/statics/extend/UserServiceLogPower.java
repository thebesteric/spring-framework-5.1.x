package org.wesoft.spring.proxy.statics.extend;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 11:12
 */
public class UserServiceLogPower extends UserServiceProxyPower {

	@Override
	public void find() {
		System.out.println("record log");
		super.find();
	}
}
