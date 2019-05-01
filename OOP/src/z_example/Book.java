package z_example;

import java.util.Scanner;

public class Book extends Product {

	private String ISBN;
	private String author;
	private String title;

	public Book(String productID, String description, String producer, String price, String ISBN, String author,
			String title) {
		super(productID, description, producer, price);
		this.ISBN = ISBN;
		this.author = author;
		this.title = title;
	}

	public void showInfo() {
		System.out.println("ISBN >>" + ISBN);
		System.out.println("author >>" + author);
		System.out.println("title >>" + title);

	}
}
