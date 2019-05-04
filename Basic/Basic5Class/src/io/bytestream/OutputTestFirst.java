package io.bytestream;

/*
	===========================================================
	OuputStream을 구현한 FileOutputStream을 이용한 예제
	===========================================================
	
	@ write( int )
		` 0-255 사이의 정수를 인자로 받아 해당하는 바이트를 출력스트림에 쓴다
		` 인자로 정수형을 받지만, 실제로는 부호없는 바이트로 전송
		  ( 자바에서 정수형은 32bit이지만 그 중 8bit만 사용 )
	
	
	
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputTestFirst {
	public static void main(String args[]) {
		try {
			FileOutputStream fos = new FileOutputStream("a.txt"); // FileOutputStream은 기본적으로 예외 발생 --- try catch 필수

			for (int ch = 'A'; ch <= 'Z'; ch++) {
				fos.write(ch);
			}
//			fos.write(100); // byte 2byte 둘다 표시 x
//			fos.write('축'); // byte 단위로만 주고 받을수 있기 때문에 2byte로 보낸다면 한글표시가 가능. 

			fos.close(); // 통로를 열였으면 닫아야함.!
			// try catch 필수

		} catch (IOException ex) {
			System.out.println("파일전송실패 :" + ex.toString());
		}
	}
}

/****************************************************
 * a.txt 를 노트패드와 워드패드로 읽어보기
 */