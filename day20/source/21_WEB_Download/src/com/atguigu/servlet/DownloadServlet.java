package com.atguigu.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//做下载的功能
		
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		
		//获取文件的真实路径
		String path = servletContext.getRealPath("/WEB-INF/风吹麦浪.mp3");
		
		//获取文件流
		InputStream in = new FileInputStream(path);
		
		//获取文件的MIME类型
		String mime = servletContext.getMimeType(path);
		//设置Content-Type，文件的类型
		response.setContentType(mime);
		//response.setHeader("Content-Type", mime);
		
		//设置文件名
		String fileName = "风吹麦浪.mp3";
		
		/*//获取User-Agent请求头
		String ua = request.getHeader("User-Agent");
		
		//判断当前浏览器是否为火狐
		if(ua.contains("Firefox")){
			//是火狐浏览器，使用BASE64编码
			fileName = "=?utf-8?b?"+new BASE64Encoder().encode(fileName.getBytes("utf-8"))+"?=";
		}else{
			//给文件名进行URL编码
			//URLEncoder.encode()需要两个参数，第一个参数时要编码的字符串，第二个是编码所采用的字符集
			fileName = URLEncoder.encode(fileName, "utf-8");
		}*/
		
		//第二种方式
		//先将字符串以gbk进行解码，然后在以iso8859-1进行编码，也可以解决乱码问题
		fileName = new String(fileName.getBytes("gbk"),"iso8859-1");
		
		//设置Content-Disposition响应头
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		
		//获取到向浏览器的输出流
		ServletOutputStream out = response.getOutputStream();
		
		//将输入流的内容复制到输出流
		IOUtils.copy(in, out);
		
		//关闭输入流
		in.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
