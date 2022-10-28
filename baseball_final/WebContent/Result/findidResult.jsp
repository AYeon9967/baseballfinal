<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 아이디 찾기 완료</title>
<link rel="stylesheet" href="resource/css/findidResult.css">
</head>
<header><%@ include file="/header.jsp" %></header>
<body>

<div class="container">
	<div class="idresult">
		<table id="idresulttable">
				<tr>
					<td align="center"><h1><br>아이디 찾기 결과</h1></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><p id="result">${findidresult }</p></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><a href="findpw.jsp"><input id="sbutton" type="button" value="비밀번호찾기"></a></td>
				</tr>
				<tr>
					<td><a href="login.jsp"><input id="sbutton" type="button" value="로그인하기"></a></td>
				</tr>
			</table>
	</div>
</div>

</body>
</html>