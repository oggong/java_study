package b_encapsulation;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {

		CalculatorExpr cal = new CalculatorExpr(); // 객체 생성
		char cn = '\0';
		int a = 0, b = 0;
		int i = 0;

		do {

			Scanner sc = new Scanner(System.in);
			System.out.println("첫번째 숫자를 입력하세요.");
			a = sc.nextInt();
			System.out.println("두번째 숫자를 입력하세요.");
			b = sc.nextInt();

			cal.setNum1(a);
			cal.setNum2(b);
			if (i >= 1) {
				System.out.println(a + " " + b);
			}

			System.out.println("더하기 :" + cal.getAddition());
			System.out.println("빼기 :" + cal.getSubtraction());
			System.out.println("곱하기 :" + cal.getMultiplication());
			System.out.println("나누기 :" + cal.getDivision());

			System.out.println("계속 하려면 y/Y를 입력하세요!");
			System.out.println();
			cn = sc.next().charAt(0);
			i++;
		} while (cn == 'Y' || cn == 'y');

	}

}
