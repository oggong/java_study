package d_array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Example3 {

	public static void main(String[] args) {

		System.out.println("학생 수:"); // 학생 수 입력
		Scanner input1 = new Scanner(System.in); // scanner

		int a = input1.nextInt(); // int 

		int[][] score = new int[a][3]; // 배열 선언

		for (int i = 0; i < a; i++) { //입력된 값 만큼 출력
			System.out.printf("%d 번째 학생의 성적을 입력 ->(국어/영어/수학)", i + 1); 
			Scanner input2 = new Scanner(System.in);
			String b = input2.nextLine();
			StringTokenizer st = new StringTokenizer(b, "/");
			for (int j = 0; j < 3; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < a; i++) {
			System.out.printf("%d 째 학생의 총점은 % d이고 평균은 %d 입니다. \n", i + 1, score[i][0] + score[i][1] + score[i][2],
					(score[i][0] + score[i][1] + score[i][2]) / 3);
		}

		String[] sub = { "국어", "영어", "수학" };

		for (int j = 0; j < 3; j++) {
			System.out.printf("%s과목 총점은 %d이고 평균은 %d입니다. \n", sub[j], score[0][j] + score[1][j] + score[2][j],
					(score[0][j] + score[1][j] + score[2][j]) / 3);
		}
	}

}