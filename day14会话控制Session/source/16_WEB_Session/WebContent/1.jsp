<%@page import="com.atguigu.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User();
		user.setUsername("白骨精");
		session.setAttribute("user", user);
		
	%>
	
	<c:url value="/2.jsp"></c:url>
	
	<br />
	
	<a href="<c:url value="/2.jsp"></c:url>">TEST</a>
	
	
	<hr />
	
	<%=response.encodeRedirectURL("/16_WEB_Session/2.jsp")%>
	<br />
	<%=response.encodeURL("/16_WEB_Session/2.jsp") %>
	<br />
	<a href="<%=response.encodeRedirectURL("/16_WEB_Session/2.jsp")%>">去2.jsp</a>
	
	
</body>
</html>