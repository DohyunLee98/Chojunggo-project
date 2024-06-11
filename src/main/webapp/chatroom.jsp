<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>번개장터 채팅방</title>
    <link rel="stylesheet" href="chat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <%@ include file="includes/header.jsp" %>
    <div class="container">
        <main>
            <section class="chat-window">
                <div class="chat-content">
                    <!-- 특정 채팅방의 내용을 동적으로 가져와서 표시합니다 -->
                    <p>채팅방: ${param.chatKey}</p>
                    <!-- 채팅 내용을 동적으로 표시 -->
                </div>
            </section>
        </main>
    </div>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
