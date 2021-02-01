<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="ztree/zTreeStyle.css">
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}
</style>
<body>

	<%@ include file="/WEB-INF/include-nav.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/WEB-INF/include-slidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
						<div style="float: right; cursor: pointer;" data-toggle="modal"
							data-target="#myModal">
							<i class="glyphicon glyphicon-question-sign"></i>
						</div>
					</div>
					<div class="panel-body">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script src="ztree/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//	1.声明一个对象存放zTree所需的设置
			var setting = {};
			//	2.发送请求，获取数据
			$.ajax({
				url : "menu/get/menu/tree.json",
				type : "post",
				dataType : "json",
				success : function(res) {
					console.log(res);
					if (res.result == "SUCCESS") {
						var zNodes = res.data;
						//	初始化树形结构					
						$.fn.zTree.init($("#treeDemo"), setting, zNodes);
					} else if (res.result == "FAILED") {
						layer.msg(res.message);
					}
				}
			})
		})
	</script>
</body>
</html>