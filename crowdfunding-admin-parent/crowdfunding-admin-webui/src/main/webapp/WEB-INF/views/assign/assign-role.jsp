<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="/WEB-INF/include-head.jsp"%>

<body>

	<%@ include file="/WEB-INF/include-nav.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/WEB-INF/include-slidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">数据列表</a></li>
					<li class="active">分配角色</li>
				</ol>
				<div class="panel panel-default">
					<div class="panel-body">
						<form role="form" class="form-inline"
							action="assign/do/role/assign.html" method="post">
							<input type="hidden" name="adminId" value="${param.adminId }">
							<input type="hidden" name="pageNum" value="${param.pageNum }">
							<input type="hidden" name="keyWord" value="${param.keyWord }">
							<div class="form-group">
								<label for="exampleInputPassword1">未分配角色列表</label><br> <select
									class="form-control" id="unSelected" multiple size="10"
									style="width: 100px; overflow-y: auto;">
									<c:forEach items="${ requestScope.unAssignedRoleList }"
										var="role">
										<option value="${role.id }">${ role.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<ul>
									<li
										class="btn btn-default glyphicon glyphicon-chevron-right toRight"></li>
									<br>
									<li
										class="btn btn-default glyphicon glyphicon-chevron-left toLeft"
										style="margin-top: 20px;"></li>
								</ul>
							</div>
							<div class="form-group" style="margin-left: 40px;">
								<label for="exampleInputPassword1">已分配角色列表</label><br> <select
									class="form-control" id="selected" multiple name="roleIdList"
									size="10" style="width: 100px; overflow-y: auto;">
									<c:forEach items="${ requestScope.assignedRoleList }"
										var="role">
										<option value="${role.id }">${ role.name }</option>
									</c:forEach>
								</select>
							</div>
							<button type="submit" id="btnSubmit" style="width: 180px;"
								class="btn btn-sm btn-success btn-block">提交</button>
						</form>
					</div>
				</div>


			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(".toRight").click(function() {
			$("#unSelected>option:selected").appendTo($("#selected"));
		});
		$(".toLeft").click(function() {
			$("#selected>option:selected").appendTo($("#unSelected"));
		});
		$("#btnSubmit").click(function(){
			$("#selected>option").prop("selected","selected");
			return true;			
		})
		
	</script>
</body>
</html>