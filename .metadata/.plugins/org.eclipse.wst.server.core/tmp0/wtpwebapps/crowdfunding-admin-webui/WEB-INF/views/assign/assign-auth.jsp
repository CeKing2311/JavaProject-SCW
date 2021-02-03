<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="assignAuthModal" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">权限分配</h4>
			</div>
			<form>
				<div class="modal-body">
					<ul id="authTreeDemo" class="ztree"></ul>					
				</div>
				<div class="modal-footer">
					<button id="authSaveBtn" type="button" class="btn btn-default"><i class="glyphicon glyphicon-plus"></i>保存</button>
				</div>
			</form>
		</div>
	</div>
</div>
