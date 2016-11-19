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
    
    <title>科目管理</title>
    
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
		
		<form action="<%=path %>/web/course!add" method="post">
			<div>
				科目名字：
				<input class="easyui-textbox" type="text" name="course.CName" data-options="required:true" />
			</div>
			<div>
				<input type="submit" value="添加科目"/>
			</div>
		</form>
		
		<hr/>
		<a href="<%=path %>/web/course!gotoQuery">查看所有</a>
		<c:forEach items="${courses}" var="c">
			<div>
				${c.CId }|----|${c.CName }
			</div>
		</c:forEach>
	
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
