<%@page import="baseball_final.vo.Reply"%>
<%@page import="baseball_final.vo.Post"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="baseball_final.service.UserService"%>
<%@page import="baseball_final.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 마이페이지</title>
<link rel="stylesheet" href="resource/css/mypage.css">
</head>
<script type="text/javascript">
function profileimg() {
	window.open("profileimg.jsp", "profileimg", "width=500, height=500");
}
function deluser() {
	if (confirm("정말 탈퇴하시겠습니까?")) {
		return true;
    } else {
    	return false;
    }
}
</script>
<header><%@ include file="header.jsp" %></header>
<body>

<%
	User user = (User)request.getAttribute("userinfo"); // user.get-() 로 회원 정보 불러올 수 있습니다.
	String userfavorite = ts.teamfullname(user.getFavorite()); // 관심구단 불러오기
	String storage = ps.getstorage(user.getProfileimg());
	
	List<Post> postlist = ps.mypagepostlist(user.getUserid());
	List<Reply> replylist = ps.mypagereplylist(user.getUserid());
	
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd, hh:mm");
	int postcount = 0;
	int replycount = 0;
%>

<div class="container">
	<h1>MYPAGE</h1>
	<div class="showuserinfo">
		<table id="profiletable">
			<tr id="profileimage">
				<td><img alt="프로필사진" src="<%= storage %>/<%= user.getProfileimg() %>" style="width:200px; height:200px; border-radius:50%;"></td>
			</tr>
			<tr>
				<td><input type="button" onclick="profileimg()" id="profile" name="profileimg" value="프로필 사진 변경"></td>
			</tr>
		</table>
		<table id="mypage">
			<tr>
				<th>아이디</th>
				<td><%= user.getUserid() %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>*****</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%= user.getName() %></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%= user.getGender() %></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><%= user.getBirthday()%></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><%= user.getNickname() %></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><%= user.getPhone() %></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%= user.getEmail() %></td>
			</tr>
			<tr>
				<th>관심구단</th>
				<td><%= userfavorite %></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="button" id="sbutton" onclick="location.href ='gouserupdate.do';" value="회원정보수정"></td>
			</tr>
		</table>
	</div>
	<div class="mywrite">
		<div id="myposth1"><h1>내가 쓴 글</h1></div>
		<div id="myreplyh1"><h1>내가 쓴 댓글</h1></div>
		<div id="mypost">
			<table id="myposttable">
				<% for (Post p : postlist) { %>
				<tr>
					<td style="width:60px;">[<%= p.getPostcategory() %>]</td>
					<td><a href="showpost.do?postnum=<%= p.getPostnum() %>"><%= p.getPosttitle() %></a></td>
					<td style="width:110px;"><%= p.getUploaddate().substring(0, 10) %></td>
				</tr>
				<% postcount++; }
				if (postcount == 0) { %> <tr><td>작성한 게시글이 없습니다.</td></tr> <% } %>
			</table>
		</div>
		<div id="myreply">
			<table id="myreplytable">
				<% for (Reply r : replylist) { %>
				<tr>
					<td><a href="showpost.do?postnum=<%= r.getPostnum() %>"><%= r.getReplycontents() %></a></td>
					<td style="width:110px;"><%= r.getUploaddate().substring(0, 10) %></td>
				</tr>
			<%	replycount++;	}
			if (replycount == 0) { %> <tr><td>작성한 댓글이 없습니다.</td></tr> <% } %>
			</table>
		</div>
	</div>
	<div id="deleteuser" align="right"><a href="deleteuser.do"><input type="button" id="dbutton" onclick="return deluser();" value="회원탈퇴"></a></div>
</div>

</body>
<footer><%@ include file="footer.jsp" %></footer>
</html>