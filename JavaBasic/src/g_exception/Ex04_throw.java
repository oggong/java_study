package g_exception;

public class Ex04_throw {

	public static void main(String[] args) {

		try {
			readArray();
		} catch (Exception ex) {
			System.out.println("예외 발생:" + ex.getMessage()); // getMessage
		}
		System.out.println("정상 종료");
	}

	static void readArray() throws Exception { // throws 
		String str[] = { "우리는 한배", "공부즐기시기", "스터디" };

		try {
			for (int i = 0; i <= str.length; i++) {
				System.out.println(str[i]);
				
			}
		} catch (Exception e) {
			throw new MyException(); // 일부러 예외 발생 시킴
		}
	}

}
