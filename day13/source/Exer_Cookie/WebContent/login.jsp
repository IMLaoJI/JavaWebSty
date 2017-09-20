<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <%
	
	//获取所有的Cookie
	Cookie[] cookies = request.getCookies();

	//设置一个默认值
	String um = "";
	
	//判断是否为null
	if(cookies != null){
		for(Cookie cookie : cookies){
			String name = cookie.getName();
			//判断name是否为username
			if("username".equals(name)){
				um = cookie.getValue();
			}
		}
	}

%> 
	EL表达式中还有一个隐含对象叫Cookie，他是一个Map<String , Cookie>

--%>
</head>
<body>

	
	<form action="LoginServlet" method="post">
		用户名 <input type="text" name="username" value="${cookie.username.value}" />
		密码 <input type="password" name="password" />
		<input type="submit" value="登录"/>
	</form>
</body>
</html>