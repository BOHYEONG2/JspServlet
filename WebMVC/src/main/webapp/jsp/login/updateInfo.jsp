<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="/WebMVC/css/layout.css">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
 	<style>
		body {
			display: flex;
			flex-direction: column;
			align-items: center;
			background-color: #f9f9f9;
			margin: 0;
			padding: 0;
		}

		h1 {
			margin-top: 20px;
			margin-bottom: 20px;
			color: navy;
			text-align: center;
			align-items: center;
		}

		form {
			display: flex;
			flex-direction: column;
			align-items: center;
			padding: 20px;
			border: 1px solid #ccc;
			border-radius: 5px;
			background-color: #f9f9f9;
		}

		label {
			margin-bottom: 10px;
			font-weight: bold;
			color: navy;
			width: 300px;
		}

		input[type="text"],
		input[type="password"] {
			width: 300px;
			padding: 5px;
			margin-bottom: 10px;
			border: none;
			border-bottom: 1px solid #ccc;
			border-radius: 0;
		}

		 .center {
			display: flex;
			justify-content: center;
			align-items: center;
			margin-top: 20px;
			margin-left: auto;
			margin-right: auto;
		}

		button[type="submit"] {
			padding: 10px 20px;
			font-size: 16px;
			background-color: #1E90FF;
			color: gold;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}

		button[type="submit"]:hover {
			background-color: #4169E1;
			color: white;
		}

		table.transparent-table {
			border-collapse: collapse;
			margin: auto;
			text-align: center;
		}

		table.transparent-table td,
		table.transparent-table th {
			border: none;
			text-align: left;
		}
	</style>
<section>
  <form action="/WebMVC/updateInfoProcess.do" method="post">
    <h1>회원정보</h1>
    <table class="transparent-table">
      <tr>
        <td style="background-color: transparent; border: none;">아이디:</td>
        <td style="background-color: transparent; border: none;">${loginUser.id}</td>
        <input type="hidden" name="id" value="${loginUser.id}">
      </tr>
      <tr>
        <td style="background-color: transparent; border: none;">기존 비밀번호:</td>
        <td style="background-color: transparent; border: none;"><input type="password" name="password" style="width: 300px;"></td>
      </tr>
    
      <tr>
        <td style="background-color: transparent; border: none;">이름:</td>
        <td style="background-color: transparent; border: none;"><input type="text" name="name" value="${loginUser.name}" style="width: 300px;"></td>
      </tr>
      <tr>
        <td style="background-color: transparent; border: none;">전화번호:</td>
        <td style="background-color: transparent; border: none;"><input type="text" name="phone" value="${loginUser.phone}" style="width: 300px;"></td>
      </tr>
      <tr>
        <td style="background-color: transparent; border: none;">생년월일:</td>
        <td style="background-color: transparent; border: none;">${loginUser.birthday}</td>
      </tr>
      
      <tr>
        <td style="background-color: transparent; border: none;">변경할 비밀번호:</td>
        <td style="background-color: transparent; border: none;"><input type="password" name="pw" style="width: 300px;"></td>
      </tr>
      <tr>
        <td style="background-color: transparent; border: none;">변경할 비밀번호 확인:</td>
        <td style="background-color: transparent; border: none;"><input type="password" name="pwcheck" style="width: 300px;"></td>
      </tr>
    </table>
    <button type="submit" style="margin-top: 20px;">수정</button>
  </form>
</section>
</body>
</html>