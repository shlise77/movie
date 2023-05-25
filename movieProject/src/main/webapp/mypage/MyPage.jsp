<%--
  Created by IntelliJ IDEA.
  User: lyuli
  Date: 2023-05-20
  Time: 오후 6:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <title>마이 페이지</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
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
<main class="container mt-5">
    <div class="row mx-3 px-3 border-bottom">
        <div class="col-sm-4 mb-3 pb-3">
            <div class="card" style="width: 18rem;">
                <img src="/resources/img/${userInfo.movieUserImg}" class="card-img-top">
                <div class="card-body">
                </div>
            </div>
        </div>
        <div class="col-sm-4 mb-3 pb-3">
            <p>닉네임 : ${userInfo.movieNickName}</p>
        </div>
        <div class="col-sm-4 mb-3 pb-3">
            <div class="ps-3">
                <button type="button" class="btn btn-danger" onclick=""><i class="bi bi-heart"></i></button><br>
            </div>
            <div class="pt-3">
                <span>좋아요 수 :</span><span>1</span><br>
            </div>
            <div class="mt-5 pt-5">
                <a href="/Movie/Write.do?movieId=${userInfo.movieId}" class="btn btn-outline-primary">글등록</a>
            </div>
        </div>
    </div>
    <div class="col-sm-12 mt-3 pt-3">
        <div>
            <table class="table table-hover table-striped text-center">
                <thead>
                <th>번호</th>
                <th>제목</th>
                <th>시간</th>
                </thead>
                <tbody>

                    <c:forEach var="contentList" items="${contentList}">
                    <tr>
                        <td>${contentList.content_num}</td>
                        <td><a href="/Movie/Read.do?userIndex=${contentList.user_index}&contentNum=${contentList.content_num}&movieId=${userInfo.movieId}">${contentList.content_title}</a></td>
                        <td>${contentList.content_date}</td>
                </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
</body>
</html>
