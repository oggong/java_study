package e_method;

/*
	overloading 
		:동일한 이름의 메소드들
		- 인자의 자료형과 갯수 달라야 함
		
		[주의 할 점]	add(1,2)
			int add (int a, int b){}
			double add (int x, int b){} ------ compile 에러 
			리턴 형만 다르면 컴파일 오류 발생
*/
public class Ex05_overloading {

//	static void addIntDouble(int c, double d) {
//		System.out.println(c + d);
//	}  ------------------------------------여기 입력해도 사용 가능 !!!

	public static void main(String[] args) {
		int a = 5, b = 7;
//		addInt(a, b); // 메소드의 첫글자는 소문자 // 그러다가 중간에 대문자로 해주는것을 권장 //카멜 표기법 == 낙타표기법
		add(a, b);
		int c = 3;
		double d = 3.6;
//		addIntDouble(c, d);
		add(c, d);
	}

//	인자와 자료형 비교
	static void add(int a, int b) {
		System.out.println(a + b);
	}

// 메소드명은 동일해도 되지만 인자의 자료형은 같아야 한다. // 다르려면 인자의 자료형과 갯수가 달라야 함!
	static void add(int c, double d) {
		System.out.println(c + d);
	}

}
