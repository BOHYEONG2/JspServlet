<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>logout</h1>
	<%
	// 세션 무효화 ( 로그아웃 )
	session.invalidate();
	%>
	<p>성공적으로 로그아웃 되었습니다</p>
	<p><a href="login.jsp">로그인페이지로 가기</a></p>
</body>
</html>