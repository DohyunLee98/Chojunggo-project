<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel="stylesheet" href="css/header.css" />
<link rel="stylesheet" href="css/font.css" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="js/header.js"></script>
</head>
<body>

	<header>
		<div id="topBar">
			<div class="title">
				<h1>
					<a href="/main.do">초중고</a>
				</h1>
			</div>

			<div class="searchbar">
				<input id = "searchWord" name="searchWord" type="text" placeholder="제목 or 내용 입력">
				<img id="search" class="search" src="image/search.png"
					onclick="search()">
			</div>

			<div id="bar_right">
				<nav>
					<ul>
						<li><a href="/write.do"><img class="register"
								src="image/register.png"></a></li>
						<!-- 상품 등록 -->
						<li><a href="/chat.do"><img class="chat"
								src="image/chat.png"></a></li>
						<!-- 채팅 -->
						<c:if test="${!empty login}">
							<!-- 로그인 / 로그아웃 -->
							<li><a href="/logout.do"><img class="logout"
									src="image/logout.png"></a></li>
						</c:if>
						<c:if test="${empty login}">
							<li><a href="/login.do"><img class="login"
									src="image/login.png"></a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			<!-- end #bar_right -->

		</div>
		<!-- end #topBar -->
	</header>

	<div id="floatBar">
		<div class="float_1">
			<div class="float_1_up">최근 본 상품</div>
			<hr>
			<div class="float_1_down">
				<ul>
					<li><a href="#" id="noLately"></a></li>
				</ul>
				<button id="recentButton" onclick="location.href='/recent.do'">최근
					본 상품 목록</button>
			</div>
		</div>
		<!-- end .float_1 -->

		<div class="float_2">
			<button id="top">TOP</button>
		</div>
		<!-- end .float_2 -->
	</div>
	<!-- end #floatBar -->

	<script>
		document.getElementById('top').addEventListener('click', function() {
			window.scrollTo({
				top : 0,
				behavior : 'smooth'
			});
		});

		// FloatBar 스크롤 따라 움직이게 하기
		var lastScrollTop = 0;
		var initialTop = 100; // 초기 위치를 약간 아래로 조정
		window.addEventListener('scroll', function() {
			var floatBar = document.getElementById('floatBar');
			var scrollTop = window.scrollY;

			if (scrollTop > lastScrollTop) {
				// 스크롤 내릴 때
				floatBar.style.top = (scrollTop + window.innerHeight
						- floatBar.offsetHeight - 20)
						+ 'px';
			} else {
				// 스크롤 올릴 때
				floatBar.style.top = (scrollTop + initialTop) + 'px';
			}

			lastScrollTop = scrollTop;
		});

		// 검색
		function search() {
			var searchWord = document.getElementById("searchWord").value;
			var url = "search.do?searchWord=" + encodeURIComponent(searchWord);
			location.href = url;
		}
	</script>

</body>
</html>
