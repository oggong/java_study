package e_method;

import java.util.Scanner;


public class Ex03_성적 {

	static int sum;
	static int avg;

	public static void main(String[] args) {
		int[] arr = input();
		calc(arr);
		output();

	}

	static int[] input() {
		// 국영수 점수를 입력 받기
		Scanner input0 = new Scanner(System.in);
		System.out.println("입력하세요");
		int kor = input0.nextInt();

		Scanner input1 = new Scanner(System.in);
		int eng = input1.nextInt();

		Scanner input2 = new Scanner(System.in);
		int math = input2.nextInt();

		int[] arr = { kor, eng, math };
		return arr;
	}

	static void calc(int[]arr) {
		// input() 에서 입력 받은 점수들의 합과 평균을 구하기
		sum = 0;
		avg = 0;
		sum = arr[0] + arr[1] + arr[2];
		avg = (arr[0] + arr[1] + arr[2]) / 3;

	}

	static void output() {
		// calc() 구한 합과 평균을 출력
		System.out.println("합: " + sum + " 평균:" + avg);
	}

}
