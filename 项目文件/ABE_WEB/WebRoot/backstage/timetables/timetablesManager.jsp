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
		<form action="<%=path %>/web/timetables!add" method="post">
			<div>
				科目:
				<input class="easyui-textbox" type="text" name="timetables.CId" data-options="required:true" />
		    </div>
		    <div>
				班级:
				<input class="easyui-textbox" type="text" name="timetables.scId" data-options="required:true" />
		    </div>
		    <div>
				教师:
				<input class="easyui-textbox" type="text" name="timetables.itId" data-options="required:true" />
		    </div>
		    <div>
				开始时间:
				<input class="easyui-textbox" type="time" name="time1" />
		    </div>
		    <div>
				结束时间:
				<input class="easyui-textbox" type="time" name="time2" />
		    </div>
		    <div>
				星期:
				<input class="easyui-textbox" type="number" name="timetables.TWeek" />
		    </div>
		    <div>
				序号:
				<input class="easyui-textbox" type="number" name="timetables.TOrder" />
		    </div>
		    <div>
				<input type="submit" value="添加课程表"/>
		    </div>
		</form>
		
		<hr/>
		<form action="<%=path %>/web/timetables!queryOfFenYe" method="post">
			<input type="text" name="scId"/>
			<input type="submit" value="查看本周课程表"/>
		</form>
		<table id="tt" class="easyui-datagrid" style="width:800px;height:auto;">
		<thead>
			<tr>
				<th rowspan="2" field="name1" width="">周数</th>
				<th rowspan="2" field="name2" width="">班级</th>
				<th colspan="4">课表</th>
			</tr>	
			<tr>
				<th field="name3" width="">第一节课</th>
				<th field="name4" width="">第二节课</th>
				<th field="name5" width="">第三节课</th>
				<th field="name6" width="">第四节课</th>
			</tr>                          
		</thead>                           
		<tbody>  
			<c:forEach items="${ttlist}" var="tt">
			<tr>                           
				<td>${tt[0].TWeek }</td>            
				<td>${tt[0].scId }<br/>${tt[0].schoolClass.scName }</td>            
				<td>${tt[0].CId }${tt[0].course.CName }(${tt[0].infoTeacher.itName })<br/>${tt[0].TStartTime }~${tt[0].TEndTime }</td>            
				<td>${tt[1].CId }${tt[1].course.CName }(${tt[1].infoTeacher.itName })<br/>${tt[1].TStartTime }~${tt[1].TEndTime }</td>            
				<td>${tt[2].CId }${tt[2].course.CName }(${tt[2].infoTeacher.itName })<br/>${tt[2].TStartTime }~${tt[2].TEndTime }</td>            
				<td>${tt[3].CId }${tt[3].course.CName }(${tt[3].infoTeacher.itName })<br/>${tt[3].TStartTime }~${tt[3].TEndTime }</td>            
			</tr>                          
			</c:forEach>                        
		</tbody>                           
	</table>
		
		
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
