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
					<th>备注</th>
					<th style="width: 140px;">档案id</th>
					<th style="width: 60px;">操作</th>
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
					<td>${u.UNote }</td>
					<td>${u.trpId }</td>
					<td>
						<a onclick="">修改</a>
						<a href="<%=path %>/web/users!delete?id=${u.UId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="11">
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
		 
		<div id="add" class="easyui-window" title="新建" style="width:300px;height:180px;" data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true">
			<form action="<%=path %>/web/users!add" method="post">
				账号<input type="text" name="user.UNum"/>
				<br/>
				昵称<input type="text" name="user.UName"/>
				<br/>
				密码<input type="text" name="user.UPass"/>
				<br/>
				类型
					<input type="radio" name="user.UType" value="1" checked="checked"/>家长
					<input type="radio" name="user.UType" value="2"/>教职工
				<br/>
				档案id<input type="text" name="user.trpId"/>
				<br/>
				<input type="submit" value="添加用户"/>
			</form>
		</div>
		
		<div style="height: 1000px;">
		
		
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
</script>
</html>