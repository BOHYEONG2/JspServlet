<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지 입니다!</h1>
	<p>환영합니다 <%= session.getAttribute("id") %>님</p> 	
	<p><a href="logout.jsp">Logout</a></p>
</body>
</html>