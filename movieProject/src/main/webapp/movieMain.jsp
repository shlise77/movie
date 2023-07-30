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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"/>
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

    <title>영화공간</title>

    <style>
        .swiper-slide {
            position: relative;
            text-align: center;
            font-size: 18px;
            background: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .swiper-slide img {
            display: block;
            width: 100%;
            height: 15em;
            object-fit: cover;
        }

        .overlay {
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            height: 100%;
            width: 100%;
            opacity: 0;
            transition: .5s ease;
            background-color: black;
        }

        .imgHoverContainer:hover .overlay {
            opacity: 0.5;
        }

        .text {
            color: white;
            font-size: 20px;
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            text-align: center;
        }
    </style>
    <script>
        $(document).ready(function () {
            $("#notUser").on("click", function () {
                alert('회원전용 게시판 입니다.');
            });
        });
    </script>
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
        <div class="container mt-lg-5">
            <div class="row">
                <div class="col-sm-12">
                    <div class="swiper">
                        <div class="swiper-wrapper">
                            <!-- th:each 을 써서 여러개 이미지 3개씩 출력 -->
                            <c:forEach var="mainList" items="${mainList}">
                            <div class="swiper-slide imgHoverContainer bg-light" >
                                    <img src="/resources/images/${mainList.content_img}" class="rounded ms-5">
                                    <div class="overlay">
                                        <div class="text">
                                            <p class="fs-3 fw-bold">제목 : ${mainList.content_title}</p>
                                            <p class="fs-5">장르 : ${mainList.genre}</p>
                                            <p class="fs-5">좋아요 수 : ${mainList.like_num}</p>
                                        </div>
                                    </div>
                            </div>
                            </c:forEach>
                        </div>
                        <div class="swiper-pagination"></div>

                        <div class="swiper-button-prev"></div>
                        <div class="swiper-button-next"></div>

                        <div class="swiper-scrollbar"></div>
                    </div>
                </div>
            </div>
        </div>

    <script>
        const swiper = new Swiper('.swiper', {
            direction: 'horizontal',
            slidesPerView: 3,
            spaceBetween: 30,
            freeMode: true,
            loop: true,

            // If we need pagination
            pagination: {
                el: '.swiper-pagination',
            },

            // Navigation arrows
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },

            // And if we need scrollbar
            scrollbar: {
                el: '.swiper-scrollbar',
            },
        });
    </script>
</main>
<footer>
    <div class="container-fluid">
        <div class="row mt-5 py-5 border border-1 border-dark">
            <div class="col-sm-12">
                <div class="mx-auto">
                    <p class="text-center fw-bold">영화 공간 입니다.</p>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
