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
		
		
		<form action="<%=path %>/web/card!add" method="post">
			<div>
				卡号
				<input type="text" name="card.CId"/>
			</div>
			<div>
				用户类型
				<input type="radio" name="card.CType" value="1" checked="checked"/>学生
				<input type="radio" name="card.CType" value="2"/>教职工
			</div>
			<div>
				用户档案id
				<input type="text" name="card.srtId"/>
			</div>
			<div>
				发卡人id
				<input type="text" name="card.itId"/>
			</div>
			<div>
				状态
				<input type="radio" name="card.CState" value="已发卡" checked="checked"/>已发卡
				<input type="radio" name="card.CState" value="未发卡"/>未发卡
			</div>
			<input type="submit" value="添加卡片信息"/>
		</form>
	
		
	</div>
	<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
	
</body>
</html>
