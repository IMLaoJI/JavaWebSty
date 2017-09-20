package com.atguigu.bookstore.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bookstore.bean.User;

/**
 * WEB相关操作的工具类
 * @author lilichao
 *
 */
public class WEBUtils {

	/**
	 * 将请参数封装为一个对象，并返回
	 * @param request
	 * @param t
	 * @return
	 */
	public static <T>T param2Bean(HttpServletRequest request, T t) {
		
		//获取请求参数的map
		Map map = request.getParameterMap();
		
		System.out.println(map);
		
		try {
			//将map转换为一个对象
			BeanUtils.populate(t, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return t;
	}

	
}
