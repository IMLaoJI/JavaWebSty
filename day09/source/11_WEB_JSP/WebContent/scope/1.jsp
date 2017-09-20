<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1.jsp</h1>
<%
	pageContext.setAttribute("pageKey", "pageValue");
	request.setAttribute("reqKey", "reqValue");
	session.setAttribute("sessKey", "sessValue");
	application.setAttribute("appKey", "appValue");
%>

pageKey : <%=pageContext.getAttribute("pageKey") %> <br /><br />
reqKey : <%=request.getAttribute("reqKey") %> <br /><br />
sessKey : <%=session.getAttribute("sessKey") %> <br /><br />
appKey : <%=application.getAttribute("appKey") %> <br /><br />

<!-- 通过转发去2.jsp -->
<%-- <jsp:forward page="/scope/2.jsp"></jsp:forward> --%>

<!-- <a href="/11_WEB_JSP/scope/2.jsp">去2.jsp</a> -->

<%
	response.sendRedirect("/11_WEB_JSP/scope/2.jsp");
%>

</body>
</html>