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
                        <a href="/Movie/MyPage.do?movieId=${userInfo.movieId}" class="text-decoration-none fs-3 fw-bold text-light">MyHome</a>
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
    <c:forEach var="mainList" items="${mainList}">
        <div class="container mt-lg-5">
            <div class="row">
                <div class="col-sm-5">
                    <div class="border border-2">
                        <img src="/resources/images/${mainList.content_img}" class="rounded ms-5" style="width: 17.3rem; height: 9.2rem;">
                    </div>
                </div>
                <div class="col-sm">
                    <div class="border border-2 bg-light h-100">
                        <div>
                            <p class="fs-3 fw-bold">제목 : ${mainList.content_title}</p>
                            <p class="fs-5">장르 : ${mainList.genre}</p>
                            <p class="fs-5">좋아요 수 : ${mainList.like_num}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</main>

</body>
</html>
