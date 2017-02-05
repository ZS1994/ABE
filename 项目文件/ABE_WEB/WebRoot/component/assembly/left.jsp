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

  </head>
  
<body>
	<div class="left" style="background-color: #9B9B9B;">
	
	
	<div class="easyui-accordion" style="width:100%;" data-options="fillSpace:true,fit: true,animate: true">
  		<div title="档案管理" data-options="iconCls:'icon-add'" style="overflow:auto;padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/student!queryOfFenYe?cz=yes&selInd=0">学生管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/parents!queryOfFenYe?cz=yes&selInd=0">家长档案管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/teacher!queryOfFenYe?cz=yes&selInd=0">教师档案管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/rel!queryOfFenYe?cz=yes&selInd=0">学生家长关系管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="课程表管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/timetables!queryOfFenYe?cz=yes&selInd=1">课程表管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/course!queryOfFenYe?cz=yes&selInd=1">科目管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="组织架构管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/schoolStructure!queryOfFenYe?cz=yes&selInd=2">区域管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/school!queryOfFenYe?cz=yes&selInd=2">学校管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/grade!queryOfFenYe?cz=yes&selInd=2">年级管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/class!queryOfFenYe?cz=yes&selInd=2">班级管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="新闻管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/backstage/news/edit.jsp">编辑新闻</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/news!queryOfFenYe?cz=yes&selInd=3">新闻列表</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="卡片与考勤管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/card!queryOfFenYe?cz=yes&selInd=4">卡片管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/attendance!queryOfFenYe?cz=yes&selInd=4">考勤管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="系统管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/users!queryOfFenYe?cz=yes&selInd=5">用户管理</a>
	  			</li>
	  			<li>
	  				<a href="<%=path %>/web/role!queryOfFenYe?cz=yes&selInd=5">角色管理</a>
	  			</li>
	  		</ul>
  		</div>
  		<div title="消息管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
  			<ul>
	  			<li>
	  				<a href="<%=path %>/web/returns!queryOfFenYe?cz=yes&selInd=6">用户反馈</a>
	  			</li>
	  			<li>
	  				<a href="#">个人通知</a>
	  			</li>
	  			<li>
	  				<a href="#">班级通知</a>
	  			</li>
	  			<li>
	  				<a href="#">公告</a>
	  			</li>
	  		</ul>
  		</div>
  		
  	
  	</div>
  	
  	
  	
	</div>
  
</body>
<script type="text/javascript">
	console.log("--->>"+${selInd });
	var sel=$(".easyui-accordion div[title]").eq(${selInd });
	sel.attr("data-options",sel.attr("data-options")+",selected:true");
</script>
</html>
