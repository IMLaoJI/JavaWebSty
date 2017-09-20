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
		pageContext.setAttribute("hello", "我好饿啊！！");
	
		pageContext.setAttribute("code", "<script>alert('还是饿！！')</script>");
	
	%>

	<!-- out标签用于在页面中输出一个内容，一般需要结合EL表达式使用 -->
	<!-- 可以通过default属性指定一个默认值，当不能获取到某个属性时会显示的值 -->
	<%-- <c:out value="${hello }" default="饿死你" ></c:out> --%>
	
	<%-- ${code } --%>
	<!-- escapeXml是否自动转义特殊字符，默认值为true自动转义 -->
	<c:out value="${code }" escapeXml="true"></c:out>
</body>
</html>