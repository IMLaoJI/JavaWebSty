package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 要编写一个Servlet
 * 1.创建一个类并实现Servlet接口
 * 2.在服务器中配置Servlet
 * @author lilichao
 * 
 * Servlet由我们创建但是由Servlet容器（Tomcat服务器）管理
 * Servlet容器主要负责管理Servlet的生命周期
 * 
 * 人的生命周期：人从生到死的过程叫做人的生命周期
 * 
 * Servlet的生命周期：Servlet对象从被创建到被销毁的过程！
 * 
 * 当我们第一次访问Servlet时
 * 	1.构造器
 *  2.init()
 *  3.service()
 *  
 * 当第一次以后访问Servlet时
 * 	service()方法
 * 
 * 当项目卸载时
 * 	destroy()方法
 * 
 * 
 * Servlet的生命周期方法：
 * 	1.构造器
 * 		- 构造器用来创建Servlet的对象，Servlet第一次接收请求时调用，只调用了一次。
 * 		- 构造器只调用了一次，说明Servlet是单例，以多线程形式去调用service()方法
 * 		- servlet不是线程安全，所以尽量不要在service()方法中操作全局变量。
 * 
 *  2.init()
 *  	- 构造器被调用后紧接着被调用，init方法用来对Servlet进行初始化操作，只调用了一次。
 *  
 *  3.service()
 *  	- 每次处理请求的时候service()方法都会被调用，会被调用多次。
 *  
 *  4.destroy()
 *  	- web项目卸载时调用，用来在对象被销毁前做一些收尾工作。只会调用一次。
 * 
 *
 */
public class HelloServlet implements Servlet {
	
	public HelloServlet() {
		System.out.println("构造器...");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init方法被调用。。。");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		System.out.println("getServletConfig方法被调用。。。");
		
		return null;
	}

	/**
	 * ServletRequest 封装的是浏览器发送给服务器请求报文
	 * ServletResponse 封装的是服务器发送给浏览器响应报文
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		/*//向控制台输出一个语句
		System.out.println("你好！ Servlet");
		
		//给浏览器发送一个信息
		//通过response对象获取一个输出流
		PrintWriter out = res.getWriter();
		//通过out可以向浏览器发送信息
		out.print(new Date());*/
		
		System.out.println("service方法被调用。。。");
		
	}

	@Override
	public String getServletInfo() {
		
		System.out.println("getServletInfo方法被调用。。。");

		
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy方法被调用。。。");
	}


}
