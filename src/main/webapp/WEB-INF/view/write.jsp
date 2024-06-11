<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 정보</title>
    <link rel="stylesheet" href="/css/write.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <%@ include file="/includes/header.jsp" %>
    <div class="content-container">
        <div class="container">
            <form action="write.do" method="post" enctype="multipart/form-data">
                <h2 class="section-title">상품정보</h2>
                <div class="section">
                    <label>상품이미지</label>
                    <div class="image-upload">
                        <input type="file" id="product-image-input" name="productImage" accept="image/*" />
                        <i class="fas fa-camera"></i>
                        <p>이미지 등록</p>
                    </div>
                </div>
                <hr class="thick-black-line">

                <div class="section">
                    <label for="product-name-input">상품명</label>
                    <input type="text" id="product-name-input" name="title" placeholder="상품명을 입력해 주세요." maxlength="40" />
                </div>
                <hr class="thick-gray-line">

                <div class="section">
                    <label for="category-select">카테고리</label>
                    <div class="category-container">
                        <select id="category-select" name="category" class="category">
                            <option>----설정안함----</option>
                            <option>디지털</option>
                            <option>가구</option>
                            <option>의류</option>
                            <option>가전제품</option>
                            <option>주방용품</option>
                            <option>스포츠/레저</option>
                            <option>뷰티</option>
                            <option>기타</option>
                        </select>
                    </div>
                </div>
                <hr class="thick-gray-line">

                <div class="section">
                    <label for="region-select">지역</label>
                    <div class="region-container">
                        <select id="region-select" name="location" class="region">
                            <option>----설정안함----</option>
                            <option>서울</option>
                            <option>경기</option>
                            <option>부산</option>
                            <option>대구</option>
                            <option>인천</option>
                            <option>광주</option>
                            <option>대전</option>
                            <option>울산</option>
                            <option>세종</option>
                            <option>강원</option>
                            <option>충북</option>
                            <option>충남</option>
                            <option>전북</option>
                            <option>전남</option>
                            <option>경북</option>
                            <option>경남</option>
                            <option>제주</option>
                        </select>
                    </div>
                </div>
                <hr class="thick-gray-line">

                <div class="section">
                    <label for="product-condition">상품 상태</label>
                    <div class="radio-group">
                        <label><input type="radio" name="productCondition" value="new"> 새 상품 (미사용) <span class="description">사용하지 않은 새 상품</span></label>
                        <label><input type="radio" name="productCondition" value="no-wear"> 사용감 없음 <span class="description">사용은 했지만 눈에 띄는 흔적이나 얼룩이 없음</span></label>
                        <label><input type="radio" name="productCondition" value="slight-wear"> 사용감 적음 <span class="description">눈에 띄는 흔적이나 얼룩이 약간 있음</span></label>
                        <label><input type="radio" name="productCondition" value="visible-wear"> 사용감 많음 <span class="description">눈에 띄는 흔적이나 얼룩이 많이 있음</span></label>
                        <label><input type="radio" name="productCondition" value="damaged"> 고장/파손 상품 <span class="description">기능 이상이나 외관 손상 등으로 수리/수선 필요</span></label>
                    </div>
                </div>
                <hr class="thick-gray-line">

                <div class="section">
                    <label for="product-description">설명</label>
                    <textarea id="product-description" name="content" placeholder="상품 설명을 입력해 주세요."></textarea>
                </div>
                <hr class="thick-gray-line">

                <div class="section">
                    <label for="product-price">가격</label>
                    <div class="price-container">
                        <input type="text" id="product-price" name="price" class="small-input" placeholder="가격을 입력해 주세요.">
                        <span class="small-label">원</span>
                    </div>
                </div>
                <hr class="thick-gray-line">

                <div class="section">
                    <label for="shipping-cost">배송비</label>
                    <div class="radio-group">
                        <label><input type="radio" name="shipping" value="included" checked onclick="hideShippingOptions()"> 배송비 포함</label>
                        <label><input type="radio" name="shipping" value="excluded" onclick="showShippingOptions()"> 배송비 별도</label>
                    </div>
                    <div id="shipping-options" class="shipping-options">
                        <div class="shipping-options-header">
                            <label>배송비 설정</label>
                        </div>
                        <div class="shipping-options-body">
                            <div class="shipping-option-group">
                                <label for="regular-shipping" class="small-label">일반택배</label>
                                <input type="text" id="regular-shipping" name="deliveryFee" class="small-input" placeholder="입력">
                                <span class="small-label">원</span>
                            </div>
                            <div class="shipping-option-group">
                                <label class="small-label">GS반값 · CU알뜰택배</label>
                                <input type="radio" name="gsCu" value="possible">
                                <span class="small-label">가능</span>
                                <input type="radio" name="gsCu" value="not-possible">
                                <span class="small-label">불가</span>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="thick-gray-line">
                <div class="section">
                    <button type="submit" class="submit-btn">등록하기</button>
                </div>
            </form>
        </div>
    </div>

    <%@ include file="/includes/footer.jsp" %>
    <script>
        function showShippingOptions() {
            document.getElementById('shipping-options').style.display = 'block';
        }

        function hideShippingOptions() {
            document.getElementById('shipping-options').style.display = 'none';
        }
    </script>
</body>
</html>