package b_operator;

/*
	shift : 모든 비트의 값을 이동하는 연산자
	
	>> : 오른쪽으로 이동
	<< : 왼쪽 이동 
	>>> : 오른쪽으로 이동 하나 (무조건 부호에 0)
	
	잘 사용 하지 않는다 !!!!!
*/

public class Ex07_shift {

	public static void main(String[] args) {

		int a = -4;
		System.out.println(a >> 2); // 0100 --> 0001 1 
		System.out.println(a << 1); // 0100 --> 1000 8
		System.out.println(a>>>1); // 어마무시한 큰수가 된다
	}

}
