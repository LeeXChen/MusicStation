<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的收藏</title>

    <%--静态包含，base标签，CSS样式，jquery样式--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //给删除的a标签绑定删除的单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                //this是正在响应事件的dom对象
                return confirm("确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");
            });

        });

        var Wind;

        function play() {
            var songname = $(this).attr('collectionName');
            if (Wind)//如果Wind对象存在
            {
                Wind.close();//调用关闭方法
                Wind = null;//并把值赋成null
            }
            Wind = window.open("${pageScope.basePath}client/collectionServlet?action=collectionMusicPlay&songname=" + songname );


        }

        function download() {
            var songname = $(this).attr('collectionName');
            location.href = "${pageScope.basePath}client/collectionServlet?action=download&songname=" + songname;
        }


        $("#play").live("click", play);

        $("#download").live("click", download);



    </script>

    <style type="text/css">
        body {
            background: -webkit-linear-gradient(top, skyblue 0%, #fff 100%) no-repeat;
            background: linear-gradient(top, skyblue 0%, #fff 100%) no-repeat;
        }

        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">我的收藏</span>
    <div>
        <%--静态包含，登陆成功以后的菜单--%>
        <%@include file="/pages/common/login_sucess_menu.jsp" %>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>歌曲</td>
            <td>歌手</td>
            <td>下载</td>
            <td colspan="3">操作</td>
        </tr>
        <C:forEach items="${requestScope.collections}" var="collection">

            <tr>
                <td>${collection.songname}</td>
                <td>${collection.singer}</td>
                <td>${collection.downloadCount}</td>
                <td><a style="cursor: pointer" collectionName="${collection.songname}" id="play">播放</a></td>
                <td><a style="cursor: pointer" collectionName="${collection.songname}" id="download">下载</a></td>
                <td><a style="cursor: pointer" class="deleteClass" href="client/collectionServlet?action=delete&id=${collection.id}">删除</a></td>
            </tr>

        </C:forEach>
    </table>


</div>

<%--静态包含，页脚信息--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>