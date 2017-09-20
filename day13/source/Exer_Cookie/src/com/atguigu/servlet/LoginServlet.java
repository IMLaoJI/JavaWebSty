package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户输入的用户名和密码
		String username = request.getParameter("username");
		 
		//默认登录成功
		//创建一个Cookie，保存用户名
		Cookie cookie = new Cookie("username", username);
		//设置一个有效时间
		cookie.setMaxAge(60*60*24*7);
		//将Cookie发送给浏览器
		response.addCookie(cookie);
		
		//重定向到login-success.jsp
		response.sendRedirect(request.getContextPath()+"/login-success.jsp");
		
		
	}

}
