package d_array;

public class Ex00_배열초기화 {

	public static void main(String[] args) {

		int a; // 변수선언(기본형) -> 메모리 확보
		a = 10; // 값 지정

		int b = 20; // 초기화

		// --------------------------------

//		int[] arr; // 변수선언(참조형) --> 원하는 메모리 확보가 아직 아님
		// new heap 메모리 확보 -- > 객체 생성
		// 선생님 만 타이핑 arr[0] = 10;
		// arr[1] = 20;
		// arr[2] = 30;

//		arr = new int[] { 3, 30, 13 }; // 배열 초기화
		// 배열, 메모리 생성, 배열 초기화

		int[] arr = { 3, 30, 13 }; // 배열, 메모리 생성, 배열 초기화

		for (int i = 0; i < arr.length; i++) { // 자바 배열 중 최고는 ---- 메모리 배열 길이(length) 값을 자동 저장됨

			System.out.print(arr[i] + " ");
		}
	}

}
