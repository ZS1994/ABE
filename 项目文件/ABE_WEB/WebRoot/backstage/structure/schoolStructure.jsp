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
    
    <title>学校班级架构</title>
    
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
		
		
		<select id="pps">
			<option value="">--请选择--</option>	
			<c:forEach items="${pps}" var="p">
			<option value="${p.ppId }">${p.ppName }</option>	
			</c:forEach>
		</select>
		省
		<select id="pcs">
			<option value="">--请选择--</option>	
		</select>
		市
		<select id="pas">
			<option value="">--请选择--</option>	
		</select>
		区
		
		<p>温馨提示：双击可查看详情。</p>
		
        <div id="sch_content">
        	<ul id="tree_ul" class="easyui-tree" data-options="animate:true,lines:true">
        	</ul>
        </div>
        
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
<script type="text/javascript">
	$(function(){
		$("#pps").change(function(){
			$.post(
				"<%=path %>/web/schoolStructure!queryPc",
				{"ppId":$(this).val()},
				function(data){
					var jarr=$.parseJSON(data);
					$("#pcs").html("<option value=''>--请选择--</option>");
					for ( var i = 0; i < jarr.length; i++) {
						$("#pcs").append("<option value='"+jarr[i].pcId+"'>"+jarr[i].pcName+"</option>");
					}
					$("#pas").html("<option value=''>--请选择--</option>");
				}
			);
		});
		$("#pcs").change(function(){
			$.post(
				"<%=path %>/web/schoolStructure!queryPa",
				{"pcId":$(this).val()},
				function(data){
					var jarr=$.parseJSON(data);
					var str="";
					$("#pas").html("<option value=''>--请选择--</option>");
					for ( var i = 0; i < jarr.length; i++) {
						$("#pas").append("<option value="+jarr[i].paId+">"+jarr[i].paName+"</option>");
					}
				}
			);
		});
		$("#pas").change(function(){
			$('#tree_ul').tree({
			    url:"<%=path %>/web/schoolStructure!querySch?paId="+$(this).val(),
			    formatter:function(node){
					return node.text;
				},
				onDblClick: function(node){
					window.location.href="<%=path%>"+node.attributes.path;
				}
			});
		});
	});
</script>
</html>
