package a_basic;

public class Main {

	public static void main(String[] args) {

		Student s = new Student();
		s.name = "홍길동"; // s 에다가 홍길동을 기술하자 !
		s.kor = 100;
		s.eng = 88;
		s.math = 77;
		System.out.println("총점 :" + s.calTotal());
		s.total = 300;
		System.out.println("평균 : " + s.calAverage());
	}
}
