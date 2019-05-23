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
	Font f = new Font("맑은 고딕",Font.BOLD,15);

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
		p_north.setBorder(new TitledBorder("제품"));

		p_north.add(new JLabel("아메리카노",SwingConstants.CENTER)); // 라벨 들어갈 내용 중앙 정렬
		p_north.add(new JLabel("카페라떼",SwingConstants.CENTER));
		p_north.add(new JLabel("카페모카",SwingConstants.CENTER));
		p_north.add(bAmericano, new ImageIcon());
		p_north.add(bCafelatte);
		p_north.add(bCafemoca);
		p_north.add(new JLabel("레몬에이드",SwingConstants.CENTER));
		p_north.add(new JLabel("베이글",SwingConstants.CENTER));
		p_north.add(new JLabel("우유",SwingConstants.CENTER));
		p_north.add(bLemonade);
		p_north.add(bBagel);
		p_north.add(bMilk);
		p_north.add(new JLabel("케이크",SwingConstants.CENTER));
		p_north.add(new JLabel("물",SwingConstants.CENTER));
		p_north.add(new JLabel("맥주",SwingConstants.CENTER));
		p_north.add(bCake);
		p_north.add(bWater);
		p_north.add(bBeer);

		// 아래쪽 영역 - 주문,결제
		JPanel p_south = new JPanel();
		p_south.setLayout(new BorderLayout());
//		p_south.setBorder(new TitledBorder("south"));

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
