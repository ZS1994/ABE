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
    
    <title>本地测试接口（模拟APP访问）</title>
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
		console.log("-----上传图片----");
		$.post(
			"<%=path %>/app/sign!uploadPhoto",
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

<hr/>
本地测试接口<br/>
URL：http://localhost:8080/ABE_WEB/app/<input id="urltmp" type="text"/>(写后面的部分)
<input type="button" value="添加宝贝" onclick="$('#urltmp').val('student!addFromApp');"/>

<br/>
<input type="button" value="添加参数" onclick="addBody()"/>
<script type="text/javascript">
	function addBody(){
		var par=$('#http_body');
		var first=$('#div1');
		var len=par.children().length;
		first.after("<div id='div"+(len+1)+"'>Key:<input type=\"text\"/>Value:<input type=\"text\"/><input type=\"button\" value=\"删除参数\" onclick=\"removeChildren('div"+(len+1)+"')\"/></div>");  
	}
	function removeChildren(id){
		//console.log("----进入removeChildren()-----");
		//console.log($("#"+id).html());
		$("#"+id).remove();
	}
	function sendHttpPost(){
		var arr = new Object(); 						
		$('#http_body').children().each(function(i,n){
			var obj = $(n);
			var key=obj.children().eq(0).val();
			var value=obj.children().eq(1).val();
			//console.log(key+"   "+value);
			arr[key+""]=value+"";
	    });
        console.log(JSON.stringify(arr));
        var urltmp=$('#urltmp').val();//后面的url
		$.post(
			"<%=path %>/app/"+urltmp,
			arr,
			function(data){
				console.log(data);
			}
		);
	}
</script>
<div id="http_body" style="border: 1px solid black;padding: 5px;">
	<div id="div1">Key:<input type="text"/>Value:<input type="text"/></div>
</div>
<input type="button" value="发送请求" onclick="sendHttpPost()"/>请在开发者模式的console中查看结果




</body>
</html>
