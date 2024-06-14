<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초중고 : 회원가입</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/join.css" />
<link rel="stylesheet" href="css/modal.css" />
<link rel="stylesheet" href="css/header.css" />
<link rel="stylesheet" href="css/main.css" />
<!-- <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="js/join.js"></script>

<style>
    #floatBar {display : none;}
</style>
</head>
<body>
    <%@ include file="/includes/header.jsp" %>

    <main class="formBox">
        <form action="join.do" method="post">
            <input type="hidden" id="success" value="<%= request.getAttribute("success") != null ? request.getAttribute("success") : "" %>">
            <p>* 표시는 필수 입력 항목입니다.</p>
            <label>* 아이디</label>
            <input type="text" name="id" id="id"><br>
            <label>* 비밀번호</label>
            <input type="password" name="pwd" id="pw1"><br>
            <label>* 비밀번호 확인</label>
            <input type="password" name="pwdCheck" id="pw2"><br>
            <label>* 이름</label>
            <input type="text" name="name"><br>
            <label>* 별명</label>
            <input type="text" name="nickname"><br>
            <label>주소</label>
            <button type="button" id="post_find">우편번호찾기</button><br>
            <input type="text" name="zipcode" id="post" placeholder="우편번호">
            <input type="text" name="address" id="address" placeholder="주소"><br>
            <input type="text" name="address_detail" id="address2" placeholder="상세주소"><br>
            <label>* 거래 선호 지역</label>
            <%@ include file="/includes/location.jsp" %>
            <input type="text" id="location" name="location"><br>
            <label class="la_account">계좌번호</label>
            <input type="text" name="account" placeholder="000-1234-5678-00"><br>
            <button id="joinComplete" type="submit">회원가입</button>
        </form>
    </main>

    <!-- modal -->
    <div id="modal" class="modal">
        <div class="modal-content">
            <span class="close" id="close">&times;</span>
            <div id="postcode"></div>
        </div>
    </div>
    <!-- modal 끝 -->

    <%@ include file="/includes/footer.jsp" %>

</body>
</html>
