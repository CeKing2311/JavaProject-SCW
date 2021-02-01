<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${ pageContext.request.contextPath }/">
<script src="jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
</head>
<body>
	<a href="test/ssm.html">测试SSM整合环境</a><br><br>
	
	<button id="btn1">Send [2,5,8] One </button><br><br>
	
	<button id="btn2">Send [2,5,8] Two </button><br><br>
	
	<script type="text/javascript">
		$(function () {
			var array=[2,5,8];
			var postData =JSON.stringify(array);
			
			//发送数组
			$("#btn2").click(function () {
				$.ajax({
					url:"send/array2.html",
					type:"post",
					contentType:"application/json;charset=utf-8", //请求体的内容为json数据
					data:postData,
					dataType:"text",
					success:function(result){
						console.log(result);
					},
					error:function(err){
						console.log(err);
					}
				})
			})
			$("#btn1").click(function () {
				$.ajax({
					url:"send/array2.html",
					type:"post",
					data:{
						"array":[2,5,8]
					},
					dataType:"text",
					success:function(result){
						console.log(result);
					},
					error:function(err){
						console.log(err);
					}
				})
			})
		})
		
	</script>
</body>
</html>