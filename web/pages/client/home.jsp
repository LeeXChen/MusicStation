<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>音悦Music首页</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

		$(function () {
            var Wind;
		    function play() {
                var musicId = $(this).attr('musicId');
                var pageNo = $(this).attr("pageNo");

                if(Wind)//如果Wind对象存在
                {
                    Wind.close();//调用关闭方法
                    Wind=null;//并把值赋成null
                }
               Wind = window.open( "${pageScope.basePath}client/musicServlet?action=musicPlay&id=" + musicId + "&pageNo=" + pageNo);


            }

            function download() {
                var musicId = $(this).attr('musicId');
                var temp = ${empty sessionScope.user ? 0:1}
                if(temp==0){
                    alert("请先登录！");
                }else {

                    location.href = "${pageScope.basePath}client/musicServlet?action=download&id=" + musicId;
                }
            }

            function collect() {

                var musicId = $(this).attr('musicId');
                var temp = ${empty sessionScope.user ? 0:1};
                var count = 1;
                if(temp==0){
                    alert("请先登录！");
                }else {
                    window.open("${pageScope.basePath}client/musicServlet?action=collect&id=" + musicId +"&count="+count,
                        "","height=700,width=1500,top=150,left=200, depended=yes,toolbar=no,z-look=yes,menubar=no,scrollbars=no, resizable=no,location=no, status=no")
                }

            }



		    $("#play").live("click",play);

            $("#download").live("click",download);

            $("#collect").live("click",collect);



         });

     </script>
	<style type="text/css">
		body{
			background:-webkit-linear-gradient(top,skyblue 0%,#fff 100%) no-repeat;
			background:linear-gradient(top,skyblue 0%,#fff 100%) no-repeat;
		}
	</style>


 </head>
 <body>

     <div id="header">
             <img class="logo_img" alt="" src="static/img/logo.jpg" >
             <span class="wel_word">音悦Music</span>
             <div>
                 <%--如果用户还没有登录，显示登录和注册按钮--%>
                 <c:if test="${empty sessionScope.user }">
                     <a href="pages/user/login.jsp">登录</a> |
                     <a href="pages/user/register.jsp">注册</a>&nbsp;&nbsp;&nbsp;
                 </c:if>
                 <%--如果用户已经登录，则显示登录成功之后的用户信息--%>
                 <c:if test="${not empty sessionScope.user }">
                     <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临音悦Music</span>
                     <a href="client/collectionServlet?action=list">我的收藏</a>&nbsp;&nbsp;
                     <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
                 </c:if>
                     <a href="pages/manager/manager.jsp">后台管理</a>

             </div>
     </div>

     <div id="main_home">
         <div id="book">
             <div class="book_cond">
                 <form action="client/musicServlet?" method="get">
					 <input type="hidden" name="action" value="pageBySearch">
                     查找：<input style="width: 150px" id="min" type="text" name="condition" value="${param.condition}">
                         <input type="submit" value="查询" />
                 </form>
             </div>
             <div style="text-align: center">
                 <span>&nbsp;</span>
                 <div>
                     <span style="color: wheat">&nbsp;</span>
                 </div>
             </div>

             <c:forEach items="${requestScope.page.items}" var="music">


                 <div class="b_list">
                     <div class="img_div">
                         <img class="book_img" alt="" src="${music.imgPath}" />
                     </div>
                     <div class="book_info">
                         <div class="book_name">
                             <span class="sp1">歌曲:</span>
                             <span class="sp2">${music.songname}</span>
                         </div>
                         <div class="book_author">
                             <span class="sp1">歌手:</span>
                             <span class="sp2">${music.singer}</span>
                         </div>
                         <div class="book_price">
                             <span class="sp1">下载(次):</span>
                             <span class="sp2">${music.downloadCount}</span>
                         </div>
                         <div class="book_add">
                             <button pageNo="${requestScope.page.pageNo}" musicId="${music.id}" id="play">试听</button>
                             <button pageNo="${requestScope.page.pageNo}" musicId="${music.id}" id="collect">收藏</button>
                             <button pageNo="${requestScope.page.pageNo}" musicId="${music.id}" id="download">下载</button>
                         </div>
                     </div>
                 </div>

             </c:forEach>


         </div>

         <%--静态包含，页码信息--%>
		<%@include file="/pages/common/page_nav.jsp"%>

	</div>

	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>