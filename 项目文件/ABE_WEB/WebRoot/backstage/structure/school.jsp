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
    
    <title>学校管理</title>
    
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
		
		<form action="<%=path %>/web/school!add" method="post">
			学校名字：<input type="text" name="sch.sName"/><br/>
			学校地址：<input type="text" name="sch.sAddress"/><br/>
			区编号：<input type="text" name="sch.paId"/><br/>
			<input type="submit" value="添加"/>
		</form>
		<div>
		<table>
			<thead>
				<tr>
					<td colspan="5">
						学校信息
					</td>
				</tr>
				<tr>
					<th>学校编号</th>
					<th>学校名称</th>
					<th>学校地址</th>
					<th>区编号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${schools}" var="s" varStatus="sta">
				<tr>
					<td>${s.SId }</td>
					<td>${s.SName }</td>
					<td>${s.SAddress }</td>
					<td>${s.paId}</td>
					<td>
						<a onclick="">修改</a>
						<a href="<%=path %>/web/school!delete?id=${s.SId }" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
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
			修改学校信息
			<form action="<%=path %>/web/school!update" method="post">
				<table>
				  <tr>
				    <td>学校编号：</td>
				    <td><input type="text" name="sch.SId" readonly="readonly" /></td>
				  </tr>
				  <tr>
				    <td>学校名称：</td>
				    <td><input type="text" name="sch.SName"  /></td>
				  </tr>
				  <tr>
				    <td>学校地址</td>
				    <td><input type="text" name="sch.SAddress"  /></td>
				  </tr>
				  <tr>
				    <td>区编号：(应使用ajax列表形式选择)</td>
				    <td><input type="text" name="sch.paId" /></td>
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
