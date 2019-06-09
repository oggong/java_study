/**
 * 
 */

window.onload = function() {

	var price = new Array();
	var content = new Array();

	// #### 1. TD에 이벤트 발생
	// ##### 2. 확인 버튼 클릭시 선택한 TD의 색을 다시 흰색으로
	// ##### 3. 값 계산하여 총합 구하기 - 각각 TD 클릭시 배열에 저장하였다가 계산

	// class 명으로 6개 한번에 받기
	var td = document.getElementsByClassName('menu');

	var btn = document.getElementById('btn');

	var count = document.getElementById('count');

	var select; // 메뉴 선택

	var content = document.getElementById('content');

	for (var i = 0; i < td.length; i++) {
		td[i].onclick = function() {

			select = this.getAttribute('price');
			// alert(select);
		}
		btn.onclick = function() {
			// alert(select);\
			total.setAttribute('value', (select * count.value));

			content.innerHTML += (select * count.value)+"원"+"<br/>";

		}
	}
}