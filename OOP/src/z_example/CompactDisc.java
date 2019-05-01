package z_example;

public class CompactDisc extends Product {

	private String ISBN;
	private String singer;
	private String title;

	public CompactDisc(String productID, String description, String producer, String price, String title,
			String singer) {
		super(productID, description, producer, price);
		this.ISBN = ISBN;
		this.singer = singer;
		this.title = title;
	}

	public void showInfo() {
		System.out.println("ISBN >>" + ISBN);
		System.out.println("singer >>" + singer);
		System.out.println("title >>" + title);
	}
}
