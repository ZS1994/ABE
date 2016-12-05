$(function() {

	//输入框不可点击状态时 背景颜色为灰色：
    $("input[type=text]:disabled").css("background-color","rgb(235, 235, 228)");
    
    //短信邮箱验证 未点击时文本框不可提交
    $(".phone").click(function(){
    	var regExp=/^1[34589]\d{9}$/;
    	if($('#phone').val()==''||$("#phone").val()==null){
    		$("#phone-tips").html("请输入接收验证码的手机号").css("color","red");
    	}else if(!regExp.test($("#phone").val())){
    		$("#phone-tips").html("电话号码格式错误").css("color","red");
    	}else{
    		//点击获取验证码 倒计时60秒 并把value改为“60 秒后重新获取”
    			$(this).parent().find("input[type=text]").attr("disabled",false).focus().css("background-color","rgb(255, 255, 255)");
    		   	var sec=60;
    			var t;
            (function timer(){
                if(sec==0){
                    sec=60;
                    $(".phone").val("获取手机验证码").attr("disabled",false).removeClass("graybg");
                    clearTimeout(t);
                }else{
                    sec--;
                    $(".phone").val(sec+" 秒后重新获取").attr("disabled",true).addClass("graybg");
                    $(this).parent().find("input[type=text]").css("background-color","rgb(235, 235, 228)");
                    t=setTimeout(timer,1000);
                }
            })();
    	}
    });
    
    
    $("#user").focus(function () {
        // 给出提示内容
        $("#suggest").text("4-20位字符，支持汉字、字母、数字及'-'、'_'组合").css("color", "#799BD2").css("font-weight", "bolder");
    }).blur(userValidator);
    $("#address").focus(function () {
        $("#address-tips").text("请务必输入详细地址.").css("color", "#799BD2").css("font-weight", "bolder");
    }).blur(addrValidator);
    $("#pwd").focus(function(){
    	$("#pwd-tips").text("密码可由6-20位的英文、数字和符号组成").css("color", "#799BD2").css("font-weight", "bolder");
    }).blur(pwdValidator);
    $("#realname").focus(function(){
    	$(".realName-tips").text("请务必填写您的真实姓名").css("color", "#799BD2").css("font-weight", "bolder");
    }).blur(realNameValidator);
    $("#cardId").blur(realIdValidator)
    $("#repwd").blur(repwdValidator);
    $("#phone").blur(phoneValidator);
    $("#tel").blur(telValidator);
    $("#QQ").blur(QQValidator);
    $("#mail").blur(mailValidator);
    $("#company").blur(companyValidator);
    $("#unionPayAccount").blur(bankValidator);
    
    /*支付方式点击时边框为红色 并显示相应的输入框*/
    $(".pay-ways li").click(function(){
    	if($(this).hasClass("selected")){
    		$(this).removeClass("selected");
    	}else{
    		$(this).addClass("selected");
    	}
    });
    $("#alipay").click(function(){
    	if($(this).hasClass("selected")){
    		$("#alipay-tr").show();
    	}else{
    		$("#alipayAccount").val("");
    		$("#alipay-tr").hide();
    	}
    })
    $("#wechat").click(function(){
    	if($(this).hasClass("selected")){
    		$("#wechat-tr").show();
    	}else{
    		$("#wechatAccount").val("");
    		$("#wechat-tr").hide();
    	}
    })
    $("#chinaUnion").click(function(){
    	if($(this).hasClass("selected")){
    		$(".chinaUnion-tr").show();
    	}else{
    		$("#unionPayAccount").val("");
    		$("#unionPayName").val("");
    		$(".chinaUnion-tr").hide();
    	}
    })
});




	//用户名验证
    function userValidator(){
    	var val=$("#user").val();
    	var regExp=/^[\u4e00-\u9fa5a-zA-Z0-9_\-]{2,20}$/;
    	var cn=val.match(/[\u4e00-\u9fa5]/g);
    	var cnLen;
    	if(cn==null||cn=="undefind"){
    		cnLen=0;
    	}else{
    		cnLen=cn.length;
    	}
    	if(val== null || val == ""){
            // 为空
            $("#suggest").html("用户名不能为空.").css("color","red").css("font-weight","bolder");
            return false;
        }else if(val.length+cnLen>=4&&val.length+cnLen<=20){
        	if(regExp.test(val)){
        		$("#suggest").text("用户名输入正确.").css("color","green").css("font-weight","bolder");
        		checkName()
        		return true;
        	}else{
        		$("#suggest").text("用户名输入格式错误.").css("color","red").css("font-weight","bolder");
        		return false;
        	}
        }else{
            // 输入错误
        	$("#suggest").text("用户名输入格式错误.").css("color","red").css("font-weight","bolder");
    		return false;
        }
    }
    
    //密码验证
    function pwdValidator(){
        var regExp = /^.{6,20}$/;
        if($("#pwd").val() == null || $("#pwd").val() == ""){
            // 为空
            $("#pwd-tips").text("密码不能为空.").css("color","red").css("font-weight","bolder");
            return false;
        }else if(!regExp.test($("#pwd").val())){
            // 不匹配
            $("#pwd-tips").text("密码输入格式错误.").css("color","red").css("font-weight","bolder");
            return false;
        }else{
            // 输入正确
            $("#pwd-tips").text("密码输入正确.").css("color","green").css("font-weight","bolder");
            return true;
        }
    }

    
    //确认密码验证
    function repwdValidator(){
        if($("#repwd").val() == null || $("#repwd").val() == ""){
            // 为空
            $("#repwd-tips").text("确认密码不能为空.").css("color","red").css("font-weight","bolder");
            return false;
        }else if($("#repwd").val() != $("#pwd").val()){
            // 两次密码输入不一致
            $("#repwd-tips").text("两次密码输入不一致.").css("color","red").css("font-weight","bolder");
            return false;
        }else{
            // 输入正确
            $("#repwd-tips").text("输入正确.").css("color","green").css("font-weight","bolder");
            return true;
        }
    }

    /*真实姓名验证*/
    function realNameValidator(){
    	var realNameExp= /^([\u4E00-\u9FA5]+|[a-zA-Z]+)$/;
    	if($("#realname").val()==""||$("#realname").val()==null){
    		$(".realName-tips").text("请输入中文，或英文真实姓名").css("color","red").css("font-weight","bolder");
    		return false;
    	}else if(!realNameExp.test($("#realname").val())){
    		$(".realName-tips").text("您输入的真实姓名格式错误").css("color","red").css("font-weight","bolder");
    		return false;
    	}else{
    		$(".realName-tips").text("");
    		return true;
    	}
    }
    
    /*身份证号码验证*/
    function realIdValidator(){
    	var realId= /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    	if($("#cardId").val()=="" || $("#cardId").val() == null){
    		$(".realId").text("请输入身份证号码").css("color","red").css("font-weight","bolder");
    		return false;
    	}else if(!realId.test($("#cardId").val())){
    		$(".realId").text("身份证格式错误").css("color","red").css("font-weight","bolder");
    		return false;
    	}else{
    		$(".realId").text("");
    		return true;
    	}
    }
    
    //收货地址验证
    function addrValidator(){
        if($("#address").val() == null || $("#address").val() == ""){
            $("#address-tips").text("地址不能为空.").css("color","red").css("font-weight","bolder");
            return false;
        }else{
            $("#address-tips").text("地址输入正确.").css("color","green").css("font-weight","bolder");
            return true;
        }
    }
    
    //电话号码验证
    function telValidator(){
        var regExp=/\d{3}-\d{8}|\d{4}-\d{7} /;
        if($("#tel").val() == null || $("#tel").val() == ""){
            //$("#tel-tips").text("电话号码不能为空.").css("color","red").css("font-weight","bolder");
        	return true;
        }else if(!regExp.test($("#tel").val())) {
            // 不匹配
            $("#tel-tips").text("电话号码格式为:xxx-xxxxxxxx 或 xxxx-xxxxxxx").css("color", "red").css("font-weight", "bolder");
            return false;
        }
        else{
            $("#tel-tips").text("输入正确.").css("color","green").css("font-weight","bolder");
            return true;
        }
    }
    
    //手机号码验证
    function phoneValidator(){
        var regExp=/^1[34589]\d{9}$/;
        if($("#phone").val() == null || $("#phone").val() == ""){
            $("#phone-tips").text("手机号码不能为空.").css("color","red").css("font-weight","bolder");
            return false;
        }else if(!regExp.test($("#phone").val())) {
            // 不匹配
            $("#phone-tips").text("电话号码格式错误.").css("color", "red").css("font-weight", "bolder");
            return false;
        }else{
            $("#phone-tips").text("输入正确.").css("color","green").css("font-weight","bolder");
            return true;
        }
    }
    
    //邮箱验证
    function mailValidator(){
        var regExp=/^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
        if($("#mail").val() == null || $("#mail").val() == ""){
        	return true;
        }else if(!regExp.test($("#mail").val())) {
            // 不匹配
            $("#mail-tips").text("电子邮箱格式输入有误.").css("color", "red").css("font-weight", "bolder");
            return false;
        }else{
            $("#mail-tips").text("输入正确.").css("color","green").css("font-weight","bolder");
            return true;
        }
    }
    //银行卡验证
    function bankValidator(){
    	if($(".chinaUnionNum-tr").is(":visible")){
    		var regExp=/^(\d{16}|\d{19})$/;
            if($("#unionPayAccount").val() == null || $("#unionPayAccount").val() == ""){
            	$("#bank-tip").text("请输入银行账号.").css("color", "red").css("font-weight", "bolder");
            	return false;
            }else if(!regExp.test($("#unionPayAccount").val())) {
                // 不匹配
                $("#bank-tip").text("银行卡格式输入有误.").css("color", "red").css("font-weight", "bolder");
                return false;
            }else{
            	$("#bank-tip").text("");
            	$.ajax({
     	        	url:"LiseUser_bankAPI.action",
     	        	type:'post',
     	        	datatype:'text',
     	        	data:{'banknumber':$("#unionPayAccount").val()},
     	        	success:function(result){
     	        		var json=eval("("+result+")");
     	        		var img="image/bank/"+json.result.bankname+".png";
     	        		$("#bank-tips").attr("src",img);
     	        	}
            	});
                return true;
            }
    	}else{
    		return true;
    	}
        
    }
    //公司名称验证
    function companyValidator(){
        if($("#company").val() == null || $("#company").val() == ""){
            $("#company-tips").text("公司名称不能为空.").css("color","red").css("font-weight","bolder");
            return false;
        }else{
            $("#company-tips").text("输入正确.").css("color","green").css("font-weight","bolder");
            return true;
        }
    }
    
    
    //判断地址是否选中
    function checkArea(){
        var selectArea=[];
        $(".send-address select:visible").each(function(){
            selectArea.push($(this).val());
        });
        if($.inArray("-1",selectArea)==-1){
        	$(".addr-tips").html("");
            return true;
        }else{
            $(".addr-tips").html("请选择区域").css("color","red").css("font-weight","bolder");
            return false;
        }
    }
    //判断 支付方式是否选中 至少选中一项
    function checkPay(){
    	var checkedNum=false;
    	$(".pay-ways li").each(function(){
    		if($(this).hasClass("selected")){
    			$("#pay-tips").text("");
    			checkedNum=true;
    		}
    	});
     	if(checkedNum){
    		return checkedNum;
    	}else{
    		$("#pay-tips").text("请选择支付方式（至少填写一个）").css("color","red").css("font-weight","bolder");
    	}
    }
    function checkPayInput(el){
    	var inputBl=false;
    	$(".hide-pay").each(function(){
    		if($(this).is(":visible")){
    			var thisName=$(this).find(".td-first").text();
    			if($(this).find("input").val()==""||$(this).find("input").val()==null){
    				$(this).find(".td-last").text(thisName.substring(0,thisName.length-2)+"不能为空").css({
    					"color":"red",
    					"font-weight":"bolder"
    				});
    				inputBl = false;
    			}else{
    				$(this).find(".td-last").text("");
    				inputBl = true;
    			}
        	}
    	});
    	return inputBl;
    }
    var bl=false;
    //点击获取验证码 从服务器发送消息
    function verification(){
    		
 			var url = "LiseUser_checkVerificationNo.action";
 			$.ajax({
 	        	url:url,
 	        	type:'post',
 	        	datatype:'text',
 	        	data:{'phone':$("#phone").val(),'verificationNo':$("#verificationNo").val()},
 	        	success:function(result){
 	        		if(result != null || result != ""){
 	        			if(result=="false"){
 	        				$("#test-tips").html("验证码错误").css("color","red").css("font-weight","bolder");
 	        				bl = false;
 	        			}else{
 	        				$("#test-tips").html("验证码正确").css("color","green").css("font-weight","bolder");
 	        				bl = true;
 	        			}
 	        		}else{
 	        			$("#test-tips").html("请输入短信验证码").css("color","red").css("font-weight","bolder");
 	        			bl = false;
 	        		}
 	        	}
 	        });	
 			return bl;
 		}
    //检测用户名是否存在
    var bl=false;
    function checkName(){
    	if($("#user").val() != null || $("#user").val() != ""){
    		var url = "LiseUser_checkName.action";
 			$.ajax({
 	        	url:url,
 	        	type:'post',
 	        	datatype:'text',
 	        	data:{'userName':$("#user").val()},
 	        	success:function(result){
 	        		if(result=="true"){
        				$("#suggest").html("用户名已存在").css("color","red");
        				bl = false;
        			}else{
        				$("#suggest").html("用户名输入正确").css("color","green");
        				bl = true;
        			}
 	        	}
 	        });	
 		}else{
 			$("#suggest").html("请输入用户名").css("color","red");
 			bl = false;
 		}
 		return bl;
 	}
    

  //QQ号码验证
  function QQValidator(){
      var regExp=/^[1-9][0-9]{5,9}$/;
      if($("#QQ").val() == null || $("#QQ").val() == ""){
          $("#").text("");
          return true;
      }else if(!regExp.test($("#QQ").val())) {
          // 不匹配
          $("#QQ-tips").text("QQ号码格式错误.").css("color", "red").css("font-weight", "bolder");
          return false;
      }
      else{
          $("#QQ-tips").text("");
          return true;
      }
  }
    
    function formValidator(){
        // 上述所有验证通过
        var bl = false;
        /**/
    	if(userValidator()&&pwdValidator()&&repwdValidator()&&realNameValidator()&&realIdValidator()&&QQValidator()&&mailValidator()&&checkPay()&&checkPayInput()&&telValidator()&&bankValidator()&&checkLicense()&&companyValidator()&&checkArea()&&addrValidator()&&phoneValidator()&&verification()&&agreeCheck()){
            // 允许表单提交
    		//&&verification()发送短信注释
            bl = true;
        }else{
            bl = false;
        }
    	return bl;
    }
    

    //判断同意条款是否被选中
    function agreeCheck(){
        if($("#sure").is(':checked')){
        	$("#sure").parent().parent().find(".td-last").html("");
            return true;
        }else{
            $("#sure").parent().parent().find(".td-last").html("请勾选服务条款").css("color", "red").css("font-weight", "bolder");
            return false;
        }
    }



    //判断type=file是否被为空
    function checkLicense(){
        if($(".license").val()==""||$(".license").val()==null){
            $("#License-fiel").html("请添加营业执照").css("color","red").css("font-weight","bolder");
            return false
        }
        return true;
    }
    function checkpic(){
        if($(".picfile").val()==""||$(".picfile").val()==null){
        }
        return true;
    }

    function changepic(e){

        var src=e.target || window.event.srcElement; //获取事件源，兼容chrome/IE
        //测试chrome浏览器、IE6，获取的文件名带有文件的path路径
        //下面把路径截取为文件名
        var filename=src.value;
        if( filename=="" || filename==null ){
            $("#pic-file").html("请上传图片").css("color", "red").css("font-weight", "bolder");
        }
        var n= filename.substring( filename.lastIndexOf('\\')+1 ) ;
        $("#pic-file").html("已选择:"+n).css("color","green").css("font-weight","bolder");
        //获取文件名的后缀名（文件格式）
        //alert( filename.substring( filename.lastIndexOf('.')+1 ) );
    }
    function changeLicense(e){

        var src=e.target || window.event.srcElement; //获取事件源，兼容chrome/IE
        //测试chrome浏览器、IE6，获取的文件名带有文件的path路径
        //下面把路径截取为文件名
        var filename=src.value;
        if( filename=="" || filename==null ){
            $("#License-fiel").html("请上传图片").css("color", "red").css("font-weight", "bolder");
            return false;
        }
        var n= filename.substring( filename.lastIndexOf('\\')+1 ) ;
        $("#License-fiel").html("已选择:"+n).css("color","green").css("font-weight","bolder");
        return true;
        //获取文件名的后缀名（文件格式）
        //alert( filename.substring( filename.lastIndexOf('.')+1 ) );
    }



