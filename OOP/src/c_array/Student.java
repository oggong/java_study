package c_array;

// 클래스 = 서로다른 자료형의 변수들 + 메소드들

public class Student {

	private String name;

	private int kor, eng, math;
	private int total;
	private double avg;

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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	// 멤버 변수 출력하기 위한 메소드
	public String toString() {
		return name + "학생 총점:" + total + "/평균:" + avg;
	}
}
