<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<% 
/*
Ŭ���̾�Ʈ�κ��� ���޹��� ID�� ��й�ȣ�� ������ �����մϴ�.
1. ��ϵ� ID�� ��й�ȣ�� ���ϱ� ���� ������ ��ϵ� ID�� ��й�ȣ�� �����մϴ�.
2/ �α��� ���¸� Ȯ���ϱ� ���� login�̶�� boolean ������ �����ϰ� �ʱⰪ�� false�� �����մϴ�.
3. ��Ű���� ����� ID�� ��й�ȣ�� ������ ��ϵ� ������ ���Ͽ� �α��� ���¸� �Ǵ��մϴ�.
4. �α��� ���¿� ���� �б� ó���մϴ�.
5. �α��� ������ ���: ���ǿ� ID�� �����ϰ� main.jsp�� �����̷�Ʈ�մϴ�.
6. �α��� ������ ���: error.jsp�� �����̷�Ʈ�մϴ�.
*/
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//��ϵ� id�� ��й�ȣ ��
	String registerID = "abc";
	String registerPassword = "123";
	
	//�α��� ���� Ȯ��
	boolean login = false;
	
	// ��Ű���� ����� ID�� ��й�ȣ ��������
	Cookie[] cookies = request.getCookies();  // Ŭ���̾�Ʈ�� ���� ��� ��Ű ����
	if(cookies != null) {		// ��Ű�迭 ���� �ƴѰ��
		for(Cookie cookie : cookies) { 
			if(cookie.getName().equals("id") && cookie.getValue().equals(registerID)) { // ���̵�� ��ϵ� ���̵� ������
				if(cookie.getName().equals("password") && cookie.getValue().equals(registerPassword)) { // ��й�ȣ�� ������
					login = true; // �α��� ����
					break; // �ݺ��� ����
				}
			}
		}
	}
	
	// �α��� ���¿� ���� �б� ó��
	if ( login) {
		//�α��� ����
		session.setAttribute("id", id);   // session.setAttribute = �����͸� �����ϴ� �޼���
										// ������ ������ ����Ǵ� ������ ����ҷ�, Ŭ���̾�Ʈ�� ���õ� ������ ������ ������ �� �ֵ��� �����ݴϴ�.
		response.sendRedirect("main.jsp"); // Ŭ���̾�Ʈ�� ��û�� �ٸ� �������� �����̷�Ʈ(������)�ϴ� ������ �Ѵ�
	} else {
		// �α��� ���� 
		response.sendRedirect("error.jsp");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>