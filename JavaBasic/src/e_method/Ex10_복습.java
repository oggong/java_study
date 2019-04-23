package e_method;

public class Ex10_복습 {

	static int n;
	static int m;
	static char alpha;

	public static void main(String[] args) {
		input();
		char[][] array = makeSquare(n, m);
		output(array);

	}// end of main
	
	/* ------------- 이런식으로 주석!!! 달기
	 * 함수명 : input
	 * 인자:
	 * 리턴형:
	 * 역할:
	*/

	static void input() {
		// 두 정수와 알파벳 문자 하나를 입력 받기
		n = 3;
		m = 4;
		alpha = 'F';

	}// end of input

	static char[][] makeSquare(int n, int m) {
		// 입력 받은 값을 이용해서 n*m 문자 배열 만들기
//		F G H I
//		J K L M
//		N O P Q
		char[][] array = new char[n][m];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = alpha;
				alpha++;
			}
		}
		return array;

	}// end of makeSquare

	static void output(char[][] array) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

		// 문자열 배열을 출력
	}// end of output

}// end of class
