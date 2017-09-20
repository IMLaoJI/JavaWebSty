package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用来接收AJAX的请求
 * @author lilichao
 *
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//向控制台输出一个语句
		System.out.println("报告超哥！我已收到请求！");
		
		//获取请求参数
		String username = request.getParameter("username");
		
		System.out.println("username = "+username);
		
		//发送一个响应信息
		response.getWriter().print("<h3>Hello AJAX!</h3>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码
		response.setContentType("text/xml;charset=utf-8");
		
		System.out.println("收到AJAX发送的POST请求");
		
		//获取请求参数
		System.out.println(request.getParameter("username"));
		
		//发送一个响应信息
		response.getWriter().print("<user>");
		response.getWriter().print("<name>tangseng</name>");
		response.getWriter().print("</user>");
	}

}
