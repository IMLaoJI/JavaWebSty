<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
</head>
<body>
	<%-- http://localhost:8080/BookStore_EG03/ <br />
	http://<%=request.getServerName() %>:<%=request.getServerPort() %><%=request.getContextPath() %>/
	<hr />
	getServerName <%=request.getServerName() %> <br />
	getServerPort <%=request.getServerPort() %> <br />
	getContextPath <%=request.getContextPath() %> <br /> --%>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<!-- 
					当发送post请求时，是通过请求体来传递请求参数，所以在Servlet中就不能获取到请求参数了
					所以这里最好不要使用post请求，改用get请求
					但是get请求会自动覆盖action属性中的参数，所以当使用get请求时，我们只能通过表单项来传递请求参数
				 -->
				<form action="client/BookClientServlet" method="get">
					<input type="hidden" name="method" value="findBookByPrice" />
					价格：<input type="text" name="min" value="${param.min}"> 元 - 
						<input value="${param.max }" type="text" name="max"> 元 
					<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>
			
			<c:choose>
				<c:when test="${empty page.data }">
					<h1>当前条件没有找到图书！</h1>
				</c:when>
				<c:otherwise>
					<c:forEach items="${page.data }" var="book">
						<div class="b_list">
							<div class="img_div">
								<img class="book_img" alt="" src="${pageContext.request.contextPath }${book.imgPath}" />
							</div>
							<div class="book_info">
								<div class="book_name">
									<span class="sp1">书名:</span>
									<span class="sp2">${book.title }</span>
								</div>
								<div class="book_author">
									<span class="sp1">作者:</span>
									<span class="sp2">${book.author }</span>
								</div>
								<div class="book_price">
									<span class="sp1">价格:</span>
									<span class="sp2">￥${book.price }</span>
								</div>
								<div class="book_sales">
									<span class="sp1">销量:</span>
									<span class="sp2">${book.sales }</span>
								</div>
								<div class="book_amount">
									<span class="sp1">库存:</span>
									<span class="sp2">${book.stock }</span>
								</div>
								<div class="book_add">
									<button>加入购物车</button>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		
			
			
			
		</div>
		
		<%@ include file="/WEB-INF/include/page.jsp" %>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>