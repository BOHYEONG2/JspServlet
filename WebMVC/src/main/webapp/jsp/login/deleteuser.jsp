<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title her
</title>

</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
	<section>
  
  <h1>회원탈퇴</h1>
    <form action="deleteUserProcess.do" method="POST">
    <input type="hidden" name="id" value="${ loginUser.id }">
        <div>
            <label for="currentPassword">현재 비밀번호:</label>
            <input type="password" id="currentPassword" name="password" required>
        </div>
        <div>
            <label for="confirmPassword">비밀번호 확인:</label>
            <input type="password" id="confirmPassword" name="pwcheck" required>
        </div>
        <div>
            <input type="submit" value="회원탈퇴">
        </div>
    </form>
</section>
	<footer>
		
	</footer>
</body>
</html>