package z_useful;

import java.util.*; // 유용한 소스

public class CalendarEx01 {

	public static void main(String[] args) {

		/*
		 * int year = Calendar.getInstance().get(Calendar.YEAR); // 자바에서 현재 연도를 int로
		 * 받아오는 것
		 * 
		 */
		Calendar c = Calendar.getInstance(); // 자바에서 가지고 있는 Calendar 값을 가지고 오시오. 객체 = object = instance
												// Calendar 값이 들어 있는 덩어리를 가지고 와라
		System.out.println(c.get(Calendar.YEAR) + "년");
		System.out.println((c.get(Calendar.MONTH) + 1) + "월"); // 월은 +1
		System.out.println(c.get(Calendar.DATE) + "일");

		// 요일 (일요일 = 1 ,월요일 = 2,........) 언어마다 요일을 어떻게 표현 하는지 알아야 한다.
		System.out.println(c.get(Calendar.DAY_OF_WEEK) + "요일");

		// 시, 분, 초 출력
		System.out.println(c.get(Calendar.HOUR) + "시");
		System.out.println(c.get(Calendar.MINUTE) + "분");
		System.out.println(c.get(Calendar.SECOND) + "초");

		// 그 외 정보

		System.out.println("그 해의" + c.get(Calendar.DAY_OF_YEAR) + " 일 입니다.");

		// 그 해의 몇번째 주인지
		// 이 달의 몇번째 주인지
		System.out.println("그 해의" + c.get(Calendar.WEEK_OF_YEAR) + " 번째 주 입니다.");
		System.out.println("그 달의" + c.get(Calendar.WEEK_OF_MONTH) + " 번째 주 입니다.");

	}

}
