package e_method;

public class Ex01_흐름 {

	public static void main(String[] args) {  
		System.out.println("main 시작");
		method(); // 메소드는 부르지 않으면 제어권이 넘어가지 않는다.
		
		System.out.println("main 끝");
	}// end of main

	//static 메소드에서는 static 만 접근 할 수 있음.
	
	static void method() {
		System.out.println("method 실행");
	}// end of method
}// end of class
