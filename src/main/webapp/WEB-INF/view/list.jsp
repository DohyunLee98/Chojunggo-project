<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>초중고</title>
<link rel="stylesheet" href="/css/list.css">
<script>
function sorting() {
    var category = document.getElementById("category").value;
    var sorting = document.getElementById("sorting").value;
    var url = "list.do?category=" + encodeURIComponent(category) + "&sorting=" + encodeURIComponent(sorting);
    location.href = url;
}
</script>
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	<div class="container">
		<div class="header">
		
			<h2>판매 글</h2>
			
			<div class = "labelBox">
				<label> <span>카테고리</span> 
				<select id="category" name="type" >
				
						<option value='all'>옵션 선택</option>
						<option value='all'>전체 보기</option>
						<option value='digital'>디지털</option>
						<option value='clothes'>의류</option>
						<option value='furniture'>가구</option>
						<option value='appliance'>가전제품</option>
						<option value='kitchen'>주방용품</option>
						<option value='leisure'>스포츠/레저</option>
						<option value='beauty'>뷰티</option>
						<option value='etc'>기타</option>
						
				</select>
				</label>
			
				<label class = "labelRight"> <span>정렬</span> 
				<select id="sorting" name="sorting">
						<option value=" order by board_num desc">최신 순</option>
						<option value=" order by board_num">오래된 순</option>
						<option value=" order by price desc">높은 가격 순</option>
						<option value=" order by price">낮은 가격 순</option>
	
				</select>
				</label>
				
				<div class = "btnBox">
					<button type = "button" name = "btn"
						onclick = "sorting()" id = "btn" >검색</button>
				</div>
				
			</div><!-- end .labelBox -->
		</div><!-- end .header -->
		
		<c:forEach var="board" items="${boardPage.content}">
			<a href="/read.do?no=${board.boardNum}" class="product-info">
				<div class="product-card">
					<div class="product-wrapper">
						<div class="image-wrapper">
							<img src="/image/uploadedImages/${board.thumbName}" width="194"
								height="194" alt="이미지 없음">
							<div class="badge-area"></div>
							<div class="overlay"></div>
						</div>
						<div class="product-info">
							<div class="product-title">${board.title}</div>
							<div class="product-price">${board.price}원</div>
						</div>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
	<c:if test="${boardPage.hasBoard()}">
	</c:if>

	<c:if test="${boardPage.hasBoard()}">
		<table class="pagination-table">
			<tr>
				<td colspan="4"><c:if test="${boardPage.startPage > 5}">
						<a class="pagination-link"
							href="list.do?pageNo=${boardPage.startPage - 5}">[이전]</a>
					</c:if> <c:forEach var="pNo" begin="${boardPage.startPage}"
						end="${boardPage.endPage}">
						<a class="pagination-link" id="pageNumber"
							href="list.do?pageNo=${pNo}&category=${param.category}">${pNo}</a>
					</c:forEach> <c:if test="${boardPage.endPage < boardPage.totalPages}">
						<a class="pagination-link"
							href="list.do?pageNo=${boardPage.startPage + 5}">[다음]</a>
					</c:if></td>
			</tr>
		</table>
	</c:if>
	<%@ include file="/includes/footer.jsp"%>
</body>
</html>