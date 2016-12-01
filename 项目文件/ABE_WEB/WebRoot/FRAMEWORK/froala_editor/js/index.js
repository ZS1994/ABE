$(document).ready(function() {
	// $("#tables").attr("style","width:80%");
		/*
		 * $.ajax({ url : '../service/NewsService/getTops', dataType : "json",
		 * success : function(data) { $.each(data, function(i, item) {
		 * $("#selectAge").append( "<option value='" + item.topname + "'>" +
		 * item.topname + "</option>"); $("#checkeds").append( "<input
		 * type='checkbox' name='category' value='" + item.topname + "' /><text>" +
		 * item.topname + "</text>&nbsp;&nbsp;&nbsp;");
		 *  }) } });
		 */
		$('#edit').editable( {
			inlineMode : false,
			alwaysBlank : true
		});
		// 修改编辑器高度
		$(".froala-element").attr("style", "height:85%");

		// 验证
		$("input[type='text' ]").click(function() {
			if ($(this).val() == "请输入...") {
				$(this).val("");
			}

		})
		// 验证
		$("input[type='text' ]").blur(function() {
			if (!$(this).val()) {
				$(this).val("请输入...");
				$(this).attr("style", "color:	#C0C0C0");
			} else {
				$(this).attr("style", "");
			}

		})

		// 提交事件
		/*
		 * $("#tijiao").click( function() { var title = $("#title").val(); var
		 * type = $("#selectAge").val() + ";"; var origin = $("#origin").val();
		 * var istop = $("input[name='istop']:checked").val(); if (!title ||
		 * !origin || title == "请输入..." || origin == "请输入...") {
		 * alert("请填写标题和文章来源。"); return; } $("input[name='category']:checked")
		 * var types = $("input[name='category']:checked"); $.each(types,
		 * function(i, item) { type += item.value + ";";
		 *  }) var content = $(".froala-element").html(); var status = "1"; var
		 * newvo = { NTitle : title, NType : type, NContent : content, NOrigin :
		 * origin, NIstop : istop, UId:parent.admin_id, NStatus : status }; var
		 * data = JSON.stringify(newvo); $.ajax({ type : 'POST', url :
		 * '../ABE_WEB/web/news!insertNews', data : data, contentType :
		 * 'application/json; charset=utf-8', dataType : "json", success :
		 * function() { alert(title + "保存成功"); $("#title").val("");
		 * $("#selectAge").val(""); $("#origin").val("");
		 * $(".froala-element").html(""); } });
		 * 
		 * });
		 */
		$("#tijiao").click(function() {
			var content = $(".froala-element").html();
			$("#Content").val(content);
			if (!title || !origin || title == "请输入..." || origin == "请输入...") {
				alert("请填写标题和文章来源。");
				return;
			}
		})
		/*
		 * 
		 * //类型修改时多选显示也同时修改 $("#selectAge").blur(function(){
		 * $("input[name='category']").show(); $("text").show(); var type =
		 * $(this).val(); var types = $("input[name='category']"); $.each(types,
		 * function(i, item) { if (item.value == type) {
		 * $(item).removeAttr("checked"); $(item).hide(); $(item).next().hide(); }
		 *  }) })
		 */
	});
