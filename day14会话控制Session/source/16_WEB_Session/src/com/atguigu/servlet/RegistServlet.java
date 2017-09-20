package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//使线程睡两秒钟，模拟网速较差的情况
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//获取浏览器持有的token
		String reqToken = request.getParameter("token");
		
		//获取session中保存的token
		String sessToken = (String) request.getSession().getAttribute("token");
		
		//将使用过的token从session中移除
		request.getSession().removeAttribute("token");
		
		//比较令牌是否一致
		if(reqToken != null && reqToken.equals(sessToken)){
			//令牌一致，处理请求
			//获取用户名
			String username = request.getParameter("username");
			
			//将用户信息插入进数据库
			System.out.println("已经将 "+username+" 插入进数据库！");
			
			//转发到regist-success.jsp
			//request.getRequestDispatcher("/form/regist-success.jsp").forward(request, response);
			//重定向到regist-success.jsp
			response.sendRedirect(request.getContextPath()+"/form/regist-success.jsp");
			
		}else{
			
			//重复提交的请求，重定向到一个错误页面
			response.sendRedirect(request.getContextPath()+"/form/error.jsp");
		}
		
		
		
		
		
	}

}
