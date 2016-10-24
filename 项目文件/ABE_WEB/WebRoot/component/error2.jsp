<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/mycss.css">
  </head>
  
  <body>
  	<div style="font-size:30px;">错误代码：300</div>
	<div style="margin:100px auto;width:1000px;height:600px;">
 		<img src="<%=path %>/FRAMEWORK/image/man_error.png" style="display:block; width:320px;height:350px;float:left;">
 		<img src="<%=path %>/FRAMEWORK/image/option_error.png" style="display:block; width:480px;height:160px;float:left;">
 		<span style="display:block; width:580px;height:160px;float:left;font-size:45px;font-family:宋体;font-weight:900;">您当前账号权限不够，请与 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员联系!</span>
 		<a href="<%=path %>/welcom.jsp" target="right" style="display:block; width:300px;height:80px;float:left;margin-left:80px;background:url(<%=path %>/FRAMEWORK/image/btn_error.png);">
 			<span style="font-size:40px;color:black;margin:17px 90px;display:block;width:300px;height:80px;">返回首页</span>
 		</a>
 	</div>
  </body>
</html>
