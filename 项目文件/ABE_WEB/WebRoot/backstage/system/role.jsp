<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
<body>
	<jsp:include page="/component/assembly/top.jsp"></jsp:include>
	<jsp:include page="/component/assembly/left.jsp"></jsp:include>
	<div class="right">
		
		<input type="button" value="新建" style="margin-top: 3px;" onclick="add()"/>
		
		<div style="margin-bottom: 5px;padding: 5px;">
	    	快速查询
	    	<br/>
	    	<form action="<%=path %>/web/role!queryOfFenYe" method="post">
	    		编号:<input name="id" type="text" value="${id }"/>
	    		&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="submit" value="查询"/>
	    	</form>	
	    </div>
	    
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<th style="width: 40px;">序号</th>
					<th style="width: 150px;">编号</th>
					<th style="width: 140px;">名字</th>
					<th>描述</th>
					<th>创建时间</th>
					<th>创建人</th>
					<th style="width: 75px;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles}" var="r" varStatus="sta">
				<tr>
					<td>${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td>${r.RId }</td>
					<td>${r.RName }</td>
					<td>${r.RDesc }</td>
					<td>${r.RCreateTime }</td>
					<td>${r.UId }</td>
					<td>
						<a class="easyui-linkbutton" onclick="update('${r.RId}','${r.RNum}','${r.RName}','${r.RPass}','${u.trpId}')" data-options="plain:true">修改</a>
						<a class="easyui-linkbutton" href="<%=path %>/web/role!delete?id=${r.RId}&token=${token}" onclick="return confirm('确定删除吗?')" data-options="plain:true">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						<form id="f1" action="<%=path %>/web/role!queryOfFenYe?id=${id}" method="post">
						<select id="sele" style="float: left;margin-top: 3px;margin-left: 5px;" name="page.size" onchange="$('#f1').submit();">
							<option value="10">10</option>
							<option value="15">15</option>
							<option value="20">20</option>
						</select>
						<span style="float: left;margin-left: 5px;">
						<span style="color: #A5A5A5;">|</span>
						<a onclick="page(1,2)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-last'" title="首页"></a>
						<a onclick="page(-1,1)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-l'" title="上一页"></a>
						<span style="color: #A5A5A5;">|</span>
						</span>
						<span style="float: left;margin-top: 3px;margin-left: 5px;">
						<input id="page" name="page.pageOn" type="number" style="width: 50px;height: 20px;" value="${page.pageOn }" min="1" max="${page.pageMax }" onchange="$('#f1').submit();"/>
						</span>
						<span style="float: left;margin-top: 5px;margin-left: 5px;">/${page.pageMax }</span>
						<span style="float: left;margin-left: 5px;">
						<span style="color: #A5A5A5;">|</span>
						<a onclick="page(1,1)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-n'" title="下一页"></a>
						<a onclick="page('${page.pageMax}',2)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-next'" title="末页"></a>
						</span>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
		 
		<div id="add" class="easyui-window" title="新建" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/role!add" method="post">
				<div>
					名字:<br/>
					<input type="text" name="role.RName" style="width: 100%;"/>
				</div>
				<div>
					描述:<br/>
					<input type="text" name="role.RDesc" style="width: 100%;"/>
				</div>
				<div>
					父角色:<br/>
					<div style="height: 100px;">
						<ul id="tree_ul_a_ids" class="easyui-tree" data-options="animate:true,lines:true">
        				</ul>
					</div>
				</div>
				<div>
					权限:<br/>
					<div style="height: 100px;">
						<ul id="tree_ul_a_pers" class="easyui-tree" data-options="animate:true,lines:true" checkbox="true">
        				</ul>
					</div>
				</div>
				<input type="submit" value="添加用户" onclick="return show_hint(['add'])"/>
			</form>
		</div>
		
		<div id="upd" class="easyui-window" title="修改" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/role!update" method="post">
				编号：<br/>
				<input id="u_1" name="role.RId" type="text" style="width: 100%;" readonly="readonly"/><br/>
				账号：<br/>
				<input id="u_2" name="role.RNum" type="text" style="width: 100%;"/><br/>
				昵称：<br/>
				<input id="u_3" name="role.RName" type="text" style="width: 100%;"/><br/>
				密码：<br/>
				<input id="u_4" name="role.RPass" type="text" style="width: 100%;"/><br/>
				档案：<br/>
				<input id="u_5" name="user.trpId" type="text" style="width: 100%;"/><br/>
				<input type="submit" value="提交" onclick="return show_hint(['upd'])"/>
			</form>
		</div>
		
		
		
		
		
		
		
		
		
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
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
	function add(){
		$("#add").window("open");
		$('#tree_ul_a_ids').tree({
		    url:"<%=path %>/web/role!queryRoles",
		    formatter:function(node){
				return node.text;
			},
			onDblClick: function(node){
				console.log("------blClick: function(node){--------");
			},
			onClick: function(node){
				$('#tree_ul_a_pers').tree({
				    url:"<%=path %>/web/role!getPers",
				    formatter:function(node){
						return node.text;
					},
					onDblClick: function(node){
						console.log("--------onDblClick: function(node){----------");
					},
					onClick:function(node){
						console.log("------ick: function(node){--------");
						
						
					},
					onCheck:function(node, checked){
						console.log("------点击复选框--------");
						var nodes = $('#tree_ul_a_pers').tree('getChecked');
						console.log(nodes);
					}
				});
				
			},
		});
	}
</script>
</html>