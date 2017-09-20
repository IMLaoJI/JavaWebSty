<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="a" uri="http://www.atguigu.com/taglib/a" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		pageContext.setAttribute("str", "谁知盘中餐，粒粒皆辛苦");
	%>
	
	<!-- 
		<if test="true">
			内容
		</if> 
	-->
	
	<!--  -->
	
	<a:MyTag4 test="${empty param.name}">
		<a:MyTag3>
			您没有填写name属性！！
		</a:MyTag3>
	</a:MyTag4>
	<a:MyTag4 test="${!empty param.name}">
		<a:MyTag3>
			您填写的name属性为 ${param.name }
		</a:MyTag3>
	</a:MyTag4>
	
	<br /><br /><br /><br /><br /><br />
	
	
	<hr />
	<a:MyTag3>
		我是MyTag3的标签体
	</a:MyTag3>

	<a:MyTag2/>

	<a:MyTag/>
</body>
</html>