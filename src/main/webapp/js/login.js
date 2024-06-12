$(document).r$eady(function(){
	
	$("#login").click(function(){
		event.preventDefault();
		LoginInfo();
	});
	
});

function LoginInfo(){
	var id = $("#id").val();
	var pwd = $("#pwd").val();
	
	var jsonData = {
		id : id,
		pwd : pwd
	}
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "데이터를 받을 자바 url", true);
	xhr.setRequestHeader = function (){
		if(xhr.readyState === XMLHttpRequest.DONE) {
			if(xhr.status === 200){
				console.log("로그인 정보 전송 성공");
			} else {
				console.error("로그인 정보 전송 실패");
			}
		}
	};
	xhr.send(JSON.stringify(jsonData));
	Logincheck(
		
	);
}

function Logincheck(){
	fetch('/join.do')
		.then(response => response.json())
		.then(data => {
			data = JSON.parse(response);
			console.log(data);
		})
		.catch(error => console.error('Error:', error));
	
	if(data[0] == 0){
		alert("존재하지 않는 아이디입니다.");
		$("#id").focus();
		return false;
	} else if (data[1] == 0) {
		alert("비밀번호가 틀렸습니다.");
		$("#pwd").focus();
		return false;
	} else {
		alert("로그인 성공");
		location.href = "main.jsp";
	}
}