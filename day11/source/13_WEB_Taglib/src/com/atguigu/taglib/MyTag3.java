package com.atguigu.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 有标签体的标签
 * @author lilichao
 *
 */
public class MyTag3 extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		//获取out对象
		JspWriter out = getJspContext().getOut();
		
		//让标签体内容在页面中执行
		//获取标签体
		JspFragment body = getJspBody();
		//在标签体执行之前加点内容
		out.print("=====================寂寞的分割线========================<br />");
		//执行标签体
		body.invoke(out);
		//在标签体执行完成以后再加点内容
		out.print("<br />=====================寂寞的分割线========================<br />");
		
	}

}
