<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=e7k1wfksa7&submodules=geocoder"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<title>야구볼래? 맛집등록</title>
<link rel="stylesheet" href="resource/css/writefood.css">
</head>
<header><%@ include file="header.jsp" %></header>
<body>

<% String team = request.getParameter("team"); %>

<div class="container">
	<h1>맛집등록하기</h1>
	<form action="writefood.do" method="post" name="writefood" onsubmit="">
	<input type="hidden" name="team" value="<%= team %>">
	<input type="hidden" id="teamlat" value="<%= ts.getx(team) %>">
	<input type="hidden" id="teamlng" value="<%= ts.gety(team) %>">
		<table id="writefood">
			<tr>
				<td>
				<select name="category">
					<option value="">- 음식 카테고리 선택 -</option>
					<option value="한식">한식</option>
					<option value="중식">중식</option>
					<option value="양식">양식</option>
					<option value="일식">일식</option>
					<option value="간식">간식</option>
					<option value="기타">기타</option>
				</select>
				<input type="text" name="restaurant" id="restaurant" placeholder="상호명(식당 이름)" required/>
				</td>
			</tr>
			<tr>	
				<td><input type="text" name="oneline" id="oneline" placeholder="한줄평" required/></td>
			</tr>
			
			<tr>
				<td><div id="map"></div></td>
			</tr>
			<tr>
				<td><input type="text" id="inputaddress" placeholder="식당 주소 검색(정확한 주소를 입력해주세요)"></td>
			</tr>
			<tr>
				<td align="right"><input type="button" id="submit" value="주소검색"></td>
			</tr>
			<tr style="display:none;"><!-- display none 처리 -->
				<td>
					<input type="text" id="address" name="address">
					<input type="text" id="lat" name="lat">
					<input type="text" id="lng" name="lng">
				</td>
			</tr>
			<tr>
				<td><input type="submit" id="sbutton" value="등록하기"></td>
			</tr>
		</table>
	</form>
</div>

</body>

<script src="resource/js/writefoodfoot.js"></script> <!-- 지도 표시를 위한 js -->

<footer><%@ include file="footer.jsp" %></footer>
</html>