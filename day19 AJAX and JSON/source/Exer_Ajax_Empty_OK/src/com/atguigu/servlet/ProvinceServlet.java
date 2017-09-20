package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Province;
import com.atguigu.dao.ProvinceDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class ProvinceServlet
 */
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//获取省份的DAO 
	private ProvinceDao provinceDao = new ProvinceDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//调用DAO获取省份信息
		List<Province> list = provinceDao.getProvinceList();
		
		//将list转换为一个JSON字符串
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		//将字符串作为响应发送
		response.getWriter().print(str);
		
	}

}
