<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
</head>
<body>
    <h1>ȸ�� ����</h1>
    <form method="POST" action="register">
        <label for="id">���̵�:</label>
        <input type="text" id="id" name="id" required><br>
        <label for="password">��й�ȣ:</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="����">
    </form>
</body>
</html>