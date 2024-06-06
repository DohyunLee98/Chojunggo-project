<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.op {

	border : 1px solid #ccc;
	border-radius : 3px;
	padding : 3px;
	
}

</style>

<script src = "js/location.js"></script>
</head>
<body>

		<!-- 테스트 -->
 		<select name = "h_area1" onChange = "cat1_change(this.value,h_area2)" class = "op">
 
            <option selected>- 선택 -</option>
            <option value = '1'>서울</option>
            <option value = '2'>부산</option>
            <option value = '3'>대구</option>
            <option value = '4'>인천</option>
            <option value = '5'>광주</option>
            <option value = '6'>대전</option>
            <option value = '7'>울산</option>
            <option value = '8'>강원도</option>
            <option value = '9'>경기도</option>
            <option value = '10'>경상남도</option>
            <option value = '11'>경상북도</option>
            <option value = '12'>전라남도</option>
            <option value = '13'>전라북도</option>
            <option value = '14'>제주도</option>
            <option value = '15'>충청남도</option>
            <option value = '16'>충청북도</option>
            
        </select>
        
        <select name = "h_area2" class = "op">
        
            <option selected>- 선택 -</option>
            <option value = '17'>강남구</option>
            <option value = '18'>강동구</option>
            <option value = '19'>강서구</option>
            <option value = '20'>강북구</option>
            <option value = '21'>관악구</option>
            <option value = '22'>광진구</option>
            <option value = '23'>구로구</option>
            <option value = '24'>금천구</option>
            <option value = '25'>노원구</option>
            <option value = '26'>도봉구</option>
            <option value = '27'>동대문구</option>
            <option value = '28'>동작구</option>
            <option value = '29'>마포구</option>
            <option value = '30'>서대문구</option>
            <option value = '31'>서초구</option>
            <option value = '32'>성동구</option>
            <option value = '33'>성북구</option>
            <option value = '34'>송파구</option>
            <option value = '35'>양천구</option>
            <option value = '36'>영등포구</option>
            <option value = '37'>용산구</option>
            <option value = '38'>은평구</option>
            <option value = '39'>종로구</option>
            <option value = '40'>중구</option>
            <option value = '41'>중랑구</option>
            
        </select>

</body>
</html>