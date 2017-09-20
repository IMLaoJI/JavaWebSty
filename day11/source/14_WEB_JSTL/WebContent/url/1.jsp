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
	
	<!-- 在域中设置一个新的属性 -->
	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
	<hr />
	${ctx }
	<hr />
	<!-- 
		在页面中设置绝对路径的方式
		1.使用base标签 <base href="" />
		2.可以使用<c:url value="/1.jsp"></c:url>
		3.使用<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
	 -->

	<!-- url标签可以自动为绝对路径加上项目名 -->
	<!-- c:param可以自动为请求参数进行URL编码 -->
	<!-- 在地址栏中不能直接输入中文参数，而是需要将地址进行URL编码以后才可以 -->
	<c:url value="/1.jsp"></c:url> <br /> <br />
	<a href="${ctx }/index.jsp">去首页</a>
	
	<br /> <br />
	<a href="<c:url value="/index.jsp"></c:url>">去首页</a>
	
	<br /> <br />
	<c:url value="/index.jsp">
		<c:param name="name" value="孙悟空"></c:param>
		<c:param name="age" value="18"></c:param>
	</c:url>
	<br /> <br />
	<a href="${pageContext.request.contextPath }/index.jsp?name=孙悟空">去首页</a>
	
</body>
</html>