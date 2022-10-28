/**파일 업로드 미리보기용 */
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	}
}

function readURL1(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview1').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	}
}

function readURL2(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview2').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	}
}