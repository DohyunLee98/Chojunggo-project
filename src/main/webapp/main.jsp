<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초중고</title>
<link rel = "stylesheet" href = "css/main.css">
<link rel = "stylesheet" href = "css/header.css">
<script src="main.js"></script>
</head>
<body>
	
	<div class = "content">
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
		
        <%@ include file = "header.jsp" %>
        
		<div class = "body">
			<a class = "banner">
				<img src = "image/banner_1.png">
			</a>
		</div>
		
		<div class = "main">
			<button>전체</button>
			<ul id = "mainList" class = "mainList">
			
				<li><a>디지털</a></li>
				<li><a>가구</a></li>
				<li><a>의류</a></li>
				<li><a>가전제품</a></li>
				<li><a>주방용품</a></li>
				<li><a>스포츠/레저</a></li>
				<li><a>뷰티</a></li>
				<li><a>기타</a></li>
				
			</ul>
		</div><!-- end .main -->
	</div>
	
<%@ include file = "includes/footer.jsp" %>
</body>
</html>
