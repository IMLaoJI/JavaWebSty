<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		List<String> list = new ArrayList<String>();
		list.add("刘备");
		list.add("关羽");
		list.add("张飞");
		list.add("赵云");
		
		//将list放入进域中
		pageContext.setAttribute("list", list);
		
		//创建一个map
		Map<String ,String> map = new HashMap<String , String>();
		//向map中添加对象
		map.put("name", "孙悟空");
		map.put("age", "18");
		map.put("gender", "男");
		
		//将map放入进域中
		pageContext.setAttribute("map", map);
	%>
	
	<!-- varStatus可以获取当遍历的状态 -->
	<!-- vs.index可以获取到当前对象的索引 -->
	<!-- vs.count 可以获取到当前遍历的数量 -->
	<!-- vs.last 可以判断当前元素是否为最后一个 -->
	<!-- vs.first 可以判断当前元素是否第一个 -->
	<!-- vs.current 当前正在遍历的对象 -->
	<c:forEach items="${list}" var="hero" varStatus="vs">
		${vs.current} -- ${hero } <br />
	</c:forEach>
	
	<hr /> 
	
	
	<!-- 使用forEach标签遍历map时，它取出是集合中的一个一个的键值对结构
		可以通过 对象.key 获取键，通过 对象.value 来获取值
	 -->
	<c:forEach items="${map }" var="user">
		${user.key} --- ${user.value} <br />
	</c:forEach>
	
	<hr />
	
	
	
	<!-- forEach可以用来遍历一个集合 -->
	<!-- items 用来指定要遍历的那个集合 -->
	<!-- var 指定域中的属性名 -->
	<!-- 
		集合中有几个元素，则标签体就会执行几次，标签体没执行一次，
		集合中元素都会以var对应的属性名，放入进域中
		我们可以通过属性名从域中获取到属性值
		
	 -->
	<%--  <%
	 	pageContext.setAttribute("hero", value)
	 %> --%>
	<c:forEach items="${list}" var="hero">
		${hero} <br />
	</c:forEach>


	<!-- 在页面中遍历一组数 -->
	<!-- 
		forEach标签可以在页面中遍历一组数
		begin 表示开始的位置，begin的值最小是0
		end 表示结束的位置
		需要遍历几次，标签体就会执行几次，每次执行都会将一个值放入进域中
		var 指定的是放入进域中的属性名
		step 用于指定步长（步长就是指每一次增加的大小，默认值为1）
	 -->
	<%-- <c:forEach begin="1" end="20" var="index" step="1">
		<a href=#>${index}</a>
	</c:forEach> --%>
	
	
</body>
</html>