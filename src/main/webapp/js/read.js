$(document).ready(function() {
	$("#smallImg img").click(function() {
		var newSrc = $(this).attr("src").replace("small", "big");
		$("#big").attr("src", newSrc);
	});

	$("#buy").click(function() {
		payment();
	});
});

function payment() {
	
	var name = $("#title").text();
	var price = $("#price").text();
	
	IMP.init('imp15547415');

	var paymentData = {
		pg: 'kakaopay',  
		pay_method: 'card',  
		merchant_uid: 'merchant_' + new Date().getTime(),  
		name: name,
		amount: price, 
		buyer_email: 'example@example.com',
		buyer_name: '홍길동',
		buyer_tel: '010-1234-5678',
		buyer_addr: '서울특별시 강남구 삼성동',
		buyer_postcode: '123-456'
	};

	IMP.request_pay(paymentData, function(response) {
		if (response.success) {
			alert('결제 성공: ' + response.imp_uid);
		} else {
			alert('결제 실패: ' + response.error_msg);
		}
	});
}