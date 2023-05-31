<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%
    if (session.getAttribute("id") != null) {
        response.sendRedirect("main.jsp"); // 세션 존재 시 메인 페이지로 이동
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>	
<body>
    <h1>로그인 페이지입니다</h1>
    <form method="POST" action="/example1/LoginServlet"> <!-- 서블릿 호출 -->
        <label for="id">id :</label>
        <input type="text" id="id" name="id" required><br>
        <label for="password">password :</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>