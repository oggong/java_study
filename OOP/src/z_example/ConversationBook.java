package z_example;

public class ConversationBook extends Book {

	public String language;

	public ConversationBook(String productID, String description, String producer, String price, String ISBN,
			String author, String title) {
		super(productID, description, producer, price, ISBN, author, title);
		this.language = language;

	}

	public void showInfo() {
		System.out.println("언어 >>"+language);
	}
}
