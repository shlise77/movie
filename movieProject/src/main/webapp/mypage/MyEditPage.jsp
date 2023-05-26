<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-22
  Time: 오전 11:47
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
    <title>Title</title>
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
                <img src="/resources/images/${userInfo.movieUserImg}" class="card-img-top">
                <div class="card-body">
                    <label for="img-chang">이미지 수정 : </label>
                    <input type="file" id="img-chang" class="form-control">
                </div>
            </div>
        </div>
        <div class="col-sm-4 mb-3 pb-3">
            <p>닉네임 : ${readDto.movie_nick_name}</p>
            <p>장르 : ${readDto.genre}
            </p>
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
        <form action="/Movie/MyEdit.do" method="post" enctype="multipart/form-data">
            <input type="hidden" name="movieId"  value="${userInfo.movieId}"/>
            <input type="hidden" name="movieNickName"  value="${userInfo.movieNickName}"/>
            <input type="hidden" name="movieIndex" value="${userInfo.movieIndex}"/>
            <input type="hidden" name="content_num" value="${readDto.content_num}"/>
            <div class="mb-2">
                <label for="movie-title" class="form-label">제목:</label>
                <input type="text" class="form-control" id="movie-title" name="contentTitle" value="${readDto.content_title}">
            </div>
            <div class="mb-2">
                <select class="form-select" aria-label="Default select example" name="genre" id="genre">
                    <option selected>${readDto.genre}</option>
                    <option value="SF">SF</option>
                    <option value="전쟁">전쟁</option>
                    <option value="멜로">멜로</option>
                </select>
            </div>
            <div class="form-floating">
                <textarea class="form-control" name="content" style="height: 300px">${readDto.content}</textarea>
            </div>
            <div class="my-3">
                <label for="file" class="form-label">첨부파일 : </label>
                <input type="file" class="form-control" id="file" name="file">
            </div>
            <duv>
                <button type="submit" class="btn btn-primary">글등록</button>
            </duv>
        </form>
    </div>

</main>
</body>
</html>
