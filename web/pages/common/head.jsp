<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/24
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";

    pageContext.setAttribute("basePath",basePath);

%>
<base href="<%= basePath%>">
<link type="text/css" rel="stylesheet" href="static/CSS/style.css">
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>


