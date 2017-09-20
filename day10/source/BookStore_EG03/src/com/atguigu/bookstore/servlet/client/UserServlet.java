package com.atguigu.bookstore.servlet.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;

/**
 * 处理用户相关请求的Servlet
 * @author lilichao
 *
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	//创建一个UserService对象
	private UserService userService = new UserServiceImpl();
       
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户传递的请求参数
		String methodName = request.getParameter("method");
		
		//通过方法名获取到方法的对象
		
		//获取当前类的Class对象
		Class<? extends UserServlet> cla = this.getClass();
		//获取cla的的方法（Method对象）
		//getDeclaredMethod需要两个参数，方法名和参数名
		//因为在java需要通过方法名和参数列表来确定一个方法
		try {
			//获取方法对象
			Method method = cla.getDeclaredMethod(methodName, HttpServletRequest.class , HttpServletResponse.class);
			//设置方法的访问权限
			method.setAccessible(true);
			//调用方法
			//invoke用于调用一个方法，第一个参数时要调用方法的对象，剩下是调用方法需要的参数
			method.invoke(this, request , response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//根据mehodName的值去调用不同的方法
		if("login".equals(methodName)){
			//调用login方法
			login(request, response);
		}else if("regist".equals(methodName)){
			//调用regist方法
			regist(request, response);
		}else if("delUser".equals(methodName)){
			delUser();
		}
		
		
	}*/
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//调用WEBUtils将请求参数封装为一个User对象
		User user = WEBUtils.param2Bean(request , new User());
		
		//获取到请求参数的map
	/*	Map map = request.getParameterMap();
		//创建一个User对象
		User user = new User();
		
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		//System.out.println(user);
		
		/*//获取用户填写用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//将用户名和密码封装为User对象
		User user = new User(null, username, password, null);*/
		
		//调用Service验证用户名和密码
		User loginUser = userService.login(user);
		
		//如果loginUser为null，用户名或密码错误，转发到login.html
		if(loginUser == null){
			
			//登录失败，设置一个错误消息 用户名或密码错误
			request.setAttribute("msg", "用户名或密码错误！");
			
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//用户名和密码正确登录成功,重定向到login-success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
		
	}

	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//获取用户填写用户名、密码、电子邮件
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//封装User对象
		User user = new User(null, username, password, email);*/
		
		User user = WEBUtils.param2Bean(request, new User());
		
		//调用Service将User插入进数据库
		boolean isRegist = userService.regist(user);
		
		//注册成功，重定向到regist_success.html
		if(isRegist){
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//设置一个错误消息
			request.setAttribute("msg", "用户名已存在！");
			
			//注册失败,转发到regist.html
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			
		}
	}


}
