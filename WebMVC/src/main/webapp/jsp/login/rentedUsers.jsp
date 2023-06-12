<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>대출 회원 목록</title>
    <style>
        table {
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 5px;
        }
    </style>
</head>
<body>
    <h1>대출 회원 목록</h1>
    <table>
        <thead>
            <tr>
                <th>대출 번호</th>
                <th>회원 ID</th>
                <th>회원 이름</th>
                <th>회원 전화번호</th>
                <th>도서 번호</th>
                <th>도서 제목</th>
                <th>도서 작가</th>
                <th>도서 출판사</th>
                <th>대출일</th>
                <th>반납일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${rentedusers}" var="rentedUser">
                <tr>
                    <td>${rentedUser.rentNo}</td>
                    <td>${rentedUser.id}</td>
                    <td>${rentedUser.name}</td>
                    <td>${rentedUser.phone}</td>
                    <td>${rentedUser.bookNo}</td>
                    <td>${rentedUser.title}</td>
                    <td>${rentedUser.writer}</td>
                    <td>${rentedUser.publisher}</td>
                    <td>${rentedUser.rentDate}</td>
                    <td>${rentedUser.rtDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>