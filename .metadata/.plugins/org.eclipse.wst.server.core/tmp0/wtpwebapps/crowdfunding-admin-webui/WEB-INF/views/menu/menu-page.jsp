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
	<%@ include file="./modal-menu-add.jsp"%>
	<%@ include file="./modal-menu-edit.jsp"%>
	<%@ include file="./modal-menu-confirm.jsp"%>
	<script src="ztree/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="crowd/menu-page.js"></script>
	<script type="text/javascript">
		$(function() {
			initTreeNode();
			$("#treeDemo").on("click", ".add", function() {
				//console.log(11111);
				window.pid = $(this).attr("dataid");
				$("#menuAddModal").modal("show");
				return false;
			})
			$("#treeDemo").on("click", ".edit", function() {
				//console.log(11111);
				window.id = $(this).attr("dataid");
				$("#menuEditModal").modal("show");
				//获取zTreeObj对象
				var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
				//获取节点对象
				var key = "id";
				var value = window.id;
				var currentNode = zTreeObj.getNodeByParam(key, value);
				console.log(currentNode);
				//回显表单数据
				$("#menuEditModal [name=name]").val(currentNode.name);
				$("#menuEditModal [name=url]").val(currentNode.url);

				$("#menuEditModal [name=icon]").val([ currentNode.icon ]);
				return false;
			})

			$("#treeDemo").on("click", ".remove", function() {
				window.id = $(this).attr("dataid");
				$("#menuConfirmModal").modal("show");
				//获取zTreeObj对象
				var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
				//获取节点对象
				var key = "id";
				var value = window.id;
				var currentNode = zTreeObj.getNodeByParam(key, value);
				$("#removeNodeSpan").html("<i class='"+currentNode.icon+"'></i>"+currentNode.name);
				//回显表单数据
				return false;
			})
			$("#confirmBtn").click(function() {
				var postData = {
					id : window.id
				};
				$.ajax({
					url : "menu/delete.json",
					type : "post",
					data : postData,
					dataType : "json",
					success : function(res) {
						var result = res.result;
						if (result == "SUCCESS") {
							layer.msg("删除成功！");
							initTreeNode();
						}
						if (result == "FAILED") {
							layer.msg("删除失败！" + res.message);
						}
					},
					error : function(err) {
						layer.msg(err);
					}
				});
				$("#menuConfirmModal").modal("hide");
			});
			$("#menuEditBtn").click(function() {
				var name = $.trim($("#menuEditModal [name=name]").val());
				var url = $.trim($("#menuEditModal [name=url]").val());
				//选中的icon
				var icon = $("#menuEditModal [name=icon]:checked").val();
				var postData = {
					id : window.id,
					name : name,
					url : url,
					icon : icon
				};
				if (postData.name == "" || postData.url == "") {
					layer.msg("名称或url为空，请重新输入！");
					return;
				}
				$.ajax({
					url : "menu/update.json",
					type : "post",
					data : postData,
					dataType : "json",
					success : function(res) {
						var result = res.result;
						if (result == "SUCCESS") {
							layer.msg("保存成功！");
							initTreeNode();
						}
						if (result == "FAILED") {
							layer.msg("保存失败！" + res.message);
						}
					},
					error : function(err) {
						layer.msg(err);
					}
				});
				$("#menuEditModal").modal("hide");
			});
			$("#menuSaveBtn").click(function() {
				var name = $.trim($("#menuAddModal [name=name]").val());
				var url = $.trim($("#menuAddModal [name=url]").val());
				//选中的icon
				var icon = $("#menuAddModal [name=icon]:checked").val();
				var postData = {
					pid : window.pid,
					name : name,
					url : url,
					icon : icon
				};
				if (postData.name == "" || postData.url == "") {
					layer.msg("名称或url为空，请重新输入！");
					return;
				}
				$.ajax({
					url : "menu/save.json",
					type : "post",
					data : postData,
					dataType : "json",
					success : function(res) {
						var result = res.result;
						if (result == "SUCCESS") {
							layer.msg("保存成功！");
							initTreeNode();
						}
						if (result == "FAILED") {
							layer.msg("保存失败！" + res.message);
						}
					},
					error : function(err) {
						layer.msg(err);
					}
				});

				$("#menuAddModal").modal("hide");
				$("#menuResetBtn").click();
			});
		})
	</script>
</body>
</html>