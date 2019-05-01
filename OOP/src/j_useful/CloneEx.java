package j_useful;

import java.util.Arrays;

public class CloneEx {

	public static void main(String[] args) {

		String[] array = { "안녕", "헬로우", "올라", "곤니찌와" };
		// String [] copy = array; // 얇은 복사
		String[] copy = array.clone(); // 깊은 복사
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.deepToString(copy));

		copy[1] = "Hello";
		copy[2] = "Hola";

		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(copy));

	}

}
