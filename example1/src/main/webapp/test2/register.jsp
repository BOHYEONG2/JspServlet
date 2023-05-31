<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
</head>
<body>
    <h1>회원 가입</h1>
    <form method="POST" action="register">
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id" required><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="가입">
    </form>
</body>
</html>