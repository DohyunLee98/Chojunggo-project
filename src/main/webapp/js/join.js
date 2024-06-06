$(document).ready(function() {


	$("#post_find").click(function() {

		openModal(event);
	})

	$("#close").click(function() {
		closeModal();
	});

	$("#join").click(function() {
		validateForm();
	});

});
//주소찾기 모달창 호출
function openModal(event) {

	if (event) {
		event.preventDefault();
	}

	document.getElementById('modal').style.display = "block";

	console.log("모달창 열림");
	try {
		new daum.Postcode({
			oncomplete: function(data) {

				document.getElementById('post').value = data.zonecode;
				document.getElementById('address').value = data.address;

				closeModal();
			},
			width: '100%',
			height: '100%'
		}).embed(document.getElementById('postcode'));
		console.log("api 호출됨");
	} catch (e) {
		console.error("api 호출 에러", e);
		closeModal();
	}
}

//주소찾기 모달창 닫기
function closeModal() {
	document.getElementById('modal').style.display = "none";
}

//유효성 검사 시작
function validateForm() {
	var isValid = true;

	isValid = validateId();
	// 패스워드 유효성 검사
	if (isValid) {
		isValid = validatePw1();
	}
	// 패스워드 확인 유효성 검사
	if (isValid) {
		isValid = validatePw2();
	}

	return isValid;
}

function validateId() {
	var id = document.getElementById('id').value;

	if (id === '') {
		alert("아이디를 입력해주세요.");
		document.getElementById('id').focus();
		return false;
	}

	var idRegex = /^[a-zA-Z0-9]{5,20}$/;
	if (!idRegex.test(id)) {
		alert('아이디는 5~20자의 영문자 및 숫자로 구성되어야 합니다.');
		document.getElementById('id').focus();
		return false;
	}

	idValue = id;

	return true;
}

function validatePw1() {
	var pw1 = document.getElementById('pw1').value;

	if (pw1 === '') {
		alert('비밀번호를 입력해 주세요.');
		document.getElementById('pw1').focus();
		return false;
	}

	/*var passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;*/
	var passwordRegex = /^[a-zA-z0-9]{4,12}$/;
	if (!passwordRegex.test(pw1)) {
		/*alert('비밀번호는 8자 이상이어야 하며, 하나 이상의 숫자 및 특수 문자를 포함해야 합니다.');*/
		alert('비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야 합니다.');
		document.getElementById('pw1').focus();
		return false;
	}

	return true;
}

function validatePw2() {
	var pw1 = document.getElementById('pw1').value;
	var pw2 = document.getElementById('pw2').value;

	if (pw2 === '') {
		alert('비밀번호 확인을 입력해 주세요.');
		document.getElementById('pw2').focus();
		return false;
	}

	if (pw1 !== pw2) {
		alert('비밀번호가 일치하지 않습니다.');
		document.getElementById('pw2').focus();
		return false;
	}

	return true;
}