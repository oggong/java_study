package c_control;

import java.util.*;

public class Ex08_while개념 {

	public static void main(String[] args) {

//		String str = " 독도는 대한민국의 아름다운 섬입니다.";
//		StringTokenizer st = new StringTokenizer(str); // 잘려진 단어들을 Token 이라고 함!
//
//		while (st.hasMoreTokens()) { // hasMoreTokens 다음 토큰이 있니 없니 t/f 연달아 토큰을 실행 시킨 이후에 토큰이 더이상 있지 않으면 false로 나옴
//			
//			System.out.println(st.nextToken());
//		}
//============================================================================================
		String str = "100*3+4/2-5";
		StringTokenizer st = new StringTokenizer(str, "+-*/%"); // 연산자만 빠지기

		while (st.hasMoreTokens()) { // 이런경우에 while문 돌림!

			System.out.println(st.nextToken());
		}
//============================================================================================
		// 1~10까지 합 구하기
//
//		int sum = 0;
//		int i = 1; // for문 초기값 위로 이동
//					// 반복문의 갯수가 정해져 있을 때 === for문
//					// 반복문의 갯수가 정해져 있지 않을 때 === while문
//
//		// for (; i <= 10;) {
//
//		while (i <= 10) {
//			sum += i;
//			i++;
//		}
//		System.out.print("값 :" + sum);

//		// [연습] 구구단 수를 입력 받아서 구구단 출력
//
//		Scanner input = new Scanner(System.in);
//		System.out.println("출력 할 구구단의 숫자를 입력 하시오.");
//
//		int dan = input.nextInt();
//		int i = 1;
//
//		while (i <= 9) {
//			System.out.printf("%d * %d = %d \n", dan, i, dan * i);
//			i++;
//		}

	}
}
