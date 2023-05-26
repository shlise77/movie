<%--  Created by IntelliJ IDEA
  User: admin
  Date: 2023-05-19
  Time: 오전 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#notUser").on("click", function () {
                alert('회원전용 게시판 입니다.');
            });
        });
    </script>
    <title>영화공간</title>
</head>
<body>
<jsp:include page="/layout/header.jsp"></jsp:include>
<nav class="navbar navbar-expand-lg bg-dark">
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item">
                <c:choose>
                    <c:when test="${userInfo.rankId eq '2'}">
                        <a href="/Movie/MyPage.do?movieId=${userInfo.movieId}"
                           class="text-decoration-none fs-3 fw-bold text-light">MyHome</a>
                    </c:when>
                    <c:when test="${userInfo.rankId eq '' == false}">
                        <a href="#" class="text-decoration-none fs-3 fw-bold text-light" id="notUser">MyHome</a>
                    </c:when>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>
<main>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-sm-12 mt-5">--%>
<%--                <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">--%>
<%--                    <div class="carousel-inner">--%>
<%--                        <div class="carousel-item">--%>
                            <c:forEach var="mainList" items="${mainList}" varStatus="status">
                                <c:if test="${status.index == 0}">
                                    <div class="active">
                                        <img src="/resources/images/${mainList.content_img}" class="d-block w-25">
                                    </div>
                                </c:if>
                                <c:if test="${status.index > 0}">
                                    <div class="item">
                                        <img src="/resources/images/${mainList.content_img}" class="d-block w-25">
                                    </div>
                                </c:if>
                                    <h5>제목 : ${mainList.content_title}</h5>
                                    <p>장르 :${mainList.genre}</p>
                                    <p>좋아요 숫자 :${mainList.like_num}</p>
                                </c:forEach>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"--%>
<%--                            data-bs-slide="prev">--%>
<%--                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
<%--                        <span class="visually-hidden">Previous</span>--%>
<%--                    </button>--%>
<%--                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"--%>
<%--                            data-bs-slide="next">--%>
<%--                        <span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
<%--                        <span class="visually-hidden">Next</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</main>

</body>
</html>
