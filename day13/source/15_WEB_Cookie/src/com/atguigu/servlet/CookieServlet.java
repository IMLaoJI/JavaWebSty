package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//在服务器中创建Cookie
		Cookie cookie = new Cookie("username", "sunwukong");
		Cookie cookie2 = new Cookie("gender", "monkey");
		
		//修改Cookie的有效路径
		//Cookie的路径由浏览器解析，所以设置路径时需要加上项目名
		cookie.setPath(request.getContextPath()+"/hello");
		
		
		//将Cookie发送给浏览器
		/**
		 * 当通过addCookie将Cookie发送给浏览器时，服务器
		 * 会在响应报文中设置一个名为Set-Cookie的响应头，具体如下：
		 * Set-Cookie: username=sunwukong
		 * 
		 * 浏览器收到这个响应头以后，会将Cookie的信息保存起来，
		 * 并且在下次访问服务器时，通过请求报文携带该Cookie，格式如下
		 * Cookie: username=sunwukong
		 */
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
	}


}
