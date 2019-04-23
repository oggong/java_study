package e_method;

public class Ex02_인자와반환3 {

	public static void main(String[] args) {
		int [] arr = add();
		
		// 합을 계산
		
		int sum = arr[0]+arr[1];
		
		System.out.println("합:" + sum);
	}

	static int[] add() { // arr 의 자료형은 int[] 로 해주면 됨!
		int a = 10, b = 20;
		// 입력 받기
		int[] arr = { a, b };
		// a b 를 하나의 값으로 만들어서 보내주기 위해 배열 선언
		return arr;
	}

}
