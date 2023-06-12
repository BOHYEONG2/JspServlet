<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <style>
        /* 스타일링을 위한 CSS 코드 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .user-info {
            margin-bottom: 20px;
        }

        .user-info table {
            width: 100%;
            border-collapse: collapse;
        }

        .user-info th,
        .user-info td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        .user-info th {
            background-color: #eee;
            text-align: left;
        }

        .button-group {
            text-align: center;
        }

        .button-group button {
            margin: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }

        .button-group button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<header>
    <jsp:include page="/jsp/include/topMenu.jsp" />
</header>
<div class="container">
    <h2>마이페이지</h2>

    <div class="user-info">
        <table>
            <tr>
                <th>아이디</th>
                <td>${userInfo.id}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${userInfo.name}</td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td>${userInfo.phone}</td>
            </tr>
            <tr>
                <th>생년월일</th>
                <td>${userInfo.birthday}</td>
            </tr>
        </table>
    </div>

    <div class="button-group">
        <button onclick="location.href='/WebMVC/updateInfo.do'">정보 수정</button>
        <c:if test="${userInfo.id eq 'manager'}">
            <button onclick="location.href='/WebMVC/insertBook.do'">책 등록</button>
        </c:if>
        <c:if test="${userInfo.id ne 'manager'}">
            <button onclick="location.href='/WebMVC/myBooks.do'">대여 도서 목록</button>
            <button onclick="if(confirm('회원 탈퇴하시겠습니까?')){ location.href='/WebMVC/deleteUser.do' }">회원 탈퇴</button>
        </c:if>
    </div>
</div>
</body>
</html>