<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	
	<div class="easyui-accordion" style="width:100%;" data-options="fillSpace:true,fit: true,animate: true">
  		<div title="档案管理" data-options="iconCls:'icon-add'" style="overflow:auto;padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/student!queryOfFenYe?cz=yes&selInd=1">学生管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/parents!queryOfFenYe?cz=yes&selInd=1">家长档案管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/teacher!queryOfFenYe?cz=yes&selInd=1">教师档案管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/rel!queryOfFenYe?cz=yes&selInd=1">学生家长关系管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="课程表管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/timetables!gotoQuery?cz=yes&selInd=2">课程表管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/course!gotoQuery?cz=yes&selInd=2">科目管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="组织架构管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/school!queryOfFenYe?cz=yes&selInd=3">学校管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/grade!queryOfFenYe?cz=yes&selInd=3">年级管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/class!queryOfFenYe?cz=yes&selInd=3">班级管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/schoolStructure!queryOfFenYe?cz=yes&selInd=3">班级架构</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="新闻管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/backstage/news/edit.jsp">编辑新闻</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/news!queryOfFenYe?pageNo=1&selInd=4">新闻列表</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="卡片与考勤管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/card!gotoQuery">卡片管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="系统管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/users!queryOfFenYe?cz=yes&selInd=6">用户管理</a>
	  			</li>
	  		</ul>
  		</div>
  		
  		
  	
  	</div>
  	
  	
  	
	</div>
  
</body>
<script type="text/javascript">
	var sel=$(".easyui-accordion div[title]").eq(${selInd+1 });
	sel.attr("data-options",sel.attr("data-options")+",selected:true");
</script>
</html>
