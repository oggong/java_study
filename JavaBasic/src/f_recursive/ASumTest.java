package f_recursive;

public class ASumTest {

//	public static void main(String[] args) {
//
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			// sum += i;
//
//			int exsum = sum;
//			sum = exsum + i;
//
//			System.out.println(sum + "=" + exsum + "+" + i);
//
//		}
//		System.out.println("합:" + sum);
//
//	} // end of main

	public static void main(String[] args) {
		int sum = 0;
		sum = sumFunc(3);
		System.out.println("총합:" + sum);
	}// end of main2

	static int sumFunc(int i) {
		if (i == 1)
			return 1;
		return i + sumFunc(i - 1); // 자기 자신이름을 자기가 호출 할때 재귀 호출!
									// 내비 두면 무한 루프 ---> 반드시 마지막 설정 해줘야 함!
									// 제어권도 확실히 하기

	}
}// end of class
