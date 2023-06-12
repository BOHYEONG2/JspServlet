<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" href="/WebMVC/css/layout.css">
<style>
    .image-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .background {
        width: 70%;
        height: 100%;
    }
</style>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    
    <div class="image-container">
        <img src="/WebMVC/image/libraryimage.jpg" alt="" class="background">
    </div>

   
</body>
</html>