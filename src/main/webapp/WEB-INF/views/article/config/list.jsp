<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<!-- saved from url=(0048)http://v3.bootcss.com/examples/navbar-fixed-top/ -->
<html lang="zh-CN">
<head>
	<%@ include file="/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/js/bussiness/article/articleConfig.js"></script>
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
								<%--<button type="button" id="exp" class="btn btn-default" onclick="exportXml()">--%>
									<%--导出<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>--%>
								<%--</button>--%>
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
								<th>来源网站</th>
								<th>备注</th>
								<th>创建时间</th>
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
								<label><font color="red">*</font>来源网址：</label>
								<input type="text" class="form-control" name="fromWeb" placeholder="中国作家网">
							</div>
							<div class="col-md-12">
								<label><font color="red">*</font>列表链接：</label>
								<input type="text" class="form-control" name="listUrl" placeholder="http://www.chinawriter.com.cn/403982/index.html">
							</div>
							<div class="col-md-12">
								<label><font color="red">*</font>文章链接：</label>
								<input type="text" class="form-control" name="articleUrl" placeholder="(http://www.chinawriter.com.cn/n1/([0-9]*)/([0-9]*)/c[0-9]*-[0-9]*.html)">
							</div>
							<div class="col-md-12">
								<label><font color="red">*</font>标题路径：</label>
								<input type="text" class="form-control" name="namePath" placeholder="//div[@class='list_warp']/h6/em/text()">
							</div>
							<div class="col-md-12">
								<label>内容路径：</label>
								<input type="text" class="form-control" name="contentPath" placeholder="//div[@class='end_info']/p/em/text()">
							</div>
							<div class="col-md-12">
								<label>发布日期路径：</label>
								<input type="text" class="form-control" name="publishDatePath" placeholder="//div[@class='end_article']//p//text()">
							</div>
							<div class="col-md-12">
								<label>日期格式：</label>
								<input type="text" class="form-control" name="publishDateFormat" placeholder="yyyy年MM月dd日HH:mm">
							</div>
							<div class="col-md-12">
								<label>备注：</label>
								<input type="textarea" class="form-control" name="remark" placeholder="备注">
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="saveYes" type="button" class="btn btn-primary" onclick="save();">
					保存
				</button>
				<button id="saveNo" type="button" class="btn" style="display:none;">
					保存
				</button>
				<button type="button" class="btn btn-default"
						data-dismiss="modal">取消
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>