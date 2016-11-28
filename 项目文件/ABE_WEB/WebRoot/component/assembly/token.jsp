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
    
    <title>My JSP 'token.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
<script type="text/javascript">
$(function(){
	$('form').each(function (i){
		console.log(i);
		/*取消下面代码的注释即可不显示token,正式版时使用*/
		$(this).prepend("<input name='token' type='hidden' value='${token }'/>");
		/*取消下面代码的注释可显示token,调试时使用*/
		//$(this).prepend("<input name='token' type='text' value='${token }' style='width:200px;'/>请在WebRoot/component/assembly/token.jsp中开关token的显示");
	});
});
</script>
  </head>
  
  <body>
  </body>
</html>
