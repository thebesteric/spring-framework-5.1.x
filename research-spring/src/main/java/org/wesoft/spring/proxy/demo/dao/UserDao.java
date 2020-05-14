package org.wesoft.spring.proxy.demo.dao;



import org.wesoft.spring.proxy.demo.anno.Select;

import java.util.List;

public interface UserDao {

	@Select("select * from user")
	List<Object> query();

}
