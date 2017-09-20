<%@page import="com.atguigu.bean.Student"%>
<%@page import="com.atguigu.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload = function(){
		var btn = document.getElementById("btn");
		
		//为按钮绑定一个单击响应函数
		btn.onclick = function(){
			alert("hello");
		};
	};

</script>

</head>
<body>
	<%
		//向session中添加一个属性
		//session.setAttribute("username", "卷帘大将");
	
		//session.removeAttribute("username");
		
		//创建一个USer对象
		User user = new User();
		user.setName("贾宝玉");
		
		//将user对象设置进session域中
		//session.setAttribute("user", user);
		
		//session.removeAttribute("user");
		
		//创建一个Student对象
		Student stu = new Student();
		
		//将stu放入进session域中
		session.setAttribute("stu", stu);
	%>

	<button id="btn">按钮</button>

</body>
</html>