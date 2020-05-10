<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/23
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临音悦Music</span>
    <a href="client/collectionServlet?action=list">我的收藏</a>&nbsp;&nbsp;
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="client/musicServlet?action=page">返回</a>
</div>
