<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 세션 무효화 (로그아웃)
    session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그아웃</title>
</head>
<body>
    <h1>로그아웃</h1>
    <p>성공적으로 로그아웃되었습니다.</p>
    <p><a href="login.jsp">로그인 페이지로 이동</a></p>
</body>
</html>