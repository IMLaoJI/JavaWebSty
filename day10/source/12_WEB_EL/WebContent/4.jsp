<%@page import="java.util.ArrayList"%>
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
	${123*456 } <br />
	
	<%
		request.setAttribute("user", "");
	
		List<String> list = new ArrayList<String>();
		
		request.setAttribute("list", list);
		
		list.add("贾宝玉");
		list.add("潘金莲");
	%>
	
	user == null : ${user == null} <br />
	empty user : ${empty user }<br />
	
	<hr />
	
	${empty "" }
	
	<hr />
	empty list --> ${empty list}
	<hr />
	list == null --> ${list == null }
	
	<hr />
	${list[1] }
	
</body>
</html>