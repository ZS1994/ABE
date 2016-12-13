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
    <title>教职工管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/assembly.css">
	
	<!--<link rel="stylesheet" href="<%=path %>/FRAMEWORK/css/css-ljl/login-comon.css" />
	--><!--<link rel="stylesheet" href="<%=path %>/FRAMEWORK/css/css-ljl/css/register.css" />
	-->
	<script src="<%=path %>/FRAMEWORK/js/js-ljl/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/GlobalProvinces_main.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/GlobalProvinces_extend.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/initLocation.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/js-ljl/cascade/onchage.js"></script>
	<!--<script src="<%=path %>/FRAMEWORK/js/js-ljl/register.js"></script>
	-->
	<script type="text/javascript">
    	$(function () { 
    		initLocation({ 
    			sheng_val: "",
    			shi_val: "",
    			xian_val: "", 
    			xiang_val: "" 
   			});
   			$("#type_sel option[value='${type}']").attr("selected",true);
			$("#sele option[value='"+${page.size}+"']").attr("selected",true);
			$("#eidtASubjectWindow1").show();
			$('#tt').show();
 		});
 		//分页
		function page(no,cz){
			var num1=$('#page').val();
			if(cz==1){//上下页
				$('#page').val(num1*1+no*1);
			}else if(cz==2){//首末页
				$('#page').val(no);
			}else{
			}
			if($('#page').val()*1<1){
				$('#page').val(1);
			}else if($('#page').val()*1>${page.pageMax}*1){
				$('#page').val(${page.pageMax});
			}
			$('#f1').submit();
		}
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
						<tr>
							<td class="td-first">本人头像 ：</td>
							<td class="td-medium"><a href="javascript:"
								class="btn_addPic"><span><i>+</i>添加图片</span><input
									type="file" tabindex="3" size="3" name="image"
									class="filePrew picfile" onchange="changepic(event);"></a><i></i></td>
							<td class="td-last"><div id="pic-file"></div></td>
						</tr>
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
						<tr>
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
						</tr>
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
	</div>		
		
		<hr/>
		<form action="<%=path %>/web/teacher!add" method="post">
			工号<input type="text" name="teacher.itNum"/>
			<br/>
			名字<input type="text" name="teacher.itName"/>
			<br/>
			性别
				<input type="radio" name="teacher.itSex" value="男" checked="checked"/>男
				<input type="radio" name="teacher.itSex" value="女"/>女
			<br/>
			生日<input type="date" name="teacher.itBirthday"/>
			<br/>
			手机号<input type="text" name="teacher.itPhone"/>
			<br/>
			职务<input type="text" name="teacher.itPost"/>
			<br/>
			入职日期<input type="date" name="teacher.itIntoDate"/>
			<br/>
			离职日期<input type="date" name="teacher.itLeaveDate"/>
			<br/>
			状态<input type="text" name="teacher.itState"/>
			<br/>
			住址<input type="text" name="teacher.itAddress"/>
			<br/>
			部门编号<input type="text" name="teacher.ssId"/>
			<br/>
			<input type="submit" value="添加教职工"/>
		</form>
		
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<td colspan="14">
						教职工信息
					</td>
				</tr>
				<tr>
					<th>序号</th>
					<th>编号</th>
					<th>工号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>生日</th>
					<th>手机</th>
					<th>职务</th>
					<th>入职日期</th>
					<th>离职日期</th>
					<th>状态</th>
					<th>住址</th>
					<th>部门编号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teachers}" var="t" varStatus="sta">
				<tr>
					<td>${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td>${t.itId }</td>
					<td>${t.itNum }</td>
					<td>${t.itName }</td>
					<td>${t.itSex }</td>
					<td>${t.itBirthday }</td>
					<td>${t.itPhone }</td>
					<td>${t.itPost }</td>
					<td>${t.itIntoDate }</td>
					<td>${t.itLeaveDate }</td>
					<td>${t.itState }</td>
					<td>${t.itAddress }</td>
					<td>${t.ssId }</td>
					<td>
						<a onclick="">修改</a>
						<a href="<%=path %>/web/teacher!delete?id=${t.itId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="14">
						<form id="f1" action="<%=path %>/web/teacher!queryOfFenYe?id=${id}" method="post">
						<select id="sele" style="float: left;margin-top: 3px;margin-left: 5px;" name="page.size" onchange="$('#f1').submit();">
							<option value="10">10</option>
							<option value="15">15</option>
							<option value="20">20</option>
						</select>
						<span style="float: left;margin-left: 5px;">
						<span style="color: #A5A5A5;">|</span>
						<a onclick="page(1,2)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-last'" title="首页"></a>
						<a onclick="page(-1,1)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-l'" title="上一页"></a>
						<span style="color: #A5A5A5;">|</span>
						</span>
						<span style="float: left;margin-top: 3px;margin-left: 5px;">
						<input id="page" name="page.pageOn" type="number" style="width: 50px;height: 20px;" value="${page.pageOn }" min="1" max="${page.pageMax }" onchange="$('#f1').submit();"/>
						</span>
						<span style="float: left;margin-top: 5px;margin-left: 5px;">/${page.pageMax }</span>
						<span style="float: left;margin-left: 5px;">
						<span style="color: #A5A5A5;">|</span>
						<a onclick="page(1,1)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-n'" title="下一页"></a>
						<a onclick="page('${page.pageMax}',2)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-next'" title="末页"></a>
						</span>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
		
		
		
	
	
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
