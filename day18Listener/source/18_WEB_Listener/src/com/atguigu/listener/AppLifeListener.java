package com.atguigu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener用来监听ServletContext对象的生命周期
 * ServletContext对象就是咱们application对象
 * ServletContext在项目启动时创建，在项目停止时销毁
 * @author lilichao
 *
 */
public class AppLifeListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("哈哈哈！我是ServletContext，我出生了！");
		
		ServletContext servletContext = sce.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("~~~~(>_<)~~~~ ， 我要挂了~~~");
	}

}
