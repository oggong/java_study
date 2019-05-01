package c_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestB extends JFrame implements ActionListener {

	JButton b;
	JTextField tf;

	TestB() {
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

	// 이벤트 구현
	void eventProc() {
		b.addActionListener(this);
		tf.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "이벤트 발생");
	}

	public static void main(String[] args) {

		TestB t = new TestB();
		t.addLayout();
		t.eventProc();

	}

}
