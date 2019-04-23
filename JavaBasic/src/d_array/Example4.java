package d_array;

public class Example4 {

	public static void main(String[] args) {
		/*
		 * // [문제] // // 동적크기로 합이 가장 큰 행을 출력하기 // int a[][]=new int[][]{{3,-5, 12 },
		 * {-2, 11, 2, -7}, {21, -21, -35, -93, -11}, {9, 14, 39, -98}}; // // 결과 : 0행
		 * // //
		 */

		int a[][] = new int[][] { { 3, -5, 12 }, { -2, 11, 2, -7 }, { 21, -21, -35, -93, -11 }, { 9, 14, 39, -98 } };

		int sum0 = 0, sum1 = 0, sum2 = 0, sum3 = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

			}
		}

		for (int j = 0; j < a[0].length; j++) {

			sum0 += a[0][j];
		}
		System.out.println(sum0);

	}

}
