package org.wesoft.spring.scan.bean;

import org.wesoft.spring.proxy.demo.anno.Select;

// @MyComponent
public interface UserDao {

	@Select("select * from user")
	Object[] findAll();

}
