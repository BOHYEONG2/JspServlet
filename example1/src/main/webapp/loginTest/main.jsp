<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���� ������ �Դϴ�!</h1>
	<p>ȯ���մϴ� <%= session.getAttribute("id") %>��</p> 	
	<p><a href="logout.jsp">Logout</a></p>
</body>
</html>