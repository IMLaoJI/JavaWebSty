package com.atguigu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * ServletRequestListener用来监听request的创建和销毁
 * @author lilichao
 *
 */
public class ReqLifeListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request要死了");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
		
		System.out.println("request出生了");
	}

}
