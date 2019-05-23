package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

public class CafePosView extends JPanel {
	// 멤버 변수 선언
	JButton bAmericano, bCafelatte, bCafemoca, bLemonade;
	JButton bBagel, bMilk, bCake, bWater, bBeer;

	JTextArea taOrderPrice;
	JButton bPayment, bCancel;

	// 멤버 객체 선언
	public CafePosView() {
		addLayout();
		connectDB();
		eventProc();

	}

	public void eventProc() {
		// 이벤트 등록
	}

	public void connectDB() {
		// DB연결
	}

	public void addLayout() {
		// 화면 붙이기 및 화면 출력

		// 멤버 변수의 객체 생성
		bAmericano = new JButton();
		bCafelatte = new JButton();
		bCafemoca = new JButton();
		bLemonade = new JButton();
		bBagel = new JButton();
		bMilk = new JButton();
		bCake = new JButton();
		bWater = new JButton();
		bBeer = new JButton();

		taOrderPrice = new JTextArea();
		bPayment = new JButton("결제");
		bCancel = new JButton("취소");

		// *****************************************************************
		// 화면 구성

		// 위쪽 영역 - 상품
		JPanel p_north = new JPanel();
		p_north.setLayout(new GridLayout(6, 3));
		p_north.setBorder(new TitledBorder("north"));

		p_north.add(new JLabel("아메리카노"));
		p_north.add(new JLabel("카페라떼"));
		p_north.add(new JLabel("카페모카"));
		p_north.add(bAmericano);
		p_north.add(bCafelatte);
		p_north.add(bCafemoca);
		p_north.add(new JLabel("레몬에이드"));
		p_north.add(new JLabel("베이글"));
		p_north.add(new JLabel("우유"));
		p_north.add(bLemonade);
		p_north.add(bBagel);
		p_north.add(bMilk);
		p_north.add(new JLabel("케이크"));
		p_north.add(new JLabel("물"));
		p_north.add(new JLabel("맥주"));
		p_north.add(bCake);
		p_north.add(bWater);
		p_north.add(bBeer);

		// 아래쪽 영역 - 주문,결제
		JPanel p_south = new JPanel();
		p_south.setLayout(new BorderLayout());
		p_south.setBorder(new TitledBorder("south"));

		// 아래쪽 영역 - 주문
		JPanel p_south_west = new JPanel();
		p_south_west.setLayout(new BorderLayout());
		p_south_west.setBorder(new TitledBorder("주문"));
		p_south_west.add(taOrderPrice);

		// 아래쪽 영역 - 결제 버튼
		JPanel p_south_east = new JPanel();
		p_south_east.setLayout(new GridLayout(2, 1));
		p_south_east.setBorder(new TitledBorder("결제"));
		p_south_east.add(bPayment);
		p_south_east.add(bCancel);

		p_south.add(p_south_west, BorderLayout.CENTER);
		p_south.add(p_south_east, BorderLayout.EAST);

		// 전체 영역 붙히기
		setLayout(new GridLayout(2, 1));
		add(p_north, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);

	}

}
