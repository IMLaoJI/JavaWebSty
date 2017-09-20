<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		
		//为id为cleanCart的链接绑定一个单击响应函数
		$("#cleanCart").click(function(){
			
			//填出一个确认框
			if(!confirm("确认清空购物车吗？")){
				
				//取消默认行为
				return false;
			}
			
		});
		
		//为所有的删除按钮绑定一个单击响应函数
		$(".delA").click(function(){
			
			//获取到要删除的图书的名字
			var title = $(this).parents("tr").find("td:eq(0)").html();
			
			//弹出一个确认框
			if(!confirm("确认删除《"+title+"》吗?")){
				return false;
			}
			
		});
		
		
	});

</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
	
	<div id="main">
	
		<c:choose>
			
			 <c:when test="${empty cart.cartItems}">
			 	<br /><br /><br /><br /><br /><br /><br />
			 	<h1 align="center">购物车里还没有商品，赶紧买吧！</h1>
			 </c:when>
			 <c:otherwise>
				<table>
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${cart.cartItems }" var="item">
						<tr>
							<td>${item.book.title }</td>
							<td>${item.count }</td>
							<td>${item.book.price }</td>
							<td>${item.amount }</td>
							<td><a class="delA" href="client/CartServlet?method=delCartItem&bookId=${item.book.id}">删除</a></td>
						</tr>
					</c:forEach>		
				</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${cart.totalAmount }</span>元</span>
			<span class="cart_span"><a id="cleanCart" href="client/CartServlet?method=clear">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>
	
		 </c:otherwise>
		
		</c:choose>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>