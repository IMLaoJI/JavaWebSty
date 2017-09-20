package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BServlet implements Servlet {
	
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		this.config = config;

	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		/**
		 * ServletContext
		 * 代表：代表整个web应用，每一个web应用都有他唯一对应ServletContext对象，该对象在项目启动时创建，在项目卸载销毁
		 * 获取：通过ServletConfig获取
		 * 功能：
		 * 	【1】获取整个WEB应用的初始化参数
		 * 		<context-param>
					<param-name>url</param-name>
					<param-value>http://www.atguigu.com</param-value>
				</context-param>
				
			【2】可以获取到资源的真实路径
				虚拟路径：http://localhost:8080/08_WEB_Servlet/index.html
				真实路径：资源在硬盘中的地址
				
			【3】可以作为一个最大的域对象在不同的WEB资源之间共享数据。
				application
				
		 */
		
		//通过ServletConfig获取ServletContext
		ServletContext context = this.getServletConfig().getServletContext();
		//获取全局的初始化参数
		String url = context.getInitParameter("url");
		//System.out.println("url = "+url);
		
		//获取index.html的真实路径（物理路径）
		//主要用于做上传和下载
		String realPath = context.getRealPath("/hello.html");
		System.out.println(realPath);
		

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
