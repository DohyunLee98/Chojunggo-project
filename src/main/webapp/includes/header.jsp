<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel = "stylesheet" href = "css/header.css" />
<link rel = "stylesheet" href = "css/font.css" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="js/header.js"></script>
</head>
<body>

	<header>
		<div id = "topBar">
		
			<div class = "title">
				<h1>
					<a href = "/main.do">초중고</a>
				</h1>
			</div>
			
			<form id="searchForm" method="get" action = "/list.do" >
			<div class = "searchbar">
				<input type = "text" placeholder = "상품명, 지역명 입력">
				<img id = "search" class = "search" src = "image/search.png">
			</div>
			</form>
	
			<div id = "bar_right">
				<nav>
					<ul>
	
						<li><a href = "/write.do"><img class = "register" src = "image/register.png"></a></li><!-- 상품 등록 -->
						<li><a href = "/chat.do"><img class = "chat" src = "image/chat.png"></a></li><!-- 채팅 -->
						<c:if test="${!empty login}"><!-- 로그인 / 로그아웃 -->
							<li><a href = "/logout.do"><img class = "logout" src = "image/logout.png"></a></li>
						</c:if>
                        <c:if test="${empty login}">
                        	<li><a href = "/login.do"><img class = "login" src = "image/login.png"></a></li>
                        </c:if>
	
					</ul>
				</nav>
			</div><!-- end #bar_right -->
			
		</div><!-- end #topBar -->
	</header>

	<div id = "floatBar">
		
		<div class = "float_1">
			<div class = "float_1_up">
				최근 본 상품
			</div>
			<hr>
			<div class = "float_1_down">
				<ul>
					<li><a href = "#" id = "noLately"></a></li>
				</ul>
				<button id="recentButton" onclick="location.href='/recent.do'">최근 본 상품 목록</button>
			</div>
		</div><!-- end .float_1 -->

		<div class = "float_2">
			<button id = "top">TOP</button>
		</div><!-- end .float_2 -->
		
	</div><!-- end #floatBar -->

<script>
	document.getElementById('top').addEventListener('click', function() {
	    window.scrollTo({ top: 0, behavior: 'smooth' });
	});
</script>

</body>
</html>
