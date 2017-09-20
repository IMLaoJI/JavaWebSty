package com.atguigu.bookstore.service;

import com.atguigu.bookstore.bean.User;

/**
 * 定义用户相关业务的接口
 * @author lilichao
 *
 */
public interface UserService {
	
	/**
	 * 用户登录的方法
	 * @param user
	 * @return
	 */
	User login(User user);
	
	/**
	 * 用户注册的方法
	 * @param user
	 * @return
	 */
	boolean regist(User user);

}
