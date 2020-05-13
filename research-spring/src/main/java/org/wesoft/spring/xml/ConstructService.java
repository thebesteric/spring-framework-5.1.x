package org.wesoft.spring.xml;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-10 00:44
 */
public class ConstructService {

	TestService testService;

	public ConstructService(TestService testService) {
		this.testService = testService;
	}

	public void getTestService() {
		System.out.println(testService);
	}

}
