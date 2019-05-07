package lifeproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_bucketlist extends JFrame {
	// 멤버 변수 생성
	JButton[] menu = new JButton[9];

	// 객체 생성
	public Main_bucketlist() {
		for (int i = 0; i < menu.length; i++) {
			menu[i] = new JButton();
//		(new ImageIcon("src/img/" + (i + 9) + ".png"));
		}
	}

	void addLayout() {
		setLayout(new BorderLayout());
		JPanel p = new JPanel(new GridLayout(3, 3));
		for (int i = 0; i < menu.length; i++) {
			p.add(menu[i]);
		}

		// 사이즈 설정 및 보여지기
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 이벤트 등록
	void eventProc() {
		BtnHdlr bh = new BtnHdlr();
		for (int i = 0; i < menu.length; i++) {
			menu[i].addActionListener(bh);
		}

	}

	// 버튼 이벤트 핸들러 클래스 생성
	class BtnHdlr implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton evt = (JButton) e.getSource();
			for (int i = 0; i < menu.length; i++) {
				evt = menu[i];
			}
		}

	}

	public static void main(String[] args) {
		Main_bucketlist mb = new Main_bucketlist();
		mb.addLayout();
		mb.eventProc();

	} // end of main

}// end of Main_bucketlist
