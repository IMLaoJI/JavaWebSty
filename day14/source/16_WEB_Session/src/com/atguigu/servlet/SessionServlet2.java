package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionServlet2
 */
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//修改JSESSIONID这个Cookie的有效时间
		Cookie[] cookies = request.getCookies();
		
		//判断cookie是否为null 
		if(cookies != null){
			//遍历cookies
			for (Cookie cookie : cookies) {
				
				//判断当前Cookie的name是否为JSESSIONID
				if("JSESSIONID".equals(cookie.getName())){
					//修改Cookie的有效时间
					cookie.setMaxAge(60*10);
					
					//将修改后的Cookie发送给浏览器，替换老的Cookie
					response.addCookie(cookie);
				}
			}
		}
		
	}


}
