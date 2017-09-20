<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	//JSON的格式和JS对象的格式基本一致，但是JSON对象的属性名要求必须使用双引号括起来
	//JSON可以从字符串转换为对象，也可以从对象转换为字符串
	var jsonStr = '{"username":"sunwukong","age":18,"gender":"nan"}';
	
	var obj2 = {
				"name":"bajie",
				"age":18,
				"obj":{
					"name":"xiaobajie",
					"age":16
				}
			};
	
	var arr = [
	           	"hello",
	           	123,
	           	true,
	           	{
					"name":"bajie",
					"age":18,
					"obj":{
						"name":"xiaobajie",
						"age":16
				}}
	           ];
	
	//alert(arr[3].name);
	
	//字符串 --> 对象
	var jsonObj = JSON.parse(jsonStr);
	
	//对象 --> 字符串
	var jsonStr1 = JSON.stringify(jsonObj);
	
	var arrStr = JSON.stringify(arr);
	
	alert(arrStr);
	
	


</script>
</head>
<body>

</body>
</html>