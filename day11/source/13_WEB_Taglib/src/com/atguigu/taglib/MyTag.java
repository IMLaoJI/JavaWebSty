package com.atguigu.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

/**
 * 自定义标签的HelloWorld
 * 这个标签让他再页面中输出一个简单的内容
 * <h1>这是我的第一个自定义标签</h1>
 * @author lilichao
 *
 */
public class MyTag implements SimpleTag {
	
	private JspContext context;

	/**
	 * doTag()在标签执行时被调用
	 */
	@Override
	public void doTag() throws JspException, IOException {
		
		//获取out对象
		JspWriter out = context.getOut();
		//通过out对象向页面输出一个内容
		out.print("<h1>这是我的第一个自定义标签</h1>");
		//在控制台输出一个内容
		System.out.println("Hello Tag!");
		
	}

	@Override
	public void setParent(JspTag parent) {
		
	}

	@Override
	public JspTag getParent() {
		return null;
	}

	@Override
	public void setJspContext(JspContext pc) {
		this.context = pc;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		
	}

}
