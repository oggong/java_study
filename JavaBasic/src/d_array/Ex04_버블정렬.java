package d_array;

//	[선택1] 삽입정렬 + 선택정렬

//	[선택2] 퀵정렬 + 힙정렬 + 머지정렬

public class Ex04_버블정렬 {

	public static void main(String[] args) {

		int[] arr = { 22, 15, 13, 7, 35, 25 };

//		for (int j = 0; j < 5; j++) {
//			if (arr[j] > arr[j + 1]) {
//				int temp = arr[j]; // 임시변수에 첫번째 값 대입
//				arr[j] = arr[j + 1];
//				arr[j + 1] = temp; // 값 맞바꾸기
//			}
//		}
		
//---------------------------------------------------------------
		
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j]; // 임시변수에 첫번째 값 대입
					arr[j] = arr[j + 1];
					arr[j + 1] = temp; // 값 맞바꾸기
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "/");

		}
	}

}
