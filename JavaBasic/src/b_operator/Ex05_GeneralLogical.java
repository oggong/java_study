package b_operator;

import java.util.Scanner;

/*
 *  논리 연산자
 *  	- 일반논리 : (true/false)다루는 논리 : && ||
 *  	- 이진논리 : (bit에 있는 1/0): & | ^
 *  		^ exclusive or ----------> 의외로 더러 사용됨
 *  
 * 
*/
public class Ex05_GeneralLogical {

	public static void main(String[] args) {

		// 문자 하나를 입력 받아
		// (1) 대문자인지 출력
		// (2) 대문자인지 소문자 인지 그외인지 출력

		Scanner input = new Scanner(System.in);
		System.out.println("문자를 하나 입력하세요:");

		char ch = input.next().charAt(0); // 형변환은 안되지만 그중 첫번째 문자를 받아오겠다.
		System.out.println("입력값 :" + ch);

		// 문자 'A' 보다 크거나 같고, 'Z'보다 작거나 같으면 -> 대문자
		// 그렇지 않으면 대문자 아님

		if (ch >= 'A' && ch <= 'Z') {
			System.out.println("대문자 " + ch);
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println("소문자 " + ch);
		}

		/*
		 * int 성적 = 75; char 태도 = 'A';
		 * 
		 * // 성적향상반 조건 -- 이고 성적 80점 이상 태도는 'A' if (성적 >= 80 && 태도 == 'A') { // 두 조건 만족
		 * and System.out.println("성적 향상반"); }
		 * 
		 * // 우등생 조건 - 성적은 80 이상이거나 태도는 'A' 이면 가능 if (성적 >= 80 || 태도 == 'A') { // 둘 중
		 * 하나는 or System.out.println("우등생");}
		 */
	}
}
