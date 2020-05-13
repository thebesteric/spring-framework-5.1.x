package org.wesoft.spring.xml;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-08 14:46
 */
public class TestService {

	private MyService myService;

	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}
}
