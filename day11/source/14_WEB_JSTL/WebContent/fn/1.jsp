<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String[] strs = {"a","b","c","d","e"};
	
		//将数组放入进域中
		pageContext.setAttribute("strs", strs);
		
		
	%>
	
	${strs }
	
	<hr />

	<!-- 函数标签库需要结合EL表达式使用 -->
	<!-- 函数标签库中的方法，都是字符串相关的操作 -->
	${fn:contains("hello","He") } <br />
	${fn:containsIgnoreCase("hello","He") } <br />
	${fn:endsWith("hello","alo") }<br />
	<!-- 自动将特殊字符转义 -->
	${fn:escapeXml("<html></html>") }<br />
	<!-- fn:join用于将一个String数组转换一个字符串，第二个参数代表的连接符 -->
	${fn:join(strs,",") }<br />
	${fn:split("a,b,c,d,e",",")[2] }<br />
	${fn:trim("      abcd       ") }<br />

</body>
</html>