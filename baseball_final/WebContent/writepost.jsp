<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 글쓰기</title>
</head>
<header><%@ include file="header.jsp" %></header>
<link rel="stylesheet" href="resource/css/writepost.css">
<body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="resource/js/writepost.js"></script> 

<%
	String team = request.getParameter("team");

	//이미지 처리를 위한 saveDirectory 정보
	String saveDirectory = pageContext.getServletContext().getRealPath("/storage");
	File saveDir = new File(saveDirectory);
	if (!saveDir.exists()) saveDir.mkdirs();
	
	HttpSession s = request.getSession();
	s.setAttribute("saveDirectory", saveDirectory);
%>

<div class="container">
	<h1>게시글쓰기</h1>
	<form action="writepost.do" method="post" name="writepost" enctype="multipart/form-data" onsubmit="return zoneCheck();">
	<input type="hidden" name="team" value="<%= team %>">
		<table id="writepost">
			<tr>
				<td>
					<select name="postcategory">
						<option value="">- 구역정보 선택 -</option>
						<option value="1루">1루</option>
						<option value="3루">3루</option>
						<option value="외야">외야</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="posttitle" id="posttitle" placeholder="제목을 입력해주세요. (자세한 구역정보 포함)" required/></td>
			</tr>
			<tr>	
				<td><textarea name="postcontents" placeholder="=== 욕설, 비난 및 비방, 혐오글은 경고없이 삭제될 수 있습니다. ===" required></textarea></td>
			</tr>
		</table>
		<table id="writeimg">
			<tr>
				<td><input type="file" onchange="readURL(this);" name="picture1"></td>
				<td><img id="preview" style="max-width:100px; max-height:100px;"/></td>
			</tr>
			<tr>	
				<td><input type="file" onchange="readURL1(this);" name="picture2"></td>
				<td><img id="preview1" style="max-width:100px; max-height:100px;"/></td>
			</tr>
			<tr>	
				<td><input type="file" onchange="readURL2(this);" name="picture3"></td>
				<td><img id="preview2" style="max-width:100px; max-height:100px;"/></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="작성하기" id="sbutton"></td>
			</tr>
		</table>
	</form>
</div>

</body>
<footer><%@ include file="footer.jsp" %></footer>
</html>