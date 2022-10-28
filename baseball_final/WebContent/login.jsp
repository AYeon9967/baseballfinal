<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 로그인</title>
<link rel="stylesheet" href="resource/css/login.css">
</head>
<header><%@ include file="header.jsp" %></header>
<body>

<div class="container">
	<div class="login">
		<div class="welcome">
			<h1>Let's Play Baseball!</h1>
		</div>
		<form action="login.do" method="post">
			<table class="logintable">
				<tr>
					<td><input type="text" name="userid" placeholder="아이디" required></td>
				</tr>
				<tr>
					<td><input type="password" name="userpw" placeholder="비밀번호" required></td>
				</tr>
				<tr>
					<td id="auth">
						<input type="radio" name="authority" value="user" checked><label>회원</label>
						<input type="radio" name="authority" value="admin"><label>관리자</label>
					</td>
				</tr>
				<tr>
					<td>${loginerror }</td>
				</tr>
				<tr>
					<td><input id="sbutton" type="submit" value="LOGIN"></td>
				</tr>
			</table>	
		</form>
		<div class="menu">
			<a href="findid.jsp">아이디 찾기</a>
		   	&nbsp;|&nbsp;
		   	<a href="findpw.jsp">비밀번호 찾기</a>
		   	&nbsp;|&nbsp;
		   	<a href="join.jsp">회원가입</a>
		</div>
	</div>
</div>

</body>
</html>