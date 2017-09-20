package com.atguigu.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestI18N {
	
	@Test
	public void test03(){
		
		Locale locale = Locale.US;
		
		//获取一个format对象
		//DateFormat format = DateFormat.getDateInstance(DateFormat.FULL, locale);
		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
		
		//使用该对象对日期进行格式化
		String date = format.format(new Date());
		
		System.out.println(date);
		
	}
	
	@Test
	public void test02(){
		
		Locale locale = Locale.KOREA;
		
		//ResourceBundle.getBundle(baseName, locale)需要两个参数，一个是国际化资源文件的基础名，一个Locale对象。
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
		
		//获取login
		String login = bundle.getString("login");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		
		
		System.out.println(login+"--"+username+"--"+password);
		
	}

	@Test
	public void test01() {
		
		//获取默认的locale，默认是根据当前系统来定
		Locale locale = Locale.getDefault();
		
		//获取一个美国的locale信息
		locale = Locale.US;
		
		//
		locale = Locale.TAIWAN;
		
		//也可以通过构造器来创建一个Locale对象
		locale = new Locale("zh", "CN");
		
		System.out.println(locale);
		
	}

}
