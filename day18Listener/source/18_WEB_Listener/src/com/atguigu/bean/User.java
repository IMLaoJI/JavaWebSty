package com.atguigu.bean;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
		//获取属性名
		String nm = event.getName();
		
		//获取属性值
		Object value = event.getValue();
		
		//获取session对象
		HttpSession session = event.getSession();
		
		System.out.println(nm+" = "+value);
		
		System.out.println("哈哈，我被设置进session域中了");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
		System.out.println("555,我被从session域中移除了");
	}

}
