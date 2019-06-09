window.onload = function() {

	var adult = document.getElementById('textfield'); // 어른 요금

	var kids = document.getElementById('textfield2'); // 아동 요금

	var baby = document.getElementById('textfield3'); // 유아 요금


	adult.onblur = cal;

	kids.onblur = cal;

	baby.onblur = cal;

	function cal() {
		// alert('a');

		document.getElementById('textfield4').value = (adult.value * 39000)
				+ (kids.value * 29000) + (baby.value * 19000);
	} // 합계 금액

//	document.getElementById('check').onclick = function() {
//		alert('결제 성공');
//	}
//	document.getElementById('book').onclick = function() {
//		alert('예약 성공');
//	}
//	document.getElementById('reset').onclick = function() {
//		alert('다시하기');
//	}
	
	var frm = document.getElementById('frm');
	
	var check = document.getElementById('check');
	
	check.onclick = function() {
		
		check.submit();
	}

}