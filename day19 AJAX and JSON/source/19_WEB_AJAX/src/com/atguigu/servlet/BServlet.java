package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BServlet
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//给浏览器响应一个JSON字符串
		//设置一个响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//获取请求参数
		String name = request.getParameter("name");
		
		System.out.println("name = "+name);
		
		//创建一个JSON字符串
		String str = "{\"username\":\"牛魔王\",\"age\":18,\"gender\":\"男\"}";
		
		//将字符串作为响应发送
		response.getWriter().print(str);
		
		
	}

}
