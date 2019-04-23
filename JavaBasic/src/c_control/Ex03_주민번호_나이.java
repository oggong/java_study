package c_control;

import java.util.*;
/*
	1 - 정수값 1 (연산 가능)
	'1' - 문자 1
	"1" - 문자열 1
*/

import java.util.Calendar;

public class Ex03_주민번호_나이 {

	public static void main(String[] args) {

		String id = "931212-1034567"; //

		String nai1 = id.substring(0, 2); // nai1 에는 80 이라는 문자열이 들어 있음

		int nai2 = Integer.parseInt(nai1); // casting 연산자는 기본형일때만!!!
//		Integer.parseInt(nai1) ---- String 을 Int 형으로 바꿔준다! String("80" -> 80)

		char a = id.charAt(7);

		int age = 0;
		// 주민번호 7번째 문자를 얻어와서
		// 1 이거나 2라면 1900
		// 3 이거나 4라면 2000

		// Calendar 클래스를 이용해서 년도값을 구해서 년도 지정
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		if (a == '1' || a == '2') { // 안씌워도 가능 하지만 사실상 블록을 씌워 주는것이 가독성 좋음
			age = year - (1900 + nai2) + 1;
			System.out.println("당신의 나이: " + age);
		} else if (a == '3' || a == '4') {
			age = year - (2000 + nai2) + 1;
			System.out.println("당신의 나이: " + age);
		}
	}

}
