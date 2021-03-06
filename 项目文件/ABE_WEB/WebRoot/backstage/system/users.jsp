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
    
    <title>用户管理</title>
    
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
		
		<input type="button" value="新建" style="margin-top: 3px;" onclick="$('#add').window('open');"/>
		
	    <div class="kscx">
	    	<form action="<%=path %>/web/users!queryOfFenYe" method="post">
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
					<th style="width: 140px;">账号</th>
					<th>昵称</th>
					<th>密码</th>
					<th style="width: 50px;">类型</th>
					<th>创建时间</th>
					<th>头像路径</th>
					<th style="width: 140px;">档案id</th>
					<th>角色</th>
					<th>学校</th>
					<th style="width: 75px;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="u" varStatus="sta">
				<tr>
					<td>${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td>${u.UId }</td>
					<td>${u.UNum }</td>
					<td>${u.UName }</td>
					<td>${u.UPass }</td>
					<td>${u.UType }</td>
					<td>${u.UCreateTime }</td>
					<td>${u.UPhotoPath }</td>
					<td>${u.trpId }</td>
					<td>${u.role.RName }</td>
					<td>${u.school.SName }</td>
					<td>
						<a class="easyui-linkbutton" onclick="update('${u.UId}','${u.UNum}','${u.UName}','${u.UPass}','${u.trpId}','${u.RId}')" data-options="plain:true">修改</a>
						<a class="easyui-linkbutton" href="<%=path %>/web/users!delete?id=${u.UId}&token=${token}" onclick="return confirm('确定删除吗?')" data-options="plain:true">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="12">
						<form id="f1" action="<%=path %>/web/users!queryOfFenYe?id=${id}" method="post">
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
			<form action="<%=path %>/web/users!add" method="post">
				账号:<br/>
				<input type="text" name="user.UNum" style="width: 100%;"/><br/>
				昵称:<br/>
				<input type="text" name="user.UName" style="width: 100%;"/><br/>
				密码:<br/>
				<input type="text" name="user.UPass" style="width: 100%;"/><br/>
				类型:<br/>
					<input type="radio" name="user.UType" value="1" checked="checked"/>家长
					<input type="radio" name="user.UType" value="2"/>教职工
				<br/>
				档案id:<br/>
				<input type="text" name="user.trpId" style="width: 100%;"/><br/>
				角色:<br/>
				<input type="text" name="user.RId" style="width: 100%;"/><br/>
				<div class="box_div">
					<ul class="easyui-tree" data-options="url:'<%=path %>/web/role!queryRoles?firstId=0',animate:true,lines:true">
		 			</ul>
				</div>
				<input type="submit" value="添加用户" onclick="return show_hint(['add'])"/>
			</form>
		</div>
		
		<div id="upd" class="easyui-window" title="修改" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/users!update" method="post">
				编号：<br/>
				<input id="u_1" name="user.UId" type="text" style="width: 100%;" readonly="readonly"/><br/>
				账号：<br/>
				<input id="u_2" name="user.UNum" type="text" style="width: 100%;"/><br/>
				昵称：<br/>
				<input id="u_3" name="user.UName" type="text" style="width: 100%;"/><br/>
				密码：<br/>
				<input id="u_4" name="user.UPass" type="text" style="width: 100%;"/><br/>
				档案：<br/>
				<input id="u_5" name="user.trpId" type="text" style="width: 100%;"/><br/>
				角色：<br/>
				<input id="u_6" name="user.RId" type="text" style="width: 100%;"/><br/>
				<div class="box_div">
					<ul class="easyui-tree" data-options="url:'<%=path %>/web/role!queryRoles?firstId=0',animate:true,lines:true">
		 			</ul>
				</div>
				<input type="submit" value="提交" onclick="return show_hint(['upd'])"/>
			</form>
		</div>
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
<script type="text/javascript">
	$(function(){
		$("#sele option[value='"+${page.size}+"']").attr("selected",true);
		$("#add ul").tree({
		    url:"<%=path %>/web/role!queryRoles?firstId=0",
			onClick: function(node){
				$("#add input[name='user.RId']").val(node.id);
			},
		});
		$("#upd ul").tree({
		    url:"<%=path %>/web/role!queryRoles?firstId=0",
			onClick: function(node){
				$("#upd input[name='user.RId']").val(node.id);
			},
		});
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
	function update(u1,u2,u3,u4,u5,u6){
		$('#upd').window('open');
		$('#u_1').val(u1);
		$('#u_2').val(u2);
		$('#u_3').val(u3);
		$('#u_4').val(u4);
		$('#u_5').val(u5);
		$('#u_6').val(u6);
	}
</script>
</html>