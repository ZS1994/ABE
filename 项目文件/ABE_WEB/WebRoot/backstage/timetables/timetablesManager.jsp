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
    
    <title>课程表管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
<body>
	
	<jsp:include page="/component/assembly/top.jsp"></jsp:include>
	<jsp:include page="/component/assembly/left.jsp"></jsp:include>
	<div class="right">
		
		<input type="button" value="新建" style="margin-top: 3px;" onclick="$('#add').window('open');"/>
		
	    <div class="kscx">
	    	<form action="<%=path %>/web/timetables!queryOfFenYe" method="post">
	    		班级编号:<input name="id" type="text" value="${id }"/>
	    		&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="submit" value="查询"/>
	    	</form>	
	    </div>
	    
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<th>班级</th>
					<th>周数</th>
					<th>第一节课</th>
					<th>第二节课</th>
					<th>第三节课</th>
					<th>第四节课</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tts}" var="tt" varStatus="sta">
				<tr>
					<td>${tt[0].scId }<br/>${tt[0].schoolClass.scName }</td>            
					<td>${tt[0].TWeek }</td>            
					<td>${tt[0].CId }${tt[0].course.CName }(${tt[0].infoTeacher.itName })<br/>${tt[0].TStartTime }~${tt[0].TEndTime }</td>            
					<td>${tt[1].CId }${tt[1].course.CName }(${tt[1].infoTeacher.itName })<br/>${tt[1].TStartTime }~${tt[1].TEndTime }</td>            
					<td>${tt[2].CId }${tt[2].course.CName }(${tt[2].infoTeacher.itName })<br/>${tt[2].TStartTime }~${tt[2].TEndTime }</td>            
					<td>${tt[3].CId }${tt[3].course.CName }(${tt[3].infoTeacher.itName })<br/>${tt[3].TStartTime }~${tt[3].TEndTime }</td>
					<td>
						<a class="easyui-linkbutton" onclick="update('${tt[0].scId}','${tt[0].TWeek}')" data-options="plain:true">编辑</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						<form id="f1" action="<%=path %>/web/timetables!queryOfFenYe?id=${id}" method="post">
						<select id="sele" style="float: left;margin-top: 3px;margin-left: 5px;" name="page.size" onchange="$('#f1').submit();">
							<option value="1">1</option>
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
			<form action="<%=path %>/web/timetables!add" method="post">
				班级:<br/>
				<select name="timetables.scId">
					<c:forEach items="${scas}" var="sca">
					<option value="${sca.scId }">${sca.scName }</option>
					</c:forEach>
				</select>
				<br/>
				星期:<br/>
				<select name="timetables.TWeek">
					<option value="1">星期一</option>
					<option value="2">星期二</option>
					<option value="3">星期三</option>
					<option value="4">星期四</option>
					<option value="5">星期五</option>
					<option value="6">星期六</option>
					<option value="7">星期日</option>
				</select>
				<br/>
				科目:<br/>
				<select name="timetables.CId">
					<c:forEach items="${cous}" var="cou">
					<option value="${cou.CId }">${cou.CName }</option>
					</c:forEach>
				</select>
				<br/>
				教师:<br/>
				<select name="timetables.itId">
					<c:forEach items="${teas}" var="tea">
					<option value="${tea.itId }">${tea.itName }</option>
					</c:forEach>
				</select>
				<br/>
				开始时间:<br/>
				<input type="time" name="time1" style="width: 100%;"/><br/>
				结束时间:<br/>
				<input type="time" name="time2" style="width: 100%;"/><br/>
				第几节课:<br/>
				<select name="timetables.TOrder">
					<option value="1">第一节课</option>
					<option value="2">第二节课</option>
					<option value="3">第三节课</option>
					<option value="4">第四节课</option>
				</select>
				<br/>
				<input type="submit" value="提交" onclick="return show_hint(['add'])"/>
			</form>
		</div>
		
		<div id="upd" class="easyui-window" title="修改" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/timetables!update" method="post">
				班级编号:<br/>
				<input id="u_1" type="text" name="timetables.scId" style="width: 100%;" readonly="readonly"/><br/>
				星期:<br/>
				<input id="u_2" type="text" name="timetables.TWeek" style="width: 100%;" readonly="readonly"/><br/>
				科目:<br/>
				<select name="timetables.CId">
					<c:forEach items="${cous}" var="cou">
					<option value="${cou.CId }">${cou.CName }</option>
					</c:forEach>
				</select>
				<br/>
				教师:<br/>
				<select name="timetables.itId">
					<c:forEach items="${teas}" var="tea">
					<option value="${tea.itId }">${tea.itName }</option>
					</c:forEach>
				</select>
				<br/>
				开始时间:<br/>
				<input type="time" name="time1" style="width: 100%;"/><br/>
				结束时间:<br/>
				<input type="time" name="time2" style="width: 100%;"/><br/>
				第几节课:<br/>
				<select name="timetables.TOrder">
					<option value="1">第一节课</option>
					<option value="2">第二节课</option>
					<option value="3">第三节课</option>
					<option value="4">第四节课</option>
				</select>
				<br/>
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
	
	function update(u1,u2){
		$("#upd").window("open");
		$('#u_1').val(u1);
		$('#u_2').val(u2);
	}
</script>
</html>
