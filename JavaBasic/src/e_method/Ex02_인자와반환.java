package e_method;

// 앞으로 역할 부분을 나눠서 만들어줄것임!
// main에 모두 넣지 않기

public class Ex02_인자와반환 {

	public static void main(String[] args) {
		// 데이터 입력 받기
		int a = 10; 
		double b = 20;
		
		add(a, b); // 함수 호출  변수 a와 b 를 가져가겠다.
	}// double로 하였을 때 에러 발생 이유 = add에서 double로 변경

	static void add(int a, double b) { // main의 a 와 b 를 받아 오겠다. 인자 아규먼트 파라미터
		// 입력받은 데이타의 합을 구해서 출력
		int sum = (int)(a + b);// casting 해야 함.

		System.out.println("합:" + sum);

	}

}
