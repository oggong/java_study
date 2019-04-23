package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01_성적 {

	public static void main(String[] args) {

		// int []kor;도 가능 /// 미국의 개발자들은 후자 권장
		int kor[] = new int[5];
		Scanner input = new Scanner(System.in);
		System.out.println("점수 입력(ex)12/13/14");
		String score = input.nextLine();
		StringTokenizer st = new StringTokenizer(score,"/");

		for (int i = 0; st.hasMoreTokens(); i++) {
			kor[i] = Integer.parseInt(st.nextToken());
		}

//		for (int i = 0; i < 5; i++) {
//
//			kor[i] = input.nextInt();
//		}

		// 총점 구하기
		int total = 0;

		for (int i = 0; i <= 4; i++) {
			total += kor[i];

		}
		System.out.println(total);
	}

}
