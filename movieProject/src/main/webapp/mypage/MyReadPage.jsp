<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-24
  Time: 오후 2:48
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
<jsp:include page="/layout/header.jsp"></jsp:include>
<main class="container mt-5">
    <div class="row mx-3 px-3 border-bottom">
        <div class="col-sm-4 mb-3 pb-3">
            <div class="card" style="width: 18rem;">
                <img src="/resources/img/${userInfo.movieUserImg}" class="card-img-top">
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
        <label for="read-title" class="form-label">제목:</label>
        <input type="text" id="read-title" class="form-control mb-3" name="contentTitle" value="${readDto.content_title}"/>
    </div>
    <div>
    <textarea name="content" id="content" cols="171" rows="20">${readDto.content}</textarea>
    </div>
    <div class="btn-group d-grid gap-2 d-md-flex justify-content-md-end mt-3">
        <div><a href="Movie/MyEdit.do" class="btn btn-primary">수정</a></div>
        <div><a href="#" class="btn btn-danger">삭제</a></div>
    </div>

</main>
</body>
</html>
