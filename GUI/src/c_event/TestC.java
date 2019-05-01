package c_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestC extends JFrame {

	JButton b;
	JTextField tf;

	TestC() {
		b = new JButton("눌러봐 버튼");
		tf = new JTextField("입력해봐", 20);

	}

	void addLayout() {
		setLayout(new FlowLayout());

		add(b);
		add(tf);

		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void eventProc() {

// 1.		
//		MyEvent evt = new MyEvent();
//		b.addActionListener(evt);
//		==================================
// 2.
//		b.addActionListener(new MyEvent());
//		========================================
		// 변수를 생성 하고 여러번 쓰지 않을때 줄여주기 (개발자 코딩을 줄이면 줄일 수록 good)

//		class MyEvent implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			JOptionPane.showMessageDialog(null, "이벤트 발생");
//		}
//	}
// ============================================================= 
// 3.

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "이벤트 발생");
			}
		});
		tf.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "이벤트 발생2");
			}
		});
	}

	public static void main(String[] args) {

		TestC t = new TestC();
		t.addLayout();
		t.eventProc();

	}

}
