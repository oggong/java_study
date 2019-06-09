/**
 * 
 */

window.onload = function() {

	var price = new Array();
	var content = new Array();

	var pricelist = [];

	// #### 1. TD에 이벤트 발생
	// ##### 2. 확인 버튼 클릭시 선택한 TD의 색을 다시 흰색으로
	// ##### 3. 값 계산하여 총합 구하기 - 각각 TD 클릭시 배열에 저장하였다가 계산

	// class 명으로 6개 메뉴 받기
	var td = document.getElementsByClassName('menu');
	
	// btn 변수 선언 (id로 )
	var btn = document.getElementById('btn');

	var count = document.getElementById('count');

	var select, menu; // 메뉴 선택

	var content = document.getElementById('content');

	var cnt;

	for (var i = 0; i < td.length; i++) {
		td[i].onclick = function() {
			menu = this.childNodes[0].nodeValue;
			select = this.getAttribute('price');
			// alert(menu);
		}
	}
	count.onchange = function() {
		// alert('확인');
		cnt = count.value;
		
		// pricelist 배열에 값 차례로 넣기
		pricelist.push(select * count.value);
		// alert(pricelist);
		
		content.innerHTML += menu + "-----------------"
				+ (select * count.value) + "원" + "<br/>";

	}

	btn.onclick = function() {
		// alert(select);

		var calculate = 0;
		
		for (var i = 0; i < pricelist.length; i++) {
			calculate += pricelist[i];

		}
		total.setAttribute('value', calculate);
	}
}