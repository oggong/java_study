package model.vo;

public class pos {

	// 주문번호,메뉴,가격,개수
	String pno;
	String pname;
	int price;
	
	public pos(String pno, String pname, int price) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}

	public pos() {
		
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
}
