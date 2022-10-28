<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="baseball_final.service.UserService"%>
<%@page import="baseball_final.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 회원정보 수정</title>
<link rel="stylesheet" href="resource/css/userinfoupdate.css">
</head>
<header><%@ include file="header.jsp" %></header>
<body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="resource/js/updateuserinfo.js"></script> <!-- 비밀번호 확인 등의 로직 -->

<%
	User user = (User)request.getAttribute("userinfo"); // user.get-() 로 회원 정보 불러올 수 있습니다.
	
	String userfavorite = ts.teamfullname(user.getFavorite()); // 관심구단 불러오기
	
	String storage = null;
	if (user.getProfileimg().equals("defaultprofileimg.png")){	storage = "resource/image";
	} else {	storage = "storage";	}
	
	String Birth = user.getBirthday(); // DB에는 년-월-일 형태로 합쳐져서 저장됨. 년월일 분리를 위한 작업
	int year = Integer.parseInt(Birth.substring(0, 4));
	int month = Integer.parseInt(Birth.substring(5, 7));
	int day = Integer.parseInt(Birth.substring(8));
	
	String female = null;	String male = null;
	if(user.getGender().equals("여성")){ female = "checked";
	} else if(user.getGender().equals("남성")){ male = "checked";
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd, hh:mm");
%>

<div class="container">
<form action="userupdate.do" onsubmit="return joinCheck() && checkIdPattern() && checkPwPattern() && checknumPattern();" method="post" name="userupdate">
	<table class="updatetable">
		<tr>
			<td colspan="2" align="center"><h1>회원정보수정</h1></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%= user.getUserid() %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="userpw" value="<%= user.getUserpw() %>" required></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="userpwcheck" placeholder="비밀번호 확인" required></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="<%= user.getName() %>" required></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nickname" value="<%= user.getNickname() %>" required></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="여성" id="gender" <%= female %>><label for="gender">여성</label>
				<input type="radio" name="gender" value="남성" id="gender" <%= male %>><label for="gender">남성</label>
			</td>
		</tr>
		<tr>
			<th>이메일<br></th>
			<td><input type="email" name="email" value="<%= user.getEmail() %>" required></td>
		</tr>
		<tr>
			<th>휴대전화<br></th>
			<td><input type="text" name="phone" value="<%= user.getPhone() %>" required></td>
		</tr>
		<tr>
			<th>생년월일<br></th>
			<td>
				<select name="year" id="year">
	        		<option value="<%= year %>"><%= year %></option>
	        		<% for(int i = 1970; i < 2023 ; i++) {%>
	        				<option value="<%= i %>"><%= i %></option>
	        		<%} %>
	      		</select>
	      		<select name="month" id="month">
	      			<option value="<%= month %>"><%= month %></option>
	        		<% for(int i = 1; i < 13 ; i++) {%>
	        			<option value="<%= i %>"><%= i %></option>
	        		<%} %>
	      		</select>
	      		<select name="day" id="day">
	      			<option value="<%= day %>"><%= day %></option>
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
          			<option value="<%= user.getFavorite() %>"><%= userfavorite %></option>
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
			<td colspan="2" align="right"><input type="submit" id="sbutton" value="회원정보수정하기"></td>
		</tr>
	</table>
</form>
</div>

</body>
</html>