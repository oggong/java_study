package h_inherit;

public class Test {

	public static void main(String[] args) {
		// 1. 클래스 생성과 메소드 호출 확인

//		Umma u = new Umma();
//		u.gene();
//		u.job();
//		u.study(); 부모 클래스에서는 자식 클래스 사용 못함
		
		/*
		 * Ddal d = new Ddal(); 
		 * d.gene(); 
		 * d.study();
		 */
//		d.job(); 자식 클래스에서는 부모 클래스에 접근 가능함  ====================focus ! *****
		
		// 2. 부모 변수에 자식 객체 생성
//		Ddal dd = new Umma(); ======= 조금 메모리를 잡아 놓고 넓게 잡으려 하는건 X
//		Umma uu = new Umma(); // 많이 메모리를 잡고 조금 사용 가능
//		uu.gene(); // ****
//		uu.job();
//		uu.study();   --- 이건 안됨!
		// 
	
		//**** overriding 
		//		- 부모자식간의 메소드명이 동일
		// 		- 인자동일/리턴형 동일
		//		- 접근지정자는 같거나 크거나 (동일하게 쓰는 것을 권장 합니다!)
		//		* 부모 변수에서 자식의 멤버 호출
		
		
		// 3. 형변환 (casting) -- 상속 관계에서만 가능
		//
//		String a  =new String("헬로우");
//		StringBuffer b = (StringBuffer)a;  --- 참조형은 형변환이 안되지만 /// 단 부모자식 관계 .. 즉, 상속 관계 에서만 가능
		
		
//		Umma u = new Umma();
//		Ddal d = (Ddal)u; 
//		Exception in thread "main" java.lang.ClassCastException: h_inherit.Umma cannot be cast to h_inherit.Ddal
	//	at h_inherit.Test.main(Test.java:40)

//		Ddal d = new Ddal();
//		Umma u = (Umma)d;
//		d.study(); // 부모 자식 간의 형변환 가능 하지만 메모리 고려 해야한다.
	
		Umma uu = new Ddal();
		uu.gene();
		uu.job();
		//study()
		
		Ddal dd =(Ddal)uu;
		dd.study();
		
		//4. instanceof 연산자
		Ddal d = new Ddal();
		if (d instanceof Ddal) {
			System.out.println("Ddal 객체임 ");
		}
		
		if (d instanceof Umma) {
			System.out.println("Umma 객체임 ");
		}
		if (d instanceof Object) {
			System.out.println("Object 객체임 "); // public class Umma 뒤에 안쓰여 있지만 
														// 자바의 모든 클래스는 Object 클래스를 받음
														// public class Umma extends Object
		}
	}
	
	
}

/*
	부모는 부모 클래스에 있는거만 사용이 가능하고 
	자식은 부모의 클래스에 있는 것과 자신의 클래스에 있는 것을 사용 할 수 있다.
*/