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
    <title>教师管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/assembly.css">
	
	<!--<link rel="stylesheet" href="<%=path %>/FRAMEWORK/css/css-ljl/login-comon.css" />
	--><!--<link rel="stylesheet" href="<%=path %>/FRAMEWORK/css/css-ljl/css/register.css" />
	--><script src="<%=path %>/FRAMEWORK/js/js-ljl/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/GlobalProvinces_main.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/GlobalProvinces_extend.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/initLocation.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/onchage.js"></script>
	<!--<script src="<%=path %>/FRAMEWORK/js/js-ljl/register.js"></script>
	--><script type="text/javascript">
    $(function () { initLocation({ sheng_val: "", shi_val: "", xian_val: "", xiang_val: "" }); })
</script>
	
	
  </head>
<body>
	
	<br><jsp:include page="/component/assembly/top.jsp"></jsp:include>
	<jsp:include page="/component/assembly/left.jsp"></jsp:include>
	<div class="right">
		<div style="width: 100%;">
			<div style="margin:0 auto;width:100px;text-align: center;">
			<a>添加教师档案</a>
			<a href="<%=path %>/web/student!queryOfFenYe?cz=yes">查看教师</a>
			</div>
			
	<div class="section">
		<div class="container">
			<form method="post" action=".action" onsubmit="return formValidator()" enctype="multipart/form-data" id="myform">
				<table>
					<thead>
						<tr class="whole-row ">
							<th colspan="3" class="first-line">添加教师档案</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="td-first"><span>* </span>教师ID：</td>
							<td class="td-medium"><input name="teacher.itId" id="itId"
								 type="text" /></td>
							<td id="suggest" class="def-tips" style="color:red"></td>
						</tr>
						<tr>
							<td class="td-first"><span>* </span>教师工号 ：</td>
							<td class="td-medium"><input name="teacher.itNum" id="itNum"
								 type="text" /></td>
							<td id="suggest" class="def-tips" style="color:red"></td>
						</tr>
						<tr>
							<td class="td-first"><span>* </span>姓名 ：</td>
							<td class="td-medium"><input name="teacher.itName" id="itName"
								type="text"/></td>
							<td id="repwd-tips" class="def-tips realName-tips"></td>
						</tr>
						<tr>
							<td class="td-first">性别 ：
							<td class="td-medium" name="teacher.itSex">
							    <input type="radio" name="teacher.itSex" id="man" value="0" 
							    checked="checked" /><label for="man">男</label> <input type="radio" 
							    name="teacher.itSex" id="women" value="1" /><label for="women">女</label> 
							    <input type="radio" name="teacher.itSex" id="secret" /><label for="secret">保密</label>
							</td>
							<td class="td-last"></td>
						</tr>
						<!--<tr>
							<td class="td-first">本人头像 ：</td>
							<td class="td-medium"><a href="javascript:"
								class="btn_addPic"><span><i>+</i>添加图片</span><input
									type="file" tabindex="3" size="3" name="image"
									class="filePrew picfile" onchange="changepic(event);"></a><i></i></td>
							<td class="td-last"><div id="pic-file"></div></td>
						</tr>-->
						<tr>
							<td class="td-first">生日 ：</td>
							<td><input type="date" id="date"/></td>
							<td id="QQ-tips" class="td-last def-tips"></td>
						</tr>
						<tr>
							<td class="td-first">手机号 ：</td>
							<td class="td-medium">
							
							<input name="teacher.itPhone" type="text" id="tel" />
								</td>
							<td id="tel-tips" class="def-tips td-last"></td>
						</tr>
						<tr>
							<td class="td-first">职务 ：</td>
							<td>
							<select name="teacher.itPost" value="">
								<option value="0">--请选择--</option>
								<option value="1">语文老师</option>
								<option value="2">音乐老师</option>
								<option value="3">美术老师</option>
								<option value="4">数学老师</option>
								<option value="5">数学老师</option>
								<option value="6">数学老师</option>
								<option value="7">数学老师</option>
							</select>
							<input name="teacher.itPost" type="text" id="QQ" />
							</td>
							<td id="QQ-tips" class="td-last def-tips"></td>
						</tr>
						<tr>
							<td class="td-first">入职日期：</td>
							<td><input name="teacher.itIntoDate" type="date"  id="intoDate" /></td>
							<td id="mail-tips" class="td-lx ast def-tips"></td>
						</tr>
						<tr>
							<td class="td-first">离职日期：</td>
							<td><input name="teacher.itLeaveDate" type="date" id="IntoDate" /></td>
							<td id="mail-tips" class="td-lx ast def-tips"></td>
						</tr>
						<tr>
							<td class="td-first">状态：</td>
							<td>
							<select name="teacher.itState" value="">
								<option value="0">--请选择--</option>
								<option value="1">在职</option>
								<option value="2">已离职</option>
								<option value="3">休假中</option>
								<option value="4">已退休</option>
							</select>
							<input name="teacher.itState" type="text" id="state" />
							</td>
							<td id="mail-tips" class="td-lx ast def-tips"></td>
						</tr>
						<!--<tr>
							<td class="td-first">住址：</td>
							<td colspan="2" class="send-address">
								<select id="sheng" onchange="provincefunction()" ></select> 
							    <select id="shi"   onchange="fatherfunction()" ></select> 
							    <select id="xian"  onchange="areafunction()" ></select> 
							    <select id="xiang" onchange="streetfunction()" ></select>
							    <span class="addr-tips" style="padding-left:10px;"></span>
							<input  type="hidden" id="province"  name="user.province"/>
							<input  type="hidden" id="father" name="user.father"/>
							<input  type="hidden" id="area" name="user.area"/>
							<input  type="hidden" id="street" name="user.street"/>
							</td>
						</tr>-->
						<tr>
							<td class="td-first">住址 ：</td>
							<td class="td-medium"><input name="teacher.itAddress" type="text"
								id="address" /></td>
							<td id="address-tips" class="td-last"></td>
						</tr>
						<tr>
							<td class="td-first">部门编号：</td>
							<td class="td-medium"><input name="teacher.ssId" type="text"
								id="address" /></td>
							<td id="address-tips" class="td-last"></td>
						</tr>
						<tr>
							<td class="td-first">教师图片 ：</td>
							<td class="td-medium"><a href="javascript:"
								class="btn_addPic"><span> +添加图片</span> <input type="file"
									tabindex="3" size="3" name="image" class="filePrew license"
									onchange="changeLicense(event); " value="请选择要上传的图片"> </a></td>
							<td class="td-last " id="License-fiel"></td>
						</tr>
						<tr>
							<td class="td-first"></td>
							<td class="td-medium"><input type="submit" id="submit"
								value="提交" /></td>
							<td class="td-last"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
			
		
			<!--<form action="<%=path %>/web/student!add" method="post">
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
		--></div>
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
