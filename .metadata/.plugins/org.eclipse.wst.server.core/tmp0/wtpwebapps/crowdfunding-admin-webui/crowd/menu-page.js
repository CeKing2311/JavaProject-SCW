//	1.发送请求，获取数据
function initTreeNode(){
	$.ajax({
		url : "menu/get/menu/tree.json",
		type : "post",
		dataType : "json",
		success : function(res) {
			console.log(res);
			if (res.result == "SUCCESS") {
				var zNodes = res.data;
				//	1.声明一个对象存放zTree所需的设置
				var setting = {
					view : {
						addDiyDom : myAddDiyDom,
						addHoverDom: myAddHoverDom,
						removeHoverDom: myRemoveHoverDom,
					},
					data:{
						key: {
							url: "ceking" //找不到此链接就不会进行跳转
						}
					},
					/*edit:{
						enable: true,
						showRenameBtn: true,
						showRemoveBtn:true 
					}*/
				};
				//	初始化树形结构					
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			} else if (res.result == "FAILED") {
				layer.msg(res.message);
			}
		}
	})
}
//鼠标进入节点范围时显示按钮
function myAddHoverDom(treeId, treeNode) {
	// 按钮出现的位置是节点
	console.log(treeNode);
	var anchorId = treeNode.tId + "_a";
	var btnGroupId = treeNode.tId + "_btnGroup";
	var level = treeNode.level;
	//console.log(treeNode);
	if ($("#" + btnGroupId).length == 0) {

		var addBtn = '<span id="'
				+ btnGroupId
				+ '" dataid="'+treeNode.id+'" class="button add '+btnGroupId+'"  title="添加节点" onfocus="this.blur();"></span>';
		var editBtn = '<span  id="'
				+ btnGroupId
				+ '" dataid="'+treeNode.id+'" class="button edit '+btnGroupId+'" title="编辑节点" treenode_edit="" style=""></span>';
		var delBtn = '<span id="'
				+ btnGroupId
				+ '" dataid="'+treeNode.id+'" class="button remove '+btnGroupId+'"  title="删除节点" treenode_remove="" style=""></span>';
		var btnHtml = "";
		if (level == 0) {
			btnHtml += addBtn;
		}else if (level == 1) {
			btnHtml += addBtn + " " + editBtn;
			var chlidLength = treeNode.children.length;
			if (chlidLength == 0) {
				btnHtml += " " + delBtn;
			}
		}else  if (level == 2) {
			btnHtml += editBtn + " " + delBtn;
		}

		$("#" + anchorId).after(btnHtml);
	}
}
// 鼠标离开节点范围时删除按钮
function myRemoveHoverDom(treeId, treeNode) {
	var btnGroupId = treeNode.tId + "_btnGroup";
	$("." + btnGroupId).remove();
}
// 修改默认的图标
function myAddDiyDom(treeId, treeNode) {
	// treeId ，整个树型结构附着的url标签的id

	// 根据id生成规则拼接出来的span的id

	var spanId = treeNode.tId + "_ico";
	$("#" + spanId).removeClass().addClass(treeNode.icon);

}