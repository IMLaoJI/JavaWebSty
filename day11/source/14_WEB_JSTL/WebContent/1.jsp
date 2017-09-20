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

	<!-- set标签用于在域中设置一个属性 -->
	<!-- var 属性的名字 -->
	<!-- value是属性的值 -->
	<!-- 默认是将属性设置进page域中 -->
	<!-- page request session application -->
	<!-- 可以通过scope属性来指定要将对象放入到哪个域中 -->
	<c:set var="name" value="孙悟空" scope="request"></c:set>
	
	<!-- remove标签可以从域中移除一个属性 -->
	<!-- var指定一个要移除的属性的名字 -->
	<!-- 默认是移除四个域中的同名属性，可以通过scope属性指定域 -->
	<c:remove var="name" scope="session"/>
	
	${requestScope.name }

	<%-- <c:out value="" default="" escapeXml=""></c:out> --%>

</body>
</html>