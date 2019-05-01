package d_constructor;

// 클래스 = 서로다른 자료형의 변수들 + 메소드들

public class Student {

	// 멤버 변수 (member field)
	private String name;

	private int kor, eng, math;
	private int total;
	private double avg;

	// 생성자 함수가 하나도 없는 경우
	// Java Compiler가 자동으로 생성(아무것도 하지 않는 역할을 하나)
	// public Student(){}
	// -> class 만들면 기본 생송자는 만든다.
	public Student() { // 초기화 하고싶어서 생성
		// this : 멤버를 지칭하기 위한 레퍼런스
		// this() : 다른 생성자 함수를 호출 ----------------- this this() 혼동 주의
		
		this("익명", 50, 50, 50); //  반드시 첫줄에 기술
//		this.name = "익명";
//		this.kor = 50;
//		this.eng = 50;
//		this.math = 50;
		System.out.println("기본 생성자 호출");
	}

	// 생성자 (멤버 변수 초기화 위해서)
	// - 클래스명과 동일한 이름의 함수
	// - 리턴형이 없음(void 안됨)
	// - 생성자 함수도 오버로딩 가능 overloading

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		System.out.println("인자 있는 생성자 호출");
	}

	// 멤버 메소드(member method)
	public int calTotal() {
		total = kor + eng + math;
		return total;
	}

	public double calAverage() {
		avg = (double) total / 3;
		return avg;
	}

// ================================================================================setter
	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getName() {
		return name;
	}

}
