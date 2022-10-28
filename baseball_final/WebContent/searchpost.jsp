<%@page import="baseball_final.service.UserService"%>
<%@page import="baseball_final.service.PostService"%>
<%@page import="baseball_final.vo.Post"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=08om0t9plg"></script>
<title>야구볼래? 검색결과</title>
<link rel="stylesheet" href="resource/css/teamlist.css">
</head>
<header><%@ include file="header.jsp" %></header>
<body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="resource/js/teamlist.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
	String team = request.getParameter("team");
	String searchthing = request.getParameter("searchthing");
	String keyword = request.getParameter("keyword");
	String desc = request.getParameter("desc");
	
	List<Post> list = null;
	if(desc != null) {
		list = ps.searchpostlist(team, searchthing, keyword);
	} else {
		list = ps.searchpostlistdesc(team, searchthing, keyword);
	}
	
	String teamname = ts.teamfullname(team); // 구단 이름 불러오기
	String teampage = ts.teampage(team); // 구단 홈페이지 주소 불러오기
	double x = ts.getx(team);	double y = ts.gety(team); // 구단 위, 경도 불러오기
	String teamstadium = ts.getstadium(team);
	String teamroadadd = ts.getroadadd(team);
	String teamadd = ts.getadd(team);
	
	String writeright = null;
	if(sessionID == null) {	writeright = "nowriteright();";
	} else if( sessionID.equals("admin")) {	writeright = "adminnowriteright();";
	} else { writeright = "location.href ='writepost.jsp?team="+ team +"'";
	}
%>

<div class="container">
	<div id="teamlogo">
		<img src="resource/image/teamlogo/<%= team %>.png" style="width:80px;"/><h1><%= teamname %></h1>
	</div>

	<div id="teaminfo">
		<div onclick="goteampage(<%= teampage %>);">구단홈페이지</div> <!-- https://blog.naver.com/larysa/222861981318 / 새창 띄우기 방법 -->
		<div onclick="document.querySelector('#teamdetail').style.display='block';">구장정보</div> <!-- 지도, 좌석표 및 기본정보 노출 --> 
		<div onclick="location.href ='foodsurroundmap.jsp?team=<%= team %>'">주변맛집</div>
	</div>

	<div id="teamdetail">
		<img alt="구장정보닫기" id="exit" src="resource/image/x.png" onclick="document.querySelector('#teamdetail').style.display='none';" style="width:35px; height:35px; border-radius:50%;">
		<table id="teamdetailtable">
			<tr>
				<td colspan="2" align="center"><h1>구장정보</h1></td>
			</tr>
			<tr>
				<td rowspan="3"><div id="map"></div></td>
				<td>
					<h3><%= teamstadium %></h3>
					<p><%= teamadd %></p>
					<p><%= teamroadadd %></p>
				</td>
			</tr>
			<tr>
				<td><h4>경기장 좌석 정보</h4>
				<p>(클릭 시 크게보기)</p></td>
			</tr>
			<tr>
				<td>
					<img alt="좌석표" id="teamseat" src="resource/image/teamseat/<%= team %>.png" onclick="window.open(this.src);">
				</td>
			</tr>
		</table>
	</div>
	
	<div id="listsearch">
		<form action="searchpost.jsp" method="post">
		<input type="hidden" name="team" value="<%= team %>">
            <table id="listsearchtable">
            	<tr>
            		<td>
						<select name="searchthing" id="searchthing">
	          				<option value="posttitle">제목</option>
	          				<option value="writernick">닉네임</option>
	          				<option value="writer">아이디</option>
						</select>
					</td>
					<td><input type="text" name="keyword" id="searchinput" placeholder="검색어 입력"></td>
					<td><input type="submit" id="sbutton" value="검색"></td>
				</tr>
            </table>
         </form>
	</div>
	
	<div id="desc">
    	<table id="desctable">
    		<tr>
				<td><a href="searchpost.jsp?team=<%= team %>&searchthing=<%= searchthing %>&keyword=<%= keyword %>">최신순</a></td>
				<td><a href="searchpost.jsp?team=<%= team %>&searchthing=<%= searchthing %>&keyword=<%= keyword %>&desc=desc">오래된순</a></td>
			</tr>
    	</table>
	</div>
	
	<div id="post">
		<table id="posttable">
			<% int postcount = 0;
			for (Post p : list) { %>
				<tr>
					<td>[<%= p.getPostcategory() %>]</td>
					<td><a href="showpost.do?postnum=<%= p.getPostnum() %>"><%= p.getPosttitle() %></a></td>
					<td><%= us.usernickSearch(p.getWriter()) %>(<%= p.getWriter() %>)</td>
					<td><%= p.getUploaddate() %></td>
				</tr>
			<% postcount++; }
			if (postcount == 0) { %> <tr><td>검색된 게시글이 없습니다.</td></tr> <% } %>
		</table>
	</div>

	<div id="writepost" onclick="<%= writeright %>">글쓰기</div>
</div>

<script>
	var HOME_PATH = window.HOME_PATH || '.';
	var arena = new naver.maps.LatLng(<%= x %>, <%= y %>),
	    map = new naver.maps.Map('map', {
	        center: arena,
	        scaleControl: false,
	        logoControl: false,
	        mapDataControl: false,
	        zoomControl: true,
	        zoom: 15,
	        minZoom: 6
	    }),
	    marker = new naver.maps.Marker({
	        map: map,
	        position: arena
	    });

	var contentString = [
	        '<div class="iw_inner">',
	        '   <h3><%= teamstadium %></h3>',
	        '   <p><%= teamadd %></p>',
	        '   <p><%= teamroadadd %></p>',
	        '</div>'
	    ].join('');
	
	var infowindow = new naver.maps.InfoWindow({
	    content: contentString,
	    maxWidth: 400,
	    backgroundColor: "white",
	    borderColor: "#980000",
	    borderWidth: 2,
	    anchorSize: new naver.maps.Size(15, 5),
	    anchorSkew: true,
	    anchorColor: "white",
	    pixelOffset: new naver.maps.Point(20, -20)
	});
	
	naver.maps.Event.addListener(marker, "click", function(e) {
	    if (infowindow.getMap()) {
	        infowindow.close();
	    } else {
	        infowindow.open(map, marker);
	    }
	});
</script>

</body>
<footer><%@ include file="footer.jsp" %></footer>
</html>