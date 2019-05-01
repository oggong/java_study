package c_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("입력할 학생수는?");
		int a = input.nextInt(); // 입력: 3 + 엔터
		input.nextLine(); // 버퍼가 남아 있음 버퍼를 -> 

		Student[] s = new Student[a];

		
		for (int i = 0; i < s.length; i++) {

			s[i] = new Student();
			System.out.println((i + 1) + "번 학생의 정보입력 -->");
			String info = input.nextLine();
			StringTokenizer st = new StringTokenizer(info);

			s[i].setName(st.nextToken());
			s[i].setKor(Integer.parseInt(st.nextToken()));
			s[i].setEng(Integer.parseInt(st.nextToken()));
			s[i].setMath(Integer.parseInt(st.nextToken()));

			s[i].calTotal();
			s[i].calAverage();

		}
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].toString());
		}
	}

}
