package com.atguigu.xml.dom;

import java.io.FileReader;
import java.io.Reader;

import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.atguigu.xml.bean.Student;

/**
 * 使用PULL解析需要导入两个jar包
 * 	kxml2-2.3.0.jar
 * 	xmlpull_1_0_5.jar
 * @author lilichao
 *
 */
public class TestPULL {
	
	@Test
	public void testPULL2() throws Exception{
		//获取工厂类实例
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		//获取解析器类实例
		XmlPullParser parser = factory.newPullParser();
		//读写xml文档
		parser.setInput(new FileReader("stu.xml"));
		
		//声明一个空的student对象
		Student stu = null;
		
		//写一个while循环
		//循环运行的条件，只要当前事件类型不是 END_DOCUMENT 那么就继续循环
		while (parser.next() != XmlPullParser.END_DOCUMENT) {
			
			//获取当前事件类型
			int event = parser.getEventType();
			
			//获取当前的标签名
			String tagName = parser.getName();
			
			//判断当前标签是否为开始标签
			if(event == XmlPullParser.START_TAG){
				//判断当前标签名是否为student
				if("student".equals(tagName)){
					
					//创建学生对象
					stu = new Student();
					
					//获取id属性值
					String idStr = parser.getAttributeValue(null, "id");
					
					stu.setId(Integer.parseInt(idStr));
				}else if("name".equals(tagName)){
					//获取学生的name
					//nextText获取下一个文本值
					String name = parser.nextText();
					
					stu.setName(name);
					
				}else if("age".equals(tagName)){
					//获取年龄
					String ageStr = parser.nextText();
					
					stu.setAge(Integer.parseInt(ageStr));
					
				}else if("gender".equals(tagName)){
					//获取性别
					String gender = parser.nextText();
					
					stu.setGender(gender);
					
				}else if("address".equals(tagName)){
					//获取年龄
					String address = parser.nextText();
					
					stu.setAddress(address);
					
					//获取id为1的学生信息
					if(stu.getId() == 1){
						//输出学生信息
						System.out.println(stu);
						
						//终止循环
						break;
					}
					
				}
				
			}
			
			
			
		}
	}

	@Test
	public void testPULL() throws Exception {
		
		//获取工厂类实例
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		//获取解析器类实例
		XmlPullParser parser = factory.newPullParser();
		//通过一个FilterReader读去xml
		Reader in = new FileReader("stu.xml");
		//将流设置进parser对象
		parser.setInput(in);
		
		//pull解析的一切操作都是通过 XmlPullParser 对象进行的
		
		//获取当前的事件类型
		int type = parser.getEventType();
		
		type = parser.next();
		type = parser.next();
		type = parser.next();
		
		//获取当前的标签名
		String tagName = parser.getName();
		
		System.out.println(tagName);
		
		//获取student的id属性
		//String idStr = parser.getAttributeValue(0);
		//getAttributeValue(namespace, name) 第一个参数接收一个命名空间，没有可以传null
		//第二个参数接收的属性名
		String idStr = parser.getAttributeValue(null, "id");
		
		System.out.println("id = "+idStr);
		
		
	}

}
