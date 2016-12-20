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
    
    <title>卡片管理</title>
    
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
	    	<form action="<%=path %>/web/card!queryOfFenYe" method="post">
	    		卡号:<input name="id" type="text" value="${id }"/>
	    		&nbsp;&nbsp;&nbsp;&nbsp;
	    		<input type="submit" value="查询"/>
	    	</form>	
	    </div>
		
		
		
		<table border="1" class="odd_table">
			<thead>
				<tr>
					<th>序号</th>
					<th>卡号</th>
					<th>持卡人类型</th>
					<th>持卡人</th>
					<th>发卡人</th>
					<th>发卡时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cards}" var="c" varStatus="sta">
				<tr>
					<td>${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td>${c.CId }</td>
					<td>${c.CType }</td>
					<td>${c.srtId }</td>
					<td>${c.itId }</td>
					<td>${c.CCreateTime }</td>
					<td>${c.CState}</td>
					<td>
						<a class="easyui-linkbutton" onclick="update('${c.CId}','${c.CType}','${c.srtId}'
						,'${c.itId}','${c.CState}','${c.CCreateTime}')" data-options="plain:true">修改</a>
						<a class="easyui-linkbutton" href="<%=path %>/web/card!delete?id=${c.CId}&token=${token}" onclick="return confirm('确定删除吗?')" data-options="plain:true">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">
						<form id="f1" action="<%=path %>/web/card!queryOfFenYe?id=${id}" method="post">
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
			<form action="<%=path %>/web/card!add" method="post">
				卡号：<br/>
				<input type="text" name="card.CId" style="width: 100%;"/><br/>
				用户类型：
				<div>
					<input type="radio" name="card.CType" value="1" checked="checked"/>学生
					<input type="radio" name="card.CType" value="2"/>教职工
				</div>
				用户档案id：<br/>
				<input type="text" name="card.srtId" style="width: 100%;"/>
				<br/>
				发卡人id:<br/>
				<input type="text" name="card.itId" style="width: 100%;"/>
				<br/>
				状态：<br/>
				<select name="card.CState">
					<option value="已发卡">已发卡</option>
					<option value="未发卡">未发卡</option>
				</select>
				<br/>
				<input type="submit" value="提交" onclick="return show_hint(['add'])"/>
			</form>
		</div>
		
		<div id="upd" class="easyui-window" title="修改" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/card!update" method="post">
				卡号：<br/>
				<input id="u_1" type="text" name="card.CId" style="width: 100%;" readonly="readonly"/><br/>
				用户类型：<br/>
				<input id="u_2_0" type="radio" name="card.CType" value="1" checked="checked"/>学生
				<input id="u_2_1" type="radio" name="card.CType" value="2"/>教职工
				<br/>
				用户档案id：<br/>
				<input id="u_3" type="text" name="card.srtId" style="width: 100%;"/>
				<br/>
				发卡人id:<br/>
				<input id="u_4" type="text" name="card.itId" style="width: 100%;"/>
				<br/>
				状态：<br/>
				<select id="u_5" name="card.CState">
					<option value="已发卡">已发卡</option>
					<option value="未发卡">未发卡</option>
				</select>
				<div>
				发卡时间：<br/>
				<input id="u_6" type="text" name="card.CCreateTime" style="width: 100%;" readonly="readonly"/>
				</div>
				<br/>
				<input type="submit" value="提交" onclick="return show_hint(['upd'])"/>
			</form>
		</div>
		
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
</body>
<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/autocomplete/src/jquery.autocomplete.css"></link>
<script type="text/javascript" src="<%=path %>/FRAMEWORK/autocomplete/src/jquery.autocomplete.js"></script>
<script type="text/javascript">
	$(function(){
		$("#sele option[value='"+${page.size}+"']").attr("selected",true);
		$("#add input[name='card.srtId']").AutoComplete({
			"data": "<%=path%>/web/card!querySrt?type="+$("#add input[name='card.CType']:checked").val(),
	       	"async": true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/工号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
		$("#add input[name='card.itId']").AutoComplete({
			"data": "<%=path%>/web/card!querySrt?type="+2,
	       	"async": true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/工号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
		$("#upd input[name='card.srtId']").AutoComplete({
			"data": "<%=path%>/web/card!querySrt?type="+$("#upd input[name='card.CType']:checked").val(),
	       	"async": true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/工号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
		$("#upd input[name='card.itId']").AutoComplete({
			"data": "<%=path%>/web/card!querySrt?type="+2,
	       	"async": true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/工号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
	});
	$("#add input[name='card.CType']").click(function(){
		$("#add input[name='card.srtId']").AutoComplete({
			"data": "<%=path%>/web/card!querySrt?type="+$("#add input[name='card.CType']:checked").val(),
	       	"async": true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/工号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
	});
	$("#upd input[name='card.CType']").click(function(){
		$("#upd input[name='card.srtId']").AutoComplete({
			"data": "<%=path%>/web/card!querySrt?type="+$("#upd input[name='card.CType']:checked").val(),
	       	"async": true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/工号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
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
	function numRadio(str){
		if(str == 1){
			return 0;
		}else if(str == 2){
			return 1;
		}
	}
	function update(u1,u2,u3,u4,u5,u6){
		$('#upd').window('open');
		$('#u_1').val(u1);
		$('#u_2_'+numRadio(u2)).click();
		$('#u_3').val(u3);
		$('#u_4').val(u4);
		$("#u_5 option[value='"+u5+"']").attr("selected",true);
		$('#u_6').val(u6);
	}
</script>
</html>
