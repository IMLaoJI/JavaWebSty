package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String parameter = request.getParameter("");
		
		request.setAttribute("name", "aa");
		Object attribute = request.getAttribute("");*/
		
		
		//获取Session对象
		HttpSession session = request.getSession();
		
		//在session中设置一个属性
		session.setAttribute("username", "孙悟空");
		
		//每一个session对象都一个唯一的标识（ID）
		String id = session.getId();
		
		response.getWriter().print("<h1>"+id+"</h1>");
	}


}
