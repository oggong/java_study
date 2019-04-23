package e_method;

// 앞으로 역할 부분을 나눠서 만들어줄것임!
// main에 모두 넣지 않기
// 자료형 만 맞으면 다 주고받을 수 있음


public class Ex02_인자와반환2 {

	public static void main(String[] args) {
		int sum = add();
		// 변수명 안맞춰도 상관 없지만 --- 맞춰야 보기에 좋음

		System.out.println("합:" + sum);
	}

	static int add() { // int형 하나의 값을 반환 하기 위해 void x int로 변경 해줘야 함
		int a = 10, b = 20;
		int sum = a + b;
		return sum; // 19 라인 실행 하지 않고 제어권 을 반환 !

		// 제어권을 반환 하면서 데이터를 하나 가져갈 수 있음 ===== 원래 return : 흐름 반환
		// return 값: 호출한 곳으로 딱 하나의 값을 반환

	} // end of add

}// end of class
