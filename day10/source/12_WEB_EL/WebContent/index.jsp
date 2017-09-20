<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("key", "pageValue");
	request.setAttribute("key", "reqValue");
	session.setAttribute("key", "sessValue");
	application.setAttribute("key", "appValue");

%>
</head>
<body>

<%-- <%=request.getAttribute("requKey") %> --%>

<!-- 如果使用EL表单时获取一个null的对象，它不会显示null，而是什么都不显示 -->
<!-- EL表达式会在四个域中分别查找属性，以从小到大的顺序查找 -->
<%-- ${key } --%>
<!-- 我们可以通过pageScope requestScope sessionScope applicationScope
		来指定要查找的域
 -->
 ${sessionScope.key }

</body>
</html>