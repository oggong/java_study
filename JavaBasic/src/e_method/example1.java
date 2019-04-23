package e_method;

import java.util.Scanner;

/*(문제 1) 영문자를 입력하여 이 문자가 대문자이면 false을 반환 소문자이면 true을 반환하는 메소드를 작성하시오. 
함수명 : checkLower
인자 : char
리턴(반환) : boolean*/

public class example1 {
	static char ch; // 인자
	static boolean result;

	public static void main(String[] args) {
		checkLower();
		System.out.println();
	}

	static void checkLower() { // 함수
		Scanner sc = new Scanner(System.in);
		System.out.println("영문자를 입력하세요");
		String str = sc.next();
		ch = str.charAt(0);

		if (ch >= 'a' && ch <= 'z') {
			result = true;
			System.out.println(result);
		} else if (ch >= 'A' && ch <= 'Z') {
			result = false;
			System.out.println(result);
		} else {
			System.out.println("error");
		}

	}
}
