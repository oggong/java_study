package c_array_1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("입력할 학생수는?");
		int a = input.nextInt(); // 입력: 3 + 엔터
		input.nextLine(); // 버퍼가 남아 있음 버퍼를 ->

		Student[] s = new Student[a];

//		for (int i = 0; i < s.length; i++) { 인덱스 하려면 오리지널 for 문!
		for (Student stu : s) { // 향상된 for문은 데이터 추출할때만 쓰는 걸로 !

			System.out.println("학생 정보 입력 (예) 홍길동/20/30/40");
			String info = input.nextLine();
			StringTokenizer st = new StringTokenizer(info, "/");

			String name = st.nextToken();

			int kor = Integer.parseInt(st.nextToken());
			// parseInt 는 static int 이기때문에 class 명 접근이 가능
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			stu = new Student(name, kor, eng, math);
			// 초기화 = 객체 생성 + 값 지정
			// 메모리 할당 받고 바로 초기화

			stu.calTotal();
			stu.calAverage();

			System.out.println(stu);

		}

	}

}
