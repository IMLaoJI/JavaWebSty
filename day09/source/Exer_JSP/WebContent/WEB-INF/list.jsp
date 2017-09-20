<%@page import="com.atguigu.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">学生列表</h1>
<%
	List<Student> list = (List<Student>)request.getAttribute("list");
%>


<%
if(list != null){
%>



<table border="1" align="center" width="50%">
	<tr>
		<td>姓名</td>
		<td>性别</td>
		<td>住址</td>
		<td colspan="2">操作</td>
	</tr>
	
	<%
	
		for(Student stu : list){
	%>
	<tr>
		<td><%=stu.getName() %></td>
		<td><%=stu.getGender() %></td>
		<td><%=stu.getAddress() %></td>
		<td><a href=#>删除</a></td>
		<td><a href=#>修改</a></td>
	</tr>
	<%
		}
	
}
	%>
	
</table>
</body>
</html>