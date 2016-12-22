<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id='hint_modal' class='easyui-window' title='' data-options='modal:true,closed:true' style='width:0px;height:0px;padding:10px;display: none;position: absolute;top: -100px;'>	
</div>		
<div id='hint' style='position: fixed;top: 50%;left: 50%;width: 400px;height: 30px;margin-left: -200px;margin-top: -15px;text-align: center;display:none;color: white;font-size: 20px;font-weight: bold;background-color: black;line-height: 30px;'>		
	<img alt="" width="30" height="30" src="<%=path%>/FRAMEWORK/image/jiaZaiZhong.gif" style="position: fixed;margin-left: -40px;"/>
	请求正在响应中...请稍等...
</div>
<script type="text/javascript">
//防止用户多次点击，过场字幕提示
function show_hint(array) {
	console.log($("#hint_modal").html());
	$("#hint_modal").window('open');
	for ( var i = 0; i < array.length; i++) {
		$("#"+array[i]).window('close');
	}
	console.log(array.length);
	$("#hint").show();
	return true;
}
</script>