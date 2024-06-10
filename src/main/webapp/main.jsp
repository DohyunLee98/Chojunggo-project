<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초중고</title>
<link rel = "stylesheet" href = "css/main.css">
<script src="main.js"></script>
</head>
<body>

	<%@ include file = "includes/header.jsp" %>
	
		<!-- <header>
			<div class="header">
				<h2 class="title">초중고</h2>
				<img class="logo" src="#"> 로고이미지
				<div class="searchbar">
					<input type="text" placeholder="상품명, 지역명 입력">
					<a>돋보기?</a>
				</div>
				<nav>
					<ul class="logo">
						<li><a><img class="basket" src="image/basket.png"></a></li>
						<li><a>로그인/회원가입</a></li>
					</ul>
				</nav>
			</div>
		</header> -->
		
	<!-- main -->
	<main>
		<div class = "section">
			<input type = "radio" name = "slide" id = "banner01" checked>
			<input type = "radio" name = "slide" id = "banner02">
			<input type = "radio" name = "slide" id = "banner03">
			
			<div class = "bannerBox">
				<ul class = "banner">
					<li><a href = "#">
						<label for = "banner03" class = "left"></label>
						<img src = "image/banner_1.png">
						<label for = "banner02" class = "right"></label>
					</a></li>
					
					<li><a href = "#">
						<label for = "banner01" class = "left"></label>
						<img src = "image/banner_2.jpg">
						<label for = "banner03" class = "right"></label>
					</a></li>
					
					<li><a href = "#">
						<label for = "banner02" class = "left"></label>
						<img src = "image/banner_3.jpg">
						<label for = "banner01" class = "right"></label>
					</a></li>
				</ul>
			</div>
			
			<div class = "mainMenu">
				
				<button>전체</button>
				
				<div class = "listBox">
					<ul id = "mainList" class = "mainList">
					
						<li><a href = "#">디지털</a></li>
						<li><a href = "#">가구</a></li>
						<li><a href = "#">의류</a></li>
						<li><a href = "#">가전제품</a></li>
						<li><a href = "#">주방용품</a></li>
						<li><a href = "#">스포츠/레저</a></li>
						<li><a href = "#">뷰티</a></li>
						<li><a href = "#">기타</a></li>
						
					</ul>
				</div><!-- end .listBox -->
				
			</div><!-- end .mainMenu -->
		</div><!-- end .section -->
		
	</main>
	
	<!-- footer -->
	<%@ include file = "includes/footer.jsp" %>
	
</body>
</html>
