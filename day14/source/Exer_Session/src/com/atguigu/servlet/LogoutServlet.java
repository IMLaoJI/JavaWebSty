package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 登出有两种方案
		 * 1.可以只移除用户对象
		 * 2.直接使Session失效 *****
		 * 
		 */
		
		//获取Session
		HttpSession session = request.getSession();
		
		//直接使session失效
		session.invalidate();
		
		//重定向到index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}


}
