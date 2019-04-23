package a_datatype;

import java.util.Scanner;

public class Ex06_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		System.out.print("A : ");
		int a = input.nextInt();

		System.out.print("B : ");
		int b = input.nextInt();

		System.out.print("C : ");
		int c = input.nextInt();

		if (1 <= a && a <= 100 || 1 <= b && b <= 100 || 1 <= c && c <= 100 ){
		
			if (a >= b && c >= a || b >= a && a >= c) {
				System.out.print("두번째 큰수는 " + a);
			} else if (b >= a && c >= b || b >= c && a >= b) {
				System.out.print("두번째 큰수는 " + b);
			} else if (c >= a && b >= c || c >= b && a >= c) {
				System.out.print("두번째 큰수는 " + c);
			} else {
				System.out.println("error");
			}
		} else {
			System.out.println("error");
		}
	}

}
