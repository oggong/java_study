package h_inherit_book;

import h_inherit_book.sub.Item;
// 자식 클래스

public class Book extends Item { // 관계 맺기

	// 부모것을 사용 가능 하니 여기는 내것만 일단 사용
	String writer;
	String publisher;

	public Book() {
		System.out.println("Book 기본 생성자");
	}

	Book(String no, String title, String writer, String publisher) {
		super(no, title); // 제일 상단에 올라와야 함! 부모 생성자 함수 부르려면 == 본인것은 본인 자리에서 생성해주세요1!!

//		super.no = no; // 내 객체를 접근 할때는 this 부모 객체를 접근 할때는 super
//		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		System.out.println("Book 인자 생성자");
	}

	public void output() {
	}

}
