<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 비밀번호 재설정 완료</title>
</head>
<header><%@ include file="/header.jsp" %></header>
<style>
.changepwresult {
	width: 700px;
	height: auto;
	margin: 20px auto;
}
#changepwresulttable {
	width: 100%;
}
.changepwresult tr {
	height: 40px;
	text-align: center;
}
#sbutton {
	width: 380px;
	height: 43px;
	background-color: #980000;
	border: none;
	border-radius: 2px;
	color: white;
}
#sbutton:hover {
	background-color: white;
	border: 1px solid #980000;
	color: #980000;
}
</style>
<body>

<div class="container">
	<div class="changepwresult">
		<table id="changepwresulttable">
			<tr>
				<td align="center"><h1><br>비밀번호 변경 완료</h1></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td><a href="login.jsp"><input id="sbutton" type="button" value="로그인하기"></a></td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>