<%@page import="com.atguigu.bean.Address"%>
<%@page import="com.atguigu.bean.User"%>
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
		User user = new User();
		user.setUsername("孙悟空");
		user.setAge(18);
		user.setGender("男");
		
		//创建一个Address对象
		Address address = new Address();
		address.setCity("北京");
		address.setStreet("长安街");
		
		//将address设置进User中
		user.setAddress(address);
		
		//将USer对象放入进request域中
		request.setAttribute("user", user);
	%>
	
	${user.address.street}

</body>
</html>