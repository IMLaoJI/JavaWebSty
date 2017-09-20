package com.atguigu.xml.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

	/**
	 * 开始解析文档时调用
	 */
	@Override
	public void startDocument() throws SAXException {
		
		System.out.println("开始解析文档。。");
	}
	
	/**
	 * 解析文档结束时调用
	 */
	 @Override
	public void endDocument() throws SAXException {
		 
		 System.out.println("解析文档结束。。。");
	}
	 
	/**
	 * 解析开始标签 
	 * qName 代表的是标签名
	 * attributes 属性的对象
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		//System.out.println("解析开始标签 。。。");
		/*System.out.println("uri = "+uri);
		System.out.println("localName = "+localName);
		System.out.println("qName = "+qName);
		
		String idStr = attributes.getValue("id");
		System.out.println("id = "+idStr);
		
		System.out.println("=========================寂寞的分割线==========================");*/
	}
	
	/**
	 * 解析结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		//System.out.println("解析结束标签。。。");
	}
	
	/**
	 * 解析文本内容时调用
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		//System.out.println("解析到一个文本。。。");
		
		String str = new String(ch, start, length);
		
		System.out.println(str);
		
	}
}
