<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>猜你喜欢</title>
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
            var musicId = $(this).attr('musicId');
            var pageNo = $(this).attr("pageNo");

            if (Wind)//如果Wind对象存在
            {
                Wind.close();//调用关闭方法
                Wind = null;//并把值赋成null
            }
            Wind = window.open("${pageScope.basePath}client/musicServlet?action=musicPlay&id=" + musicId + "&pageNo=" + pageNo);


        }

        function download() {
            var musicId = $(this).attr('musicId');
            location.href = "${pageScope.basePath}client/musicServlet?action=download&id=" + musicId;
        }

        function collect() {

            var musicId = $(this).attr('musicId');
            var count = 2;
            location.href ="${pageScope.basePath}client/musicServlet?action=collect&id=" + musicId +"&count="+count+"&collectId="+${requestScope.collectId};

        }

        $("#play").live("click", play);

        $("#download").live("click", download);

        $("#collect").live("click", collect);

    </script>
    <style type="text/css">
        body {
            background: -webkit-linear-gradient(top, skyblue 0%, #fff 100%) no-repeat;
            background: linear-gradient(top, skyblue 0%, #fff 100%) no-repeat;
        }
    </style>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">猜你喜欢</span>


</div>

<div id="main">
    <table>
        <tr>
            <td>歌曲</td>
            <td>歌手</td>
            <td>下载</td>
            <td colspan="3">操作</td>
        </tr>
        <C:forEach items="${requestScope.musics}" var="music">

            <tr>
                <td>${music.songname}</td>
                <td>${music.singer}</td>
                <td>${music.downloadCount}</td>
                <td><a musicId="${music.id}" id="play" style="cursor:pointer" >试听</a></td>
                <td><a musicId="${music.id}" id="collect" style="cursor: pointer">收藏</a></td>
                <td><a musicId="${music.id}" id="download" style="cursor: pointer">下载</a></td>
            </tr>

        </C:forEach>
    </table>

</div>

<%--静态包含，页脚信息--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>