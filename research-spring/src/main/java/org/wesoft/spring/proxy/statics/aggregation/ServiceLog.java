package org.wesoft.spring.proxy.statics.aggregation;

import org.wesoft.spring.proxy.statics.aggregation.Service;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 13:18
 */
public class ServiceLog implements Service {

	Service target;

	public ServiceLog(Service target) {
		this.target = target;
	}

	@Override
	public void query() {
		System.out.println("log");
		target.query();
	}
}
