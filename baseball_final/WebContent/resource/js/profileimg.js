/**파일 업로드 미리보기용 */
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "";
	}
}

function finishprofileupdate(){
	opener.location.reload();
	window.close();
}

function profileupdate(){
	opener.location.reload();
}