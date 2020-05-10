<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑音乐</title>
	<%--静态包含，base标签，CSS样式，jquery样式--%>
	<%@include file="/pages/common/head.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	h1 a {
		color:red;
	}

	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">编辑音乐</span>

			<%--静态包含 manager 管理模块的菜单--%>
			<%@include file="/pages/common/manager_menu.jsp"%>

		</div>

		<div id="main">
			<form action="manager/musicServlet" method="post">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="action" value="${ empty param.id?"add":"update" }"/>
				<input type="hidden" name="id" value="${ requestScope.music.id }"/>
				<table>
					<tr>
						<td>歌曲</td>
						<td>歌手</td>
						<td>风格</td>
						<td>位置</td>
						<td>封面</td>
						<td>下载</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="songname" type="text" value="${requestScope.music.songname}"/></td>
						<td><input name="singer" type="text" value="${requestScope.music.singer}"/></td>
						<td><input name="style" type="text" value="${requestScope.music.style}"/></td>
						<td><input name="location" type="text" value="${requestScope.music.location}"/></td>
						<td><input name="imgPath" type="text" value="${requestScope.music.imgPath}"/></td>
						<td><input name="downloadCount" type="text" value="${requestScope.music.downloadCount}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>
				</table>
			</form>


		</div>

		<%--静态包含，页脚信息--%>
		<%@include file="/pages/common/footer.jsp" %>
</body>
</html>