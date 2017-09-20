<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	window.onload = function(){
		
		//获取按钮的对象
		var btn = document.getElementById("sub_btn");
		//为按钮绑定单击响应函数
		btn.onclick = function(){
			
			//点击以后使按钮不可用
			this.disabled=true;
			
			//当将提交按钮设置为不可用时，会自动取消它的默认行为
			//手动提交表单
			this.parentNode.submit();
			
		};
		
	};
	
</script>

</head>
<body>
<%
	
	//在服务器中生成一个token（一次性的令牌）
	String token = UUID.randomUUID().toString();

	//在服务中保存token
	session.setAttribute("token", token);

%>

${requestScope.contextPath }

<h1>注册页面</h1>
<form action="${pageContext.request.contextPath }/RegistServlet" method="get">
	<input type="hidden" name="token" value="<%=token %>" />
	用户名 <input type="text" name="username" />
	<input id="sub_btn" type="submit" value="注册" />
</form>

</body>
</html>