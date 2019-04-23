package d_array;

import java.util.Scanner;

public class Ex07_baseball {

	public static void main(String[] args) {

		int baseball[] = new int[3]; // 1. 컴퓨터 랜덤 수 3개 넣을 배열 선언

		for (int i = 0; i < baseball.length; i++) {
			baseball[i] = (int) (Math.random() * 9) + 1;
			for (int j = 0; j < i; j++) { // 랜덤으로 설정한 수 3개의 중복 제거
				if (baseball[i] == baseball[j]) {
					j--;
				}
			}
			System.out.print(baseball[i]); // 랜덤으로 잡은 수 임시로 출력
		}
		System.out.println();

		int answer[] = new int[3]; // 2. 사용자가 입력 할 수를 넣을 배열 선언
		STRIKE: for (int n = 0; n < 10; n++) { // 10번 시도 할수 있게 설정
			Scanner input = new Scanner(System.in); // 입력
			for (int i = 0; i < answer.length; i++) {
				System.out.println("숫자를 입력:");
				answer[i] = input.nextInt();
			}

			// 3. baseball 배열과 answer 배열을 각각 비교

			int strike = 0, ball = 0; // 초기화
			for (int i = 0; i < baseball.length; i++) {
				for (int j = 0; j < answer.length; j++) {

					if (baseball[i] == answer[j] && i == j) {
						strike++; // 자리 위치까지 같다면 strike ++
					} else if (baseball[i] == answer[j] && i != j) {
						ball++; // 위치는 다르면 ball++
					}

				}

			}
			if (strike == 3) { // 3strike 이라면 반복문 종료
				System.out.println("게임 끝");
				break STRIKE;
			} else {
				System.out.println(strike + " " + ball);
			}

		}

	} // end of main
}// end of class
