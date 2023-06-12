<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>책 등록</title>
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
			margin-top: 50px;
			margin-bottom: 20px;
			color: navy;
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
		}

		input[type="text"] {
			width: 300px;
			padding: 5px;
			margin-bottom: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
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
	</style>
	<h1>책 등록</h1>
	<form action="insertBookProcess.do" method="post">
		<label for="title">제목:</label>
		<input type="text" id="title" name="title" required><br>
		<label for="writer">저자:</label>
		<input type="text" id="writer" name="writer" required><br>
		<label for="publisher">출판사:</label>
		<input type="text" id="publisher" name="publisher" required><br>

		<button type="submit">등록</button>
	</form>
</body>
</html>