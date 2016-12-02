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
    
    <title>学生管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/assembly.css">
  </head>
 
  
<body>
	
	<br><jsp:include page="/component/assembly/top.jsp"></jsp:include>
	<jsp:include page="/component/assembly/left.jsp"></jsp:include>
	<div class="right">
		<div style="width: 100%;">
			<div style="margin:0 auto;width:100px;text-align: center;">
			<a>添加学生</a>
			<a href="<%=path %>/web/student!queryOfFenYe?cz=yes">查看学生</a>
			</div>
			<form action="<%=path %>/web/student!add" method="post">
				学号：
				<input type="text" name="student.isNum" /><br/>
				学生姓名：
				<input type="text" name="student.isName" /><br/>
				性别：
				男<input type="radio" name="student.isSex" value="男" checked="checked"/>
				女<input type="radio" name="student.isSex" value="女"/><br/>
				生日：
				<input type="date" name="student.isBirthday" /><br/>
				是否本地生：
				是：<input type="radio" name="student.isLocal" value="1" checked="checked"/>
				否：<input type="radio" name="student.isLocal" value="0"/><br/>
				是否是教职子弟：
				是：<input type="radio" name="student.isTeacherChildren" value="1"/>
				否：<input type="radio" name="student.isTeacherChildren" value="0" checked="checked"/><br/>
				入校日期(此处还需给默认时间)：
				<input type="date" name="student.isIntoDate" /><br/>
				离校日期：
				<input type="date" name="student.isLeaveDate" /><br/>
				状态：
				<input type="text" name="student.isState" /><br/>
				班级(写ajax获取当前所有班级)：
				<input type="text" name="student.scId" /><br/>
				<input type="submit" value="提交"/>
			</form>
		</div>
		<div>
			<table border="1" id="eidtASubjectWindow1" style="font-size: 12px;">
			    <tr>
			    	<th width="130px">编号</th>
			    	<th>学号</th>
			    	<th>学生姓名</th>
			    	<th>性别</th>
			    	<th>生日</th>
			    	<th>是否本地生</th>
			    	<th>是否教职子弟</th>
			    	<th>入校日期</th>
			    	<th>离校日期</th>
			    	<th>状态</th>
			    	<th>班级id</th>
			    	<th>操作</th>
			    </tr>
			    <c:forEach items="${stus}" var="stu">
			    <tr>
					<td width="">${stu.isId }</td>
					<td width="">${stu.isNum }</td>
					<td width="">${stu.isName }</td>
					<td width="">${stu.isSex }</td>
					<td width="">${stu.isBirthday }</td>
					<td width="">${stu.isLocal }</td>
					<td width="">${stu.isTeacherChildren}</td>
					<td width="">${stu.isIntoDate }</td>
					<td width="">${stu.isLeaveDate }</td>
					<td width="">${stu.isState }</td>
					<td width="">${stu.schoolClass }</td>
					<td width="5%" align="center">
						<a onclick="">修改</a>
						<a href="<%=path %>/web/student!delete?id=${stu.isId}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
			    </tr>
			    </c:forEach>
		    </table>
		</div>
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
