<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>新闻编辑管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/FRAMEWORK/css/assembly.css">
		<link
			href="<%=path%>/FRAMEWORK/froala_editor/css/font-awesome.min.css"
			rel="stylesheet" type="text/css">
		<link
			href="<%=path%>/FRAMEWORK/froala_editor/css/froala_editor.min.css"
			rel="stylesheet" type="text/css">

	</head>

	<body>

		<jsp:include page="/component/assembly/top.jsp"></jsp:include>
		<jsp:include page="/component/assembly/left.jsp"></jsp:include>
		<div class="right">
			<
			<form action="<%=path%>/web/news!add" method="post">
				<table class="table table-bordered table-hover definewidth m10"
					id="tables" style="width: 90%">
					<tr>
						<td>
							<button type="button" class="btn btn-info">
								标题
							</button>
							&nbsp;
							<input type="text" id="title" name="news.NTitle" value="请输入..."
								style="color: #C0C0C0" />
							&nbsp;&nbsp;
						</td>

						<td>
							<button type="button" class="btn btn-info">
								类型
							</button>
							&nbsp;
							<select name="news.NType" id="selectAge">
								<option value="生活">
									生活
								</option>
								<option value="健康">
									健康
								</option>
								<option value="健康">
									新闻
								</option>
								<option value="头条咨询">
									头条资讯
								</option>
								<!--<option value="鏃舵斂">鏃舵斂</option>
					<option value="鐢熸椿">鐢熸椿</option>
					<option value="鐑偣">鐑偣</option>
					<option value="骞冲畨绀惧尯">骞冲畨绀惧尯</option>
					<option value="娉曞埗绀惧尯">娉曞埗绀惧尯</option>
					<option value="鏂囨槑绀惧尯">鏂囨槑绀惧尯</option>
					<option value="鍏氬缓绀惧尯">鍏氬缓绀惧尯</option>
					<option value="绉戞櫘绀惧尯">绉戞櫘绀惧尯</option>
					<option value="鎴夸骇瀹跺洯">鎴夸骇瀹跺洯</option>
					<option value="鏅烘収鏃呮父">鏅烘収鏃呮父</option>
					<option value="娓呴杞﹀奖">娓呴杞﹀奖</option>
					<option value="浜插瓙鏁欒偛">浜插瓙鏁欒偛</option>
					<option value="鍋ュ悍楗">鍋ュ悍楗</option> -->
							</select>
							&nbsp;&nbsp;
						</td>

					</tr>

					<tr>
						<td>
							<button type="button" class="btn btn-info">
								是否置顶
							</button>
							&nbsp;&nbsp;
							<input name="news.NIstop" type="radio" value="0" list
								checked="true" />
							否 &nbsp;
							<input name="news.NIstop" type="radio" value="1" />
							是&nbsp;
						</td>
						<td>
							<button type="button" class="btn btn-info">
								来源
							</button>
							&nbsp;
							<input type="text" name="news.NOrigin" id="origin" value="请输入..."
								style="color: #C0C0C0">
							&nbsp;&nbsp;
						</td>
						<td type="hidden">
							<input type="hidden" name=news.NContent id="Content" />
						</td>
					</tr>
					<tr>
						<!-- 				<td colspan="2" id="checkeds">
					<button type="button" class="btn btn-info">进行新闻编辑</button>&nbsp;&nbsp;&nbsp;
				
				</td> -->
					</tr>


					<tr>
						<td colspan="2" id="checkeds">
							<section id="editor">
							<div id='edit' style="margin-top: 0px; height: 500px;"></div>
							</section>

						</td>
					</tr>

					<tr>
						<td colspan="2" id="checkeds" style="TEXT-ALIGN: center;">
							<input type="submit" class="btn btn-primary" id="tijiao"
								value="提交">


						</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/libs/jquery-1.11.1.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/froala_editor.min.js"></script>
		<!--[if lt IE 9]>
    <script src="../js/froala_editor_ie8.min.js"></script>
  <![endif]-->
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/tables.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/lists.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/colors.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/media_manager.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/font_family.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/font_size.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/block_styles.min.js"></script>
		<script
			src="<%=path%>/FRAMEWORK/froala_editor/js/plugins/video.min.js"></script>
		<script src="<%=path%>/FRAMEWORK/froala_editor/js/index.js"></script>

		<script src="<%=path%>/FRAMEWORK/froala_editor/js/langs/zh_cn.js"></script>
	</body>
</html>
