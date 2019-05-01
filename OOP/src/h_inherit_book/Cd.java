package h_inherit_book;

// 미완ㅅ

import h_inherit_book.sub.Item;

public class Cd extends Item {

	String singer;

	public Cd() {
		System.out.println("Cd 기본 생성자");
	}

	Cd(String no, String title, String singer) {
		super(no, title);

		this.singer = singer;
		System.out.println("Cd 인자 생성자");
	}

	public void output() {
	}
}
