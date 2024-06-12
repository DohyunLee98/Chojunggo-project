$(document).ready(function(){
	
	$('#search').click(function(){
		search();
	});
});

function search(){
	/*var searchVal = $("#searchVal").val();*/

	$("#searchForm").attr("action","/list.do");
	$("#searchForm").submit();


	/*var xhr = new XMLHttpRequest();
	xhr.open("POST", "데이터를 받을 자바 url", true);
	xhr.setRequestHeader = function (){
		if(xhr.readyState === XMLHttpRequest.DONE) {
			if(xhr.status === 200){
				console.log("데이터 전송 성공");
			} else {
				console.error("데이터 전송 실패");
			}
		}
	};
	xhr.send(JSON.stringify({data: searchVal}));*/	
}
