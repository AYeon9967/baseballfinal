<%@page import="baseball_final.service.PostService"%>
<%@page import="baseball_final.service.UserService"%>
<%@page import="baseball_final.vo.User"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 프로필 사진 변경</title>
<link rel="stylesheet" href="resource/css/profileimg.css">
</head>
<body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="resource/js/profileimg.js"></script>

<%
	UserService us = UserService.getInstance();
	PostService ps = PostService.getInstance();
	String preprofile = us.userpicSearch((String)session.getAttribute("sessionID"));
	String storage = ps.getstorage(preprofile);
	
	//이미지 처리를 위한 saveDirectory 정보
	String saveDirectory = pageContext.getServletContext().getRealPath("/storage");
	File saveDir = new File(saveDirectory);
	if (!saveDir.exists()) saveDir.mkdirs();
	
	HttpSession s = request.getSession();
	s.setAttribute("saveDirectory", saveDirectory);
%>

<form action="profileimgupdate.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="preprofile" value="<%= preprofile %>">

	<table id="profileupdate">
		<tr>
			<td></td>
		</tr>
		<tr>
			<td><img alt="프로필사진" id="preview" src="<%= storage %>/<%= preprofile %>" style="width:100px; height:100px; border-radius:50%;"></td>
		</tr>
		<tr>
			<td><input type="file" onchange="readURL(this);" name="profileimg"></td>
		</tr>
		<tr>
			<td><input type="submit" id="sbutton" value="프로필 사진 설정하기"></td>
		</tr>
		<tr>
			<td><img alt="나가기" id="preview" src="resource/image/x.png" onclick="finishprofileupdate();" style="width:35px; height:35px; border-radius:50%;"></td>
		</tr>
	</table>

</form>

</body>
</html>