<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>音悦Music注册页面</title>

    <%--静态包含，base标签，CSS样式，jquery样式--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">

        $(function () {

            $("#username").blur(function () {

                //获取用户名
                var username = this.value;
                if (username != "" && username != null) {

                    $.getJSON("${basePath}userServlet", "action=ajaxExistsUsername&username=" + username, function (data) {

                        if (data.existsUsername) {
                            $("span.errorMsg").text("用户名已存在！");
                        } else {
                            $("span.errorMsg").text("用户名可用！");
                        }

                    });
                }else {
                    $("span.errorMsg").text("");
                }

            });

            //切换验证码
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });

            //点击logo返回首页
            $("#login_header").click(function () {
                window.location.href = "index.jsp";
            });

            //注册
            $("#sub_btn").click(function () {

                // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1.获取用户名输入框里的内容
                var username = $("#username").val();
                //2.创建正则表达式
                var usernamePatt = /^\w{5,12}$/;
                //3.使用test方法验证
                if (!usernamePatt.test(username)) {
                    //4.提示用户结果
                    $("span.errorMsg").text("用户名长度为5-12位！");
                    return false;
                }


                // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位验证
                //1.获取密码输入框里的内容
                var password = $("#password").val();
                //2.创建正则表达式
                var passwordPatt = /^\w{5,12}$/;
                //3.使用test方法验证
                if (!passwordPatt.test(password)) {
                    //4.提示用户结果
                    $("span.errorMsg").text("密码长度应为5-12位！");
                    return false;
                }

                // 确认密码：和密码相同
                //1.获取确认密码输入框里的内容
                var repwdText = $("#repwd").val();
                //和密码进行比较
                if (repwdText != password) {
                    //提示用户结果
                    $("span.errorMsg").text("两次输入密码不一致！");
                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1.获取邮箱输入框里的内容
                var emailText = $("#email").val();
                //2.创建正则表达式
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3.使用test方法验证
                if (!emailPatt.test(emailText)) {
                    //提示用户结果
                    $("span.errorMsg").text("邮箱格式不合法！");
                    return false;
                }


                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#code").val();
                //去除验证码前后空格
                codeText = $.trim(codeText);

                if (codeText == null || codeText == "") {
                    $("span.errorMsg").text("验证码不能为空！");
                    return false;
                }


                $("span.errorMsg").text("");
            });

        });

    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册Music用户</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"
                               value="${requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"
                               value="${requestScope.repwd}"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email"
                               value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 110px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg"
                             style="float: right; margin-right: 40px; width: 110px; height: 45px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--静态包含，页脚信息--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>