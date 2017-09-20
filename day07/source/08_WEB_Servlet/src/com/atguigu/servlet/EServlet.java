package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EServlet
 */
public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 一般情况下Servlet不会分别处理get请求和post请求，而是对两个请做一个统一的处理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编写业务逻辑
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
