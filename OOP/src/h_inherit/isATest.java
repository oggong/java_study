package h_inherit;

import java.awt.*;


// 부모의 멤버를 마음대로 쓰고싶어서 ===== 상속

public class isATest extends Frame {

	isATest(){
		
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		isATest test = new isATest();

	}

}
