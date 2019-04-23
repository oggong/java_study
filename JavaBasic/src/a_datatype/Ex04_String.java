package a_datatype;

public class Ex04_String {

	public static void main(String[] args) {
//		String a;
//		a = new String("홍길동");
		
		String a = "홍길동"; // 홍길동 과 홍길동 이 같음 -----> 비정상 new 를 비사용( 정확하게 하려면 이것은 사용 하지 말아야 함)
		String b = "홍길동"; // 더 혼동이 오게 됨 !! 
		
		
//		String a = new String("홍길동"); 홍길동 과 홍길동은 다름  -------> 정상 new 를 사용 (주소가 다르므로 다름)
//		String b = new String("홍길동");
		
		
		if (a == b) {
			System.out.println("같다");
			
		} else {
			System.out.println("다르다");
		}
	
		if(a.equals(b)) { // String 의 같음을 비교 하려면 .equals 를 사용하여 비교 하기! 동등 연산자는 -> 주소를 물어보는 것
			System.out.println("이름이 같다");
			
		} else {
			System.out.println("이름이 다르다");
		}
	}

}
// String 은 클래스 
// new 라는 것을 쓰면 메모리 구조체가 달라짐 
// 현 자바개발자도 혼동 하는 부분들 
