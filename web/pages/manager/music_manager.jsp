<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>音乐管理</title>
	<%--静态包含，base标签，CSS样式，jquery样式--%>
	<%@include file="/pages/common/head.jsp" %>
	<script type="text/javascript">
		$(function () {
			//给删除的a标签绑定删除的单击事件，用于删除的确认提示操作
			$("a.deleteClass").click(function () {
			    //this是正在响应事件的dom对象
				return confirm("确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗？");
            });

        });


	</script>

</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">音乐管理系统</span>

			<%--静态包含 manager 管理模块的菜单--%>
			<%@include file="/pages/common/manager_menu.jsp"%>

	</div>

	<div id="main">
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
			<C:forEach items="${requestScope.page.items}" var="music">

				<tr>
					<td>${music.songname}</td>
					<td>${music.singer}</td>
					<td>${music.style}</td>
					<td>"${music.location}"</td>
					<td>"${music.imgPath}"</td>
					<td>${music.downloadCount}</td>
					<td><a href="manager/musicServlet?action=getMusic&id=${music.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteClass" href="manager/musicServlet?action=delete&id=${music.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>

			</C:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/music_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加音乐</a></td>
			</tr>
		</table>

		<%--静态包含，页码信息--%>
		<%@include file="/pages/common/page_nav.jsp"%>

	</div>

	<%--静态包含，页脚信息--%>
	<%@include file="/pages/common/footer.jsp" %>
</body>
</html>