package e_method;

public class Ex07_CallByValue {

	public static void main(String[] args) {
		int a = 10, b = 20;
		add(a, b);
		System.out.println("2.A=" + a + ",B=" + b);

	} //기본형 데이터의 경우 메서드에서 해당 데이터를
	
		// 단, 기본형에서도 메서드를 통해 값 변경 하고 싶은 경우에 return사용

	static void add(int a, int b) {
		a += b;
		System.out.println("1.A=" + a + ",B=" + b); //1.
	}
}
