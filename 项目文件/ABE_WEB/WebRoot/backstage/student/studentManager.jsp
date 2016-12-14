<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/assembly.css">
  </head>
  
<body>
	<jsp:include page="/component/assembly/top.jsp"></jsp:include>
	<jsp:include page="/component/assembly/left.jsp"></jsp:include>
	<div class="right">
		
		<input type="button" value="新建" style="margin-top: 3px;" onclick="$('#add').window('open');"/>
		
		<div style="margin-bottom: 5px;padding: 5px;">
	    	快速查询
	    	<br/>
	    	<form action="<%=path %>/web/student!queryOfFenYe" method="post">
	    		编号:<input name="id" type="text" value="${id }"/>
	    		&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="submit" value="查询"/>
	    	</form>	
	    </div>
	    
		<table border="1" class="odd_table">
			<thead>
				 <tr>
				 	<th style="width: 40px;">序号</th>
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
			</thead>
			<tbody>
				<c:forEach items="${stus}" var="stu" varStatus="sta">
			    <tr>
			    	<td>${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
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
						<a class="easyui-linkbutton" onclick="update('${stu.isName}','${stu.isSex}','${stu.isBirthday}','${stu.isLocal}','${stu.isTeacherChildren}','${stu.isLeaveDate }','${stu.isState }','${stu.schoolClass }','${stu.isId }')">修改</a>
						<a class="easyui-linkbutton" href="<%=path %>/web/student!delete?id=${stu.isId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
			    </tr>
			    </c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10">
						<form id="f1" action="<%=path %>/web/student!queryOfFenYe?id=${id}" method="post">
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
		 
		<div id="add" class="easyui-window" title="新建" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
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
		
		<div id="upd" class="easyui-window" title="修改" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/student!update" method="post">
				学生姓名：<br/>
				<input id="u_1" name="student.isName" type="text" style="width: 100%;" /><br/>
				性别：<br/>
				男<input id="u_2_0" type="radio" name="student.isSex" value="男"/>
				女<input id="u_2_1" type="radio" name="student.isSex" value="女"/><br/>
				生日：<br/>
				<input id="u_3" name="student.isBirthday" type="date" style="width: 100%;"/><br/>
				是否本地生：
				是：<input id="u_4_1" type="radio" name="student.isLocal" value="1" checked="checked"/>
				否：<input id="u_4_0" type="radio" name="student.isLocal" value="0"/><br/>
				是否是教职子弟：
				是：<input id="u_5_1" type="radio" name="student.isTeacherChildren" value="1"/>
				否：<input id="u_5_0" type="radio" name="student.isTeacherChildren" value="0"/><br/>
				离校日期：
				<input id="u_6" type="date" name="student.isLeaveDate" /><br/>
				状态：
				<input id="u_7" type="text" name="student.isState" /><br/>
				班级(写ajax获取当前所有班级)：
				<input id="u_8" type="text" name="student.scId" /><br/>
				<input id="u_9" type="hidden" name="student.IsId" />
				<input type="submit" value="提交" onclick="return show_hint(['upd'])"/>
			</form>
		</div>
	
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
<script type="text/javascript">
	
	$(function(){
		$("#sele option[value='"+${page.size}+"']").attr("selected",true);
	})
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
	function sexRadio(str){
		if(str == "男"){
			return 0;
		}else if(str == "女"){
			return 1;
		}
	}
	function numRadio(str){
		if(str == 0){
			return 0;
		}else if(str == 1){
			return 1;
		}
	}
	function update(u1,u2,u3,u4,u5,u6,u7,u8,u9){
		$('#upd').window('open');
		$('#u_1').val(u1);
		$('#u_2_'+sexRadio(u2)).click();
		$('#u_3').val(u3);
		$('#u_4_'+numRadio(u4)).click();
		$('#u_5_'+numRadio(u5)).click();
		$('#u_6').val(u6);
		$('#u_7').val(u7);
		$('#u_8').val(u8);
		$('#u_9').val(u9);
	}
</script>
</html>