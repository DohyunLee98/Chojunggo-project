<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.op {
    border: 1px solid #ccc;
    border-radius: 3px;
    padding: 3px;
    margin-bottom: 10px;
    margin-right: 10px; /* 오른쪽 여백 추가 */
}
.op:focus {
    outline: 2px solid #ffcc00;
}

.select-container {
    display: flex;
    align-items: center;
}
</style>
<script src="js/location.js"></script>
</head>
<body>
    <!-- 테스트 -->
    <div class="select-container">
        <select id="h_area1" name="h_area1" class="op">
            <option selected>- 선택 -</option>
        </select>
        <select id="h_area2" name="h_area2" class="op">
            <option selected>- 선택 -</option>
        </select>
    </div>
</body>
</html>
