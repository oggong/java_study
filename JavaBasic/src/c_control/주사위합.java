package c_control;

import java.util.Scanner;

public class 주사위합 {

	public static void main(String[] args) {

		// 입력 값
		Scanner input = new Scanner(System.in);

		System.out.print(" ");
		int a = input.nextInt();

		// 1. 첫 번째 주사위의 수
		for (int i = 1; i <= 6; i++) {
			// 2. 두 번째 주사위의 수
			for (int j = 1; j <= 6; j++) {
//				if( 입력값과 i + j 같다면) 출력 (i 와 j 값을)
				if (a == i + j) {
					System.out.println(i + " " + j);
				}

			}
		}

	}

}
