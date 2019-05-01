package h_inherit_book;

import h_inherit_book.sub.Item;

public class Dvd extends Item {

	String actor;
	String director;

	public Dvd() {
		System.out.println("Dvd 기본 생성자");
	}

	Dvd(String no, String title, String actor, String director) {
		super(no, title);

		this.actor = actor;
		this.director = director;
		System.out.println("Dvd 인자 생성자");

	}

	public void output() {
	}
}
