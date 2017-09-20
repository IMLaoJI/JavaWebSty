package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author lilichao
 *
 *转发和重定向比较
 *
 *					浏览器发送的请求次数			发生的位置				浏览器地址栏			浏览器是否感知
 *	转发（request）			1				  服务器				不发生改变					不可以
 *	重定向（response）			2				浏览器				发生改变				        可以知道
 *
 *
 */
public class HServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 请求首行
		 * 请求头
		 * 空行
		 * 请求体
		 * 
		 * 
		 * HttpServletRequest
		 * 代表：浏览器发送给服务器的请求报文
		 * 获取：该对象由Tomcat服务器创建，最终作为参数传递给doGet或doPost方法
		 * 功能：
		 * 	【1】获取请求参数
		 * 	【2】可以获取项目名
		 *  【3】可以作为一个域对象在不同的web资源之间共享数据（request servletContext）
		 *  【4】可以做请求的转发
		 */
		
		//获取请求参数
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//在页面中输出用户名
		response.getWriter().print("<h1>username = "+username+"</h1>");
		System.out.println(password);*/
		
		//获取项目名
		//这个方法主要用来设置绝对路径
		/*String contextPath = request.getContextPath();
		System.out.println(contextPath);*/
		
		
		//请求的转发
		/**
		 * 所谓的转发就是servlet收到浏览器发送的请求以后，
		 * 当前servlet不去处理请求，
		 * 而是去调用服务器内部的其他资源去处理请求。
		 * 转发的特点：
		 * 	转发时浏览器发送了1次请求
		 *  转发是在服务器内部进行的
		 *  浏览器的地址栏不会发生改变
		 *  浏览器不知道转发的发生
		 * 
		 */
		//1.获取一个请求的派发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("target.html");
		//2.通过dispatcher发起转发操作
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 响应首行
		 * 响应头
		 * 空行
		 * 响应体
		 * 
		 * 
		 * HttpServletResponse
		 * 代表：代表服务器发送给浏览器的响应报文
		 * 获取：该对象由服务器创建，最终作为参数传递到doGet或doPost方法中，我们可以在这两个方法中直接使用
		 * 功能：
		 * 	【1】向浏览器输出一个页面或者是页面片段
		 * 	【2】可以发起请求的重定向
		 * 
		 */
		
		//【1】向浏览器输出一个页面或者是页面片段
		//response.getWriter().print("");
		//获取一个字符输出流
		PrintWriter out = response.getWriter();
		//通过流向浏览器响应一段信息
		out.print("<h1>Hello</h1>");
		
		//【2】可以发起请求的重定向
		/**
		 * 重定向指的是当服务器收到一个请求后，返回给浏览器一个特殊的响应
		 * 这个特殊的响应告诉浏览器再去向另一个地址发送请求。
		 * 
		 * HTTP/1.1 302 Found
		   Location: http://localhost:8080/08_WEB_Servlet/target.html
		   
		   这个特殊的响应的响应状态码是302，还有一个特殊的头Location，Location指向一个新的地址
		   当浏览器收到302这个响应状态码，他会想Location头所指向的地址再次发送请求
		   
		   重定向的特点：
		   	重定向时浏览器发送了2次请求
		   	重定向是发生浏览器端
		   	重定向时浏览器的地址栏发生改变
		   	浏览器可以感知重定向的发生
		 */
		response.sendRedirect("target.html");
		
	}

}
