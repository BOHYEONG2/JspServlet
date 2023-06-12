<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 검색</title>
<link rel="stylesheet" href="/WebMVC/css/layout.css">
</head>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 12px 16px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    .unavailable {
        color: red;
        font-weight: bold;
    }

    /* 추가된 스타일 */
    section {
        padding: 20px;
    }

    h1 {
        font-size: 24px;
        margin-bottom: 20px;
    }

    form {
        margin-bottom: 20px;
    }

    input[type="text"] {
        padding: 8px;
        width: 200px;
    }

    input[type="submit"] {
        padding: 8px 16px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }

    table {
        border: 1px solid #ddd;
        margin-top: 20px;
    }

    th, td {
        padding: 12px 16px;
    }
    tbody td {
        padding: 12px 16px;
        border: 1px solid #ddd;
        font-size: 16px; /* 글꼴 크기를 16px로 설정 */
        font-weight: bold; /* 글꼴을 진하게 설정 */
    }

    tbody td:nth-child(odd) {
        background-color: #ffd700; /* 노란색 배경으로 변경 */
        color: #000; /* 진한 검정색 글꼴로 변경 */
    }

    tbody td:nth-child(even) {
        background-color: #ffd700; /* 노란색 배경으로 변경 */
        color: #000; /* 진한 검정색 글꼴로 변경 */
    }
        td {
        padding: 12px 16px;
        border: 1px solid #ddd;
        font-size: 14px;
    }

    td:nth-child(odd) {
        background-color: #f9f9f9;
    }

    td:nth-child(even) {
        background-color: black;
    }
</style>
<body>
   <header>
      <jsp:include page="/jsp/include/topMenu.jsp"/>
   </header>
   <section>
      <h1>책 검색</h1>
      <form action="searchBook.do" method="POST">
        <div>
            <label for="title"></label>
            <input type="text" id="title" name="title">
            <input type="submit" value="검색">
        </div>
      </form>
      
      <table>
        <thead>
            <tr>
                <th>책 번호</th>
                <th>책 제목</th>
                <th>작가</th>
                <th>출판사</th>
                <th>대출 가능 여부</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.no}</td>
                    <td>${book.title}</td>
                    <td>${book.writer}</td>
                    <td>${book.publisher}</td>
                    <td>
                        <c:choose>
                            <c:when test="${book.isAvailable eq true}">
                                대출 불가
                            </c:when>
                            <c:otherwise>
                                대출 가능
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
   </section>
</body>
</html>