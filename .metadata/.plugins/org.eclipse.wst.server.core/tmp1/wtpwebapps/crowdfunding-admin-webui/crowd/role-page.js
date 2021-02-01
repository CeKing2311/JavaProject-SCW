//执行分页，生成页面效果
function generatePage() {
	var pageInfo = getPageInfoRemote();
	initTableBody(pageInfo);
}
// 远程访问获取数据
function getPageInfoRemote() {
	var ajaxResult = $.ajax({
		url : "role/get/page/info.json",
		type : "post",
		data : {
			pageNum : window.pageNum,
			pageSize : window.pageSize,
			keyWord : window.keyWord
		},
		async : false,
		dataType : "json",
	});

	console.log(ajaxResult);
	var statusCode = ajaxResult.status;
	var statusMsg = ajaxResult.statusText;
	if (statusCode != 200) {
		layer.msg("服务器响应失败！状态码：" + statusCode + ";响应信息：" + statusMsg);
		return null;
	}
	var resultEntity = ajaxResult.responseJSON;
	var result = resultEntity.result;
	if (result == "FAILED") {
		// 请求失败
		layer.msg(resultEntity.messgae);
		return null;
	}
	var pageInfo = resultEntity.data;
	return pageInfo;
}
// 填充表格
function initTableBody(pageInfo) {
	$("#rolePageBody").empty();
	$("#Pagination").empty();
	// 判断pageInfo是否有效
	if (pageInfo == null || pageInfo == undefined || pageInfo.list == null
			|| pageInfo.list.length == 0) {
		$("#rolePageBody").append("<tr><td colspan='4'>抱歉，没有查询到数据！</td></tr>");
		return;
	}
	for (var i = 0; i < pageInfo.list.length; i++) {
		var role = pageInfo.list[i];
		var roleId = role.id;
		var roleName = role.name;
		var numTd = "<td>" + (i + 1) + "</td>";
		var chkTd = "<td><input type='checkbox' class='btn-chk-role' dataId='"+roleId+"' dataName='"+roleName+"' ></td>";
		var nameTd = "<td>" + roleName + "</td>";

		var chkBtn = '<button type="button" class="btn btn-success btn-xs"> <i class=" glyphicon glyphicon-check"></i></button>&nbsp;';
		var editBtn = '<button type="button" onclick="editRole('+roleId+',\''+roleName+'\')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>&nbsp;'
		var delBtn = '<button type="button" onclick="delRole('+roleId+',\''+roleName+'\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>&nbsp;';
		var btnTd = "<td style='width:150px;'>" + chkBtn + editBtn + delBtn
				+ "</td>";

		var tr = "<tr>" + numTd + chkTd + nameTd + btnTd + "</tr>";
		$("#rolePageBody").append(tr);
	}
	generateNavigator(pageInfo);
}
// 分页导航条
function generateNavigator(pageInfo) {
	var total = pageInfo.total;

	$("#Pagination").pagination(total, {
		num_edge_entries : 3, // 边缘页数
		num_display_entries : 3, // 主体页数
		callback : paginationCallBack, // 点击翻页按钮时回调函数
		items_per_page : pageInfo.pageSize, // 每页显示条数
		current_page : pageInfo.pageNum - 1, // Pagination 内部使用pageIndex来管理页码
		prev_text : "上一页",
		next_text : "下一页"
	});
}
// 分页回调函数
function paginationCallBack(pageIndex, jQuery) {
	// 根据 page_index 计算 pageNum
	window.pageNum = pageIndex + 1;
	
	generatePage();
	//取消超链接的跳转行为
	return false;
}