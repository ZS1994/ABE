/*
 * 张顺
 * 2016-12-13 22:36:32
 * 公共js
 * 
 */
//显示数据表格单元格详情并可复制内容到剪贴板
$(function(){
	$("td").dblclick(function(){
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
		console.log("readonly");
		$(this).addClass("read_only");
	});
});
function trans_radio(str){
	if (str=="是") {
		return 0;
	}else if (str=="否") {
		return 1;
	}
}
