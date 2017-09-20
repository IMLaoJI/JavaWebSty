package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodServlet
 */
public class EncodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户填写的请求参数
		//String username = request.getParameter("username");
		
		//System.out.println(username);
		
		//设置response的编码字符集
		//response.setCharacterEncoding("utf-8");
		
		//设置一个Content-Type响应
		//response.setHeader("Content-type", "text/html;charset=utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		//向页面输出一段内容
		response.getWriter().print("张三");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String aa = request.getParameter("username");
		
		//当我们去处理post请求乱码时，需要指定request所使用的字符集
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		System.out.println(username);
	}

}
