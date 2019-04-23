package e_method;

public class Ex06_WrongOverLoading {

	public static void main(String[] args) {
		String msg = "안녕";
		output1(msg);
//		String result = output(msg);
		String result = output2(msg);
	}
	static void output1(String msg) {
		System.out.println(msg);
	}
//	static String output(String msg) {
//		String result = "맞점";
//		return result;
//	}			이것의 문제를 해결 하기 위해선 메소드 이름 바꿔 줘야 합니다.
	static String output2(String msg) {
		String result = "맞점";
		return result;
	}
}

