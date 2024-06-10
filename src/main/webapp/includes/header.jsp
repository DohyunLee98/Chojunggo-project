<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel = "stylesheet" href = "css/header.css" />
<link rel = "stylesheet" href = "//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<header>
		<div id = "topBar">
		
			<div class = "title">
				<h1>
					<a href = "/main.do">초중고</a>
				</h1>
			</div>
			
			<form action = "" method = "get" >
			<div class = "searchbar">
				<input type = "text" placeholder = "상품명, 지역명 입력">
				<img class = "search" src = "image/search.png">
			</div>
			</form>
	
			<div id = "bar_right">
				<nav>
					<ul>
	
						<li><a><img class = "register" src = "image/basket.png"></a></li><!-- 상품 등록 -->
						<li><a><img class = "chat" src = "image/chat.png"></a></li><!-- 채팅 -->
						<li><a><img class = "mypage" src = "image/login.png"></a></li><!-- 마이페이지 -->
						<li><a href = "/login.do"><img class = "login" src = "image/login.png"></a></li>
						<%-- <c:choose><!-- 로그인 / 로그아웃 -->
							<c:when test = "${loginCheck}">
								<li><a href = "/logout.do"><img class = "talk" src = "image/basket.png"></a></li>
							</c:when>
							
							<c:otherwise>
								<li><a href = "/login.do"><img class = "talk" src = "image/basket.png"></a></li>
							</c:otherwise>
						</c:choose> --%>
	
					</ul>
				</nav>
			</div><!-- end #bar_right -->
			
		</div><!-- end #topBar -->
	</header>

		<div id = "floatBar">
			<div class = "float_1">
				<ul>

					<li>찜목록</li>
					<li><button id = "jjimList">보러가기</button></li>

				</ul>
			</div>
			<!-- end .float_1 -->

			<div class = "float_2">
				<div class = "float_2_up">최근 본 상품</div>
				<hr>
				<div class = "float_2_down">
					<ul>

						<li><a href = "#" id = "noLately"> <i class = "xi-eye-o xi-2x"></i>
						</a></li>
						<li id = "noLately">최근 본 상품이 없습니다.</li>

					</ul>
				</div>
			</div>
			<!-- end .float_2 -->

			<div class = "float_3">

				<button>TOP</button>

			</div>
			<!-- end .float_3 -->
		</div>
		<!-- end #floatBar -->

</body>
</html>