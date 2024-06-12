<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초중고</title>
<link rel = "stylesheet" href = "css/main.css">
<link rel = "stylesheet" href = "css/common.css">
<script src="main.js"></script>
<script src = "https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>

	<%@ include file = "/includes/header.jsp" %>
		
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
				
				<button id = "category" onclick="location.href='/list.do'" >카테고리</button>
				
				<div class = "listBox">
					<ul id = "mainList" class = "mainList">
					
						<li id = "digi"><a href = "#">디지털</a></li>
						<li id = "funi"><a href = "#">가구</a></li>
						<li id = "clothing"><a href = "#">의류</a></li>
						<li id = "applliance"><a href = "#">가전제품</a></li>
						<li id = "kitchen"><a href = "#">주방용품</a></li>
						<li id = "leisure"><a href = "#">스포츠/레저</a></li>
						<li id = "beauty"><a href = "#">뷰티</a></li>
						<li id = "etc"><a href = "#">기타</a></li>
						
					</ul>
				</div><!-- end .listBox -->
				
			</div><!-- end .mainMenu -->
		</div><!-- end .section -->
		
	</main>
	
	<!-- footer -->
	<%@ include file = "/includes/footer.jsp" %>
	
</body>
</html>
