package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet3
 */
public class CookieServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//创建一个name为username的Cookie
		Cookie cookie = new Cookie("username", "bajie");
		
		//设置Cookie的有效时间
		//可以通过setMaxAge()来设置Cookie的有效时间，接收一个秒数作为参数
		
		//当秒数大于0时，有效时间会设置为相应的秒数
		//cookie.setMaxAge(30);
		
		//当秒数等于0时，代表Cookie立即失效，浏览器不会保存。
		//cookie.setMaxAge(0);
		
		//当秒数小于0时，和不设置是一样，一次会话中有效
		//cookie.setMaxAge(-100);
		
		//设置一个永久有效的时间
		cookie.setMaxAge(60*60*24*365*10);
		
		//将Cookie发送给浏览器
		response.addCookie(cookie);
	}


}
