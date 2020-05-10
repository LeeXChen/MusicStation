<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>音悦Music首页</title>
    <link rel="stylesheet" type="text/css" href="static/CSS/index.css">
    <link rel="stylesheet" type="text/css" href="static/CSS/butn.css">
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".logo").click(function () {
                window.location.href="index.jsp";
            });
            $(":button:first").click(function () {
                window.location.href="pages/user/register.jsp";
            });
            $(":button:last").click(function () {
                window.location.href="pages/user/login.jsp";
            });
        })
    </script>
</head>
<body>
    <div class="clazz">
        <div class="logo">
            <img id="logo" src="static/img/logo.jpg">
        </div>
        <div class="btn">
            <div id="regist">
                <button>注册</button>
            </div>
            <div id="login">
                <button>登录</button>
            </div>
        </div>
    </div>

    <div class="container">
        <a href="client/musicServlet?action=page" class="btn_2">进入首页</a>
    </div>

    <div>
    </div>
    <div id="bottom">
			<span>
				音悦Music.Copyright &copy;2020
			</span>
    </div>
</body>
</html>