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
	// ���� ��ȿȭ ( �α׾ƿ� )
	session.invalidate();
	%>
	<p>���������� �α׾ƿ� �Ǿ����ϴ�</p>
	<p><a href="login.jsp">�α����������� ����</a></p>
</body>
</html>