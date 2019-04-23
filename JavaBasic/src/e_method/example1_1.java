package e_method;
// 선생님 코딩

import java.util.Scanner;

public class example1_1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		char ch = input.next().charAt(0);
		boolean result = checkLower(ch);
		System.out.println(result);
	}

	static boolean checkLower(char ch) {
		if (ch >= 'a' && ch <= 'b') {
			return true;
		} else {
			return false;
		}
	}

}
