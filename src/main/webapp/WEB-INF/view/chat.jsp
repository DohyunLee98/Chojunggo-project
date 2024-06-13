<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>채팅</title>
<link rel="stylesheet" href="/css/chat.css">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <%@ include file="/includes/header.jsp"%>
    <div class="container">
        <div class="main-left">
            <c:forEach var="chat" items="${chatList}" varStatus="loop">
                <div class="chat-item" data-chat-id="chat${loop.index}">
                    <div class="chat-icon">
                        <i class="fas fa-bolt"></i>
                    </div>
                    <div class="chat-details">
                        <p id="chatList${loop.index}" class="chat-title">${chat.title}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="main-right">
            <div class="no-chat-selected">
                <p>대화방을 선택해주세요</p>
            </div>
            <c:forEach var="chat" items="${chatList}" varStatus="loop">
                <iframe class="hidden chat-${loop.index}" id="chat${loop.index}"
                    src='https://www.vchatcloud.com/chat-demo/iframe/iframe_pc/v4/index.html?channelKey=${chat.channelKey}'
                    frameborder='no' scrolling='no' marginwidth='0' marginheight='0' width='100%' height='100%'></iframe>
            </c:forEach>
        </div>
    </div>
    <%@ include file="/includes/footer.jsp"%>
</body>
<script src="/js/chat.js"></script>
</html>
