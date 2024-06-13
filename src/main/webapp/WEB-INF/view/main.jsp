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
				
				<div class = "listBox">
					
					<p>카 테 고 리</p>
					
					<button class = "button" style = "vertical-align : middle" 
						id = "categories" onclick = " location.href = '/list.do' ">
						<span>전체보기 </span>
					</button>
					
					<ul id = "mainList" class = "mainList">
					
						<li id = "digi"><a href = "/list.do?category=digital">디지털</a></li>
						<li id = "furni"><a href = "/list.do?category=furniture">가구</a></li>
						<li id = "clothing"><a href = "/list.do?category=clothes">의류</a></li>
						<li id = "appliance"><a href = "/list.do?category=appliance">가전제품</a></li>
						<li id = "kitchen"><a href = "/list.do?category=kitchen">주방용품</a></li>
						<li id = "leisure"><a href = "/list.do?category=leisure">스포츠/레저</a></li>
						<li id = "beauty"><a href = "/list.do?category=beauty">뷰티</a></li>
						<li id = "etc"><a href = "/list.do?category=etc">기타</a></li>
						
					</ul>
				</div><!-- end .listBox -->
				
			</div><!-- end .mainMenu -->
		</div><!-- end .section -->
		
	</main>
	
	<!-- footer -->
	<%@ include file = "/includes/footer.jsp" %>
	
	<!-- script -->
	<input type = "hidden" id = "logoutSuccess" value = "<%= request.getAttribute("logoutSuccess") != null ? request.getAttribute("logoutSuccess") : "" %>">

    <script>
    
        $(document).ready(function() {
            // 로그아웃 성공 여부 확인
            var logoutSuccess = $('#logoutSuccess').val();
            
            if (logoutSuccess === 'true') {
            	
                alert('로그아웃이 완료되었습니다.');
                
            } else if (logoutSuccess === 'false') {
            	
                alert('로그아웃에 실패했습니다. 다시 시도해주세요.');
                
            }
        });
        
    </script>
	
</body>
</html>
