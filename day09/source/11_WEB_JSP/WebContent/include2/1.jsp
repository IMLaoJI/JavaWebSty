<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>我是一个快乐1.jsp</h1>
	
	<!-- 使用include指令将2.jsp引入到1.jsp中 -->
	<%-- <%@ include file="/include/2.jsp" %> --%>
	
	<jsp:forward page="/include/2.jsp">
		<jsp:param value="sunwukong" name="username"/>
	</jsp:forward>
</body>
</html>