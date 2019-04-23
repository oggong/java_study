package g_exception;

/*
	오류
		-에러: 심각한 오류
		-예외: 심각하지 않은 오류
		
	(1) 예외를 잡자 - try ~ catch 구문
		try {
			예외 발생할 구문
		}catch(){
			예외가 발생한 후의 구문
		}finally{
			예외 발생 여부 상관없이 무조건 실행 구문
		}
*/

public class Ex01_TryCatch {

	public static void main(String[] args) {

		String[] str = { "맛점", "우산", "즐거운화요일" };

		try {

			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i]);
			}
			System.out.println("예외가 발생할 여지가 있는 구문");
//			return; // return을 사용 해도 finally 는 출력 
		} catch (Exception ex) {
			// TODO: handle exception 사후 처리 및 에러 메시지 띄워야!
			System.out.println("예외 발생" + ex.getMessage()); // ex.toString() 도 사용하기도 함

			ex.printStackTrace();
		} finally {
			System.out.println("무조건 실행 구문"); // 무조건 실행 하는 것은 왜 쓰는 것인가 !!!!!!!!!!!!
		} // connection 닫는 부분!
			//
		System.out.println("프로그램 정상 종료");
	}

}
