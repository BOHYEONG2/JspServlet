<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//���� Ȯ��
	if (session.getAttribute("id") != null) {
	    response.sendRedirect("main.jsp"); // ���� ���� �� ���� �������� �̵�
	} else {
    if (request.getMethod().equalsIgnoreCase("POST")) { 
        String id = request.getParameter("id");
        String password = request.getParameter("password");
		//  request.getMethod().equalsIgnoreCase("POST")��
		// Ŭ���̾�Ʈ�� HTTP ��û �޼��尡 "POST"������ Ȯ���ϴ� ���ǹ��Դϴ�.
		// �� ���ǹ��� �ַ� �� �����͸� ������ ������ ��, POST ��û�� ó���ϴ� �κп��� ���˴ϴ�.
        
        // ��ϵ� id�� ��й�ȣ ��
        String registerID = "bohyeong";
        String registerPassword = "123";
        
        // �α��� ���� Ȯ��
        boolean login = false;
        
        // �α��� ó��
        if (id.equals(registerID) && password.equals(registerPassword)) {
            // �α��� ����
            login = true;
            
            // ���ǿ� �α��� ���� ����
            session.setAttribute("id", id);
        }
     
        if (login) {
            response.sendRedirect("main.jsp"); // �α��� ���� �� ���� �������� �̵�
        } else {
            response.sendRedirect("error.jsp"); // �α��� ���� �� ���� �������� �̵�
        }
    }
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
	<form method="POST" action="login.jsp">
	<label for="id">id :</label>
	<input type="text" id="id" name="id" required><br>
	<label for="password">password :</label>
	<input type="password" id="password" name="password" required><br>
	<input type="submit" value="�α���">
		
	</form>
</body>
</html>