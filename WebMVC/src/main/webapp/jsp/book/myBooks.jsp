<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>나의 대여 도서 목록</title>
   <style>
        h1 {
            color: black;
            text-align: center;
            margin: 20px 0;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
            text-align: center;
        }
        th, td {
            border: 1px solid navy;
            padding: 10px;
            text-align: center;
            
        }
        th {
            background-color: black;
            color: gold;
        }
        td:nth-child(odd) {
            background-color: black;
            color: black;
        }
        td:nth-child(even) {
            background-color: gold;
            color: navy;
        }
        input[type="submit"] {
            background-color: black;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: gold;
            color: navy;
        }
    </style>
</head>
<body>
<header>
    <jsp:include page="/jsp/include/topMenu.jsp"/>
</header>
<h1>나의 대여 도서 목록</h1>
<table>
    <thead>
        <tr>
            <th>대출 번호</th>
            <th>도서 번호</th>
            <th>도서 제목</th>
            <th>도서 작가</th>
            <th>도서 출판사</th>
            <th>대출일</th>
            <th>반납하기</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach items="${myBooks}" var="book">
            <tr>
                <td>${book.rentNo}</td>
                <td>${book.bookNo}</td>
                <td>${book.title}</td>
                <td>${book.writer}</td>
                <td>${book.publisher}</td>
                <td>${book.rentDate}</td>
                <td>
                    <form action="returnBook.do" method="post">
                        <input type="hidden" name="bno" value="${book.bookNo}" />
                        <input type="submit" value="반납하기" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>