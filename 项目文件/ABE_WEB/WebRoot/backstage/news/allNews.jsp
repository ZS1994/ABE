<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>学生管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/FRAMEWORK/css/assembly.css">
		
	</head>

	<body>
		<jsp:include page="/component/assembly/top.jsp"></jsp:include>
		<jsp:include page="/component/assembly/left.jsp"></jsp:include>
		<div class="right">



			<div style="margin-bottom: 5px; padding: 5px;">
				快速查询
				<br />
				<form action="<%=path%>/web/news!queryOfFenYe" method="post">
					编号:
					<input name="id" type="text" value="${id }" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询" />
				</form>
			</div>

			<table border="1" class="odd_table">
				<thead>
					<tr>
						<th style="width: 40px;">
							序号
						</th>
						<th width="130px">
							编号
						</th>
						<th>
							标题
						</th>
						<th>
							发布状态
						</th>
						<th>
							新闻类型
						</th>
						<th>
							新闻来源
						</th>
						<th>
							创建时间
						</th>
						<th>
							最后修改时间
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${newslist}" var="news" varStatus="sta">
						<tr>
							<td>
								${(sta.index+1)+((page.pageOn-1)*page.size) }
							</td>
							<td width="" align="center">
								${news.NId }
							</td>
							<td width="" align="center">
								${news.NTitle }
							</td>
							<td width="" align="center">
								${news.NStatus }
							</td>
							<td width="" align="center">
								${news.NType }
							</td>
							<td width="" align="center">
								${news.NOrigin }
							</td>
							<td width="" align="center">
								<fmt:formatDate value="${news.NCreatTime }" pattern="yyyy-MM-dd" />
							</td>
							<td width="" align="center">
								<fmt:formatDate value="${news.NFinalTime }" pattern="yyyy-MM-dd" />
							</td>
							<td width="5%" align="center">
								<a data-options="plain:true" class="easyui-linkbutton" onclick="update('${news.NId}','${news.NTitle}','${news.NStatus}','<fmt:formatDate value="${news.NCreatTime }" pattern="yyyy-MM-dd" />','<fmt:formatDate value="${news.NFinalTime }" pattern="yyyy-MM-dd" />','${news.NContent}','${news.NIstop}','${news.NOrigin}','${news.NType}','${news.UId}')">修改</a>
								<a data-options="plain:true" class="easyui-linkbutton"
									href="<%=path%>/web/news!delete?id=${news.NId}&token=${token}"
									onclick="return confirm('确定删除吗?')">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="9">
							<form id="f1" action="<%=path%>/web/news!queryOfFenYe?id=${id}"
								method="post">
								<select id="sele"
									style="float: left; margin-top: 3px; margin-left: 5px;"
									name="page.size" onchange="$('#f1').submit();">
									<option value="10">
										10
									</option>
									<option value="15">
										15
									</option>
									<option value="20">
										20
									</option>
								</select>
								<span style="float: left; margin-left: 5px;"> <span
									style="color: #A5A5A5;">|</span> <a onclick="page(1,2)"
									class="easyui-linkbutton"
									data-options="plain:true,iconCls:'icon-last'" title="首页"></a> <a
									onclick="page(-1,1)" class="easyui-linkbutton"
									data-options="plain:true,iconCls:'icon-l'" title="上一页"></a> <span
									style="color: #A5A5A5;">|</span> </span>
								<span style="float: left; margin-top: 3px; margin-left: 5px;">
									<input id="page" name="page.pageOn" type="number"
										style="width: 50px; height: 20px;" value="${page.pageOn }"
										min="1" max="${page.pageMax }" onchange="$('#f1').submit();" />
								</span>
								<span style="float: left; margin-top: 5px; margin-left: 5px;">/${page.pageMax
									}</span>
								<span style="float: left; margin-left: 5px;"> <span
									style="color: #A5A5A5;">|</span> <a onclick="page(1,1)"
									class="easyui-linkbutton"
									data-options="plain:true,iconCls:'icon-n'" title="下一页"></a> <a
									onclick="page('${page.pageMax}',2)" class="easyui-linkbutton"
									data-options="plain:true,iconCls:'icon-next'" title="末页"></a> </span>
							</form>
						</td>
					</tr>
				</tfoot>
			</table>


			<div id="upd" class="easyui-window" title="修改"
				data-options="modal:true,closed:true"
				style=" width:800px; padding: 10px; display: none;">
				<form action="<%=path%>/web/news!update" method="post">
					<table class="table table-bordered table-hover definewidth m10"
						id="tables" style="width: 90%">
						<tr>
							<td>
								<button type="button" class="btn btn-info">
									该新闻编号
								</button>
								&nbsp;
								<input type="text" id="u_1" name="news.NId" readonly="readonly"/>
								&nbsp;&nbsp;
							</td>
							<td>
							<button type="button" class="btn btn-info">
									新闻创建日期
								</button>
								&nbsp;
								<input id="u_4" type="text" name="news.NCreatTime" readonly="readonly"/>
							</td>
						</tr>
						<tr>
						<td>
								<button type="button" class="btn btn-info">
									创建者编号
								</button>
								&nbsp;
								<input type="text" id="u_10" name="news.UId" readonly="readonly"/>
								&nbsp;&nbsp;
							</td>
							
							<td>
								<button type="button" class="btn btn-info">
									上次修改日期
								</button>
								&nbsp;
								<input id="u_5" type="text" name="news.NFinalTime" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							

							<td>
								<button type="button" class="btn btn-info">
									类型
								</button>
								&nbsp;
								<select name="news.NType" id="u_9">
									<option value="生活">
										生活
									</option>
									<option value="健康">
										健康
									</option>
									<option value="新闻">
										新闻
									</option>
									<option value="头条咨询">
										头条资讯
									</option>
								</select>
								&nbsp;&nbsp;
							</td>

						</tr>

						<tr>
							<td>
								<button type="button" class="btn btn-info">
									是否置顶
								</button>
								&nbsp;&nbsp;
								<input name="news.NIstop" type="radio" value="0" id="u_7_0"/>
								否 &nbsp;
								<input name="news.NIstop" type="radio" value="1" id="u_7_1"/>
								是&nbsp;
							</td>
							<td>
								<button type="button" class="btn btn-info">
									状态
								</button>
								&nbsp;&nbsp;
								<input name="news.NStatus" type="radio" value="1" id="u_3_1"/>
								发布中&nbsp;
								<input name="news.NStatus" type="radio" value="0" id="u_3_0"/>
								未发布 &nbsp;
								
							</td>
						</tr>
						<tr>
							<td>
								<button type="button" class="btn btn-info">
									标题
								</button>
								&nbsp;
								<input type="text" id="u_2" name="news.NTitle" 
									style="color: #C0C0C0" />
								&nbsp;&nbsp;
							</td>
							<td>
								<button type="button" class="btn btn-info">
									来源
								</button>
								&nbsp;
								<input type="text" name="news.NOrigin" id="u_8" 
									style="color: #C0C0C0">
								&nbsp;&nbsp;
							</td>
							<td type="hidden">
								<input type="hidden" name=news.NContent id="Content" />
							</td>
						</tr>
						<tr>
							<td colspan="2" id="checkeds">
								<section id="editor">
								<div id='edit' style="margin-top: 0px; height: 500px;"></div>
								</section>

							</td>
						</tr>
						<tr>
							<td colspan="2" id="checkeds" style="TEXT-ALIGN: center;">
								<input type="submit" class="btn btn-primary" id="tijiaoxiugai"
									value="提交修改">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	</body>
	<script src="<%=path%>/FRAMEWORK/froala_editor/js/froala_editor.min.js"></script>
	<!--[if lt IE 9]>
    <script src="../js/froala_editor_ie8.min.js"></script>
  <![endif]-->
	<script
		src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/tables.min.js"></script>
	<script src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/lists.min.js"></script>
	<script
		src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/colors.min.js"></script>
	<script
		src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/media_manager.min.js"></script>
	<script
		src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/font_family.min.js"></script>
	<script
		src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/font_size.min.js"></script>
	<script
		src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/block_styles.min.js"></script>
	<script src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/video.min.js"></script>
	<script src="<%=path%>/FRAMEWORK/froala_editor/js/langs/zh_cn.js"></script>
	<link
			href="<%=path%>/FRAMEWORK/froala_editor/css/font-awesome.min.css"
			rel="stylesheet" type="text/css">
	<link
			href="<%=path%>/FRAMEWORK/froala_editor/css/froala_editor.min.css"
			rel="stylesheet" type="text/css">
	<script type="text/javascript">
	
	$(function(){
		$("#sele option[value='"+${page.size}+"']").attr("selected",true);
	})
	//分页
	function page(no,cz){
		var num1=$('#page').val();
		if(cz==1){//上下页
			$('#page').val(num1*1+no*1);
		}else if(cz==2){//首末页
			$('#page').val(no);
		}else{
		}
		if($('#page').val()*1<1){
			$('#page').val(1);
		}else if($('#page').val()*1>${page.pageMax}*1){
			$('#page').val(${page.pageMax});
		}
		$('#f1').submit();
	}
	function sexRadio(str){
		if(str == "男"){
			return 0;
		}else if(str == "女"){
			return 1;
		}
	}
	function numRadio(str){
		if(str == 0){
			return 0;
		}else if(str == 1){
			return 1;
		}
	}
	function update(u1,u2,u3,u4,u5,u6,u7,u8,u9,u10){
		$('#edit').editable( {
			inlineMode : false,
			alwaysBlank : true
		});
		// 修改编辑器高度
		$(".froala-element").attr("style", "height:75%");
		
		$('#upd').window('open');
		$('#u_1').val(u1);
		$('#u_2').val(u2);
		$('#u_3_'+numRadio(u3)).click();
		$('#u_4').val(u4);
		$('#u_5').val(u5);
		$(".froala-element").html(u6);
		$('#u_7_'+numRadio(u7)).click();
		$('#u_8').val(u8);
		$("#u_9 option[value='"+u9+"']").attr("selected",true);
		$('#u_10').val(u10);
		
	}
	$("#tijiaoxiugai").click(function() {
			var content = $(".froala-element").html();
			$("#Content").val(content);
			if(confirm("是否确认修改？")){
			return true;
			}else{
			return false;
			}
		})
</script>
</html>