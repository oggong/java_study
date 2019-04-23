package b_operator;

public class Ex01_IncDec { // 증감 연산자
	/*
	 * 증가 감소 연산자 : ++, --
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 5, b = 7;

//		System.out.println("A=" + a + 1 + ",B=" + b + 1);  -- 값 A=51 B=71 나와 버림
//		System.out.println("A=" + (a + 1) + ",B=" + (b + 1)); // A=6 B=8

		/*
		 * a = a + 1; b = b - 1;
		 * 
		 * System.out.println("A=" + a + ",B=" + b); // A=6 B=6
		 * 
		 * // 위와 같은 코딩 a++; b--; System.out.println("A=" + a + ",B=" + b); // A=7 B=5 //
		 * 축약형으로 증가연산자 사용
		 * 
		 * ++a; // a++ --b; // b++ System.out.println("A=" + a + ",B=" + b); // A=8 B=4
		 */

//		int result = ++a;
//		System.out.println("Result:" + result + "A=" + a); // 6 6 a 먼저 증가시키고 result 값 입력
//
//		int result2 = a++;
//		System.out.println("Result:" + result2 + "A=" + a);// 6 7 result2 입력 후에 a를 증가시킴

		System.out.println("A=" + ++a + "B=" + --b); // 6 6 --- 첫계산
		System.out.println("A=" + a++ + "B=" + b--); // 6 6 --- 누적 후 두번째 계산
		System.out.println("A=" + a + "B=" + b); // 7 5 --- 누적 후 세번째 계산

		
		
	}

}
