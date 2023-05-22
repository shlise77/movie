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
    <title>마이 페이지</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>

<main class="container">
    <div class="row mx-3 px-3">
        <div class="col-sm-4">
            <div class="card" style="width: 18rem;">
                <img src="../img/no-image.jpg" class="card-img-top">
                <div class="card-body">
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <p>닉네임</p>
        </div>
        <div class="col-sm-4">
            <p>좋아요 수</p>
            <p>1</p>
            <a href="#" ></a>
        </div>
    </div>
    <div class="col-sm-12"></div>
</main>
</body>
</html>
