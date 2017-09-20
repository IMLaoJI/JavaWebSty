package com.atguigu.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class TestBeanUtils {
	
	@Test
	public void test2(){
		
		//创建一个map
		Map<String, Object> map = new HashMap<String, Object>();
		//向map中添加属性
		map.put("name1", "猪八戒");
		map.put("age", "38");
		map.put("address", "高老庄");
		
		//将这个map转换为一个Student对象
		Student stu = new Student();
		
		//populate可以将一个map转换成指定的java对象，要求map中key要和对象的属性名一致
		try {
			BeanUtils.populate(stu, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(stu);
		
		
	}

	@Test
	public void test() {
		
		Student stu = new Student();
		
		/*stu.setName("孙悟空");
		stu.setAge(18);
		stu.setAddress("花果山");*/
		
		String name = "sunwukong";
		String age = "18";
		String address = "花果山";
		
		//BeanUtils可以动态想JavaBean设置或读取属性
		//使用BeanUtils需要导入两个jar包
		//commons-beanutils-1.8.0.jar
		//commons-logging-1.1.1.jar
		//setProperty方法需要设置三个参数，第一个参数需要一个对象，指定要为哪个对象设置属性
		//第二参数要设置的属性名 , 第三个参数时一个要设置的值
		try {
			//这个方法就可以像stu对象中设置一个name属性为孙悟空
			BeanUtils.setProperty(stu, "name", "孙悟空");
			//设置一个age,BanUtils可以自动转型
			BeanUtils.setProperty(stu, "age", "abc");
			
			BeanUtils.setProperty(stu, "address", "花果山");
			
			System.out.println(stu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
