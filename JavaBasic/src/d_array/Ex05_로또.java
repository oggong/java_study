package d_array;

public class Ex05_로또 {

	public static void main(String[] args) {

//		int[] lotto = new int[6];
		int[][] lotto = new int[5][6];

		// 로또 번호 생성 !!!!(5줄 6개)!

		for (int i = 0; i < lotto.length; i++) { // 2차원 배열 length는 5

			for (int j = 0; j < lotto[i].length; j++) { //
				lotto[i][j] = (int) (Math.random() * 45) + 1; // 숫자를 랜덤으로 받는 부분!
				// 같은 숫자인지 비교
				for (int k = 0; k < j; k++) {
					if (lotto[i][k] == lotto[i][j]) {
						j--;
					}
				}

				// 랜덤 함수 = 랜덤으로 반환 해줌 --- int 로 하면 소수점 다 날라감 !
				// 로또 번호 6개 잡음
				// but 동일한 숫자를 못잡음 !!!!!!!!!!!!!!@!!!!!!@!@!@!@!@!@!@

			}
		}
		// 정렬

//		for (int i = arr.length - 1; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				if (arr[j] > arr[j + 1]) {
//					int temp = arr[j]; // 임시변수에 첫번째 값 대입
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp; // 값 맞바꾸기
//				}
//			}

		for (int k = 0; k < lotto.length; k++) { // 행
			for (int i = lotto[k].length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) { // 열
					if (lotto[k][j] > lotto[k][j + 1]) {
						int temp = lotto[k][j];
						lotto[k][j] = lotto[k][j + 1];
						lotto[k][j + 1] = temp;
					}
				}
			}
		}

		// 출력
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lotto[i].length; j++) {
				System.out.print(lotto[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
