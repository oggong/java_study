package g_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02_TryCatch2 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
//			FileInputStream fis = new FileInputStream("abc.txt");
			fis = new FileInputStream("abc.txt");

			System.out.println("파일 연결");

			fis.read();

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일 없는 예외:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("입출력 예외:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("그외 예외처리");
		} // 외국 저자들은 catch 여러번 쓰기도 함!
		finally {
			try {fis.close();} catch (Exception e) {} //예외의 종류가 많음
		}
	}

}
