<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/assembly.css">

  </head>
  
<body>
  	
	<div class="left" style="background-color: #9B9B9B;">
  		<ul>
		<li>
			<a href="<%=path %>/">返回</a>
  		</li>
  		<li>学生管理</li>
  		<ul>
  			<li>
  				<a href="<%=path %>/backstage/student/studentManager.jsp">学生管理</a>
  			</li>
  		</ul>
  		<li>教职员工管理</li>
  		<ul>
  			<li>
  				<a href="<%=path %>/backstage/student/studentManager.jsp">教职员工管理</a>
  			</li>
  		</ul>
  		<li>课程表管理</li>
  		<ul>
  			<li>
  				<a href="<%=path %>/backstage/timetables/timetablesManager.jsp">课程表管理</a>
  			</li>
  			<li>
  				<a href="<%=path %>/backstage/timetables/courseManager.jsp">科目管理</a>
  			</li>
  		</ul>
  		<li>组织架构管理</li>
  		<ul>
  			<li>
  				<a href="<%=path %>/">班级管理</a>
  			</li>
  		</ul>
  		</ul>
  	
	</div>
  
</body>
</html>
