<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 회원가입</title>
<link rel="stylesheet" href="resource/css/join.css">
</head>
<header><%@ include file="header.jsp" %></header>
<body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="resource/js/joinfunction.js"></script> <!-- 비밀번호 확인 등의 로직 -->

<div class="container">
	<form action="join.do" onsubmit="return joinCheck() && checkIdPattern() && checkPwPattern() && checknumPattern();" method="post" name="join">
		<table class="jointable">
			<tr>
				<td colspan="3" align="center"><h1>회원가입</h1></td>
			</tr>
			<tr>
				<th width="150px">아이디<br></th>
				<td><input type="text" name="userid" placeholder="6-16자 이내 영문아이디 입력" autofocus required></td>
				<td align="right"><input type="button" id="idcheckbutton" onclick="idCheck()" value="아이디 중복 확인"></td>
			</tr>
			<tr>
				<th>비밀번호<br></th>
				<td><input type="password" id="userpw" name="userpw" placeholder="8자 이상, 영문, 숫자, 특수문자 혼합" required></td>
			</tr>
			<tr>
				<th>비밀번호 확인<br></th>
				<td><input type="password" id="userpwcheck" name="userpwcheck" placeholder="비밀번호 확인" required></td>
				<td><label id="pwlabel"></label></td>
			</tr>
			<tr>
				<th>이름<br></th>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<th>닉네임<br></th>
				<td><input type="text" name="nickname" required></td>
			</tr>
			<tr>
				<th>성별<br></th>
				<td id="gen">
					<input type="radio" name="gender" value="여성" id="gender"><label for="gender">여성</label>
					<input type="radio" name="gender" value="남성" id="gender"><label for="gender">남성</label>
				</td>
			</tr>
			<tr>
				<th>이메일<br></th>
				<td><input type="email" name="email" placeholder="email@gmail.com" required></td>
			</tr>
			<tr>
				<th>휴대전화<br></th>
				<td><input type="text" name="phone" placeholder="-를 제외하고 입력해주세요" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required></td>
			</tr>
			<tr>
				<th>생년월일<br></th>
				<td>
					<select name="year" id="year">
		        		<option value="">년</option>
		        		<% for(int i = 1970; i < 2023 ; i++) {%>
		        			<option value="<%= i %>"><%= i %></option>
		        		<%} %>
		      		</select>
		      		<select name="month" id="month">
		      			<option value="">월</option>
		        		<% for(int i = 1; i < 13 ; i++) {%>
		        			<option value="<%= i %>"><%= i %></option>
		        		<%} %>
		      		</select>
		      		<select name="day" id="day">
		      			<option value="">일</option>
		        		<% for(int i = 1; i < 32 ; i++) {%>
		        			<option value="<%= i %>"><%= i %></option>
		        		<%} %>
		      		</select>
				</td>
			</tr>
			<tr>
				<th>관심구단</th>
				<td>
					<select name="favorite" id="favorite">
	          			<option value="">관심구단을 선택해주세요</option>
	          			<option value="lg">엘지 트윈스(LG TWINS)</option>
	          			<option value="ssg">에스에스지 랜더스(SSG LANDERS)</option>
	          			<option value="samsung">삼성 라이온즈(SAMSUNG LIONS)</option>
	          			<option value="doosan">두산 베어스(DOOSAN BEARS)</option>
	          			<option value="kiwoom">키움 히어로즈(KIWOOM HEROS)</option>
	          			<option value="kt">케이티 위즈(KT WIZ)</option>
	          			<option value="kia">기아 타이거즈(KAI TIGERS)</option>
	          			<option value="nc">엔씨 다이노스(NC DINOS)</option>
	          			<option value="lotte">롯데 자이언츠(LOTTE GIANTS)</option>
	          			<option value="hanhwa">한화 이글스(HANHWA EAGLES)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" id="sbutton" value="가입하기">
				</td>
			</tr>
		</table>
	</form>
</div>

<script>
let userpwcheck = document.querySelector("#userpwcheck");
userpwcheck.addEventListener("blur", function() {
let userpw = document.querySelector("#userpw").value;
let userpwcheck = document.querySelector("#userpwcheck").value;

let pwlabel = document.querySelector("#pwlabel");
if (userpw == userpwcheck) {
  pwlabel.innerHTML = "일치";
  pwlabel.style.color = "green";
} else {
  pwlabel.innerHTML = "불일치";
  pwlabel.style.color = "red";
}
});
</script>

</body>
</html>