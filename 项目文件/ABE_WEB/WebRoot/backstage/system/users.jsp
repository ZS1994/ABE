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
		
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<td colspan="11">
						用户信息
					</td>
				</tr>
				<tr>
					<th>序号</th>
					<th>编号</th>
					<th>账号</th>
					<th>昵称</th>
					<th>密码</th>
					<th>类型</th>
					<th>创建时间</th>
					<th>头像路径</th>
					<th>备注</th>
					<th>档案id</th>
					<th>操作</th>
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
						首页
						上一页
						跳转
						下一页
						末页
					</td>
				</tr>
			</tfoot>
		</table>
	
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
