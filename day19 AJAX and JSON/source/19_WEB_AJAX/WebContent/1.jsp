<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		//为btn01绑定一个单击响应函数
		$("#btn01").click(function(){
			
			//设置url
			var url = "${pageContext.request.contextPath }/BServlet";
			
			//设置请求参数
			var param = {
					"name":"messi"
			};
			
			//设置一个回调函数
			//响应数据会通过回调函数的参数的形式返回
			//我们获取到响应信息，还需要为函数设定一个参数
			function callBack(data){
				alert(data.username);
			}
			
			//设置响应的类型
			var type = "json";
			
			//调用post发送ajax请求
			//$.post(url, param, callBack, type);
			
			$.post("${pageContext.request.contextPath }/BServlet",{"name":"messi"},function(data){
				
				alert(data);
				
			},"json");
			
		});
		
		
		//为btn02绑定一个单击响应函数
		$("#btn02").click(function(){
			var url = "${pageContext.request.contextPath }/BServlet";
			var param = {"name":"messi","t":new Date()};
			$.getJSON(url,param,function(data){
				alert(data);
			});
			
		});
	});

</script>
</head>
<body>
	<button id="btn01">通过jQuery发送POST请求</button>
	<button id="btn02">通过jQuery发送GET请求</button>
</body>
</html>