package h_inherit_book.sub;

// 부모 클래스 는 한개만 ! 

public abstract class Item {

	protected String no;
	protected String title;

	public Item() {
		System.out.println("Item 기본 생성자");
	}

	public Item(String no, String Title) {
		this.no = no;
		this.title = title;
		System.out.println("Item 인자생성자");

	}

	// abstract
	public abstract void output(); // {} // {}: 함수표시는 아무일도 하지 않지만 완벽한 함수 구현
									// 다형성, 오버라이딩을 위해 부모클래스는 item
									// 강제적으로 overriding 시키기 위해 abstract 선언
									// 무조건 받아가야함 (병장이 짬시키는것)
									// 따라서 미완성 메소드이기 때문에 item 메소드는 미완성!
	// 다형성 - 오버라이딩 필수 
	//문법적으로 오버라이딩 할때 오타나게 하는 걸 방지하게 하기 위해 abstract
}
