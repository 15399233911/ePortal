<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>eportal电子商务管理系统</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/css.css" />
		<link href="css/admin.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/sdmenu.js"></script>
		<script type="text/javascript" src="js/laydate/laydate.js"></script>
	</head>
	
	<body>
		<div class="header">
 			<div class="logo"><h3>ePortal电子商务管理系统</h3></div>
			<div class="header-right">
				<a style="font-size:15px">欢迎：${currentAdmin.loginname }</a>
	            <i class="icon-question-sign icon-white"></i> <a href="#">帮助</a>
				<i class="icon-off icon-white"></i>
				<a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal">注销</a>
	            <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">注销系统</h3>
					</div>
					<div class="modal-body"><p>您确定要注销退出系统吗？</p></div>
					<div class="modal-footer">
						 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height:20px;" href="loginSys.jsp" >确定退出</a>
					</div>
				</div>
			</div>
		</div>
		<!-- 顶部 -->
		
		<div id="middle">
		     <div class="left">
				    <script type="text/javascript">
						var myMenu;
						window.onload = function() {
							myMenu = new SDMenu("my_menu");
							myMenu.init();
						};
					</script>
				
					<div id="my_menu" class="sdmenu"><!--左侧菜单-->
						<div >
							<span>用户</span>
							<a href="#">会员管理</a>
							<a href="#">会员级别管理</a>
							<a href="#">系统用户</a>
							<a href="#">新增会员级别</a>
							<a href="#">新增系统用户</a>
							<a href="#">新增注册会员</a>
						</div>
						<div class="collapsed">
							<span>商品</span>
							<a href="#">商品管理</a>
							<a href="#">商品分类</a>
							<a href="#">新增商品</a>
							<a href="#">新增商品分类</a>
						</div>
						<div class="collapsed">
							<span>新闻</span>
							<a href="#">新闻管理</a>
							<a href="#">新闻栏目管理</a>
							<a href="#">新增新闻</a>
							<a href="#">新增新闻栏目</a>
						</div>
					
						<div class="collapsed">
							<span>订单</span>
							<a href="#">订单管理</a>
						</div>
				  </div>
		    </div>
			<!-----------------菜单舒展按钮--------------------->
			<!--<div class="Switch"></div>-->
			<!--<script type="text/javascript">-->
			<!--   	$(document).ready(function(e) {-->
			<!--		$(".Switch").click(function(){-->
			<!--		$(".left").toggle();-->
			<!--		});-->
			<!--	});-->
			<!--</script>-->
			 <div>
				 <div class="right"  id="mainFrame"><!--右侧正文-->
					 <div class="right_cont">
						 <ul class="breadcrumb">当前位置：
							  <a href="#">首页</a> <span class="divider">/</span>
							  <a href="#">商品</a> <span class="divider">/</span>
							    商品分类
						 </ul>
					 </div>
				 </div>
		     </div>
		     
		     <div>
		<!-------------------商品分类管理---------------------->
		<!--main-->
		<center>
			<div class="titleText">新闻栏目管理</div>
			<div style="margin-bottom:10px;">
				<a href="getNewsColumnPer.action">新增新闻栏目</a>		
			</div>
			<div class="displayTable">
			<table id="row" class="displaytag" style="width: 80%;margin-left: 250px">
			<thead>
				<tr>
					<th class="sortable">行号</th>
					<th class="sortable">上级栏目</th>
					<th class="sortable">栏目名称</th>
					<th class="sortable">栏目编码</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="list" status="st">
					<tr style="<s:if test="#st.even">background-color:#F0F0F0</s:if>">
						<td style="text-align:center;"><s:property value="(#st.index+1)+(page-1)*size"/></td>
						<td style="text-align:center;"><s:property value="newscolumns.columnname"/></td>
						<td style="text-align:center;"><s:property value="columnname"/></td>
						<td style="text-align:center;"><s:property value="columncode"/></td>
						<td style="text-align:center;">							
							<a href="updateNewsColumns.action?id=${id }">修改</a>&nbsp;				
							<a href="deleteNewsColumns.action?id=${id }">删除</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			</table> 
			<!----------分页-------->
				<div align="center">
					<span class="pagebanner">共找到${count }条记录</span>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<span class="pagelinks">
						[<a href="newsColumns.action?page=1">首页</a>/
						
						<c:if test="${page>1 }">
							<a href="newsColumns.action?page=${page-1 }">上一页</a>]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
						<c:if test="${page<=1}">
							上一页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
							
						<c:if test="${page != total }">
							[<a href="newsColumns.action?page=${page+1 }">下一页</a>/
						</c:if>
						<c:if test="${page == total}">
							[下一页/
						</c:if>
						
						<a href="newsColumns.action?page=${total }">末页</a>]
					</span>
				</div>		
		</div>
		</center>
		<!------------------------------------------->

		     </div>
		</div>
		<!-- 底部 -->
		<div id="footer">版权所有：ePortal &copy; 2015&nbsp;&nbsp;&nbsp;&nbsp;</div>
		
		 <script>
			!function(){
				laydate.skin('molv');
				laydate({elem: '#Calendar'});
			}();
		</script>
	</body>
</html>
