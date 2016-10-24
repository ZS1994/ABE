function my_confirm(){
	//这个是section1、section2、section3等等的删除提醒
	return confirm("确定删除吗?删除该节点会将该节点下面的所有子节点一起删除。");
}


function check(){
	var ban1=$('#num').val();
	var ban2=$('#month').val();
	var str1=$.trim(ban1);
	var str2=$.trim(ban2);
	if((ban1!=undefined && str1=="") || (ban2!=undefined && str2=="")){
		alert("必填项不能为空！请重新输入！");
		return false;
	}else {
		return true;
	}
}

//记住用户名密码
function save() {
	var str_username = $("#txt_username").val();
	var str_password = $("#txt_password").val();
  if ($("#ck_rmbUser").attr("checked")) {
    $.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie
    $.cookie("username", str_username, { expires: 7 });
    $.cookie("password", str_password, { expires: 7 });
  }
  else {
    $.cookie("rmbUser", "false", { expire: -1 });
    $.cookie("username", "", { expires: -1 });
    $.cookie("password", "", { expires: -1 });
  }
  if(
	  (str_username!=undefined 
			  && ($.trim(str_username)=="" || $.trim(str_username)=="请输入用户名")) 
		  || 
	  (str_password!=undefined 
			  && ($.trim(str_password)=="" || $.trim(str_password)=="请输入密码"))
	  ){
  	alert("用户名和密码不能为空!");
  	return false;
  }else {
  	return true;
	}
}

