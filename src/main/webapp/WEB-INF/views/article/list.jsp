<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<!-- saved from url=(0048)http://v3.bootcss.com/examples/navbar-fixed-top/ -->
<html lang="zh-CN">
<head>
	<%@ include file="/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/js/bussiness/article/article.js"></script>
	<style>
		td{
			line-height: 30px!important;
		}
	</style>
</head>
<body>
<div class="wrapper">
	<div class="content">
		<div class="container-fluid" style="padding-top: 15px;">

			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline">
						<div class="form-group">
							<label>&nbsp;关键字：</label>
							<input type="text" class="form-control" id="name">
						</div>
						<button type="button" id="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查询
						</button>
					</form>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row" style="margin-bottom: 10px;">
						<div class="col-sm-7">
							<div role="toolbar" class="btn-toolbar">
								<div class="btn-group dropup">
									<button type="button" class="btn btn-success dropdown-toggle"  onclick="addFn();">
										新增 <span class="glyphicon glyphicon-plus"></span>
									</button>
								</div>
								<button type="button" id="del" class="btn btn-default">
									删除<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
								</button>
								<c:choose>
									<c:when test="${spiderStatus.status eq '执行中'}">
										<button type="button" id="spider1" class="btn btn-default" disabled="disabled">
											采集中,启动时间：<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"  value="${spiderStatus.createTime}"/>
										</button>
									</c:when>
									<c:otherwise>
										<button type="button" id="spider" class="btn btn-default">
											采集<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
										</button>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="col-sm-5" style="margin-right:0">
							<nav class="pagination" style="margin:0;float:right;">
							</nav>
						</div>
					</div>
					<div class="row">
						<input type="hidden" name="pageNo" value="1"/>
						<input type="hidden" name="pageSize" value="10"/>
						<table class="table table-striped" style="margin-bottom: 0px;" id="listTab">
							<thead style="background-color: gainsboro;">
							<tr>
								<th><input type="checkbox" class="alltoggle" id="selectAll"></th>
								<th>标题</th>
								<th>来源网站</th>
								<th>发布日期</th>
								<th>采集日期</th>
								<th>操作</th>
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
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	 aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close"
						data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					信息保存
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel-body">
					<div class="col-md-12">
						<form id="saveForm" name="saveForm" method="post">
							<input type="hidden" class="form-control" name="id" >
							<div class="col-md-12">
								<label>标题：</label>
								<input type="text" class="form-control" name="name">
							</div>
							<div class="col-md-12">
								<label>来源网站：</label>
								<input type="text" class="form-control" name="fromWeb">
							</div>
							<div class="col-md-12">
								<label>来源链接：</label>
								<input type="text" class="form-control" name="fromUrl">
							</div>
							<div class="col-md-12">
								<label>发布日期：</label>
								<input type="text" class="form-control" name="publishDate">
							</div>
							<div class="col-md-12">
								<label>内容：</label>
								<input type="text" class="form-control" name="content">
							</div>
							<div class="col-md-12">
								<label>备注：</label>
								<input type="text" class="form-control" name="remark">
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<%--<button id="saveYes" type="button" class="btn btn-primary" onclick="save();">--%>
					<%--保存--%>
				<%--</button>--%>
				<%--<button id="saveNo" type="button" class="btn" style="display:none;">--%>
					<%--保存--%>
				<%--</button>--%>
				<button type="button" class="btn btn-default"
						data-dismiss="modal">取消
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>