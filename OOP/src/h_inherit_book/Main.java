package h_inherit_book;

import h_inherit_book.sub.Item;

public class Main {

	public static void main(String[] args) {

		Item i = null;
//		Book b  = new Book(); // 객체가 잘 넘어가는지 일단 확인
//		b.output();
//	
//		Book b2 = new Book("0001","자바","아무개","엔코아");
//		// Book 의 인자 있는 생성자를 호출
//		b2.output();
		System.out.println("항목을 선택하세요(1.Book 2.Dvd 3.Cd)->");
		int sel = 1;
		switch (sel) {
		case 1:
			new Book(/* 초기값 */);
			break;
		case 2:
			new Dvd(/* 초기값 */);
			break;
		case 3:
			new Cd(/* 초기값 */);
			break;
		}
		i.output(); // 다형성
		
	}

}
