<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>音悦Music注册页面</title>

	<%--静态包含，base标签，CSS样式，jquery样式--%>
	<%@include file="/pages/common/head.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}

	#main_success{
		height: 460px;
		width: 1200px;
		border: 1px black solid;
		background-color: skyblue;
	}

</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.jpg" >
				<%--静态包含，登陆成功以后的菜单--%>
				<%@include file="/pages/common/login_sucess_menu.jsp"%>
		</div>
		
		<div id="main_success" style="margin: auto">
		
			<h1>欢迎回来 <a href="client/musicServlet?action=page">转到主页</a></h1>
	
		</div>

		<%--静态包含，页脚信息--%>
		<%@include file="/pages/common/footer.jsp"%>

</body>
</html>