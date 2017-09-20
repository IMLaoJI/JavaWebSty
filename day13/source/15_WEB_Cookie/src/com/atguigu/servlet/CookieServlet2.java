package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet2
 */
public class CookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//读取浏览器携带的Cookie信息
		Cookie[] cookies = request.getCookies();
		
		//遍历之前先判断cookies是否为null
		if(cookies!=null){
			//遍历Cookie
			for (Cookie cookie : cookies) {
				//获取Cookie的name
				String name = cookie.getName();
				
				//获取Cookie的value
				String value = cookie.getValue();
				
				if("username".equals(name)){
					//修改Cookie的值为shaseng
					cookie.setValue("shaseng");
					
					//将修改过的Cookie再次发送给浏览器
					response.addCookie(cookie);
				}
				
			}
		}
		
		
	}


}
