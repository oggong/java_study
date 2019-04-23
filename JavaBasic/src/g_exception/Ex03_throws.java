package g_exception;

import java.io.FileInputStream;

public class Ex03_throws {

	public static void main(String[] args) {
		try {
			readFile();
			System.out.println("파일처리");
		} catch (Exception e) {
			System.out.println("예외발생");
		}
	}

	static void readFile() throws Exception { // 모든 발생한 예외를 넘기겠다
		FileInputStream fis = new FileInputStream("xxx.txt");
		System.out.println("파일 연결");
	}

}
