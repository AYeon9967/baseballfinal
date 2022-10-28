<%@page import="baseball_final.vo.Postpic"%>
<%@page import="java.util.List"%>
<%@page import="baseball_final.vo.Post"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 게시글 수정</title>
<link rel="stylesheet" href="resource/css/updatepost.css">
</head>
<header><%@ include file="header.jsp"%></header>
<body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="resource/js/writepost.js"></script>

<%
	String team = request.getParameter("team");
	Post post = (Post)request.getAttribute("post"); // user.get-() 로 회원 정보 불러올 수 있습니다.

	//이미지 처리를 위한 saveDirectory 정보
	String saveDirectory = pageContext.getServletContext().getRealPath("/storage");
	File saveDir = new File(saveDirectory);
	if (!saveDir.exists()) saveDir.mkdirs();
	
	HttpSession s = request.getSession();
	s.setAttribute("saveDirectory", saveDirectory);
	
	List<Postpic> piclist = ps.showpicture(post.getPostnum());
	int piccount = 0;
	String pic1 = null, pic2 = null, pic3 = null;
	int picnum1 = 0, picnum2 = 0, picnum3 = 0;
	
	for (Postpic p : piclist) {
		if (piccount == 0) {	pic1 = p.getPicture(); picnum1 = p.getPicnum();
		} else if (piccount == 1) {		pic2 = p.getPicture(); picnum2 = p.getPicnum();
		} else if (piccount == 2) {		pic3 = p.getPicture(); picnum3 = p.getPicnum();
		}
		piccount++;
	}
%>

<div class="container">
	<form action="updatepost.do" method="post" enctype="multipart/form-data" name="updatepost">
	<input type="hidden" name="team" value="<%= team %>">
	<input type="hidden" name="postnum" value="<%= post.getPostnum() %>">
		<table id="writepost">
			<tr>
				<td colspan="2">
					<select name="postcategory">
						<option value="<%= post.getPostcategory() %>"><%= post.getPostcategory() %></option>
						<option value="1루">1루</option>
						<option value="3루">3루</option>
						<option value="외야">외야</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="posttitle" value="<%= post.getPosttitle() %>" required/></td>
			</tr>
			<tr>	
				<td colspan="2">
				<textarea rows="12" cols="50" name="postcontents" required><%= post.getPostcontents() %></textarea>
				</td>
			</tr>
		</table>
		<table id="writeimg">
			<tr>	
				<td>
					<input type="hidden" name="prepic1" value="<%= pic1 %>">
					<input type="hidden" name="prepicnum1" value="<%= picnum1 %>">
					<input type="file" onchange="readURL(this);" name="picture1">
				</td>
				<td><img src="storage/<%= pic1 %>" id="preview" style="max-width:100px; max-height:100px;"/></td>
			</tr>
			<tr>	
				<td>
					<input type="hidden" name="prepic2" value="<%= pic2 %>">
					<input type="hidden" name="prepicnum2" value="<%= picnum2 %>">
					<input type="file" onchange="readURL1(this);" name="picture2">
				</td>
				<td><img src="storage/<%= pic2 %>" id="preview1" style="max-width:100px; max-height:100px;"/></td>
			</tr>
			<tr>	
				<td>
					<input type="hidden" name="prepic3" value="<%= pic3 %>">
					<input type="hidden" name="prepicnum3" value="<%= picnum3 %>">
					<input type="file" onchange="readURL2(this);" name="picture3">
				</td>
				<td><img src="storage/<%= pic3 %>" id="preview2" style="max-width:100px; max-height:100px;"/></td>
			</tr>
			<tr>	
				<td colspan="2" align="right">
				<input type="submit" value="수정하기" id="sbutton"></td>
			</tr>
		</table>
	</form>
</div>

</body>
<footer><%@ include file="footer.jsp"%></footer>
</html>