package com.atguigu.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 模拟Java中if语句的功能
 * <if test="true">
		内容
	</if> 
 * @author lilichao
 *
 */
public class MyTag4 extends SimpleTagSupport {
	
	/**
	 *  在处理器类中顶一个test属性
	 */
	private boolean test;
	
	/**
	 * 当标签中有属性时，只需要为指定的属性提供一个set方法，那么服务器会自动调用set方法为属性赋值
	 * @param test
	 */
	public void setTest(boolean test) {
		this.test = test;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		//如果test为true则执行标签体
		if(test){
			//执行标签体
			//getJspBody().invoke()可以传一个null，当传一个null作为参数时，他会默认在当前页面执行
			//getJspBody().invoke(null);
			
			JspWriter out = getJspContext().getOut();
			getJspBody().invoke(out);
		}
		
	}

}
