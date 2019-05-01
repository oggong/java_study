package l_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx2 {

	public static void main(String[] args) {

		ArrayList<Student> data = method();
		// 여기서 출력

//		for (Student a : data) {
//			System.out.println(a);
//		}

		// 표준화 출력
		// Enumeration -> Iterator
		Iterator it = data.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

//		for (int i = 0; i < data.size(); i++) {
//			Student s = (Student) data.get(i);
//			System.out.println(s);
//		}
	}

	static ArrayList method() {
		Student a = new Student("홍길자", 20);
		Student b = new Student("홍길숙", 30);
		Student c = new Student("홍동자", 40);
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(a);
		list.add(b);
		list.add(c);
		return list;
	}
}

class Student {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public String toString() {
		return name + "학생은" + age + "세 입니다.";
	}
}
