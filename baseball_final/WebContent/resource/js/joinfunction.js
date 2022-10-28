
function joinCheck() {
	var join = document.join;
	var pw = join.userpw.value;
	var pwch = join.userpwcheck.value;

	if (pw == pwch) {
		return true;
	} else {
		alert("비밀번호 확인이 일치하지 않습니다");
		join.userpwcheck.focus();
		return false;
	}
}

function idCheck() {
	var join = document.join;
	var id = join.userid.value;

	if (!id) {
		alert("아이디를 입력해주세요.");
		join.userid.focus();
		return false;
	} else if (id.length < 5 || id.length > 17) {
		alert("아이디는 6-16자리로 구성하여야 합니다.");
		return false;
	} else {
		window.open("joinidcheck.jsp?id=" + id, "idCheck", "width=500, height=500");
	}
}

function idCheckdone() {
	var idCheckForm = document.idCheckForm;
	var id = idCheckForm.id.value;

	opener.document.join.userid.value = id;
	window.close();
}

function checkIdPatternPopup() {
	var id = idCheckForm.id.value;

	if (id.length < 5 || id.length > 17) {
		alert("아이디는 6-16자리로 구성하여야 합니다.");
		return false;
	} else {
		return true;
	}
}

function checkPwPattern() {
	var pw = join.userpw.value;

	var pattern1 = /[0-9]/; // 숫자
	var pattern2 = /[a-zA-Z]/; // 문자
	var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자

	if (!pattern1.test(pw) || !pattern2.test(pw) || !pattern3.test(pw) || pw.length < 8) {
		alert("비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성하여야 합니다.");
		return false;
	} else {
		return true;
	}
}

function checknumPattern() {
	var phone = join.phone.value;

	var pattern1 = /[0-9]/; // 숫자

	if (!pattern1.test(phone)) {
		alert("핸드폰 번호는 숫자만 입력해주세요");
		return false;
	} else {
		return true;
	}
}
