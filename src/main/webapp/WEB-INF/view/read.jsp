<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/read.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>

	<%@ include file="/includes/header.jsp"%>

	<main>
		<div id="wrapper">
			<div id="container">

				<div class="product">
					<div class="product1">
						<!-- 큰 이미지 박스 -->
						<div class="large-image-box">
							<img src="image/uploadedImages/${assemble.boardDetail.thumbName}"
								alt="이미지 없음">
						</div>

						<!-- 작은 이미지 박스들 -->
						<div class="small-images">
							<div class="small-image-box"></div>
							<div class="small-image-box"></div>
							<div class="small-image-box"></div>
							<div class="small-image-box"></div>
						</div>
					</div>
					<!-- end .product1 -->

					<div class="product2">

						<div class="productContent">

							<div class="title">
								<h3>${assemble.boardDetail.title}</h3>
								<h2>${assemble.boardDetail.price}원</h2>
							</div>

							<hr>

							<div class="contents">

								<div id="contentLeft" class="content">
									<ul>
										<li>상품 상태</li>
										<li>배송비</li>
										<li>직거래 지역</li>
									</ul>
								</div>

								<div id="contentRight" class="content">
									<ul>
										<li>${assemble.boardContent.productCondition}</li>
										<li>${assemble.boardContent.deliveryFee}원</li>
										<li>${assemble.boardDetail.location}</li>
									</ul>
								</div>

							</div>
							<!-- end .content -->

						</div>
						<!-- end .productContent -->

						<div class="buttonBox">

							<div id="chatBox">
								<form action="/chat.do" method="post">
									<button class="chat" onclick="submit">
										<!-- 버튼 누를 때 챗점두 -->
										<img src="image/chat2.png"> <span>채팅</span>
									</button>
									<input type="hidden" name="writer" value="${board.id}">
									<input type="hidden" name="title" value="${board.title}">
								</form>
							</div>
							<!-- end #chat -->

							<div id="buyBox">
								<button class="buy">구매하기</button>
							</div>
							<!-- end #buy -->

						</div>
						<!-- end .buttonBox -->

					</div>
					<!-- end .product2 -->
				</div>
				<!-- end .product -->

				<div class="ProductInfostyle__Wrapper-sc-ql55c8-0 gPJVxW">
					<div class="ProductInfostyle__HeadLine-sc-ql55c8-1 fscFAw">상품정보</div>
					<div class="ProductInfostyle__Description-sc-ql55c8-2 hWujk">
						<div
							class="ProductInfostyle__DescriptionContent-sc-ql55c8-3 eJCiaL">
							<p style="width: 663px;">${assemble.boardContent.content}</p>
						</div>

						<div class="ProductInfostyle__DetailInfo-sc-ql55c8-4 sBGtP">
							<div class="ProductInfostyle__Info-sc-ql55c8-5 errcAj">
								<div class="ProductInfostyle__InfoTitle-sc-ql55c8-6 jnXffx">
									<p class="xi-maker prdInfo">직거래지역</p>
								</div>

								<div class="ProductInfostyle__InfoValue-sc-ql55c8-10 hSkOuU">
									<div>
										<span>${assemble.boardDetail.location}</span>
									</div>
								</div>
							</div>

							<div class="ProductInfostyle__Info-sc-ql55c8-5 errcAj">
								<div class="ProductInfostyle__InfoTitle-sc-ql55c8-6 jnXffx">
									<p class="xi-paper prdInfo">카테고리</p>
								</div>

								<div class="ProductInfostyle__InfoValue-sc-ql55c8-10 hSkOuU">
									<span>${assemble.boardDetail.category}</span>
								</div>
							</div>

							<div class="ProductInfostyle__Info-sc-ql55c8-5 errcAj"></div>
						</div>
					</div>
				</div>
				<!-- end .Wrapper-sc-ql55c8-0 -->

			</div>
			<!-- end #container -->
		</div>
		<!-- end #wrapper -->
	</main>

	<%@ include file="/includes/footer.jsp"%>

</body>
</html>