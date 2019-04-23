package b_operator;

import java.util.Scanner;

/*
	산술 연산자 : *  /  %  , +  -  
 	% 나머지 연산자 

*/

public class Ex03_Arithmetic {

	public static void main(String[] args) {

		// 1. 숫자하나를 입력받기 (Scanner - import.java.util.*)
		// 2. 홀수인지 짝수인지 연산하여 출력 (% : 나머지 연산자)

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하시오.");

		int a = scan.nextInt();

		if (a % 2 == 0) {
			System.out.println("짝수 입니다.");

		} else {
			System.out.println("홀수 입니다.");
		}

	}

}
