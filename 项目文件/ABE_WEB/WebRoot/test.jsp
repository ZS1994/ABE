<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/themes/yellow/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/jquery-easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/mycss.css">
  </head>
  <script type="text/javascript">
	function cs(){
		console.log("-----进入cs----");
		$.post(
			"<%=path %>/app/sign!signInFromApp",
			{UNum:$("#UNum").val(),UPass:$("#UPass").val()},
			function(data){
				console.log(data);
			}
		);
	}
	function cs2(){
		console.log("-----进入注册----");
		$.post(
			"<%=path %>/app/sign!signUpFromApp",
			{UId:$("#UId2").val(),UPhoto:$("#UPhoto2").val(),format:$("#format2").val()},
			function(data){
				console.log(data);
			}
		);
	}
  </script>
<body>

模拟手机登录的情况(请进入开发者模式Console查看测试情况)
<br/>
<input id="UNum" type="text"/>
<br/>
<input id="UPass" type="text"/>
<br/>
<input type="button" value="测试" onclick="cs()"/>


<hr/>
模拟手机注册
<br/>ID
<input id="UId2" type="text"/>
<br/>后缀
<input id="format2" type="text"/>
<br/>头像
<textarea id="UPhoto2" rows="5" cols="20"></textarea>
<br/>
<input type="button" value="注册" onclick="cs2()"/>




</body>
</html>
