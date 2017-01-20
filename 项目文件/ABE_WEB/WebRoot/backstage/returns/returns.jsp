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
    
    <title>反馈管理</title>
    
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
		
		<div style="margin-bottom: 5px;padding: 5px;">
	    	快速查询
	    	<br/>
	    	<form action="<%=path %>/web/returns!queryOfFenYe" method="post">
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
			    	<th>用户名</th>
			    	<th>反馈内容</th>
			    	<th>反馈状态</th>
			    	<th>反馈时间</th>
			    	<th>操作</th>
			    </tr>
			</thead>
			<tbody>
				<c:forEach items="${rets}" var="ret" varStatus="reta">
			    <tr>
			    	<td>${(reta.index+1)+((page.pageOn-1)*page.size) }</td>
					<td width="" align="center">${ret.RId }</td>
					<td width="" align="center">${ret.user.UName }</td>
					<td width="" align="center" style="word-break:break-all">${ret.RContent }</td>
					<td width="" align="center">${ret.RStatus }</td>
					<td width="" align="center">${ret.RTime }</td>
					<td width="5%" align="center">
						<a data-options="plain:true" class="easyui-linkbutton" href="<%=path %>/web/returns!delete?id=${ret.RId}&token=${token}" onclick="return confirm('确定删除吗?')">删除</a>
						<a data-options="plain:true" class="easyui-linkbutton" href="#">发送个人消息</a>
					</td>
			    </tr>
			    </c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						<form id="f1" action="<%=path %>/web/returns!queryOfFenYe?id=${id}" method="post">
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
	function update(u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11){
		$('#upd').window('open');
		$('#u_1').val(u1);
		$('#u_2').val(u2);
		$('#u_3').val(u3);
		$('#u_4_'+sexRadio(u4)).click();
		$('#u_5').val(u5);
		$('#u_6_'+numRadio(u6)).click();
		$('#u_7_'+numRadio(u7)).click();
		$('#u_8').val(u8);
		$('#u_9').val(u9);
		$("#u_10 option[value='"+u10+"']").attr("selected",true);
		$("#u_11 option[value='"+u11+"']").attr("selected",true);
	}
</script>
</html>