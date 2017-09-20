package com.atguigu.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 通过继承SimpleTagSupport来创建一个自定义标签
 * @author lilichao
 *
 */
public class MyTag2 extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		//向页面输出一个内容
		JspWriter out = getJspContext().getOut();
		
		//通过out对象向页面中输出一个内容
		out.print("<h3>这是我的第二个自定义标签</h3>");
	}

}
