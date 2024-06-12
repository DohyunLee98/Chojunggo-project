<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<link rel = "stylesheet" href = "css/common.css">
<link rel = "stylesheet" href = "css/read.css">
<link rel = "stylesheet" href = "//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>

	<%@ include file = "/includes/header.jsp"%>

	<main>
		<div id = "wrapper">
			<div id = "container">

				<div class = "product">
					<div class = "product1">

						<div class = "productImgBox">
							<div id = "image">
								<a href = "#"><img src = "image/prd_3_1.jpg"></a>
							</div>
						</div><!-- end .productImgBox -->

					</div><!-- end .product1 -->

					<div class = "product2">

						<div class = "productContent">

							<div class = "title">
								<h3>나이키 덩크 로우 범고래</h3>
								<h2>150,000 원</h2>
							</div>

							<hr>

							<div class = "contents">

								<div id = "contentLeft" class = "content">
									<ul>
										<li>상품 상태</li>
										<li>배송비</li>
										<li>직거래 지역</li>
									</ul>
								</div>

								<div id = "contentRight" class = "content">
									<ul>
										<li>새 상품</li>
										<li>무료 배송</li>
										<li>서울특별시 서초구 반포본동</li>
									</ul>
								</div>

							</div><!-- end .content -->

						</div><!-- end .productContent -->

						<div class = "buttonBox">
						
							<div id = "chatBox">
								<button class = "chat">
									<img src = "image/chat2.png">
									<span>채팅</span>
								</button>
							</div><!-- end #chat -->

							<div id = "buyBox">
								<button class = "buy">구매하기</button>
							</div><!-- end #buy -->

						</div><!-- end .buttonBox -->

					</div><!-- end .product2 -->
				</div><!-- end .product -->

				<div class = "ProductInfostyle__Wrapper-sc-ql55c8-0 gPJVxW">
					<div class = "ProductInfostyle__HeadLine-sc-ql55c8-1 fscFAw">상품정보</div>
					<div class = "ProductInfostyle__Description-sc-ql55c8-2 hWujk">
						<div class = "ProductInfostyle__DescriptionContent-sc-ql55c8-3 eJCiaL">
							<p style = "width: 663px;">내용을 입력하세요.</p>
						</div>
						
						<div class = "ProductInfostyle__DetailInfo-sc-ql55c8-4 sBGtP">
							<div class = "ProductInfostyle__Info-sc-ql55c8-5 errcAj">
								<div class = "ProductInfostyle__InfoTitle-sc-ql55c8-6 jnXffx">
									<p class = "xi-maker prdInfo"> 직거래지역</p>
								</div>
								
								<div class = "ProductInfostyle__InfoValue-sc-ql55c8-10 hSkOuU">
									<div>
										<span>서울특별시 서초구 반포본동</span>
									</div>
								</div>
							</div>
							
							<div class = "ProductInfostyle__Info-sc-ql55c8-5 errcAj">
								<div class = "ProductInfostyle__InfoTitle-sc-ql55c8-6 jnXffx">
									<p class = "xi-paper prdInfo"> 카테고리</p>
								</div>
								
								<div class = "ProductInfostyle__InfoValue-sc-ql55c8-10 hSkOuU">
									<div class = "ProductInfostyle__Category-sc-ql55c8-8 bevkRX">
										<a href = "/categories/320?order = date&amp;page = 1&amp;req_ref = popular_category">의류</a>
											<span class = "ProductInfostyle__CategorySeparator-sc-ql55c8-9 ewtJFK">&gt;</span>
											
										<a href = "/categories/320300?order = date&amp;page = 1&amp;req_ref = popular_category">신발</a>
											<span class = "ProductInfostyle__CategorySeparator-sc-ql55c8-9 ewtJFK">&gt;</span>
											
										<a href = "/categories/320300200?order = date&amp;page = 1">운동화</a>
									</div>
								</div>
							</div>
							
							<div class = "ProductInfostyle__Info-sc-ql55c8-5 errcAj">
							
								<div class = "ProductInfostyle__InfoTitle-sc-ql55c8-6 jnXffx">
									<p class = "xi-tag prdInfo"> 상품태그</p>
								</div>
								
								<div class = "ProductInfostyle__InfoValue-sc-ql55c8-10 hSkOuU">
									<a class = "ProductInfostyle__Tag-sc-ql55c8-7 dDHUHy">#덩크 로우</a>
									<a class = "ProductInfostyle__Tag-sc-ql55c8-7 dDHUHy">#덩크 로우 범고래</a>
									<a class = "ProductInfostyle__Tag-sc-ql55c8-7 dDHUHy">#나이키</a>
									<a class = "ProductInfostyle__Tag-sc-ql55c8-7 dDHUHy">#나이키신발</a>
								</div>
								
							</div>
						</div>
					</div>
				</div><!-- end .Wrapper-sc-ql55c8-0 -->

			</div><!-- end #container -->
		</div><!-- end #wrapper -->
	</main>

	<%@ include file = "/includes/footer.jsp"%>

</body>
</html>
