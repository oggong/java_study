package c_control;

import java.util.*;

/*
 *  while(false){
 *  	명령문
 *  } 먼저 조건 비교 후 명령문
 *  
 *  do{
 *  	명령문
 *  }while(false); // 명령문 실행 후 조건 비교 ------------ 언제 조건을 비교하느냐의 차이
*/
public class Ex10_do_while {

	public static void main(String[] args) {
		char result = '\0'; // '\u0000' 자바스타일 유니코드 0

		do {
			Scanner input = new Scanner(System.in);
			System.out.println("출력 할 구구단의 숫자를 입력 하시오.");

			int dan = input.nextInt();

			int i = 1;

			while (i <= 9) {
				System.out.printf("%d * %d = %d \n", dan, i, dan * i);
				i++;
			}
			System.out.println("다시 할래?(y|Y)");
			result = input.next().charAt(0); // nextLine() next() vs nextLine()
		} while (result == 'Y' | result == 'y');
	}
 
}
