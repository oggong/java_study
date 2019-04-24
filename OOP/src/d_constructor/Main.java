package d_constructor;

// 클래스 = 서로다른 자료형의 변수들 + 메소드들
/*
	캡슐화 = 권한관련부여
	1. 멤버변수 - private -- 다른 클래스에서 접근 허용 안됨 
	
	
	2. 멤버 메소드 - public 모든 접근 허용
*/
public class Main {

	public static void main(String[] args) {

		Student s2 = new Student("홍길동", 100, 80, 70);

		/*
		 * System.out.println("이름 :" + s2.getName()); System.out.println("총점 :" +
		 * s2.calTotal()); System.out.println("평균 : " + s2.calAverage());
		 */
		
		Student s = new Student();
//		s.setName("홍길동");
//		s.setEng(88);
//		s.setMath(77);
		/*
		 * System.out.println("이름 :" + s.getName()); System.out.println("총점 :" +
		 * s.calTotal()); System.out.println("평균 : " + s.calAverage());
		 */
	} // end of main

}// end of class
