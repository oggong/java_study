package a_datatype;

public class Ex02_Caution {

	public static void main(String[] args) {
	
		// 실수형
	//	float f; // 4Byte 차지 
	//	f = 3.6; // ---> 3.6 은 8Byte 값
	//	f = 3.6F; // 4Byte 형식의 실수
		
		double f;
		f = 3.6;
		
		System.out.println("실수 :"+ f);

		
		// 문자형 - 정수형
		
		char ch;
		ch = 65;
		System.out.println("ch값:"+ch);
		
		
		int i ='a';
		
		//int i;
		//i = 'a';
		System.out.println("i값: "+ i);
		
		long l = 10000000000L; // 대문자 L을 써야함
		System.out.println("l값:"+ l);
		// int i2 = 10000000000L;
		
		
		//형 변환 - casting 
		double db = 100; // double db = (double)100; 
		System.out.println("db값:"+ db );
		//메모리를 크게 잡고 작은 메모리를 넣어도 상관 없음.
		
		
		int in = (int)100.1; // int in = 100.1; 
		System.out.println("in값 :"+in);
	}

}
