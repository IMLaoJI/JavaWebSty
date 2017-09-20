package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户填写的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//去数据库中验证用户名和密码是否正确（默认只有一个用户 admin 密码 123123）
		if("admin".equals(username) && "123123".equals(password)){
			// 登录成功 重定向到login-success.html
			response.sendRedirect("login-success.html");
		}else{
			//登录失败 转发到login-error.html
			request.getRequestDispatcher("login-error.html").forward(request, response);;
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
