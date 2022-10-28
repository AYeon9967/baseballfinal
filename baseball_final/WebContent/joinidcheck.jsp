<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 아이디 중복 확인</title>
<link rel="stylesheet" href="resource/css/joinidcheck.css">
</head>
<body>
<script src="resource/js/joinfunction.js"></script>

<%
	String id = (String)request.getParameter("id");
	int idchecking;
	if(request.getAttribute("idcheck") == null){	idchecking = -1;
	} else {	idchecking = (int)request.getAttribute("idcheck");
	}
%>

<div class="idcheckcontainer">
	<form name="idCheckForm" method="post" onsubmit="return checkIdPatternPopup();" action="joinidcheck.do">
		<table class="idcheck">
			<tr>
				<td><input type="text" name="id" value="<%= id %>"></td>
				<td><input type="submit" id="sbutton" value="아이디 중복 확인"></td>
			</tr>
		<%if(idchecking == 0) {	%>
			<tr>
				<td colspan="2">
				<span id="findidfail"><%= id %></span><br>
				이미 사용중인 아이디 입니다.<br>
				다른 아이디를 입력하세요
				</td>
			</tr>
		<%} else if(idchecking == 1) {%>
			<tr>
				<td colspan="2">
				<span id="findidsuc"><%= id %></span><br>
				사용하실 수 있는 ID입니다.
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="usebutton" onclick="idCheckdone()" value="ID 사용하기"></td>
			</tr>
		<%} else {%>
			<tr>
				<td colspan="2">중복확인 버튼을 눌러주세요</td>
			</tr>
		<%} %>
		</table>
	</form>
</div>

</body>
</html>