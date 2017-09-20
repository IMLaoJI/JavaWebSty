package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.atguigu.servlet2.MyGenericServlet;

public class CServlet extends MyGenericServlet {
	
	@Override
	public void init() {
		
		System.out.println("我是CServlet的初始化操作！！");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		//获取phone的值
		String phone = getInitParameter("phone");
		
		System.out.println("phone = "+phone);
		
		
		System.out.println("Hello Servlet");
		
		res.getWriter().print("Hello");
		
	}

}
