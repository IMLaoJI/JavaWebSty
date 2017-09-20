package com.atguigu.xml.dom;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;

import com.atguigu.xml.handler.MyHandler;
import com.atguigu.xml.handler.MyHandler2;

public class TestSAX {
	
	@Test
	public void testSAX2() throws Exception{
		//创建工厂类实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//创建解析器类实例
		SAXParser parser = factory.newSAXParser();
		//解析xml文档
		parser.parse("stu.xml", new MyHandler2());
	}

	@Test
	public void testSAX() throws Exception {
		//创建工厂类实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//获取解析器类实例
		SAXParser parser = factory.newSAXParser();
		//解析xml文档
		//sax的解析的全部操作都是通过处理器类来实现
		//使用sax解析我们需要自己创建一个处理器类
		parser.parse("stu.xml", new MyHandler());
		
		
	}

}
