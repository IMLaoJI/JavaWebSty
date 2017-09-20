package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.City;
import com.atguigu.dao.CityDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//创建一个CityDao
	private CityDao cityDao = new CityDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//获取省份的id
		String id = request.getParameter("id");
		
		//根据省份的id查找城市信息
		List<City> list = cityDao.getCityByProId(id);
		
		//将list转换为一个JSON字符串
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		//将字符串作为响应发送
		response.getWriter().print(str);
		
	}

}
