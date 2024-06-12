<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초중고 : 로그인</title>
<link rel = "stylesheet" href = "css/common.css" />
<link rel = "stylesheet" href = "css/login.css" />
<link rel = "stylesheet" href = "css/font.css" />

<style>

#floatBar {display : none;}

</style>

</head>
<body>

<div id = "wrapper">

	<header style = "background : white;">
		<h1 id = "logo"><a href = "main.do">초중고</a></h1>
	</header>
	
	<div id = "container">
	
		<form action = "login.do" name = "login" method = "post" id = "loginForm">
		
			<div class = "inputRow">
				<input type = "text" name = "id" placeholder = "아이디" />
				<c:if test = "${errors.id}">ID를 다시 입력하세요.</c:if>
			</div>
			
			<div class = "inputRow">
				<input type = "password" name = "pwd" placeholder = "비밀번호" />
				<c:if test = "${errors.password}">비밀번호를 다시 입력하세요.</c:if>
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
			
				<li><a href = "#">아이디 찾기 &nbsp;ㅣ&nbsp;</a></li>
				<li><a href = "#">비밀번호 찾기 &nbsp;ㅣ&nbsp;</a></li>
				<li><a href = "join.do">회원가입</a></li>
				
			</ul>
		</div>
		
	</div><!-- end #container -->
	
</div><!-- end #wrapper -->

</body>
</html>
