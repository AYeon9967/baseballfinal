<%@page import="baseball_final.vo.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=fp1cdq6q03"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<meta charset="UTF-8">
<title>야구볼래? 주변맛집</title>
<link rel="stylesheet" href="resource/css/foodsurroundmap.css">
</head>
<header><%@ include file="header.jsp" %></header>
<script>
function nowriteright() {	alert("로그인 이후 맛집등록이 가능합니다");	}
function goteampage(teampage) {
	var url = teampage;
	window.open(url, '_blank');
}
</script>
<%
String team = request.getParameter("team");
List<Food> list = fs.foodlist(team);

String teamname = ts.teamfullname(team); // 구단 이름 불러오기
String teampage = ts.teampage(team); // 구단 홈페이지 주소 불러오기

String writeright = null;
if(sessionID == null) {	writeright = "nowriteright();";
} else { writeright = "location.href ='writefood.jsp?team="+ team +"'";
}
%>
<body>
<div class="container">

	<div id="teamlogo">
		<img src="resource/image/teamlogo/<%= team %>.png" style="width:80px;"/><h1><%= teamname %></h1>
	</div>
	
	<div id="teaminfo">
		<div onclick="goteampage(<%= teampage %>);">구단홈페이지</div>
		<div onclick="location.href ='teamlist.do?team=<%= team %>'">게시글</div>
	</div>

<h1 id="maph1">주변 맛집 지도</h1>
	<div id="map"></div>
	<!-- 맛집 이름으로 검색하기 -->
	<table id="foodtable">
		<tr id="home">
			<td id="homelat"><%= ts.getx(team) %></td>
			<td id="homelng"><%= ts.gety(team) %></td>
		</tr>
		<%
		int foodcount = 0;
		for (Food f : list) {
		%>
			<tr id="areadb">
				<td id="lat<%= foodcount %>"><%= f.getLat() %></td>
				<td id="lng<%= foodcount %>"><%= f.getLng() %></td>
				<td id="name<%= foodcount %>"><%= f.getRestaurant() %></td>
				<td id="add<%= foodcount %>"><%= f.getAddress() %></td>
				<td id="cat<%= foodcount %>"><%= f.getCategory() %></td>
			</tr>
			<tr id="area">
				<td id="cat">[<%= f.getCategory() %>]</td>
				<td id="name"><h3><%= f.getRestaurant() %></h3><p>- <%= f.getAddress() %></p></td>
				<td id="one"><%= f.getOneline() %></td>
				<% if(sessionID != null && sessionID.equals("admin")) { %>
					<td id="but"><input type="button" onclick="location.href ='deletefood.do?foodnum=<%= f.getFoodnum() %>&team=<%= team %>'" id="delbutton" value="삭제"></td>
				<% } %>
			</tr>
		<%	
		foodcount++; }
		if (foodcount == 0) { %> <tr><td>등록된 맛집이 없습니다</td></tr> <% } %>
		<tr>
			<td colspan="3"><input type="button" onclick="<%= writeright %>" id="sbutton" value="맛집등록하기"></td>
		</tr>
	</table>
</div>

<script src="resource/js/foodsurroundmapfoot.js"></script> <!-- 지도 표시를 위한 js -->
</body>
<footer><%@ include file="footer.jsp" %></footer>
</html>