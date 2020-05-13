package org.wesoft.spring.inject.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-08 23:45
 */
@Component
@Scope("prototype")
public class ProtoTypeBean {
	public ProtoTypeBean() {
		System.out.println("ProtoTypeBean init");
	}
}
