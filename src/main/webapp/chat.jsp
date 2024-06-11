<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅</title>
    <link rel="stylesheet" href="chat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <%@ include file="includes/header.jsp" %>
    <div class="container">
        <main>
            <aside class="chat-list-section">
                <nav>
                    <ul>
                        <li>전체 대화</li>
                    </ul>
                </nav>
                <div class="chat-list">
                    <c:forEach var="chat" items="${chatList}">
                        <div class="chat-item">
                            <div class="chat-icon"><i class="fas fa-bolt"></i></div>
                            <div class="chat-details">
                                <a href="chatroom.jsp?chatKey=${chat.key}">
                                    <p class="chat-title">${chat.title}</p>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </aside>
            <section class="chat-window">
                <div class="empty-chat">
                    <i class="fas fa-comment-dots"></i>
                    <p>대화방을 선택해 주세요</p>
                </div>
            </section>
        </main>
    </div>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
