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
    
    <title>学生家长关系管理</title>
    
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
		
		<form action="<%=path %>/web/rel!add" method="post">
			家长
				<select name="rel.ipId">
					<c:forEach items="${pars}" var="par">
					<option value="${par.ipId }">${par.ipName }</option>
					</c:forEach>
				</select>
			<br/>
			学生
				<select name="rel.isId">
					<c:forEach items="${stus}" var="stu">
					<option value="${stu.isId }">${stu.isName }</option>
					</c:forEach>
				</select>
			<br/>
			关系<input type="text" name="rel.spRelation"/>
			<br/>
			<input type="submit" value="添加家长"/>
		</form>
		
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<td colspan="6">
						学生家长关系
					</td>
				</tr>
				<tr>
					<th>序号</th>
					<th>编号</th>
					<th>家长</th>
					<th>学生</th>
					<th>关系</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rels}" var="r" varStatus="sta">
				<tr>
					<td>${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td>${r.spId }</td>
					<td>${r.parent.ipName }</td>
					<td>${r.student.isName }</td>
					<td>${r.spRelation }</td>
					<td>
						<a onclick="">修改</a>
						<a href="<%=path %>/web/rel!delete?id=${r.spId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
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
