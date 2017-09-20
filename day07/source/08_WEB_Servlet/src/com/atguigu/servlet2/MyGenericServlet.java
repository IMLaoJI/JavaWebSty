package com.atguigu.servlet2;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class MyGenericServlet implements Servlet , ServletConfig {
	
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		
		//调用init()方法
		init();
	}
	
	public void init(){
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException ;

	@Override
	public String getServletInfo() {
		return "我是一个漂亮的Servlet";
	}

	@Override
	public void destroy() {
	}

	@Override
	public String getServletName() {
		return this.getServletConfig().getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		return this.getServletConfig().getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		return this.getServletConfig().getInitParameter(name);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return this.getServletConfig().getInitParameterNames();
	}

}
