<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "css/common.css" />
<link rel = "stylesheet" href = "css/login.css" />
</head>
<body>

<div id = "wrapper">

	<header>
		<h1 id = "logo"><a href = "main.do">초중고</a></h1>
	</header>
	
	<div id = "container">
	
		<form action = "login.do" name = "login" method = "post" id = "loginForm">
		
			<div class = "inputRow">
				<input type = "text" name = "id" value = "${param.id}" placeholder = "아이디" />
				<c:if test = "${errors.id}">ID를 입력하세요.</c:if>
			</div>
			
			<div class = "inputRow">
				<input type = "password" name = "pw" value = "${param.pw}" placeholder = "비밀번호" />
				<c:if test = "${errors.password}">비밀번호를 입력하세요.</c:if>
			</div>
			
			<c:if test = "${errors.idOrPwNotMatch}" >
				
				아이디 또는 패스워드가 일치하지 않습니다.
				
			</c:if>
			
			<div id = "log_login">
				<input type = "submit" value = "로그인" />
			</div>
					
		</form><!-- end #loginForm -->
		
		<div class = "mid">
			<ul>
			
				<li><a href = "#">아이디 찾기 ㅣ&nbsp;</a></li>
				<li><a href = "#">비밀번호 찾기 ㅣ&nbsp;</a></li>
				<li><a href = "join.do">회원가입</a></li>
				
			</ul>
		</div>
		
	</div><!-- end #container -->	
		
	<footer>
	
		<div class = "footerInner">
			<ul id = "fiUp">
			
				<li><a href = "#">이용약관 ㅣ&nbsp;</a></li>
				<li><a href = "#">개인정보처리방침 ㅣ&nbsp;</a></li>
				<li><a href = "#">법적고지 ㅣ&nbsp;</a></li>
				<li><a href = "#">고객센터</a></li>
			
			</ul>
			
			<p id = "fiDown"><span>초중고</span> Copyright © 초중고 Corp. All Rights Reserved.</p>
			
		</div><!-- end .footerInner -->
			
	</footer>
	
</div><!-- end #wrapper -->
</body>
</html>
