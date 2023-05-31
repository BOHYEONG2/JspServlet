<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//세션 확인
	if (session.getAttribute("id") != null) {
	    response.sendRedirect("main.jsp"); // 세션 존재 시 메인 페이지로 이동
	} else {
    if (request.getMethod().equalsIgnoreCase("POST")) { 
        String id = request.getParameter("id");
        String password = request.getParameter("password");
		//  request.getMethod().equalsIgnoreCase("POST")는
		// 클라이언트의 HTTP 요청 메서드가 "POST"인지를 확인하는 조건문입니다.
		// 이 조건문은 주로 폼 데이터를 서버로 전송할 때, POST 요청을 처리하는 부분에서 사용됩니다.
        
        // 등록된 id와 비밀번호 비교
        String registerID = "bohyeong";
        String registerPassword = "123";
        
        // 로그인 상태 확인
        boolean login = false;
        
        // 로그인 처리
        if (id.equals(registerID) && password.equals(registerPassword)) {
            // 로그인 성공
            login = true;
            
            // 세션에 로그인 정보 저장
            session.setAttribute("id", id);
        }
     
        if (login) {
            response.sendRedirect("main.jsp"); // 로그인 성공 시 메인 페이지로 이동
        } else {
            response.sendRedirect("error.jsp"); // 로그인 실패 시 에러 페이지로 이동
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
	<h1>로그인 페이지입니다</h1>
	<form method="POST" action="login.jsp">
	<label for="id">id :</label>
	<input type="text" id="id" name="id" required><br>
	<label for="password">password :</label>
	<input type="password" id="password" name="password" required><br>
	<input type="submit" value="로그인">
		
	</form>
</body>
</html>