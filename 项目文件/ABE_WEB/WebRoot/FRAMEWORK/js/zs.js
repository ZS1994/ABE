/*
 * 张顺
 * 2016-12-13 22:36:32
 * 公共js
 * 
 */
//显示数据表格单元格详情并可复制内容到剪贴板
$(function(){
	$("tbody tr td").dblclick(function(){
		$('#tdTip').window('open');
		$("#dialog_content").html($(this).html());
	});
	$("#tdTip input").click(function() {  
		if ( window.clipboardData ) {  
			window.clipboardData.setData("Text", $("#dialog_content").html());  
			alert('复制成功！');  
		}else{
			alert("不好意思，该浏览器无法使用该功能。");
		}
	});
	$("input[readonly]").each(function(){
		$(this).addClass("read_only");
	});
	$("input.Wdate[ddf='yyyy-MM-dd']").each(function(){
		$(this).val((new Date()).Format("yyyy-MM-dd"));
	});
	$("input.Wdate[ddf='yyyy-MM-dd hh:mm:ss']").each(function(){
		$(this).val((new Date()).Format("yyyy-MM-dd hh:mm:ss"));
	});
	$("input.Wdate[ddf='hh:mm']").each(function(){
		$(this).val((new Date()).Format("hh:mm"));
	});
});
function trans_radio(str){
	if (str=="是") {
		return 0;
	}else if (str=="否") {
		return 1;
	}
}
//对Date的扩展，将 Date 转化为指定格式的String   
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
//例子：   
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.Format = function(fmt){ //author: zs  
	var o = {   
		"M+" : this.getMonth()+1,                 //月份   
		"d+" : this.getDate(),                    //日   
		"h+" : this.getHours(),                   //小时   
		"m+" : this.getMinutes(),                 //分   
		"s+" : this.getSeconds(),                 //秒   
		"q+" : Math.floor((this.getMonth()+3)/3), //季度   
		"S"  : this.getMilliseconds()             //毫秒   
	};   
	if(/(y+)/.test(fmt))   
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	for(var k in o)   
		if(new RegExp("("+ k +")").test(fmt))   
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	return fmt;   
}  
