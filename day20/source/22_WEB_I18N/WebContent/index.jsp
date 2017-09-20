<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%
		//获取浏览器的语言信息
		Locale locale = request.getLocale();
		//创建一个ResourceBundle对象
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
	%> --%>
	
	<c:if test="${!empty param.locale}">
		<!-- 手动指定Locale信息 -->
		<!-- 如果 value属性为空，则会默认设置服务器的Locale信息-->
		<fmt:setLocale value="${param.locale }"/>
	</c:if>
	<!-- 通过 fmt:setBundle制定国际化资源文件的基础名-->
	<fmt:setBundle basename="i18n"/>
	
	
	<%-- <h1><fmt:message key="info"/> : <fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="full" timeStyle="full"/>  </h1> --%>
	
	<h3>
		
		<fmt:message key="info">
			<fmt:param><span style="color: red">大师兄</span></fmt:param>
			<fmt:param><span style="color: red"><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="full" timeStyle="full"/></span></fmt:param>
		</fmt:message>
		
	</h3>

	<h1><fmt:message key="login"/></h1>
	<form action="">
		<fmt:message key="username"/> <input type="text" /> <br /> <br />
		<fmt:message key="password"/> <input type="password" /> <br /> <br />
		<input type="submit" value="<fmt:message key="login"/>" /> <br /> <br />
	</form>
	<a href="/22_WEB_I18N/index.jsp?locale=zh_CN">中文</a> | <a href="/22_WEB_I18N/index.jsp?locale=en_US">ENGLISH</a>
</body>
</html>