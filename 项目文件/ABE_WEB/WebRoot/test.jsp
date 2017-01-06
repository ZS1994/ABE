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
			"<%=path %>/app/one!uploadPhoto",
			{UId:$("#UId2").val(),UPhoto:$("#UPhoto2").val(),format:$("#format2").val(),licence:$("#licence").val()},
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
<input type="button" value="登录" onclick="cs()"/>
<hr/>
模拟手机上传头像
<br/>licence
<input id="licence" type="text"/>
<br/>ID
<input id="UId2" type="text"/>
<br/>后缀
<input id="format2" type="text"/>
<br/>头像
<textarea id="UPhoto2" rows="5" cols="20"></textarea>
<br/>
<input type="button" value="上传头像" onclick="cs2()"/>

<hr/>
本地测试接口<br/>
URL：http://localhost:8080/ABE_WEB/app/<input id="urltmp" type="text"/>(写后面的部分)
<br/>
<input type="button" value="添加宝贝" onclick="$('#urltmp').val('student!addFromApp');"/>
<input type="button" value="查看学生信息" onclick="$('#urltmp').val('student!queryFromApp');"/>
<input type="button" value="分页查看所有学生信息" onclick="$('#urltmp').val('student!queryOfFenYeFromApp');"/>
<input type="button" value="发表分享" onclick="$('#urltmp').val('forum!addFromApp');"/>
<input type="button" value="发表评论" onclick="$('#urltmp').val('forum!addCommentFromApp');"/>
<input type="button" value="查看分享" onclick="$('#urltmp').val('forum!queryOfFenYeForumFromApp');"/>
<input type="button" value="查看评论" onclick="$('#urltmp').val('forum!queryOfFenYeCommentFromApp');"/>
<input type="button" value="点赞" onclick="$('#urltmp').val('forum!updateLikeFromApp');"/>
<input type="button" value="添加市" onclick="$('#urltmp').val('city!addFromApp');"/>
<input type="button" value="修改市" onclick="$('#urltmp').val('city!updateFromApp');"/>
<input type="button" value="查看市" onclick="$('#urltmp').val('city!queryFromApp');"/>
<input type="button" value="添加区" onclick="$('#urltmp').val('area!addFromApp');"/>
<input type="button" value="修改区" onclick="$('#urltmp').val('area!updateFromApp');"/>
<input type="button" value="查看区" onclick="$('#urltmp').val('area!queryFromApp');"/>
<input type="button" value="添加学校" onclick="$('#urltmp').val('school!addFromApp');"/>
<input type="button" value="修改学校" onclick="$('#urltmp').val('school!updateFromApp');"/>
<input type="button" value="查看学校" onclick="$('#urltmp').val('school!queryFromApp');"/>
<input type="button" value="添加年级" onclick="$('#urltmp').val('grade!addFromApp');"/>
<input type="button" value="修改年级" onclick="$('#urltmp').val('grade!updateFromApp');"/>
<input type="button" value="查看年级" onclick="$('#urltmp').val('grade!queryFromApp');"/>
<input type="button" value="添加班级" onclick="$('#urltmp').val('class!addFromApp');"/>
<input type="button" value="修改班级" onclick="$('#urltmp').val('class!updateFromApp');"/>
<input type="button" value="查看班级" onclick="$('#urltmp').val('class!queryFromApp');"/>
<input type="button" value="查看本周课程表" onclick="$('#urltmp').val('timetables!queryFromApp');"/>
<input type="button" value="注册" onclick="$('#urltmp').val('sign!signUpFromApp');"/>
<input type="button" value="查看成绩" onclick="$('#urltmp').val('score!QueryScoreFromApp');"/>
<input type="button" value="通过isId查询成绩" onclick="$('#urltmp').val('score!QueryScoreFromAppOfisId');"/>
<input type="button" value="打卡" onclick="$('#urltmp').val('attendance!addFromApp');"/>
<input type="button" value="查看考勤信息" onclick="$('#urltmp').val('attendance!queryOfUid');"/>
<input type="button" value="创建环信群组" onclick="$('#urltmp').val('test!createGroupHx');"/>
<div>--教师档案-->>
<input type="button" value="查看教师相关的班级信息" onclick="$('#urltmp').val('teacher!querySchoolClass');"/>
<input type="button" value="通过uid查看教师档案信息" onclick="$('#urltmp').val('teacher!queryFromApp');"/>

</div>
<br/>
<input type="button" value="添加参数" onclick="addBody()" style="background-color: rgba(230, 255, 0, 0.33);"/>
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
<div id="http_body" style="border:1px solid rgba(4, 253, 4, 0.43);padding: 5px;">
	<div id="div1">Key:<input type="text"/>Value:<input type="text"/></div>
</div>
<input type="button" value="发送请求" onclick="sendHttpPost()"/>请在开发者模式的console中查看结果


<hr/>
<script type="text/javascript">
	/*
	function sendGet(){
		$.ajax(
			url:"",
			type:"get",
			success:function(){
				
			}
		);
	}
	*/
	function sendPost(){
		$.ajax({
			url:"https://a1.easemob.com/1149161109115389/abeweb/token",
			type:"post",
			data:'{"grant_type":"client_credentials","client_id":"YXA6bT3_gKZGEeako5-7Fr2uYA","client_secret":"YXA6t2dRDJBE4mygBoMMkYLpkpA9yyE"}',
			success:function(str){
				console.log(str);
			}
		});
	}
	function sendPost2(){
		$.ajax({
			url:"https://a1.easemob.com/1149161109115389/abeweb/users",
			type:"post",
			headers:{'Authorization':'Bearer YWMtbgY8rKZGEearZsnUazr-ywAAAAAAAAAAAAAAAAAAAAFtPf-ApkYR5qSjn7sWva5gAgMAAAFYR8qcmABPGgBZtHWSsPRtszcvIFxdYj85tbIvZyVEQMx7Tu26LEs6ZA'},
			data:'{"username":\"'+$('#name').val()+'\","password":"'+$('#pass').val()+'"}',
			success:function(str){
				console.log(str);
			}
		});
	}
	function sendPut(){
		$.ajax({
			url:"https://a1.easemob.com/1149161109115389/abeweb/users/"+$('#name_put').val()+"/password",
			type:"put",
			headers:{'Authorization':'Bearer YWMtbgY8rKZGEearZsnUazr-ywAAAAAAAAAAAAAAAAAAAAFtPf-ApkYR5qSjn7sWva5gAgMAAAFYR8qcmABPGgBZtHWSsPRtszcvIFxdYj85tbIvZyVEQMx7Tu26LEs6ZA'},
			data:'{"newpassword":\"'+$('#pass_put_new').val()+'\"}',
			success:function(str){
				console.log(str);
			}
		});
	}
	function sendDelete(){
		$.ajax({
			url:"https://a1.easemob.com/1149161109115389/abeweb/users/"+$('#name_delete').val(),
			type:"delete",
			headers:{'Authorization':'Bearer YWMtbgY8rKZGEearZsnUazr-ywAAAAAAAAAAAAAAAAAAAAFtPf-ApkYR5qSjn7sWva5gAgMAAAFYR8qcmABPGgBZtHWSsPRtszcvIFxdYj85tbIvZyVEQMx7Tu26LEs6ZA'},
			success:function(str){
				console.log(str);
			}
		});
	}
</script>
<br/>
<input type="button" value="测试-获取token" onclick="sendPost()"/>
<br/><br/>
username<input type="text" id="name"/>password<input type="text" id="pass"/>
<br/>
<input type="button" value="测试-创建账号" onclick="sendPost2()"/>
<br/><br/>
username<input type="text" id="name_delete"/>
<br/>
<input type="button" value="测试-删除单个用户" onclick="sendDelete()"/>
<br/><br/>
username<input type="text" id="name_put"/>
<br/>
新password<input type="text" id="pass_put_new"/>
<br/>
<input type="button" value="测试-重置用户密码" onclick="sendPut()"/>
<br/><br/>


</body>
</html>
