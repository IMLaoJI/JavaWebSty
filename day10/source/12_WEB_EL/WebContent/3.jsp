<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${pageContext.request.contextPath }
	<%
		request.setAttribute("reqKey", "reqValue");
	%>
	
	<br />
	<br />
	
	${requestScope.contextPath }
	
	<!-- 通过param对象获取到用户发送的请求参数 -->
	<h3>${param.name }</h3>
	
<hr />
	
	<h2>${paramValues.hobby[1] }</h2>

<hr />

	<h3>${header['User-Agent'] }</h3>

	
</body>
</html>