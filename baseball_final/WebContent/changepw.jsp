<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 비밀번호 재설정</title>
<link rel="stylesheet" href="resource/css/changepw.css">
</head>
<header><%@ include file="header.jsp" %></header>
<body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="resource/js/changepwfunction.js"></script> <!-- 다시입력 확인 로직 -->

<div class="container">
	<div class="changepw">
		<form action="changepw.do" onsubmit="return changeCheck() && checkPwPattern();" method="post" name="changepassword">
			<table class="changepwtable">
				<tr>
					<td colspan="2" align="center"><h1><br>비밀번호 변경</h1></td>
				</tr>
				<tr>
					<td><input type="hidden" name="previouspw" value="${ findpwresult }"></td>
					<td><input type="hidden" name="userid" value="${ userid }"></td>
				</tr>
				<tr>
					<th>비밀번호 재설정<br></th>
					<td><input type="password" name="userpwchange" placeholder="재설정할 비밀번호를 입력해주세요" required></td>
				</tr>
				<tr>
					<th>비밀번호 확인<br></th>
					<td><input type="password" name="chuserpwchange" placeholder="재설정할 비밀번호를 다시 입력해주세요" required></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" id="sbutton" value="비밀번호 변경하기"></td>
				</tr>
			</table>
		</form>
	</div>
</div>

</body>
</html>