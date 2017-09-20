<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是我的第一个JSP网页</h1>
	
	<!-- JSP的脚本片段 -->
	<%
		
		System.out.println("hello JSP");
		
		Date date = new Date();
	
	%>
	
	<%
		int a = 10;
		if(a<9){
	%>
	
		<h3>宋老师真帅！！</h3>
	
	<%
		}
	%>
	
	<hr />
	
	<%
		for(int i= 0 ; i<100 ; i++){
	%>
	
	<h3>宋老师真帅！！</h3>
	
	<%
		}
	
	%>
	
	
	
	
	<!-- JSP表达式 -->
	<%=date %>
	
</body>
</html>