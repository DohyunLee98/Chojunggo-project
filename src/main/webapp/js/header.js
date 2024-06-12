

$(document).ready(function(){
	
	$('#search').click(function(){
		search();
	});
});

function search(){

	$("#searchForm").attr("action","/list.do");
	$("#searchForm").submit();


}
