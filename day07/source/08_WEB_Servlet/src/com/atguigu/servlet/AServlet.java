// package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		/**
		 * 一个Servlet都有他唯一对应的ServletConfig
		 * 
		 * ServletConfig
		 * 代表：封装的就是Servlet的配置信息，封装的就是servlet标签中的聂荣
		 * 获取：该对象由服务器创建，最终会作为参数传到init方法中，我们可以在这个方法中直接使用
		 * 功能：
		 * 	【1】 获取servlet的别名
		 * 	【2】获取当前Servlet的初始化参数
		 * 	【3】获取ServletContext对象
		 * 		<init-param>
					<param-name>user</param-name>
					<param-value>root</param-value>
				</init-param>
		 */
		
		//【1】 获取servlet的别名
		String servletName = config.getServletName();
		//输出servletName
		System.out.println("别名:"+servletName);
		
		//2.获取当前Servlet的初始化参数
		String user = config.getInitParameter("user");
		System.out.println("user: "+user);
		
		//3.获取ServletContext对象
		// 我们web应用中所有信息都封装在ServletContext对象中，每一个web应用都对应着一个唯一的ServletContext
		ServletContext context = config.getServletContext();
		
		String url = context.getInitParameter("url");
		System.out.println("AServlet ："+url);
		

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
