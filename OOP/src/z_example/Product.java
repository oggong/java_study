package z_example;

public class Product {

	private String productID;
	private String description;
	private String producer;
	private String price;

	
	
	public Product(String productID, String description, String producer, String price) {
		this.productID = productID;
		this.description = description;
		this.producer = producer;
		this.price = price;
	}

	public void showInfo() {
		System.out.println(""+productID);
		System.out.println(""+description);
		System.out.println(""+producer);
		System.out.println(""+price);
	}

}
