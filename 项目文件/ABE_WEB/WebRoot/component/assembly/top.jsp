<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/jquery-easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/My97DatePicker/WdatePicker.js"></script>
	
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/token.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/assembly.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/FRAMEWORK/css/zs_css.css">
	<script type="text/javascript" src="<%=path %>/FRAMEWORK/js/zs.js"></script>
  </head>
  
<body>
	<div class="top" style="display: table;width: 100%;text-align: center;">
  		<span style="color: black;font-family: Baskerville Old Face;font-size: 36px;font-weight: bold;display: table-cell;vertical-align: middle;">
  			安贝儿
		</span>
  		
  		
  		<div id="tdTip" class="easyui-dialog" title="提示" style="width:400px;height:200px;display: none;"
		    data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
		    <div id="dialog_content" style="word-wrap:break-word; width:300px;">
		    </div>
	    	<input type="button" value="复制到剪切板" style="position:absolute;bottom: 10px;left: 150px;"/>
		</div>
  		
  		
	    <jsp:include page="/component/assembly/token.jsp"></jsp:include>
	    
	    
	    <div style="position: absolute;bottom:5px;right: 40px;">
	    	<div style="text-align: left;">
	    		登陆者:
		    	<span style="color: red;">${user.UNum }</span>
		    	<span style="color: black;">${user.UName }</span>
	    	</div>
	    	<div style="text-align: left;">
		    	学校:
		    	<span style="color: red;">${user.school.SName }</span>
	    	</div>
	    </div>
	</div>
</body>
</html>
