package b_operator;

// 숏 서킷 로직 : 일반 논리에 적용

public class ShortCircuitLogic {

	public static void main(String[] args) {

		int a = 3;
		if (a > 3 && ++a > 3) {
			System.out.println("조건 만족"); // 출력 여부 && and 연산 이니 앞에 false 이면 뒤 연산을 수행 하지 않고 false
		}
		System.out.println("A=" + a); // a =?

		if (a > 1 || ++a > 3) {
			System.out.println("조건 만족2"); // or 하나만 true 여도 뒷 연산을 실행 하지 않음
		}
		System.out.println("A=" + a);
		
		
	} // 이진 논리로 사용하면 두개다 연산한 결과 값이 나옴
		// A =4
		// 조건만족 2
		// A=5
//	if (a > 3 & ++a > 3) {
//		System.out.println("조건 만족"); 
//	}
//	System.out.println("A=" + a); 
//
//	if (a > 1 | ++a > 3) {
//		System.out.println("조건 만족2"); 
//	}
//	System.out.println("A=" + a);
}