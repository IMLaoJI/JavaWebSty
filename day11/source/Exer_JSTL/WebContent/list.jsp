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
	<h1 align="center">学生列表</h1>
	
	<c:choose>
		<c:when test="${empty list }">
			<h3 align="center">当前列表为空</h3>
		</c:when>
		<c:otherwise>
			<table align="center" border="1" width="50%">
				<tr>
					<td>姓名</td>
					<td>性别</td>
					<td>地址</td>
				</tr>
				<c:forEach items="${list }" var="stu">
					<tr>
						<td>${stu.name }</td>
						<td>${stu.gender }</td>
						<td>${stu.address }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>


</body>
</html>