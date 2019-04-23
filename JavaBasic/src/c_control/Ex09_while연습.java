package c_control;

/*
 * [ 3,6,9 게임]
 * 
 * 1 ~ 50 까지 숫자 중에서 3,6,9 포함 되면 그 갯수만큼 '짝' 출력
 * 
 * 하나도 포함되어 있지 않으면 그 숫자 출력
 * 
 * 
 * 
*/
public class Ex09_while연습 {

	public static void main(String[] args) {

//		for (int i = 1; i <= 50; i++) {
//			int mok = i; // i라는 원본 숫자를 mok 으로 복사 넣어 놓기
//			boolean su369 = false; // 초기값 false 지정
//
//	
//			while (mok != 0) {
//				int na = mok % 10;
//				if (na == 3 || na == 6 || na == 9) {
//					System.out.print("짝");
//					su369 = true;
//				}
//				mok /= 10;
//			}
//			if (su369) {
//				System.out.println();
//			} else {
//				System.out.print(i);
//			}
//		}
//-------------------------------------------------------------------------

		int sum = 0;

		for (int i = 1; i <= 10000; i++) {
			int mok = i;

			while (mok != 0) {
				int na = mok % 10;

				if (na == 8) {

					sum += 1;
				}
				mok /= 10;
			}

		}
		System.out.println(sum);
	}
}
