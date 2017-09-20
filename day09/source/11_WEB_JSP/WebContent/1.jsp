<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>你看我乱不乱！！</h1>

	<%!
		private String username;
	
		public int sum(int a , int b){
			
			return a+b;
		}
	%>


	<%-- <%
		Date date = new Date();
	
		//out.print(date);
		
	%> --%>
	
	<%-- <%=new Date();%> --%>
	
	
	<%--JSP注释 --%>
	<!-- HTML注释 -->
	<%
		//Java注释
	%>
	
	<%=sum(123, 456) %>
	
	
</body>
</html>