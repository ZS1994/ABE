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
  </head>
<body>

<form action="http://v1.avatardata.cn/Sms/Send?key=4819b920396a48e88ca8cda04faecff9&templateId=7f50d840e00c4c31858e3d7c6314791b" method="post">
	手机号:<input type="text" name="mobile"/>验证码将通过短信发送到该手机号，请填写常用号码
	<br/>
	验证码:<input type="text" name="param"/>
	
	<input type="submit" value="发送手机验证码"/>同一号码  一天最多能接收五次验证码
</form>

<hr/>
<a href="<%=path %>/test!test">TestAction</a>
${AAA }

<hr/>
<a href="<%=path %>/component/login.jsp">跳转登录</a>

<hr/>
<a href="<%=path %>/test!test2">测试能否查询数据库</a>

<hr/>

<a href="<%=path %>/test.jsp">跳转模拟APP登录界面</a>


</body>
</html>
