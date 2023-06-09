<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-19
  Time: 오후 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .header-control {
        display: inline;
        width: 35%;
        padding: 0.375rem 0.75rem;
        font-size: 1rem;
        color: #212529;
        background-color: #fff;
        background-clip: padding-box;
        border: 1px solid #ced4da;
        -webkit-appearance: none;
        -moz-appearance: none;
        appearance: none;
        border-radius: 0.375rem;
        transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
    }
</style>
<header class="container-fluid bg-secondary p-4">
    <div class="row">
        <div class="col-sm-2">
            <a href="#" class="fs-2 text-info text-center text-decoration-none">영화 공간</a>
        </div>
        <div class="col-sm">
            <div class="d-flex flex-row-reverse">
                <c:choose>
                <c:when test="${userInfo.rankId eq '2' || sessionScope.movieId != null}">
                    <div>
                        <form action="/Movie/Logout.do" method="post">
                            <p>
                                <button type="submit" class="btn btn-primary text-decoration-none">로그아웃</button>
                            </p>
                        </form>
                    </div>
                    <div class="pt-2 pe-5">
                        <span>${userInfo.movieNickName}님 반갑습니다.</span>
                    </div>
                </c:when>
                <c:when test="${userInfo.rankId eq '' == false}">
                <form action="/Movie/Login.do" method="post">
                    <div class="d-inline">
                        <label for="movie-id" class="label-control">ID :</label>
                        <input type="text" class="header-control" id="movie-id" name="movieId">
                    </div>
                    <div class="d-inline">
                        <label for="user-pw" class="label-control">PW :</label>
                        <input type="text" class="header-control" id="user-pw" name="userPw">
                    </div>
                    <div class="d-inline ms-3">
                        <button type="submit" class="btn btn-primary">로그인</button>
                    </div>
                </form>
            </div>
        </div>
        <a href="/Movie/SignUp.do" class="col-sm-2 btn btn-link text-decoration-none">회원가입</a>
        </c:when>
        </c:choose>
    </div>
</header>
