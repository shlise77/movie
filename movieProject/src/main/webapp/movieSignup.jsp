<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-19
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <title>회원가입 페이지</title>
</head>
<body>
<main class="container my-4 py-4">
    <div class="row">
        <div class="col-sm-4 my-5 mx-auto border border-3">
            <form action="/Movie/SignUp.do" method="post">
                <div>
                    <label for="user-id" class="form-label mt-3">사용자 :</label>
                    <input type="text" class="form-control" id="user-id" name="userId" placeholder="Id를 입력해주세요">
                </div>
                <div>
                    <label for="user-nick" class="form-label mt-3">닉네임 :</label>
                    <input type="text" class="form-control" id="user-nick" name="userNickName" placeholder="사용할 닉네임을 입력해주세요">
                </div>
                <div>
                    <label for="user-pw" class="form-label mt-3">비밀번호 :</label>
                    <input type="text" class="form-control" id="user-pw" name="userPw" placeholder="비밀번호를 입력해주세요">
                </div>
                <div>
                    <label for="user-check-pw" class="form-label mt-3">비밀번호 확인 :</label>
                    <input type="text" class="form-control" id="user-check-pw" name="userCheckPw" placeholder="비밀번호를 재 입력해주세요">
                </div>
                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary mt-3 d-block">회원가입</button>
                    <button type="reset" class="btn btn-outline-primary d-block mt-3">취소</button>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
