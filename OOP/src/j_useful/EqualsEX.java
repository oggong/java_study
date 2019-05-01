package j_useful;

public class EqualsEX {

	public static void main(String[] args) {
		Student a = new Student("123123", "홍길동");
		Student b = new Student("343445", "이바돔");

		if (a.equals(b)) {
			System.out.println("동일인");
		} else {
			System.out.println("다른학생");
		}
		System.out.println(a.toString());
		System.out.println(b);

	}

}

class Student {
	String hakbun, name;

	public Student() {
	}

	public Student(String hakbun, String name) {
		this.hakbun = hakbun;
		this.name = name;
	}

	public boolean equals(Object obj) {

		Student other = (Student) obj;
		if (hakbun.equals(other.hakbun))
			return true;
		else
			return false;
	}

	public String toString() {
		return "[" + hakbun + "]" + name;
	}
}
