<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<title>Insert title here</title>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${ pageContext.request.contextPath }/">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<div>
				<a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
			</div>
		</div>
	</div>
	</nav>
	<div class="container" style="text-align: center;">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-log-in"></i> 系统消息
			</h2>
			<!-- requestScope存放 request域数据的map -->
			<h3>${requestScope.exception.message }</h3>
			<a id="btnBack" href="admin/to/login/page.html" style="width:150px;margin: 0 auto;" class="btn btn-lg btn-success btn-block" >返回上一页</a>
	</div>
	<script src="jquery/jquery-2.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js" />	
	<script type="text/javascript">
		$(function () {
			$("#btnBack").click(function () {
				
			})
		})
	</script>
</body>
</html>