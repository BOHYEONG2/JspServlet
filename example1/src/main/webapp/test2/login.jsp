<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%
    if (session.getAttribute("id") != null) {
        response.sendRedirect("main.jsp"); // ���� ���� �� ���� �������� �̵�
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>	
<body>
    <h1>�α��� �������Դϴ�</h1>
    <form method="POST" action="/example1/LoginServlet"> <!-- ���� ȣ�� -->
        <label for="id">id :</label>
        <input type="text" id="id" name="id" required><br>
        <label for="password">password :</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="�α���">
    </form>
</body>
</html>