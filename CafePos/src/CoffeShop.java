import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.CafePosView;
import view.SalesView;
import view.StockView;


public class CoffeShop extends JFrame {
	
	CafePosView cafepos;
	SalesView sales;
	StockView stock;
	
	public CoffeShop() {
		// 각각의 화면을 관리하는 클래스 객체 생성 
		cafepos = new CafePosView();
		sales = new SalesView();
		stock = new StockView();
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("판매 탭", cafepos );
		pane.addTab("재고 탭", stock );
		pane.addTab("매출 탭", sales);

		pane.setSelectedIndex(0);

		// 화면 크기 지정
		add("Center", pane);
		setSize(800,600);
		setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {

		new CoffeShop();
	}

}
