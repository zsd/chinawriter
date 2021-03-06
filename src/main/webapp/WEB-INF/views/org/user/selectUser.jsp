<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<script type="text/javascript" src="${ctx}/js/platform/org/selectUser.js"></script>
<!-- 选择用户摸态框 -->
<div class="modal fade" id="selectUserModal" tabindex="-1" role="dialog"
	 aria-labelledby=selectUserModal" aria-hidden="true">
	<div class="modal-dialog" style="width:700px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close"
						data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="selectUserModalLabel">
					选择用户
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel-body" style="padding: 0px;">
					<div class="col-md-12" style="padding: 0px;">
						<div class="wrapper" style="padding: 0px;">
							<div class="content" style="padding: 0px;">
								<div class="container-fluid" style="padding: 0px;">
									<div class="panel panel-default">
										<div class="panel-body">
											<form class="form-inline">
												<div class="form-group">
													<label>&nbsp;&nbsp;名称：</label>
													<input type="text" class="form-control" id="userName">
												</div>
												<button type="button" id="userSubmit" class="btn btn-default">
													<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查询
												</button>
											</form>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-body">
											<div class="row" style="margin-bottom: 10px;">
												<div class="col-sm-12" style="margin-right:0">
													<nav class="pagination" id="selectUser" style="margin:0;float:right;">
													</nav>
												</div>
											</div>
											<div class="row">
												<input type="hidden" id="userPageNo" value="1"/>
												<input type="hidden" id="userPageSize" value="10"/>
												<table class="table table-striped" style="margin-bottom: 0px;" id="userListTab">
													<thead style="background-color: gainsboro;">
													<tr>
														<th></th>
														<th>名称</th>
														<th>创建时间</th>
														<th>更新时间</th>
													</tr>
													</thead>
													<tbody class="listTab">
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div><!-- /.container -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button  type="button" class="btn btn-primary" onclick="getSelectUserId();">
					确定
				</button>
				<button type="button" class="btn btn-default"
						data-dismiss="modal">取消
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>