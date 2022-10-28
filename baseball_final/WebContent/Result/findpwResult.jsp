<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 비밀번호 찾기 완료</title>
<link rel="stylesheet" href="resource/css/findpwResult.css">
</head>
<header><%@ include file="/header.jsp" %></header>
<body>

<div class="container">
<div class="pwresult">
	<table id="pwresulttable">
		<tr>
			<td colspan="2" align="center"><h1><br>비밀번호 찾기 결과</h1></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td><p id="result">${findpwresult }</p></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td><a href="main.jsp"><input id="sbutton" type="button" value="홈으로"></a></td>
		</tr>
		<tr>
			<td><a href="join.jsp"><input id="sbutton" type="button" value="회원가입하기"></a></td>
		</tr>
	</table>
</div>
</div>

</body>
</html>