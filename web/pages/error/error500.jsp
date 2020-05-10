<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>访问出错了</title>
	<%--静态包含，base标签，CSS样式，jquery样式--%>
	<%@include file="/pages/common/head.jsp" %>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">访问出错了</span>

		<div>
			<a href="client/musicServlet?action=page">返回首页</a>
		</div>
	</div>
	
	<div id="main">
		<h1>哎呀，访问出错了！</h1>
		<h1 style="color: red">很抱歉，您访问的后台程序出现了错误，程序员小哥，正在努力为您抢修！！！</h1>
	</div>

	<%--静态包含，页脚信息--%>
	<%@include file="/pages/common/footer.jsp" %>
</body>
</html>