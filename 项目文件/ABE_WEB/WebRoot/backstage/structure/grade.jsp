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
    
    <title>年级管理</title>
    
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
		
		<form action="<%=path %>/web/grade!add" method="post">
			年级名字：<input type="text" name="g.sgName"/><br/>
			学校id：<input type="text" name="g.SId"/><br/>
			<input type="submit" value="添加"/>
		</form>
		<div>
		<table>
			<thead>
				<tr>
					<td colspan="4">
						年级信息
					</td>
				</tr>
				<tr>
					<th>年级编号</th>
					<th>年级名称</th>
					<th>学校名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sgs}" var="sg" varStatus="sta">
				<tr>
					<td>${sg.sgId }</td>
					<td>${sg.sgName }</td>
					<td>${sg.school.SName}</td>
					<td>
						<a onclick="">修改</a>
						<a href="<%=path %>/web/grade!delete?id=${sg.sgId }" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
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
		<div>
			修改班级信息
			<form action="<%=path %>/web/grade!update" method="post">
				<table>
				  <tr>
				    <td>年级编号：</td>
				    <td><input type="text" name="g.sgId" readonly="readonly" /></td>
				  </tr>
				  <tr>
				    <td>年级名称</td>
				    <td><input type="text" name="g.sgName"  /></td>
				  </tr>
				  <tr>
				    <td>学校编号：(应使用ajax列表形式选择)</td>
				    <td><input type="text" name="g.SId" /></td>
				  </tr>
				  <tr>
				  	<td colspan="2"><input type="submit" value="提交"/></td>
				  </tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
