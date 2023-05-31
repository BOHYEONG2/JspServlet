<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
</head>
<body>
    <h1> <p>환영합니다 <%= session.getAttribute("id") %>님</p></h1>
    <p>로그인 성공!</p>
    <a href="logout.jsp">로그아웃</a>
</body>
</html>