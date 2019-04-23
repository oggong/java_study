package e_method;

import java.util.Scanner;

//[필수]   multiple 메소드 만들기

//
//
//- 2개의 int 인자인 경우는 곱셈계산 한 결과를 출력
//- 1개의 int 인자와 1개의 char 인자인 경우는 int 인자 수 만큼 char 인자 문자를 출력
//- 2개의 int 인자와 1개의 char 인자인 경우는 char 인자 문자를 n * m 형식의 행과 열로 출력 

public class example3 {

	static int a, b;
	static int gop;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		a = sc.nextInt();
		b = sc.nextInt();

		gop();

	}

	static void gop() {

		gop = a * b;

		System.out.println(gop);
	}
}
