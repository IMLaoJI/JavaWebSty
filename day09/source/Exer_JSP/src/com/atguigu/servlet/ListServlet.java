package com.atguigu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Student;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建学生列表
		List<Student> list = new ArrayList<Student>();
		//向列表中添加学生
		list.add(new Student("孙悟空", "男", "花果山"));
		list.add(new Student("猪八戒", "男", "高老庄"));
		list.add(new Student("沙和尚", "男", "流沙河"));
		list.add(new Student("白骨精", "女", "白骨洞"));
		list.add(new Student("蜘蛛精", "女", "盘丝洞"));
		list.add(new Student("奔波霸", "男", "通天河"));
		
		//把list放入进域中
		//request
		//request.getSession();
		//getServletContext();
		request.setAttribute("list", list);
		
		//转发请求到list.jsp
		//WEB-INF目录下的资源不能直接被访问，但是通过转发可以访问
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/list.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
