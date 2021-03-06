<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="css/pagination.css">
<script type="text/javascript" src="jquery/jquery.pagination.js"></script>
<body>
	<%@ include file="/WEB-INF/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/include-slidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 数据列表
						</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" role="form" action="admin/get/page.html"
							method="post" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input class="form-control has-success" name="keyWord"
										value="${param.keyWord }" type="text" placeholder="请输入查询条件">
								</div>
							</div>
							<button type="submit" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button type="button" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class=" glyphicon glyphicon-remove"></i> 删除
						</button>
						<a href="admin/to/add/page.html" class="btn btn-primary"
							style="float: right;"><i class="glyphicon glyphicon-plus"></i>
							新增</a> <br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th width="30"><input type="checkbox"></th>
										<th>账号</th>
										<th>名称</th>
										<th>邮箱地址</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty requestScope.pageInfo.list}">
										<tr>
											<td colspan="6" align="center">未查询到数据！</td>
										</tr>
									</c:if>
									<c:if test="${!empty requestScope.pageInfo.list}">
										<c:forEach items="${requestScope.pageInfo.list}" var="admin"
											varStatus="myStatus">
											<tr>
												<td>${myStatus.count}</td>
												<td><input type="checkbox"></td>
												<td>${admin.loginAcct }</td>
												<td>${admin.userName }</td>
												<td>${admin.email }</td>
												<td><a
													href="assign/to/assign/role/page.html?adminId=${admin.id}&pageNum=${requestScope.pageInfo.pageNum }&keyWord=${ param.keyWord}"
													class="btn btn-success btn-xs"> <i
														class=" glyphicon glyphicon-check"></i>
												</a> <a
													href="admin/to/edit/page.html?adminId=${admin.id}&pageNum=${requestScope.pageInfo.pageNum }&keyWord=${ param.keyWord} "
													class="btn btn-primary btn-xs"> <i
														class=" glyphicon glyphicon-pencil"></i>
												</a> <a class="btn btn-danger btn-xs"
													href="admin/remove/${admin.id}/${requestScope.pageInfo.pageNum}/${param.keyWord}.html">
														<i class=" glyphicon glyphicon-remove"></i>
												</a></td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="6" align="center">
											<div id="Pagination" class="pagination"></div>
										</td>
									</tr>

								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		initPagination();						
	});
	function initPagination(){
		var total =${requestScope.pageInfo.total};
		var pageSize= ${requestScope.pageInfo.pageSize}
		// 创建分页
		$("#Pagination").pagination(total, {
			num_edge_entries: 3, //边缘页数
			num_display_entries: 3, //主体页数
			callback: pageSelectCallback,  //点击翻页按钮时回调函数
			items_per_page:pageSize, //每页显示条数
			current_page:${requestScope.pageInfo.pageNum-1}, //Pagination 内部使用pageIndex来管理页码
			prev_text:"上一页",
			next_text:"下一页"
		});	
	}
	//page_index :从0开始
	function pageSelectCallback(pageIndex, jq){
		//根据 page_index 计算 pageNum		
		var pageNum =pageIndex+1;
		var keyWord= JSON.stringify(${param.keyWord});
		if(keyWord==undefined){
			keyWord="";
		}
		window.location.href="admin/get/page.html?pageNum="+pageNum+"&keyWord="+keyWord;
		return false;
	}
</script>
</body>
</html>