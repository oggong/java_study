package b_encapsulation;

// 클래스 = 서로다른 자료형의 변수들 + 메소드들
/*
	캡슐화 = 권한관련부여
	1. 멤버변수 - private -- 다른 클래스에서 접근 허용 안됨 
	
	
	2. 멤버 메소드 - public 모든 접근 허용
*/
public class Main {

	public static void main(String[] args) {

		Student s = new Student();

		s.setName("홍길동"); // s 에다가 홍길동을 기술하자 !
		s.setKor(100); // s.kor = 100;
		s.setEng(88);
		s.setMath(77);
		System.out.println("이름 :" + s.getName());
		System.out.println("총점 :" + s.calTotal());
//		s.total = 300;
		System.out.println("평균 : " + s.calAverage());
	}

}
