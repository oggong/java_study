package c_control;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
//	문제2)  문자열처리하기
//	문자 N(a~z, A~Z)를 입력받아 N이 소문자면 a부터 N까지 인쇄하고 
//	N이 대문자이면 문자 N부터  Z까지 출력하라 
//	그 밖의 문자가 입력되면 Error 를 출력하라
//
//	입력  출력
//	f       abcdef
//	X       XYZ
//	6       Error
// ---------------------------------------------------------------------------
//		Scanner input = new Scanner(System.in);
//		System.out.print("문자를 입력하세요");
//		char ch = input.next().charAt(0);
//
//		if (ch >= 'A' & ch <= 'Z') {
//			for (int i = ch; i <= 'Z'; i++) {
//				System.out.print((char) i);
//			}
//		} else if (ch >= 'a' & ch <= 'z') {
//			for (int j = 'a'; j <= ch; j++) {
//				System.out.print((char) j);
//			}
//		} else {
//			System.out.println("error");
//		}

//
//	---------------------------------------------------------------
//
//
//
//	문제) 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오. 
//	   
//	     입력 
//	     3  4   
//	     
//	     출력
//	     1 2 3 4
//	     2 4 6 8
//	     3 6 9 12

//		Scanner input = new Scanner(System.in);
//
//		int row = 0, col = 0; // 행 열 초기화
//
//		System.out.print(" "); // 행 입력
//		col = input.nextInt();
//
//		System.out.print(" "); // 열 입력
//		row = input.nextInt();
//
//		for (int i = 1; i <= row; i++) {
//			for (int j = 1; j <= col; j++) {
//				System.out.print(i * j + " ");
//			}
//			System.out.println(" ");
//		}
//=-----------------------------------------------------

		Scanner input = new Scanner(System.in);

		int height = 0, width = 0;

		System.out.print(" ");
		height = input.nextInt();

		System.out.print(" ");
		width = input.nextInt();

		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				System.out.print(j + " ");

			}
			System.out.println(" ");
		}

	}

}
