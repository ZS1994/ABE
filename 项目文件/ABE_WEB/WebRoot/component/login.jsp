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
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/jquery-easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/assembly.css">
	<style type="text/css">
	.box{
	    display: flex;
	    width: 100%;
	    height: 100%;
	    justify-content: center;
	    align-items:center;
	    FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,startColorStr=#fff,endColorStr=rgb(3, 99, 101)); /*IE 6 7 8*/ 
		background: -ms-linear-gradient(top, #fff,  rgb(3, 99, 101));        /* IE 10 */
		background:-moz-linear-gradient(top,#fff,rgb(3, 99, 101));/*火狐*/ 
		background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#fff), to( rgb(3, 99, 101)));/*谷歌*/ 
		background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#fff), to( rgb(3, 99, 101)));      /* Safari 4-5, Chrome 1-9*/
		background: -webkit-linear-gradient(top, #fff,  rgb(3, 99, 101));   /*Safari5.1 Chrome 10+*/
		background: -o-linear-gradient(top, #fff,  rgb(3, 99, 101));  /*Opera 11.10+*/
	}
	.word_3d{
		text-align:center;
		width:300px;
		left:calc(50% - 125px);
		top:calc(46% - 212px);
		margin:0 auto;
		position: absolute;
	    font-size: 60px;
	    font-weight: bolder;
	    text-shadow: 1px 1px rgba(61, 123, 255, 0.8), 2px 2px rgba(13, 133, 248, 0.8), 3px 3px rgba(21, 138, 251, 0.8), 4px 4px rgba(34, 144, 250, 0.8), 5px 5px rgba(50, 149, 242, 0.8), 6px 6px rgba(81, 166, 247, 0.8);
	    color: rgb(0, 230, 219);
	}
	.box_midden{
		width:300px;
		height:160px;
		margin-top: -4%;
		border: 1px black solid;
		box-shadow: 3px 3px 3px;
		border-radius: 15px;
		padding: 15px;
		background-color: white;
	}
	</style>
	</head>
<body class="box">

<div class="box_midden">
	<h1 align="center">登录</h1>
	<form action="<%=path %>/web/sign!signIn" method="post">
		<div style="text-align: center;">
			账号：<input type="text" name="user.UNum"/>
		</div>
		<div style="margin-top: 5px;text-align: center;">
			密码：<input type="password" name="user.UPass"/>
		</div>
		<div align="center" style="margin-top: 5px;">
			<input type="submit" value="登录"/>
		</div>
	</form>
	<div style="text-align: center;color: red;">${hint }</div>
</div>
<div class="word_3d">
	安贝尔
</div>

<jsp:include page="/component/assembly/token.jsp"></jsp:include>
</body>
</html>
