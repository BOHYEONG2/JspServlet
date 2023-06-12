<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
<style>
        /* 테이블 스타일 */
        table {
            width: 60%;
            margin: 0 auto; 
            border-collapse: collapse;
            text-align: center;
            background-color: beige;
        }

        th, td {
            padding: 10px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        /* 헤더 스타일 */
        .header {
            text-align: center;
        }

        /* 도서 번호 스타일 */
        .book-no {
            font-weight: bold;
            color: #333;
        }

        /* 대출 가능 여부 스타일 */
        .availability {
            font-weight: bold;
            color: #333;
        }

        /* 대출하기 버튼 스타일 */
        .btn-rent {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin: 2px;
            cursor: pointer;
            border-radius: 3px;
            transition: background-color 0.3s ease-in-out;
        }

        .btn-rent:hover {
            background-color: #45a049;
        }

        .btn-rent:disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }
        
        /* 대출 가능 여부 색상 지정 */
        .availability-yes {
            color: green;
        }

        .availability-no {
            color: red;
        }
    </style>
    <script  src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
     <script>
    	function rentBtnClick(bookNo, bookTitle) {
    		if(confirm(bookTitle + '도서를 대출하시겠습니까?')) {
    			location.href = "${pageContext.request.contextPath}/rentBook.do?no=" + bookNo + "&id=${loginUser.id}"
    		}
    	}

        function returnBtnClick(bookNo, bookTitle) {
            if(confirm(bookTitle + '도서를 반납하시겠습니까?')) {
                location.href = "${pageContext.request.contextPath}/returnBook.do?no=" + bookNo + "&id=${loginUser.id}"
            }
        }
    </script>
</head>
<body>
    <header class="header">
        <jsp:include page="/jsp/include/topMenu.jsp"/>
    </header>
    <h1 class="header">도서 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th style="width: 10%;">도서 번호</th>
                <th>제목</th>
                <th>작가</th>
                <th>출판사</th>
                <c:if test="${loginUser != null}">
                    <c:choose>
                        <c:when test="${loginUser.id eq 'manager'}">
                            <th>관리</th>
                        </c:when>
                        <c:otherwise>
                            <th class="availability">대출 가능 여부</th>
                            <th>대출하기</th>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td class="book-no">${book.no}</td>
                    <td>${book.title}</td>
                    <td>${book.writer}</td>
                    <td>${book.publisher}</td>
                    <c:if test="${loginUser != null}">
                        <c:choose>
                            <c:when test="${loginUser.id eq 'manager'}">
                                <td>
                                    <form action="deleteBook.do" method="post" onsubmit="return confirm('삭제하시겠습니까?');">
                                        <input type="hidden" name="no" value="${book.no}" />
                                        <input type="submit" value="삭제" />
                                    </form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td class="availability ${book.isAvailable ? 'availability-yes' : 'availability-no'}">
                                    ${book.isAvailable ? '대출 가능' : '대출 중'}
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${book.isAvailable == false}">
                                            <input type="button" value="대출하기" disabled>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="button" class="btn-rent" value="대출하기" onclick="rentBtnClick(${book.no}, '${book.title}')">
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>






