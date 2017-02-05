<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<jsp:include page="/component/assembly/top.jsp"></jsp:include>
	<jsp:include page="/component/assembly/left.jsp"></jsp:include>
	<div class="right">
		
		<input type="button" value="新建" style="margin-top: 3px;" onclick="$('#add').window('open');"/>
		
		<div style="margin-bottom: 5px;padding: 5px;">
	    	快速查询
	    	<br/>
	    	<form action="<%=path %>/web/rel!queryOfFenYe" method="post">
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
			    	<th>家长</th>
					<th>学生</th>
					<th>关系</th>
					<th>操作</th>
			    </tr>
			</thead>
			<tbody>
				<c:forEach items="${rels}" var="r" varStatus="sta">
			    <tr>
			    	<td width="" align="center">${(sta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td width="" align="center">${r.spId }</td>
					<td width="" align="center">${r.parent.ipName }</td>
					<td width="" align="center">${r.student.isName }</td>
					<td width="" align="center">${r.spRelation }</td>
					<td width="5%" align="center">
						<a data-options="plain:true" class="easyui-linkbutton" onclick="update('${r.spId}','${r.ipId}','${r.isId}',
						'${r.spRelation}')">修改</a>
						<a data-options="plain:true" class="easyui-linkbutton" href="<%=path %>/web/rel!delete?id=${r.spId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
					</td>
			    </tr>
			    </c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<form id="f1" action="<%=path %>/web/rel!queryOfFenYe?id=${id}" method="post">
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
			<form action="<%=path %>/web/rel!add" method="post">
				家长：<br/>
		<!--	<select name="rel.ipId">
					<c:forEach items="${pars}" var="par">
					<option value="${par.ipId }">${par.ipName }(手机号${par.ipPhone })</option>
					</c:forEach>
				</select> -->
			
				<input type="text" id="a_2" name="rel.ipId"/>
				<br/>
				学生：<br/>
		<!--			<select name="rel.isId">
					<c:forEach items="${stus}" var="stu">
					<option value="${stu.isId }">${stu.isName }(学号${stu.isNum })</option>
					</c:forEach>
				</select>
			-->
			<input type="text" id="a_3" name="rel.isId"/>
				<br/>
				关系：<br/>
				<select  name="rel.spRelation">
				<option value="父女">父女</option>
				<option value="父子">父子</option>
				<option value="母女">母女</option>
				<option value="母子">母子</option>
				</select>
				<br/>
				<input type="submit" value="提交"/>
			</form>
		</div>
		
		<div id="upd" class="easyui-window" title="修改" data-options="modal:true,closed:true" style="width:300px;padding:10px;display: none;">
			<form action="<%=path %>/web/rel!update" method="post">
				编号：<br/>
				<input id="u_1" type="text" name="rel.spId" style="width: 100%" readonly="readonly"/><br/>
				家长：<br/>
					<input type="text" id="u_2" name="rel.ipId"/>		
		<!--	<select id="u_2" name="rel.ipId">
					<c:forEach items="${pars}" var="par">
					<option value="${par.ipId }">${par.ipName }(手机号${par.ipPhone })</option>
					</c:forEach>
				</select>
	-->	
				<br/>
				学生：<br/>
					<input type="text" id="u_3" name="rel.isId"/>
		<!-- 	<select id="u_3" name="rel.isId">
					<c:forEach items="${stus}" var="stu">
					<option value="${stu.isId }">${stu.isName }(学号${stu.isNum })</option>
					</c:forEach>
				</select>
		 -->
				<br/>
				关系：<br/>
				<select id="u_4"  name="rel.spRelation">
				<option value="父女">父女</option>
				<option value="父子">父子</option>
				<option value="母女">母女</option>
				<option value="母子">母子</option>
				</select>
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
		$("#a_2").AutoComplete({
			"data": "<%=path%>/web/rel!querySrt?type="+2,
	       	"async": true,
	       	"scroll":true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/手机号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
						
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
		$("#u_2").AutoComplete({
			"data": "<%=path%>/web/rel!querySrt?type="+2,
	       	"async": true,
	       	"scroll":true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/手机号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
						
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
		$("#a_3").AutoComplete({
			"data": "<%=path%>/web/rel!querySrt?type="+1,
	       	"async": true,
	       	"scroll":true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/手机号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
						
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
		$("#u_3").AutoComplete({
			"data": "<%=path%>/web/rel!querySrt?type="+1,
	       	"async": true,
	       	"scroll":true,
			"width": "auto",
			"listStyle": "custom",
			"matchHandler": function(keyword, data){
				var isgo=(data.num.indexOf(keyword)>=0)||(data.name.indexOf(keyword)>=0);
	            return isgo;
	        },
			"createItemHandler": function(index, data){
				var str="<div>"+
						"编号："+data.value+"<br/>"+
						"学号/手机号："+data.num+"<br/>"+
						"姓名："+data.name+
						"</div>";
						
				return str;
			},
			"onerror": function(msg){alert(msg);}
		});
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
	function update(u1,u2,u3,u4){
		$('#upd').window('open');
		$('#u_1').val(u1);
		$('#u_2').val(u2);
		$('#u_3').val(u3);
		$("#u_4 option[value='"+u4+"']").attr("selected",true);
	}
</script>
</html>