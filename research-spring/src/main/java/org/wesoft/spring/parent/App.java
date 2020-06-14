package org.wesoft.spring.parent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wesoft.spring.parent.bean1.ParentBean;
import org.wesoft.spring.parent.bean2.ChildBean;

public class App {

	public static void main(String[] args) {
		// 父容器
		AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext();
		parent.register(AppConfigParent.class);
		parent.refresh();

		// 子容器
		AnnotationConfigApplicationContext child = new AnnotationConfigApplicationContext();
		child.register(AppConfigChild.class);
		child.setParent(parent);
		child.refresh();

		System.out.println("from parent context: " + parent.getBean(ParentBean.class));
		System.out.println("from child context: " +child.getBean(ChildBean.class));
		System.out.println("from child context: " +child.getBean(ParentBean.class));

	}

}
