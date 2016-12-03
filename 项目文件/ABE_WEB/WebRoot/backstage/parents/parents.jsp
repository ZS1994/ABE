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
    
    <title>家长档案管理</title>
    
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
		
		<form action="<%=path %>/web/parents!add" method="post">
			姓名<input type="text" name="parent.ipName"/>
			<br/>
			性别
				<input type="radio" name="parent.ipSex" value="男" checked="checked"/>男
				<input type="radio" name="parent.ipSex" value="女"/>女
			<br/>
			生日<input type="date" name="parent.ipBirthday"/>
			<br/>
			手机号<input type="text" name="parent.ipPhone"/>
			<br/>
			住址<input type="text" name="parent.ipAddress"/>
			<br/>
			<input type="submit" value="添加家长"/>
		</form>
		
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<td colspan="8">
						家长档案信息
					</td>
				</tr>
				<tr>
					<th>序号</th>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>生日</th>
					<th>手机</th>
					<th>住址</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${parents}" var="p" varStatus="sta">
				<tr>
					<td>${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td>${p.ipId }</td>
					<td>${p.ipName }</td>
					<td>${p.ipSex }</td>
					<td>${p.ipBirthday }</td>
					<td>${p.ipPhone }</td>
					<td>${p.ipAddress }</td>
					<td>
						<a onclick="">修改</a>
						<a href="<%=path %>/web/parents!delete?id=${p.ipId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">
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
