
function nowriteright() {
	alert("로그인 이후 글쓰기가 가능합니다");
}

function adminnowriteright() {
	alert("관리자는 글쓰기가 불가합니다");
}

function goteampage(teampage) {
	var url = teampage;
	window.open(url, '_blank');
}

function showdetail() {
	document.querySelector('#teamdetail').style.display = 'block';
}

function hidedetail() {
	document.querySelector('#teamdetail').style.display = 'none';
}