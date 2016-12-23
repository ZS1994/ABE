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
    
    <title>班级管理</title>
    
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
		
		<div style="margin-bottom: 5px;padding: 5px;">
	    	快速查询
	    	<br/>
	    	<form action="<%=path %>/web/class!queryOfFenYe" method="post">
	    		编号:<input name="id" type="text" value="${id }"/>
	    		&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="submit" value="查询"/>
	    	</form>	
	    </div>
		
		
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<th>班级编号</th>
					<th>班级名称</th>
					<th>班主任</th>
					<th>年级</th>
					<th>学校</th>
					<th>班级创建时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${scs}" var="c" varStatus="sta">
				<tr>
					<td>${c.scId }</td>
					<td>${c.scName }</td>
					<td>${c.infoTeacher.itName }</td>
					<td>${c.schoolGrade.sgName }</td>
					<td>${c.school.SName }</td>
					<td>${c.scCreateTime }</td>
					<td>${c.scState}</td>
					<td>
						<a class="easyui-linkbutton" onclick="update('${c.scId}','${c.scName}','${c.schoolGrade.sgId}'
						,'${c.infoTeacher.itId}','${c.scCreateTime}','${c.scState}')">修改</a>
						<a class="easyui-linkbutton" href="<%=path %>/web/class!delete?id=${c.scId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">
						<form id="f1" action="<%=path %>/web/class!queryOfFenYe?id=${id}" method="post">
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
			<form action="<%=path %>/web/class!add" method="post">
				班级名称：<br/>
				<input type="text" name="cla.scName" style="width: 100%;"/><br/>
				年级：<br/>
				<select name="cla.sgId">
					<c:forEach items="${sgs}" var="sg">
					<option value="${sg.sgId }">${sg.sgName }</option>
					</c:forEach>
				</select>
				<br/>
				班主任：<br/>
				<select name="cla.itId">
					<c:forEach items="${teas}" var="tea">
					<option value="${tea.itId }">${tea.itName }</option>
					</c:forEach>
				</select>
				<br/>
				状态：<br/>
				<select name="cla.scState">
					<option value="有效">有效</option>
					<option value="无效">无效</option>
				</select>
				<br/>
				<input type="submit" value="提交" onclick="return show_hint(['add'])"/>
			</form>
		</div>
		
		<div id="upd" class="easyui-window" title="修改" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/class!update" method="post">
				班级编号：<br/>
				<input id="u_1" name="cla.scId" type="text" style="width: 100%;" readonly="readonly"/><br/>
				班级名称：<br/>
				<input id="u_2" type="text" name="cla.scName" style="width: 100%;"/><br/>
				年级：<br/>
				<select id="u_3" name="cla.sgId">
					<c:forEach items="${sgs}" var="sg">
					<option value="${sg.sgId }">${sg.sgName }</option>
					</c:forEach>
				</select>
				<br/>
				班主任：<br/>
				<select id="u_4" name="cla.itId">
					<c:forEach items="${teas}" var="tea">
					<option value="${tea.itId }">${tea.itName }</option>
					</c:forEach>
				</select>
				<br/>
				创建时间：<br/>
				<input id="u_5" type="text" name="cla.scCreateTime" style="width: 100%;" readonly="readonly"/><br/>
				状态：<br/>
				<select id="u_6" name="cla.scState">
					<option value="有效">有效</option>
					<option value="无效">无效</option>
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
	function update(u1,u2,u3,u4,u5,u6){
		$('#upd').window('open');
		$('#u_1').val(u1);
		$('#u_2').val(u2);
		$("#u_3 option[value='"+u3+"']").attr("selected",true);
		$("#u_4 option[value='"+u4+"']").attr("selected",true);
		$('#u_5').val(u5);
		$("#u_6 option[value='"+u6+"']").attr("selected",true);
	}
</script>
</html>
