<%@ page import="java.time.temporal.Temporal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>音悦Music随身听</title>

    <%
        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";

        pageContext.setAttribute("basePath", basePath);

    %>
    <base href="<%= basePath%>">
    <link rel="stylesheet" href="static/CSS/base.css?version=19.3.9.1">
    <link rel="stylesheet" href="static/CSS/play_background.css">
    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/mouse.js"></script>
    <style type="text/css">
        body {
            overflow-x: hidden;
            overflow-y: hidden;
        }

        .draw {
            position: fixed;
            width: 1px;
            line-height: 1px;
            pointer-events: none;
        }

        @keyframes floatOne {
            0% {
                opacity: 1;
            }
            50% {
                opacity: 1;
            }
            100% {
                opacity: 0;
                transform: translate3D(0, -20px, 0) scale(5) rotate(45deg);
            }
        }
    </style>

</head>
<body>

<%--动态背景--%>
<div class="bubble">

    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
    <div class="circle-container">
        <div class="circle"></div>
    </div>
</div>
</div>
<%--动态背景--%>
<div id="audio" class="audio audio-off">
    <audio id="audio-my" songname="${requestScope.music.songname}"
           src="${requestScope.music.location}/${requestScope.music.songname}" preload="metadata"></audio>

    <div class="audio-head">
        <div class="audio-head-tittle">
            <div class="audio-head-tittle-text audio-head-tittle-text-off"></div>
        </div>
        <div class="audio-head-tittle-by"></div>
    </div>
    <div class="add"></div>
    <div class="min-time"></div>
    <div class="audio-img">
        <canvas id="audio-img-canvas" width="200px" height="200px"></canvas>
        <div class="audio-img-cover audio-img-cover-off"></div>
        <canvas id="audio-img-canvas-play" class="audio-img-canvas-play-off" width="45px" height="200px"></canvas>
    </div>
    <div class="audio-text">歌词待更新</div>
    <div class="audio-by">
        <div class="audio-by-all">
            <span class="audio-by-now"></span>
        </div>
        <div class="audio-by-text">
            <span class="audio-by-text-now">00:00</span>
            <span class="audio-by-text-all">00:00</span>
        </div>
    </div>
    <div class="audio-btn">
        <div class="audio-btn-list audio-btn-list-off"></div>
        <div class="audio-btn-before"></div>
        <div class="audio-btn-play audio-btn-play-off audio-btn-play-off-a"></div>
        <div class="audio-btn-sound"></div>
        <div class="audio-btn-next"></div>
    </div>
    <div class="audio-sound">
        <div class="audio-sound-all">
            <span class="audio-sound-now"></span>
            <span class="audio-sound-art"></span>
        </div>
    </div>
</div>

<a class="audio-head-tittle-text-out"></a>
<a class="audio-head-tittle-text-out-a"></a>

<script src="static/js/base.js" type="text/javascript"></script>
<div style="text-align:center;margin:150px 0; font:normal 14px/24px 'MicroSoft YaHei';">
    <p style="color: #ffe57d">音悦Music.Copyright &copy;2020</p>
</div>
</body>
</html>
