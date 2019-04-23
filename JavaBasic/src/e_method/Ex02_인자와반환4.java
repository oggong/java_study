package e_method;

public class Ex02_인자와반환4 {

	static int a, b; // 아예 class 에 변수를 선언 == 멤버 변수 == 전역 변수 == global 변수
	// static 맞춰서 입력 해주기
	static int sum;

	public static void main(String[] args) {
		a = 10;
		b = 20;

		add();
		System.out.println("합: " + sum);
	}

	static void add() {
		sum = a + b;

	}

}
