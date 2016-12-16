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
			<c:forEach items="${pps}" var="p">
			<option value="${p.ppId }">${p.ppName }</option>	
			</c:forEach>
		</select>
		省
		<select id="pcs">
			<c:forEach items="${pcs}" var="c">
			<option value="${c.pcId }">${c.pcName }</option>	
			</c:forEach>	
		</select>
		市
		<select id="pas">
			<c:forEach items="${pas}" var="a">
			<option value="${a.paId }">${a.paName }</option>	
			</c:forEach>	
		</select>
		区
		
		<br/>
		
                该区部下的学校班级架构
        <ul class="easyui-tree" data-options="animate:true,lines:true">
     	<c:forEach items="${schools}" var="s">
                <li><span><a href="<%=path %>/web/school!queryOfFenYe?cz=no&id=${s.SId }">${s.SName }</a></span>
  	         	<ul>
  	         	<c:forEach items="${s.grade}" var="g">
 			 		<li><span><a href="<%=path %>/web/grade!queryOfFenYe?cz=no&id=${g.sgId }" >${g.sgName }</a></span>
      	     		<ul>
      	     		<c:forEach items="${g.sclass}" var="c">
     		 			<li><span><a href="<%=path %>/web/class!queryOfFenYe?cz=no&id=${c.scId}">${c.scName }</a></span>
     		 				<ul>
	       	     		<c:forEach items="${c.student}" var="student">
	      		 			<li><span><a href="#" target="right">${student.isName }</a></span></li>
	       	     		</c:forEach>
	       	     		</ul>
     		 			</li>
      	     		</c:forEach>
      	     		</ul>
 			 		</li>
  	         	</c:forEach>
  	         	</ul>
                </li>
     	</c:forEach>
        </ul>
        
        
        
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
<script type="text/javascript">
	$(function(){
		$("#pps option[value='"+${pp.ppId}+"']").attr("selected",true);
		$("#pcs option[value='"+${pc.pcId}+"']").attr("selected",true);
		$("#pas option[value='"+${pa.paId}+"']").attr("selected",true);
	});
</script>
</html>
