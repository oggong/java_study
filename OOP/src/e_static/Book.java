package e_static;

/*
	static 변수 : 각 객체에서 공유 하려고 각 메모리당 하나씩만
	static 변수는 클래스명 접근이 가능!
	(그래서 static 변수 = 클래스 변수)
*/
public class Book {
	private static int count; // 아무도 객체를 생성하지 않아도 static 은 메모리에 값을 넣어줌
						// 클래스명 접근 가능
	int temp;

	public Book() {
		count++;
		temp ++;
		System.out.println("책 한권 생성");
	}

	public static int getCount() {
		return count;
	}
}
