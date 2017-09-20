<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setAttribute("Hello-Kitty", "Tomcat");

	Map<String, String> map = new HashMap<String, String>();
	
	map.put("name", "张三");
	map.put("age", "18");
	pageContext.setAttribute("map", map);
%>

<!-- 像这种名字比较特殊的属性，我们还可以通过另一种方式获取 -->
${requestScope['Hello-Kitty']}
<br />
<!-- 可以通过map.key来获取map中的值  -->
${map.name}
${map['age']}

</body>
</html>