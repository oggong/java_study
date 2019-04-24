package a_basic;

//object oriented programming 객체 지향형 언어 


// 자바에서는 인스턴스 라고 지칭 함 


public class Main {
// 클래스 = 서로다른 자료형의 변수들 + 메소드들
	
	
	public static void main(String[] args) {

		Student s = new Student(); // Student 라는 클래스를 s 로 선언 하겠다.
		
		// 메모리상의 덩어리를 객체라고 하겠다 .  
		
		s.name = "홍길동"; // s 에다가 홍길동을 기술하자 !
		s.kor = 100;
		s.eng = 88;
		s.math = 77;
		System.out.println("총점 :" + s.calTotal());
		s.total = 300;
		System.out.println("평균 : " + s.calAverage());
	}

}
