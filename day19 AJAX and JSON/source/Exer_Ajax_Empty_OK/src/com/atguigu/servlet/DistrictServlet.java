package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.District;
import com.atguigu.dao.DistrictDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class DistrictServlet
 */
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//创建一个districtdao
	private DistrictDao districtDao = new DistrictDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		//获取城市的id
		String id = request.getParameter("id");
		//调用dao查询区县的信息
		List<District> list = districtDao.getListByCityId(id);
		
		//将list转换为一个JSON字符串
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		//将str作为响应发送
		response.getWriter().print(str);
		
	}

}
