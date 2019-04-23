package b_encapsulation;

// 클래스 = 서로다른 자료형의 변수들 + 메소드들

public class Student {

	private String name;

	private int kor, eng, math;
	private int total;
	private double avg;

	int calTotal() {
		total = kor + eng + math;
		return total;
	}

	double calAverage() {
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
