package e_static2;

public class Test { // main 

	public static void main(String[] args) {
		UserA a = new UserA(); // 1. UserA 형태의 객체를 생성 - > UserA로
		a.use(); //8

		UserB b = new UserB();
		b.use();

		UserC c = new UserC();
		c.use();
	} //end of main

}// end of class
