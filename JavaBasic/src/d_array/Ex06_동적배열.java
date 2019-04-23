package d_array;

public class Ex06_동적배열 {

	public static void main(String[] args) {

		char[][] star = new char[4][];
		// 값지정
		for (int i = 0; i < star.length; i++) {

			star[i] = new char[i + 1]; // star.length를 1번째는 1번 2번째는 2개 --> 서로다른 배열 갯수
//			4열로 4개를 만드는것 x
//			1열 메모리 

			for (int j = 0; j < i + 1; j++) {
				star[i][j] = '*';

			}
		}
		// 출력
//		*
//		**
//		***
//		****

		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
	}
}
