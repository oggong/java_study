package a_sample;

/*
	Java GUI
	- WEB으로 많이 만듦
		-AWT - 1.2 이전
		-Swing - 1.2 이후
		
		java = write once run anywhere
*/

import java.awt.*;
import javax.swing.*;

public class AwtTest extends JFrame {
	// 1. 멤버변수 선언
	JButton b1;
	JButton b2;
	JTextField tf;
	JTextArea ta;
	JRadioButton rb1;
	JRadioButton rb2; // 대문자 J 붙히면 됨

	AwtTest() {
		super("나의 두번째 창");
		// 객체 생성
		b1 = new JButton("ok");
		b2 = new JButton("cancel");
		tf = new JTextField(30);
		ta = new JTextArea(10, 50);

		rb1 = new JRadioButton("male");
		rb2 = new JRadioButton("female");

		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);

	}

	void addLayout() {
		// 3. 붙이기

//		FlowLayout fl = new FlowLayout();
//		setLayout(fl);
//		================줄여서 쓰기
//		setLayout(new FlowLayout()); // 윗줄 상단 중앙에 배치 - 컴포넌트의 크기가 고정
//		setLayout(new GridLayout(3, 2)); // 행과 열에 배치
		setLayout(new BorderLayout()); // NORTH,SOUTH,CENTER,WEST,EAST , 영역에 배치

		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.SOUTH);
		add(tf, BorderLayout.WEST);
		add(ta, BorderLayout.CENTER);
		add(rb1, BorderLayout.EAST);
		add(rb2, BorderLayout.EAST);
		JPanel p = new JPanel();
		p.add(rb1);
		p.add(rb2);

		add(p, BorderLayout.EAST);

		// 4. 화면에 출력
		setSize(600, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		AwtTest at = new AwtTest();
		at.addLayout();
	}

}
