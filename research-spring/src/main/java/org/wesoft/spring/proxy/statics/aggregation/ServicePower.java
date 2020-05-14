package org.wesoft.spring.proxy.statics.aggregation;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 13:51
 */
public class ServicePower implements Service {
	Service target;

	public ServicePower(Service target) {
		this.target = target;
	}

	@Override
	public void query() {
		System.out.println("power");
		target.query();
	}
}
