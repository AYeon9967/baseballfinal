<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 회원가입 성공</title>
<link rel="stylesheet" href="resource/css/joinResult.css">
</head>
<header><%@ include file="/header.jsp" %></header>
<body>

<div class="container">
	<div class="joinresult">
		<table id="joinresulttable">
			<tr>
				<td colspan="2" align="center"><h1><br>회원가입 완료</h1></td>
			</tr>
			<tr>
				<td colspan="2" align="center"></td>
			</tr>
			<tr>
				<td><a href="./main.jsp"><input id="sbutton" type="button" value="홈으로"></a></td>
			</tr>
			<tr>
				<td><a href="./login.jsp"><input id="sbutton" type="button" value="로그인하기"></a></td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>