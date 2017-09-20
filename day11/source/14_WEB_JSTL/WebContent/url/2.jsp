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
	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
	
	<!-- 用于请求的重定向 -->
	<!-- url指定的重定向的目标地址 -->
	<!-- redirect标签会自动为地址加上项目名，所以们不需要手动设置 -->
	<!-- 使用 c:param 可以在重定向的地址中加上请求参数 -->
	<c:redirect url="/index.jsp">
		<c:param name="name" value="唐僧"></c:param>
	</c:redirect>
	
</body>
</html>