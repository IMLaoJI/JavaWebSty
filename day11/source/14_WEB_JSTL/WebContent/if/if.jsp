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

	<!-- if标签相当于java中的if
		test属性接收一个boolean值，如果值为true，则标签体执行，
		如果值为false，则标签体不执行
	 -->
	<c:if test="${empty param.name }">
		<h3>您没有输入name属性！</h3>
	</c:if>
	
	<c:if test="${!empty param.name }">
		<h3>你干嘛输入了一个name属性！</h3>
	</c:if>
	
	<hr />
	
	<!-- choose标签作用相当于java中if...else.. -->
	<!-- choose中可以使用when标签，作用和if标签类似 -->
	<!-- otherwise标签中的内容，将会在when标签没有执行时才执行 -->
	<!-- 还可以在choose中写多个when -->
	<!-- choose标签中最多会有一个标签执行，只要有一个符合添加，其他将不再判断 -->
	<!-- 当所有的when标签都没有执行时，otherwise标签才会执行 -->
	<!-- 使用choose标签时一定要注意when和otherwise的顺序 -->
	<!-- when标签和otherwise标签不能脱离choose标签使用 -->
	<%-- <c:when test="${param.score >= 60 }">
		<h3>恭喜您考了一个D</h3>
	</c:when> --%>
	<c:choose>
		
		<c:when test="${param.score == 100 }">
			<h3>恭喜您考了100分！</h3>
		</c:when>
		<c:when test="${param.score >= 90 }">
			<h3>恭喜您考了一个A</h3>
		</c:when>
		<c:when test="${param.score >= 80 }">
			<h3>恭喜您考了一个B</h3>
		</c:when>
		<c:when test="${param.score >= 70 }">
			<h3>恭喜您考了一个C</h3>
		</c:when>
		<c:when test="${param.score >= 60 }">
			<h3>恭喜您考了一个D</h3>
		</c:when>
		<c:otherwise>
			<h3>恭喜你，你丫不及格！</h3>
		</c:otherwise>
	</c:choose>





</body>
</html>