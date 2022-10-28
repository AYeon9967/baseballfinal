
function joinCheck(){
	var join = document.userupdate;
	var pw = userupdate.userpw.value;
	var pwch = userupdate.userpwcheck.value;
	
	if(pw == pwch){
		return true;
	} else {
		alert("비밀번호 확인이 일치하지 않습니다");
		join.userpwcheck.focus();
		return false;
	}
}

function checkPwPattern() {
	var pw = userupdate.userpw.value;

	var pattern1 = /[0-9]/; // 숫자
	var pattern2 = /[a-zA-Z]/; // 문자
	var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
	
	if( !pattern1.test(pw) || !pattern2.test(pw) || !pattern3.test(pw) || pw.length < 8){
		alert("비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성하여야 합니다.");
		return false;
	} else {
		return true;
	}
}

function checknumPattern() {
	var account = userupdate.account.value;
	var phone = userupdate.phone.value;

	var pattern1 = /[0-9]/; // 숫자
	
	if( !pattern1.test(account) ){
		alert("계좌번호는 숫자만 입력해주세요");
		return false;
	} else if ( !pattern1.test(phone) ) {
		alert("핸드폰 번호는 숫자만 입력해주세요");
		return false;
	} else {
		return true;
	}
}