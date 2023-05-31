<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<% 
/*
클라이언트로부터 전달받은 ID와 비밀번호를 변수에 저장합니다.
1. 등록된 ID와 비밀번호와 비교하기 위해 변수에 등록된 ID와 비밀번호를 저장합니다.
2/ 로그인 상태를 확인하기 위해 login이라는 boolean 변수를 선언하고 초기값을 false로 설정합니다.
3. 쿠키에서 저장된 ID와 비밀번호를 가져와 등록된 정보와 비교하여 로그인 상태를 판단합니다.
4. 로그인 상태에 따라 분기 처리합니다.
5. 로그인 성공한 경우: 세션에 ID를 저장하고 main.jsp로 리다이렉트합니다.
6. 로그인 실패한 경우: error.jsp로 리다이렉트합니다.
*/
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//등록된 id와 비밀번호 비교
	String registerID = "abc";
	String registerPassword = "123";
	
	//로그인 상태 확인
	boolean login = false;
	
	// 쿠키에서 저장된 ID와 비밀번호 가져오기
	Cookie[] cookies = request.getCookies();  // 클라이언트로 받은 모든 쿠키 저장
	if(cookies != null) {		// 쿠키배열 널이 아닌경우
		for(Cookie cookie : cookies) { 
			if(cookie.getName().equals("id") && cookie.getValue().equals(registerID)) { // 아이디와 등록된 아이디가 같을때
				if(cookie.getName().equals("password") && cookie.getValue().equals(registerPassword)) { // 비밀번호가 같을때
					login = true; // 로그인 성공
					break; // 반복문 종료
				}
			}
		}
	}
	
	// 로그인 상태에 따라 분기 처리
	if ( login) {
		//로그인 성공
		session.setAttribute("id", id);   // session.setAttribute = 데이터를 저장하는 메서드
										// 세션은 서버에 저장되는 데이터 저장소로, 클라이언트와 관련된 정보를 서버에 유지할 수 있도록 도와줍니다.
		response.sendRedirect("main.jsp"); // 클라이언트의 요청을 다른 페이지로 리다이렉트(재지정)하는 역할을 한다
	} else {
		// 로그인 실패 
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