package b_operator;

import java.util.Scanner;

/*
 * 삼항 연산자 
 *  (조건)? A:B
 *  조건이 true 이면 A 실행하고 false 이면 B 실행한다.
 *  
*/
public class Ex08_Samhang {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("A:");
		int first = input.nextInt();

		System.out.println("B:");
		int second = input.nextInt();

		int max = (first > second ) ? first : second;
		System.out.println("큰수 :" + max);

		// [문제 두 수를 입력 받아 큰 수를 출력 (삼항 연산자 이용)]

		/*
		 * int score = 71; String result = ""; if( score >= 80) result = "합격"; else
		 * result ="불합격"; System.out.println("당신은"+result+"입니다.");
		 * 
		 */
	}

}
