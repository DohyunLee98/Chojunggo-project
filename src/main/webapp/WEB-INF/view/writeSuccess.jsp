<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 완료</title>
<link rel = "stylesheet" href = "//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel = "stylesheet" href = "css/common.css">
<link rel = "stylesheet" href = "css/writeSuccess.css">
</head>
<body>

<%@ include file = "/includes/header.jsp" %>
	
<div id = "container">
	<div class = "pBox">
		
		<p class = "xi-document xi-4x"></p>
		<p class = "success">상품이 성공적으로 등록되었습니다.</p>
		
		<p class = "content">
		
			상품이 업데이트가 되었습니다.<br>
			계속해서 다음 페이지로 이동합니다
			
		</p>
			
	</div>
	
	<div class = "goBox">

		<input type = "submit" value = "전체상품 목록" 
			onclick = " location.href = 'list.do' " class = "goList">
		<input type = "submit" value = "작성한 글 보기" 
			onclick = " location.href = 'read.do?${boardNum}' " class = "goRead">
	
	</div>
</div>
	
<%@ include file = "/includes/footer.jsp" %>

</body>
</html>