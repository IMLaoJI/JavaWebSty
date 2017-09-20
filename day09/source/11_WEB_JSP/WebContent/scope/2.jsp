<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>2.jsp</h1>
pageKey : <%=pageContext.getAttribute("pageKey") %> <br /><br />
reqKey : <%=request.getAttribute("reqKey") %> <br /><br />
sessKey : <%=session.getAttribute("sessKey") %> <br /><br />
appKey : <%=application.getAttribute("appKey") %> <br /><br />
</body>
</html>