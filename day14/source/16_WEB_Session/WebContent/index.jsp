<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${sessionScope.username }</h1> 

<h3>Session对象是否为新创建的 ： <%=session.isNew() %></h3>
<%
	//手动设置Session的最大有效时间
	//当传一个大于0的数时，session的最大闲置时间会被设置为相应的秒数
	//session.setMaxInactiveInterval(10);

	//当传一个等于0的数时，代表当前Session对象立即失效
	//session.setMaxInactiveInterval(0);
	
	//当传一个小于0的数时，session对象会永远有效，所以尽量不给他设置负值
	//session.setMaxInactiveInterval(-100);
	
	//使session立即失效
	session.invalidate();
%>
<h3>Session对象的最大闲置时间： <%=session.getMaxInactiveInterval() %></h3>
</body>
</html>