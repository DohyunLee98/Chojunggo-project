<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>주문배송조회</title>
<link rel="stylesheet" href="/css/recentBoard.css">
<link rel="stylesheet"
	href="https://d13fzx7h5ezopb.cloudfront.net/fonts/font.css">

</head>
<body>
	<%@ include file="includes/header.jsp"%>
	<div class="container">
		<div class="header">
			<h4>최근 본 상품</h4>
		</div>
		<c:if test="${not empty board}">
		<c:forEach var="board" items="${board}">
			<div class="order-info">
				<div class = "date">
					"${board.createdDate }"
				</div>
			</div>
			<a href="#" class="product-info">
				<img src="/image/uploadedImages/${board.thumbName }" class="product-image">
				<div class="product-details">
					<h3>${board.title }</h3>
					<p>가격  : ${board.price }</p>
				</div>
			</a>
		</c:forEach>
		</c:if>
	</div>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>
