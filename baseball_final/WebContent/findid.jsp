<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 아이디 찾기</title>
<link rel="stylesheet" href="resource/css/findid.css">
</head>
<header><%@ include file="header.jsp" %></header>
<body>

<div class="container">
	<div class="findid">
		<form action="findid.do" method="post">
			<table class="findidtable">
				<tr>
					<td colspan="2" align="center"><h1>아이디 찾기</h1></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
					<label><input type="radio" name="gender" value="여성">여성</label>
					<label><input type="radio" name="gender" value="남성">남성</label>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" placeholder="email@gmail.com" required></td>
				</tr>
				<tr>
					<th>휴대전화</th>
					<td><input type="text" name="phone" placeholder="-를 제외하고 입력해주세요" required></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" id="sbutton" value="아이디 찾기"></td>
				</tr>
			</table>
		</form>
	</div>
</div>

</body>
</html>