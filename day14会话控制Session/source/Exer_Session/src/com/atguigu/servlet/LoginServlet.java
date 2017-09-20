package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取HttpSession对象
		HttpSession session = request.getSession();
		
		//获取用户名
		String username = request.getParameter("username");
		
		/**
		 * 我们如何判断用户是否登录？
		 * 我可以将用户的信息放到一个域中，然后就可以通过看域中有没有用户信息，来判断用户是否登录！
		 * 一般情况我们会将User对象放入到Session域中，来验证用户是否登录
		 */
		
		//将username放入到Session域中
		session.setAttribute("loginUser", username);
		
		//默认登录成功，重定向到index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
