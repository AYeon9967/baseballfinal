<%@page import="baseball_final.vo.Postpic"%>
<%@page import="baseball_final.vo.Reply"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="baseball_final.vo.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 게시글</title>
<link rel="stylesheet" href="resource/css/showpost.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
</head>
<header><%@ include file="header.jsp"%></header>
<script>
function nowriteright() { alert("로그인 이후 댓글쓰기가 가능합니다"); }
function adminnowriteright() { alert("관리자는 댓글쓰기가 불가능합니다"); }
function del() {
	if (confirm("정말 삭제하시겠습니까?")) {
		return true;
    } else {
    	return false;
    }
}
</script>
<!-- https://blog.naver.com/mystar999/222832285549 -->
<body>
<%
	Post post = (Post)request.getAttribute("post"); // user.get-() 로 회원 정보 불러올 수 있습니다.
	
	int postnum = post.getPostnum();
	String team = ts.teamfullname(post.getTeam());
	List<Reply> replylist = ps.showreply(postnum);
	List<Postpic> piclist = ps.showpicture(postnum);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd, hh:mm");
	int piccount = 0;
	int replycount = 0;
%>

<div class="container">
	<div class="showpost">
		<table id="post">
			<tr>
				<td><a href="teamlist.do?team=<%= post.getTeam() %>"><%= team %></a></td>
			</tr>
			<tr>
				<td><h1>[<%= post.getPostcategory() %>] <%= post.getPosttitle() %></h1></td>
			</tr>
			<tr>
				<td id="userprofile">
					<% String userprofilepic = us.userpicSearch(post.getWriter()); 
						if(userprofilepic == null) {
							%><img id="profile" src="resource/image/defaultprofileimg.png"><%
						} else {
							%><img id="profile" src="<%= ps.getstorage(userprofilepic) %>/<%= userprofilepic %>"><%
						}
					%>
					<p id="nick"><%= post.getWriternick() %>(<%= post.getWriter() %>) <span id="date"><%= post.getUploaddate() %></span></p>
				</td>
			</tr>
			<tr>
				<td>
					<!-- Slider main container -->
					  <!-- "해당 클래스명"이 없으면 슬라이더 작동 불가능 -->
					  <div class="swiper" style="width:600px; height:500px;">
					    <div class="swiper-wrapper">
					      	<% for (Postpic p : piclist) { %>
								<div class="swiper-slide"><img src="storage/<%= p.getPicture() %>" style="max-width:600px; max-height:500px;"></div>
							<%	piccount++;		}
							if (piccount == 0) { %> 첨부된 사진이 없습니다. <% } %>
					    </div>
					    <!-- 페이징 필요시 추가 -->
					    <div class="swiper-pagination"></div>
					    <!-- 이전, 다음 버튼 필요시 추가 -->
					    <div class="swiper-button-prev"></div>
					    <div class="swiper-button-next"></div>
					  </div>
				</td>
			</tr>
			<tr>
				<td><%= post.getPostcontents() %></td>
			</tr>
		<% if (sessionID != null && sessionID.equals("admin")) { %>
			<tr>
				<td>
					<a href="deletepost.do?postnum=<%= post.getPostnum() %>"><input type="button" id="postbutton" onclick="return del();" value="글 삭제"></a>
				</td>
			</tr>
		<% } else if (post.getWriter().equals(sessionID)) {%>
			<tr>
				<td>
					<a href="deletepost.do?postnum=<%= post.getPostnum() %>"><input type="button" id="postbutton" onclick="return del();" value="글 삭제"></a>
					<a href="goupdatepost.do?postnum=<%= post.getPostnum() %>"><input type="button" id="postbutton" value="글 수정"></a>
				</td>
			</tr>
		<% } %>
		</table>
		
		<hr>
		
		<table id="reply">
			<% for (Reply r : replylist) { %>
				<tr>
					<td id="userprofile">
						<img id="profile" src="<%= ps.getstorage(us.userpicSearch(r.getUserid())) %>/<%= us.userpicSearch(r.getUserid()) %>">
						<p id="nick"><%= us.usernickSearch(r.getUserid()) %>(<%= r.getUserid() %>) <span id="date"><%= r.getUploaddate() %></span></p>
					</td>
				</tr>
				<tr>
					<td id="replycon"><%= r.getReplycontents() %>
					<% if(sessionID != null && (r.getUserid().equals(sessionID) || sessionID.equals("admin"))){ %>
						<p id="replyup"><a href="deletereply.do?replynum=<%= r.getReplynum() %>" onclick="return del();">삭제</a></p>
					<% } %>
					</td>
				</tr>
			<%	replycount++;	}
			if (replycount == 0) { %> <tr><td>작성된 댓글이 없습니다.</td></tr> <% } %>
		</table>
		
		<!-- sessionID에 따른 댓글 등록창 -->
		<% if(sessionID != null && !sessionID.equals("admin")) { %>
			<form action="writereply.do?postnum=<%= post.getPostnum() %>" method="post" name="reply">
				<input type="hidden" name="postwriter" value="<%= post.getWriter() %>"><!-- 추후 댓글 [작성자] 표시용 -->
				<table id="writereply">
					<tr>
						<td><input type="text" name="replycontents" required></td>
						<td><input type="submit" id="sbutton" value="댓글 등록"></td>
					</tr>
				</table>
			</form>
		<% } else if(sessionID != null && sessionID.equals("admin")) { %>
			<table id="writereply">
				<tr>
					<td><input type="text" name="replycontents" required></td>
					<td><input type="button" id="sbutton" onclick="adminnowriteright();" value="댓글 등록"></td>
				</tr>
			</table>
		<% } else { %>
			<table id="writereply">
				<tr>
					<td><input type="text" name="replycontents" required></td>
					<td><input type="button" id="sbutton" onclick="nowriteright();" value="댓글 등록"></td>
				</tr>
			</table>
		<% } %>
	</div>
</div>

<script>
let swiper = new Swiper(".swiper", {
	  // 옵션
	  // 한 슬라이드에 보여줄 갯수
	  slidesPerView : 'auto', 
	  // 슬라이드 사이 여백
	  spaceBetween : 20, 
	  // 무한반복
	  loop: false, 
	  // 슬라이드 반복 시 마지막 슬라이드에서 다음 슬라이드가 보여지지 않는 현상 수정
	  loopAdditionalSlides: 1, 
	  // 자동재생
	  autoplay: {
	    // 시간 설정
	    delay: 10000, 
	    // false로 설정 시 스와이프 후 자동 재생이 비활성화 되지 않음
	    disableOnInteraction: false,
	  },
	  // 페이징 출력 시 추가
	  pagination: {
	    el: ".swiper-pagination",
	    type: "fraction",
	  },
	  // nav 화살표 출력 시 추가
	  navigation: {
	    nextEl: ".swiper-button-next",
	    prevEl: ".swiper-button-prev",
	  }
	});
</script>

</body>
<footer><%@ include file="footer.jsp"%></footer>
</html>