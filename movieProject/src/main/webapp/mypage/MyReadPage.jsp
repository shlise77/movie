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
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </div>
        <div class="col-sm-4 mb-3 pb-3">
            <p>닉네임 : ${userInfo.movieNickName}</p>
            <p>장르 :
            </p>
        </div>
        <div class="col-sm-4 mb-3 pb-3">
            <div>
                <button type="button" class="btn btn-light" onclick=""><i class="bi bi-heart"></i></button>
                <span>좋아요 수 :</span><span>1</span><br>
            </div>
            <div>

            </div>
        </div>
    </div>
    <div class="col-sm-12 mt-3 pt-3">

    </div>
</main>
</body>
</html>
