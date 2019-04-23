package f_recursive;

public class Fibonacci {

	// 피보나치 수열!!@#!@#!@#!#

	public static void main(String[] args) {
		int n = 5;
		int result = fib(n);
		System.out.println("결과 : " + result);
	}

	static int fib(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		return fib(n - 1) + fib(n - 2);
	}

} // 일반적으로 쓰지 않는 이유는 가독성이 떨어지기 때문임! 재귀호출1@#!@#!@#!@#
