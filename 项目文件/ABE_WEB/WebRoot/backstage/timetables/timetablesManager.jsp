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
				日期:
				<input class="easyui-textbox" type="date" name="timetables.TDate" />
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
		<a href="<%=path %>/web/timetables!gotoQuery">查看本周课程表</a>
		<table id="tt" class="easyui-datagrid" style="width:600px;height:auto;">
		<thead>
			<tr>
				<th rowspan="2" field="name1" width="50">日期</th>
				<th rowspan="2" field="name2" width="50">班级</th>
				<th colspan="4">课表</th>
			</tr>	
			<tr>
				<th field="name3" width="50">第一节课</th>
				<th field="name4" width="50">第二节课</th>
				<th field="name5" width="50">第三节课</th>
				<th field="name6" width="50">第四节课</th>
			</tr>                          
		</thead>                           
		<tbody>  
			<tr>                           
				<td>Data 1</td>            
				<td>Data 2</td>            
				<td>Data 3</td>            
				<td>Data 4</td>            
				<td>Data 5</td>            
				<td>Data 6</td>            
			</tr>    
			<c:forEach items="${ttlist}" var="tt">
			<tr>                           
				<td>${tt[0].TDate }</td>            
				<td>${tt[0].scId }</td>            
				<td>${tt[0].course.CName }</td>            
				<td>${tt[1].course.CName }</td>            
				<td>${tt[2].course.CName }</td>            
				<td>${tt[3].course.CName }</td>            
			</tr>                          
			</c:forEach>                        
		</tbody>                           
	</table>
		
		
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
