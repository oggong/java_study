package b_operator;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("첫번째 수를 입력하세요");
		int a = input.nextInt();
		System.out.println("두번째 수를 입력하세요");
		int b = input.nextInt();
		System.out.println("세번째 수를 입력하세요");
		int c = input.nextInt();

		int second = ((a >= b && b >= c && a >= c) || (c >= b && b >= a && c >= a)) ? b
				: ((b >= a && a >= c && b >= c) || (c >= a && a >= b && c >= b)) ? a : c;

		System.out.println("두번째로 큰 수:" + second);
	}

}
