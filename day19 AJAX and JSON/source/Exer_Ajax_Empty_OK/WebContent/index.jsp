<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		
		//1.发送ajax请求加载省份的信息
		//设置url
		var url = "${pageContext.request.contextPath}/ProvinceServlet";
		//设置type
		var type = "json";
		//发送ajax请求
		$.post(url,function(data){
			
			//遍历data信息
			for(var i=0 ; i<data.length ; i++){
				//获取id和name信息
				var id = data[i].id;
				var name = data[i].name;
				
				//向select中添加option
				//select选中是option的value属性，所以我们将id设置为option的value
				$("[name=province]").append("<option value='"+id+"'>"+name+"</option>");
			}
			
		},type);
		
		
		//2.当省份信息发生改变时，去根据省份的id加载城市的信息
		$("[name=province]").change(function(){
			
			//在加载城市信息之前，先将原有的信息清除。
			$("[name=city] option:gt(0)").remove();
			//在加载城市信息之前，先将原有的信息清除。
			$("[name=district] option:gt(0)").remove();
			
			//向CityServlet发送请求
			var url = "${pageContext.request.contextPath}/CityServlet";
			//设置请求参数
			var params = {"id":this.value};
			
			$.post(url,params,function(data){
				
				//使用each来遍历data
				$(data).each(function(){
					//我们可以使用this来代表数组中的每一个对象
					var id = this.id;
					var name = this.name;
					//向city的select中添加option
					$("[name=city]").append("<option value='"+id+"'>"+name+"</option>");
					
				});
				
				
			},"json");
			
			
		});
		
		//3.当城市信息发生改变，要去加载区县信息
		$("[name=city]").change(function(){
			
			//在加载区县信息之前，先将原有的信息清除。
			$("[name=district] option:gt(0)").remove();
			
			//设置请求地址
			var url = "${pageContext.request.contextPath}/DistrictServlet";
			
			//设置请求参数
			var params = {"id":this.value};
			
			//发送请求
			$.post(url,params,function(data){
				
				//遍历data
				$(data).each(function(){
					var id = this.id;
					var name = this.name;
					$("[name=district]").append("<option value='"+id+"'>"+name+"</option>");
				});
				
			},"JSON");
			
		});
		
	});

</script>
<title>三级联动</title>
</head>
<body>
<select name="province">
	<option>请选择省...</option>
</select>
<select name="city">
	<option>请选择市...</option>
</select>
<select name="district">
	<option>请选择区县...</option>
</select>
</body>
</html>