package com.yjp.springboot.server;

import org.springframework.beans.factory.annotation.Autowired;

import com.yjp.springboot.bean.Base;
import com.yjp.springboot.dao.UserDao;

public abstract class BaseService<T extends Base> {
	
	@Autowired
	private UserDao userDao;
	
	public T findById(int id){
		 return (T) userDao.getUserJPQL(id);
	}

}
