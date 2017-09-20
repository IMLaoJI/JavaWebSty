package com.atguigu.xml.dom;

import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.atguigu.xml.bean.Student;

public class TestDOM4J {
	/**
	 * 通过dom4j使用xpath要先导入一个jar包
	 * 	jaxen-1.1-beta-6.jar
	 * @throws Exception 
	 */
	@Test
	public void testXpath() throws Exception{
		
		SAXReader reader = new SAXReader();
		Document document = reader.read("stu.xml");
		
		//我们使用selectNodes 或 selectSingleNode
		//查询id为2的学生
		Element stuEle = (Element) document.selectSingleNode("/students/student[@id='2']");
		
		//获取学生的信息
		String idStr = stuEle.attributeValue("id");
		String name = stuEle.elementText("name");
		String ageStr = stuEle.elementText("age");
		String gender = stuEle.elementText("gender");
		String address = stuEle.elementText("address");
		
		//封装为一个学生对象
		Student stu = new Student(Integer.parseInt(idStr), name, Integer.parseInt(ageStr), gender, address);
		
		System.out.println(stu);
		
	}
	
	@Test
	public void testDOM4jWrite2() throws Exception{
		//创建一个Document对象
		Document document = DocumentHelper.createDocument();
		//添加一个跟节点
		Element rootEle = document.addElement("teachers");
		//添加teacher元素
		rootEle.addElement("teacher").addText("佟老师");
		rootEle.addElement("teacher").addText("苍老师");
		
		//将Document对象写入到文件中
		XMLWriter writer = new XMLWriter(new FileWriter("teacher.xml"), OutputFormat.createPrettyPrint());
		writer.write(document);
		//关闭流
		writer.close();
	}
	
	@Test
	public void testDOM4JWrite() throws Exception{
		//获取解析器类实例
		SAXReader reader = new SAXReader();
		//解析xml文件获取Document对象
		Document document = reader.read("stu.xml");
		//向students标签中添加一个新的学生信息
		//获取根节点
		Element rootEle = document.getRootElement();
		
		/*
		 * 
		 * <student id="1">
				<name>孙悟空</name>
				<age>18</age>
				<gender>男</gender>
				<address>花果山</address>
			</student>
		 * */
		
		//向根节点中添加一个student标签
		Element stuEle = rootEle.addElement("student");
		//向stuEle中添加一个id属性
		stuEle.addAttribute("id", "4");
		//添加name
		stuEle.addElement("name").addText("李逍遥");
		//添加age gender address
		stuEle.addElement("age").addText("18");
		stuEle.addElement("gender").addText("男");
		stuEle.addElement("address").addText("余杭县");
		
		//将修改的内容输出到文件中
		
		//创建一个漂亮的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		
		//创建一个XMLWriter对象
		XMLWriter writer = new XMLWriter(new FileWriter("stu2.xml"),format);
		//将Document对象写入到文件中
		writer.write(document);
		//关闭流
		writer.close();
		
		
	}

	@Test
	public void testDOM4J() throws Exception {
		
		//获取解析器类实例
		SAXReader reader = new SAXReader();
		//解析xml文档获取Document对象
		Document document = reader.read("stu.xml");
		//dom4j的操作是从根节点开始，所以先要通过Document对象获取根节点，然后通过根节点来做解析
		Element rootEle = document.getRootElement();
		
		//获取所有的student元素
		List<Element> stuEles = rootEle.elements("student");
		//遍历stuEles
		for (Element stuEle : stuEles) {
			//获取学生的id
			String idStr = stuEle.attributeValue("id");
			//获取学生的name
			String name = stuEle.element("name").getText();
			//获取学生的age
			String ageStr = stuEle.elementText("age");
			//获取学生的gender
			String gender = stuEle.elementText("gender");
			//获取学生的地址
			String address = stuEle.elementText("address");
			//将学生信息封装为对象
			Student stu = new Student(Integer.parseInt(idStr), name, Integer.parseInt(ageStr), gender, address);
			System.out.println(stu);
		}
		
		
		
	}

}
