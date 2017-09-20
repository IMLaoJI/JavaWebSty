package com.atguigu.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.atguigu.xml.bean.Student;

public class TestDOM {
	
	@Test
	public void testDOM2() throws Exception{
		//获取工厂类实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取解析器类实例
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档获取Document对象
		Document document = builder.parse("stu.xml");
		
		//通过Document对象解析文档
		//getElementById在这不好使，XML中均为自定义属性，id在xml目前没有意义的
		/*Element ele = document.getElementById("1");
		System.out.println(ele);*/
		
		//获取所有student标签的NodeList
		NodeList stuEles = document.getElementsByTagName("student");
		
		//遍历stuEles读取学生信息
		for(int i=0 ; i<stuEles.getLength() ; i++){
			//获取学生标签
			//将node强转为Element
			Element stuEle = (Element) stuEles.item(i);
			//获取id属性值
			String idStr = stuEle.getAttribute("id");
			//获取name值
			Node nameNode = stuEle.getElementsByTagName("name").item(0);
			String name = nameNode.getTextContent();
			
			//获取age
			String ageStr = stuEle.getElementsByTagName("age").item(0).getTextContent();
			
			//获取gender
			String gender = stuEle.getElementsByTagName("gender").item(0).getTextContent();
			
			//获取address
			String address = stuEle.getElementsByTagName("address").item(0).getTextContent();
			
			//System.out.println(idStr+"--"+name+"--"+ageStr+"--"+gender+"--"+address);
			//封装Student对象
			Student stu = new Student(Integer.parseInt(idStr), name, Integer.parseInt(ageStr), gender, address);
			
			System.out.println(stu);
			
		}
		
	}

	@Test
	public void testDOM() throws Exception {
		
		//获取工厂类实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取解析器类实例
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml文档获取Document对象
		Document document = builder.parse("stu.xml");
		
		System.out.println(document);
		
	}

}
