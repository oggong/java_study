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
	Font f = new Font("맑은 고딕",Font.BOLD,15);
	

	public CoffeShop() {
		try {
//			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel"); // 맥 스타일
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // 윈도우 스타일


			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
		}

		// 각각의 화면을 관리하는 클래스 객체 생성
		cafepos = new CafePosView();
		sales = new SalesView();
		stock = new StockView();

		JTabbedPane pane = new JTabbedPane();
		pane.setFont(f);
		pane.addTab("판매 탭",new ImageIcon("src/img/icon1.png"), cafepos);
		pane.addTab("재고 탭",new ImageIcon("src/img/icon2.png"), stock);
		pane.addTab("매출 탭",new ImageIcon("src/img/icon3.png"), sales);

		pane.setSelectedIndex(0);

		// 화면 크기 지정
		add("Center", pane);
		pane.updateUI();
		setSize(1600, 900);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new CoffeShop();

	}

}
