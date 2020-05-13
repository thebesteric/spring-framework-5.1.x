package org.wesoft.spring.inject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;
import org.wesoft.spring.inject.bean.Other;
import org.wesoft.spring.inject.bean.ProtoTypeBean;

import javax.annotation.PostConstruct;

@Service
public abstract class MyService {

	@Autowired
	Other foo;

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ProtoTypeBean protoTypeBean;

	@PostConstruct
	public void init() {
		System.out.println("foo = " + foo.getClass().getName());
	}

	public void isProtoType() {
		System.out.println(protoTypeBean.hashCode());
	}

	public void getProtoTypeBean() {
		System.out.println(applicationContext.getBean(ProtoTypeBean.class).hashCode());
	}

	@Lookup
	public abstract ProtoTypeBean lookupProtoTypeBean();

	public void getProtoTypeBeanForLookup() {
		System.out.println(lookupProtoTypeBean().hashCode());
	}

}
