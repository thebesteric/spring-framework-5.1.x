package org.wesoft.spring.proxy.statics.aggregation;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 13:48
 */
public class Test {

	public static void main(String[] args) {
		Service proxy = new ServiceLog(new UserService());
		proxy.query();

		Service proxy1 = new ServicePower(proxy);
		proxy1.query();
	}

}
