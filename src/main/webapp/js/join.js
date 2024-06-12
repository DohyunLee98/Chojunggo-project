$(document).ready(function() {


	$("#post_find").click(function() {

		openModal(event);
	})

	$("#close").click(function() {
		closeModal();
	});

	$("#joinComplete").click(function() {
		validateForm(event);
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
function validateForm(event) {
	var isValid = true;

	isValid = validateId(event);
	// 패스워드 유효성 검사
	if (isValid) {
		isValid = validatePw1(event);
	}
	// 패스워드 확인 유효성 검사
	if (isValid) {
		isValid = validatePw2(event);
	}
	if (isValid){
		isValid = validateName(event);
	}
	if (isValid){
		isValid = validateNick(event);
	}
	
	if(isValid){
		isValid = validateLocation(event);
	}
	
	return isValid;
}

function validateId(event) {
	var id = document.getElementById('id').value;

	if (id === '') {
		alert("아이디를 입력해주세요.");
		document.getElementById('id').focus();
		event.preventDefault();
		return false;
	}

	var idRegex = /^[a-zA-Z0-9]{5,20}$/;
	if (!idRegex.test(id)) {
		alert('아이디는 5~20자의 영문자 및 숫자로 구성되어야 합니다.');
		document.getElementById('id').focus();
		event.preventDefault();
		return false;
	}

	idValue = id;

	return true;
}

function validatePw1(event) {
	var pw1 = document.getElementById('pw1').value;

	if (pw1 === '') {
		alert('비밀번호를 입력해 주세요.');
		document.getElementById('pw1').focus();
		event.preventDefault();
		return false;
	}

	/*var passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;*/
	var passwordRegex = /^[a-zA-z0-9]{4,12}$/;
	if (!passwordRegex.test(pw1)) {
		/*alert('비밀번호는 8자 이상이어야 하며, 하나 이상의 숫자 및 특수 문자를 포함해야 합니다.');*/
		alert('비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야 합니다.');
		document.getElementById('pw1').focus();
		event.preventDefault();
		return false;
	}

	return true;
}

function validatePw2(event) {
	var pw1 = document.getElementById('pw1').value;
	var pw2 = document.getElementById('pw2').value;

	if (pw2 === '') {
		alert('비밀번호 확인을 입력해 주세요.');
		document.getElementById('pw2').focus();
		event.preventDefault();
		return false;
	}

	if (pw1 !== pw2) {
		alert('비밀번호가 일치하지 않습니다.');
		document.getElementById('pw2').focus();
		event.preventDefault();
		return false;
	}

	return true;
}

function validateName(event) {
	let name = document.getElementById('name').value;
	
	if(name === ''){
		alert("이름을 입력해주세요.");
		document.getElementById('name').focus();
		event.preventDefault();
		return false;
	}
	
	return true;
}

function validateNick(event) {
	let nick = document.getElementById('nickname').value;
	
	if(nick === ''){
		alert("별명을 입력해주세요.");
		document.getElementById(' nickname').focus();
		event.preventDefault();
		return false;
	}
	
	return true;
}

function validateLocation(event) {
	let loc = document.getElementById('location').value;
	
	if(loc === ''){
		alert("선호지역을 선택해주세요.");
/*		document.getElementById('location').focus();
*/		
		$("select[name=h_area1]").focus();
		event.preventDefault();
		return false;
	}
	
	return true;
}





// location

var cat1_name = new Array('서울', '부산', '대구', '인천', '광주', '대전', '울산', '강원', '경기', '경남', '경북', '전남', '전북', '제주', '충남', '충북');

var cat2_name = {
	'서울': ['강남구', '강동구', '강북구', '강서구', '관악구', '광진구', '구로구', '금천구', '노원구', '도봉구', '동대문구', '동작구', '마포구', '서대문구', '서초구', '성동구', '성북구', '송파구', '양천구', '영등포구', '용산구', '은평구', '종로구', '중구', '중랑구'],
	'부산': ['강서구', '금정구', '남구', '동구', '동래구', '부산진구', '북구', '사상구', '사하구', '서구', '수영구', '연제구', '영도구', '중구', '해운대구', '기장군'],
	'대구': ['남구', '달서구', '동구', '북구', '서구', '수성구', '중구', '달성군'],
	'인천': ['계양구', '남구', '남동구', '동구', '미추홀구', '부평구', '서구', '연수구', '중구', '강화군', '옹진군'],
	'광주': ['광산구', '남구', '동구', '북구', '서구'],
	'대전': ['대덕구', '동구', '서구', '유성구', '중구'],
	'울산': ['남구', '동구', '북구', '중구', '울주군'],
	'강원': ['강릉시', '동해시', '삼척시', '속초시', '원주시', '춘천시', '태백시', '고성군', '양구군', '양양군', '영월군', '인제군', '정선군', '철원군', '평창군', '홍천군', '화천군', '횡성군'],
	'경기': ['고양시 덕양구', '고양시 일산구', '과천시', '광명시', '광주시', '구리시', '군포시', '김포시', '남양주시', '동두천시', '부천시 소사구', '부천시 오정구', '부천시 원미구', '성남시 분당구', '성남시 수정구', '성남시 중원구', '수원시 권선구', '수원시 장안구', '수원시 팔달구', '시흥시', '안산시 단원구', '안산시 상록구', '안성시', '안양시 동안구', '안양시 만안구', '오산시', '용인시', '의왕시', '의정부시', '이천시', '파주시', '평택시', '하남시', '화성시', '가평군', '양주군', '양평군', '여주군', '연천군', '포천군'],
	'경남': ['거제시', '김해시', '마산시', '밀양시', '사천시', '양산시', '진주시', '진해시', '창원시', '통영시', '거창군', '고성군', '남해군', '산청군', '의령군', '창녕군', '하동군', '함안군', '함양군', '합천군'],
	'경북': ['경산시', '경주시', '구미시', '김천시', '문경시', '상주시', '안동시', '영주시', '영천시', '포항시 남구', '포항시 북구', '고령군', '군위군', '봉화군', '성주군', '영덕군', '영양군', '예천군', '울릉군', '울진군', '의성군', '청도군', '청송군', '칠곡군'],
	'전남': ['광양시', '나주시', '목포시', '순천시', '여수시', '강진군', '고흥군', '곡성군', '구례군', '담양군', '무안군', '보성군', '신안군', '영광군', '영암군', '완도군', '장성군', '장흥군', '진도군', '함평군', '해남군', '화순군'],
	'전북': ['군산시', '김제시', '남원시', '익산시', '전주시 덕진구', '전주시 완산구', '정읍시', '고창군', '무주군', '부안군', '순창군', '완주군', '임실군', '장수군', '진안군'],
	'제주': ['서귀포시', '제주시', '남제주군', '북제주군'],
	'충남': ['공주시', '논산시', '보령시', '서산시', '아산시', '천안시', '금산군', '당진군', '부여군', '서천군', '연기군', '예산군', '청양군', '태안군', '홍성군'],
	'충북': ['제천시', '청주시 상당구', '청주시 흥덕구', '충주시', '괴산군', '단양군', '보은군', '영동군', '옥천군', '음성군', '진천군', '청원군']
};



$(document).ready(function() {

	var area1 = document.getElementById('h_area1');
	var area2 = document.getElementById('h_area2');
	
	cat1_name.forEach(optionText => {
		var option = document.createElement('option');
		option.value = optionText;
		option.textContent = optionText;
		area1.add(option);
	});

	$(area1).change(function(){
		updateArea2();
	});
	
	$(area2).change(function(){
		inputText(area1, area2);
	});
	
});

function updateArea2() {
	
	var area1 = document.getElementById('h_area1');
	var area2 = document.getElementById('h_area2');
	var city = area1.value;

	area2.innerHTML = '<option value="" disabled selected>- 선택 -</option>'

	if(city && cat2_name[city]){
		var districts = cat2_name[city];
		for (var i = 0; i < districts.length; i++) {
			var option = document.createElement('option');
			option.value = districts[i];
			option.text = districts[i];
			area2.appendChild(option);
		}
	}
	
}

function inputText(area1, area2){
	
	var city = area1.value;
	var districts = area2.value;
	
	$('#location').val(city + " "+ districts);	
};

