<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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

		<title>新闻列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/FRAMEWORK/css/assembly.css">

	</head>

	<body>

		<jsp:include page="/component/assembly/top.jsp"></jsp:include>
		<jsp:include page="/component/assembly/left.jsp"></jsp:include>
		<div class="right">


			<br />
			<div class="inner">
				<table width="98%" border="0" cellpadding="2" cellspacing="1"
					bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
					<tr bgcolor="#E7E7E7">
						<th height="14" colspan="8" background="<%=path%>/images/tbg.gif">
							新闻列表信息&nbsp;
						</th>
					</tr>
					<tr align="center" bgcolor="#FAFAF1" height="22">
						<th width="5%">
							序号
						</th>
						<th width="20%">
							标题
						</th>

						<th width="15%">
							发布状态
						</th>
						<th width="15%">
							创建时间
						</th>
						<th width="15%">
							最后修改时间
						</th>

						<th width="20%">
							操作
						</th>

					</tr>
					<c:forEach var="data" items="${datas}" varStatus="st">

						<tr align='center' bgcolor="#FFFFFF" javascript: this.bgC
							olor='red' ;
	;
	javascript: this
.bgColor='#FFFFFF'
							;" height="22">
							<td bgcolor="#FFFFFF" align="center" id="num">
								${st.index+1}
							</td>
							<td bgcolor="#FFFFFF" align="center">
								${data.NTitle }
							</td>
							<td bgcolor="#FFFFFF" align="center">
								${data.NStatus }
							</td>
							<td bgcolor="#FFFFFF" align="center">
								${data.NCreatTime }
							</td>
							<td bgcolor="#FFFFFF" align="center">
								${data.NFinalTime }
							</td>


							<td bgcolor="#FFFFFF" align="center">
								<a href="">修改</a>
								<a href="">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<center>
					<a href="<%=path%>/web/news!queryOfFenYe?pageNo=1">首页</a>
					<a href="<%=path%>/web/news!queryOfFenYe?pageNo=${curPage-1}">上一页</a>
					<a href="<%=path%>/web/news!queryOfFenYe?pageNo=${curPage+1}">下一页</a>
					跳转到第<input  type="text"  size="4" />页
					<a href="<%=path%>/web/news!queryOfFenYe?pageNo=${maxPage}">尾页</a>
					<center />
			</div>

		</div>
		<jsp:include page="/component/assembly/bottom.jsp"></jsp:include>

	</body>
</html>
