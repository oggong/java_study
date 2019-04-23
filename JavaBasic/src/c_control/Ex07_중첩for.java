package c_control;

public class Ex07_중첩for {

	public static void main(String[] args) {
		// ***** ex1)
		// ****
		// ***
		// **
		// *

		/*
		 * for (int i = 0; i < 5; i++) {
		 * 
		 * for (int j = 4; j >= i; j--) {
		 * 
		 * System.out.print("*"); } System.out.println(); }
		 */
		// 알파벳 A-Z 까지 -- 26번 반복

		/*
		 * for (int i = 0; i < 26; i++) { for (char ch = 'A'; ch <= 'A' + i; ch++) {
		 * System.out.print(ch);
		 * 
		 * } System.out.println(); }
		 */

		/*
		 * for (int i = 0; i < 26; i++) { for (char ch = 'A'; ch <= 'A' + i; ch++) {
		 * System.out.print(ch);
		 * 
		 * } System.out.println(); }
		 */

		/*
		 * for (int i = 0; i < 26; i++) { for (char ch = 'A'; ch <= 'Z' - i; ch++) {
		 * System.out.print(ch);
		 * 
		 * } System.out.println(); }
		 */

		/*
		 * 3번 for (int i = 0; i < 26; i++) { for (int ch = 'A'+i; ch <= 'Z'; ch++) {
		 * System.out.print((char)ch);
		 * 
		 * } System.out.println(); }
		 */
		/*
		 * 4번! for (int i = 0; i < 26; i++) { for (char ch = 'Z'; ch >= 'Z' - i; ch--) {
		 * System.out.print(ch);
		 * 
		 * } System.out.println(); }
		 */

//		// 26번 행 반복
//		for (int j = 0; j < 26; j++) {
//			// 문자열 출력
//			for (char i = (char) ('A' + j); i <= 'Z'; i++) {
//				System.out.print(i);
//			}
//			// 개행
//			System.out.println();
//
//			// 행마다 띄어쓰기 반복
//			for (int k = 0; k <= j; k++) {
//				System.out.print(' ');
//			}
//		}
		for (int i = 0; i < 26; i++) {
			for (int ch = 'A' + i; ch <= 'Z'; ch++) {
				System.out.print((char) ch);

			}
			System.out.println();
			
			for(int k = 0; k <= i; k++) {
				System.out.print(' ');
			}
		}

	}

}
