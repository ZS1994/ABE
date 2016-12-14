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
		<input type="text" value="省" /><input type="text" value="市" /><input type="text" value="区" name="paId"/><br/>
        <span><a href="#" target="right">该区部下的学校班级架构</a></span>
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
</html>
