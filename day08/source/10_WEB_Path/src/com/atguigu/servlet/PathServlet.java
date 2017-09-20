package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//转发到1.html
		//转发是在服务器内部进行，它会自动为绝对路径加上项目名
		request.getRequestDispatcher("/hello/1.html").forward(request, response);
		
		//重定向是发生在浏览器端的，地址由浏览器解析，绝对路径需要加上项目名
		
		/*String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		response.sendRedirect(contextPath+"/hello/1.html");*/
		
	}


}
