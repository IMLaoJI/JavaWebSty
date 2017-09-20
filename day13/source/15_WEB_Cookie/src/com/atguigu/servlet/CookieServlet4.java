package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet4
 */
public class CookieServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使名为username的Cookie立即失效
		Cookie cookie = new Cookie("username", "aa");
		
		//将cookie设置为立即失效
		cookie.setMaxAge(0);
		
		//将Cookie发送给浏览器，替换老的Cookie
		response.addCookie(cookie);
	}


}
