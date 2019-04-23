package a_datatype;

import java.util.*; // Scanner 사용 하려면 import 해줘야 함.
					// documentation 을 봐줘야 함.
// import java.util.Scanner;

public class Ex05_Scanner {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); 
		
		System.out.print("학생이름 입력하세요.");
		String name = input.nextLine(); // 문자열 처리 nextLine;
										// next 도 가능;
		// 학생명을 입력 받아서 점수를 출력
		
		System.out.print("국어점수 => ");
		int kor = input.nextInt();

		System.out.print("영어 점수 =>");
		int eng = input.nextInt();

		System.out.print("수학 점수 =>");
		int math = input.nextInt();

		// 총점을 구해서 출력
		int total = kor + eng + math;
		System.out.println("총점 : " + total);

		// 평균 구하기
		double avg = (double) total / 3; // int 와 int 계산을 하면 int 로 결과 값이 나옴
		// total 을 double 형으로 변환 해줘야 함
		System.out.println("평균 : " + avg);

	}

}
