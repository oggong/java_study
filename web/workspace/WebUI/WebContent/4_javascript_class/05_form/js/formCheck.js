window.onload = function() {

	var frm = document.getElementById('frm');
	var inputs = document.querySelectorAll("input");

	var nickarray = new Array('babo', 'geni', 'idiot', 'gdb');

	// 이전 방식
	// var frm = document.querySelector('#frm');
	// var inputs = document.getElementByTagName('input');

	frm.onclick = function(e) {
		// alert('서버로 데이타 전송');
		// alert('ok');
		//e.preventDefault();
		
		
		var agree = frm.agree;

		// alert(agree.checked);

		if (!agree.checked) {
			alert('반드시 확인하셔야합니다.');
			return;
		}
		
		
		// 별칭이 ['babo','geni','idiot','gdb'] 단어만 사용
		var nick = document.getElementById('nickname').value;

		alert(nick);

		for (var i = 0; i < nickarray.length; i++) {

			if (nick !== nickarray[i]) {
				alert('다시 입력하시오');
				return;
			} else {
				alert('통과');
				break;
			}

		}
		

		frm.submit();
	}

}