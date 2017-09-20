package com.atguigu.xml.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.atguigu.xml.bean.Student;

/**
 * 解析stu.xml文档的处理器
 * @author lilichao
 *
 */
public class MyHandler2 extends DefaultHandler {
	
	//当前解析到的标签名
	private String tagName;
	
	//顶一个学生对象，用来封装信息
	private Student stu;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		//为tagName赋值
		this.tagName = qName;
		
		//判断当前标签是否为student
		if("student".equals(qName)){
			
			//创建学生对象
			stu = new Student();
			
			//获取id属性
			String idStr = attributes.getValue("id");
			//System.out.println(idStr);
			
			//封装id属性
			stu.setId(Integer.parseInt(idStr));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		//读取到结束标签时，要将tagName设置为null
		this.tagName = null;
		
		//判断当前标签是否为student结束标签
		if("student".equals(qName) && stu.getId()==1){
			
			System.out.println(stu);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//获取name age gender address
		
		if("name".equals(this.tagName)){
			String name = new String(ch, start, length);
			//System.out.println(name);
			stu.setName(name);
			
		}else if("age".equals(tagName)){
			String ageStr = new String(ch, start, length);
			//System.out.println(ageStr);
			stu.setAge(Integer.parseInt(ageStr));
			
		}else if("gender".equals(tagName)){
			String gender = new String(ch, start, length);
			//System.out.println(gender);
			stu.setGender(gender);
			
		}else if("address".equals(tagName)){
			String address = new String(ch, start, length);
			//System.out.println(address);
			stu.setAddress(address);
		}
	}

}
