<%@page import="baseball_final.service.FoodService"%>
<%@page import="baseball_final.service.TeamService"%>
<%@page import="baseball_final.service.PostService"%>
<%@page import="baseball_final.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/css/header.css">
</head>
<body>

<%
String sessionID = (String)session.getAttribute("sessionID");

PostService ps = PostService.getInstance();
UserService us = UserService.getInstance();
TeamService ts = TeamService.getInstance();
FoodService fs = FoodService.getInstance();

String usernick = us.usernickSearch(sessionID);
%>

<div class="headcontainer">
	<div class="logo">
		<a href="main.jsp"><img src="resource/image/LOGO.png"></a>
	</div>
<% if(sessionID == null) { %>
	<div id="navdiv">
		<div id="user">
			<ul>
				<li><a href="login.jsp">로그인</a></li>
				<li><a href="join.jsp">회원가입</a></li>
			</ul>
		</div>
	</div>
<% } else if(sessionID.equals("admin")) {%>
	<div id="navdiv">
		<div id="user">
			<ul>
				<li>administrator</li>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
		</div>
	</div>
<% } else { %>
	<div id="navdiv">
		<div id="user">
			<ul>
				<li><a href="mypage.do"><%= usernick %>님 접속중</a></li>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
		</div>
	</div>
<% } %>
</div>
<hr>
</body>
</html>