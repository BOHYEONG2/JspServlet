<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Book Page</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <style>
    .logo-cell {
      padding-right: 10px;
      border-right: none;
    }
    .logoimg {
      width: 100%;
      max-width: 300px;
    }
    td:nth-child(odd) {
      background-color: #f2f2f2;
    }
    td:nth-child(even) {
      background-color: #ffffff;
    }
    .navbar {
      background-color: #f8f9fa;
    }
    .navbar .nav-item {
      margin-right: 10px;
    }
    .navbar .nav-link {
      color: #333;
    }
    .btn-custom {
      background-color: navy;
      color: #ffffff;
      border: none;
      padding: 10px 20px;
      font-size: 16px;
      font-weight: 500;
      text-decoration: none;
      transition: background-color 0.3s ease;
    }
    .btn-custom:hover {
      background-color: #001f3f;
    }
    .navbar-text {
      font-size: 16px;
      font-weight: 500;
      margin-right: 10px;
    }
    .welcome-message {
      font-size: 16px;
      font-weight: 500;
      margin-right: 10px;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
  <a class="navbar-brand" href="/WebMVC/main.do">
    <img src="/WebMVC/image/bookimage.jpg" alt="" class="logoimg" />
  </a>
  <div class="collapse navbar-collapse">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a href="/WebMVC/main.do" class="btn btn-custom">홈으로</a>
      </li>
      <li class="nav-item">
        <a href="/WebMVC/searchBook.do" class="btn btn-custom">도서검색</a>
      </li>
      <li class="nav-item">
        <a href="/WebMVC/getBookList.do" class="btn btn-custom">도서목록</a>
      </li>
      <c:choose>
        <c:when test="${empty loginUser}">
          <li class="nav-item">
            <a href="/WebMVC/insertUser.do" class="btn btn-custom">회원가입</a>
          </li>
          <li class="nav-item">
            <a href="/WebMVC/login.do" class="btn btn-custom">로그인</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="nav-item">
            <a href="/WebMVC/mypage.do" class="btn btn-custom">마이페이지</a>
          </li>
          <li class="nav-item">
            <a href="/WebMVC/logout.do" class="btn btn-custom">로그아웃</a>
          </li>
        </c:otherwise>
      </c:choose>
    </ul>
    <c:if test="${not empty loginUser}">
      <span class="navbar-text welcome-message">[${loginUser.name}님 안녕하세요!]</span>
    </c:if>
  </div>
</nav>
</body>
</html>