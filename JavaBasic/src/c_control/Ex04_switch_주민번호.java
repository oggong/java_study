package c_control;

/*
 * 	switch 문 : 분기문
 * 
 * 	switch(___){
 * 		case A: 명령어A; break;
 *		case B: 명령어B; break;
 *		case C: 명령어C; break;
 *		default: 그외 명령어;
 *						           만약 default 를 앞에 쓰게 된다면 break; 사용
 * }
 * 		___ : 정수형 / 문자형   ex) double x
 * 							  String(1.5 버전 이후) 사용
*/

public class Ex04_switch_주민번호 {

	public static void main(String[] args) {

		String id = "930825-1034567";
		char chul = id.charAt(8);
		String home = "";

		switch (chul) {
		case '0':
			home = "서울";
			break;
		case '1':
			home = "인천/부산";
			break;
		case '2':
			home = "경기";
			break;
		case '9':
			home = "제주";
			break;
		default:
			home = "한국인";
		}
		System.out.println("출신지: " + home);
	}

}
