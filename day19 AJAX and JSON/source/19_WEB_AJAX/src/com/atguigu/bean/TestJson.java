package com.atguigu.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class TestJson {
	
	@Test
	public void test3(){
		
		
		//创建一个List
		List<Student> list = new ArrayList<Student>();
		
		//向list中添加学生
		list.add(new Student("孙悟空", 18, "男", "花果山"));
		list.add(new Student("悟空", 28, "男", "花果山2号"));
		list.add(new Student("孙行者", 38, "男", "果山3号"));
		list.add(new Student("行者孙", 48, "男", "山4号"));
		
		//将list转换为一个JSON字符串
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		//将JSON字符串转换为一个List
		List<Map<String,Object>> list2 = gson.fromJson(str, List.class);
		
		System.out.println(list2.get(0));
		
	}
	
	
	@Test
	public void test2(){
		
		//将Map转换为一个JSON
		Map<String, Object> map = new HashMap<String, Object>();
		
		//向map中添加数据
		map.put("name", "猪八戒");
		map.put("age", 28);
		map.put("adddress", "高老庄");
		
		//创建一个GSON对象
		Gson gson = new Gson();
		String str = gson.toJson(map);
		
		//将字符串转换为一个map
		Map<String,Object> map2 = gson.fromJson(str, Map.class);
		
		System.out.println(map2.get("name"));
		
	}

	@Test
	public void test1() {
		
		//JAVA对象 --> JSON
		//创建一个Java对象
		Student stu = new Student("孙悟空", 18, "男", "花果山");
		
		//String str = "{\"name\"}";
		
		//创建一个Gson的对象
		Gson gson = new Gson();
		
		//将stu转换为一个字符串
		String stuStr = gson.toJson(stu);
		
		//将stuStr转换为一个Student对象
		//fromJson需要两个参数，第一个json字符串，第二个目标对象的大Class对象
		Student stu2 = gson.fromJson(stuStr, Student.class);
		
		
		System.out.println(stu2.getName());
		
		
	}

}
