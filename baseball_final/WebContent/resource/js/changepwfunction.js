function changeCheck(){
	var changepassword = document.changepassword;
	var userpwchange = changepassword.userpwchange.value;
	var chuserpwchange = changepassword.chuserpwchange.value;
	
	if(userpwchange == chuserpwchange){
		return true;
	} else {
		alert("비밀번호 확인이 일치하지 않습니다");
		changepassword.chuserpwchange.focus();
		return false;
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