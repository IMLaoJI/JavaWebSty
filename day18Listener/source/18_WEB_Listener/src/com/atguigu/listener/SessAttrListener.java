package com.atguigu.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 监听Session中属性变化的监听器
 * @author lilichao
 *
 */
public class SessAttrListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		
		//获取添加的属性的名字
		String name = se.getName();
		
		//获取添加属性的值
		Object value = se.getValue();
		
		System.out.println("Session中添加了一个属性: "+name+" = "+value);

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		//获取添加的属性的名字
		String name = se.getName();
		
		//获取添加属性的值
		Object value = se.getValue();
		
		System.out.println("Session中的一个属性被移除: "+name+" = "+value);

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		//获取添加的属性的名字
		String name = se.getName();
		
		//获取添加属性的值
		//获取到的是老值
		Object value = se.getValue();
		
		//获取新的属性的值
		HttpSession session = se.getSession();
		Object newValue = session.getAttribute(name);
		
		System.out.println("Session中的一个属性被替换了: "+name+" = "+value +" --> 新值为："+newValue);
	}

}
