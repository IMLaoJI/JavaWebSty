package com.atguigu.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Student implements HttpSessionActivationListener , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		
		HttpSession session = se.getSession();
		
		System.out.println("我和Session一起去硬盘了，不要找我了~~");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("哈哈，我又和session一起回来了！！");
	}

}
