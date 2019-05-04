package f_numbergame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener {
	int count = 0;
	int getsu = 4;
	JButton[][] la = new JButton[getsu][getsu];

	char[][] answer = new char[getsu][getsu];

	JButton firstClick;
	int firstRow, firstCol;

	public MyFrame() {
		// 객체 셍성
		JPanel p = new JPanel();

		p.setLayout(new GridLayout(4, 4));

		for (int i = 0; i < getsu; i++) {
			for (int j = 0; j < getsu; j++) {
				la[i][j] = new JButton();
				la[i][j].addActionListener(this);
				p.add(la[i][j]);

				answer[i][j] = '0'; // 문자 초기화
			}
		}

		// 화면 출력
		add(p);
		setSize(500, 500);
		setVisible(true);

		// 이벤트 등록

	} // MyFrame 생성자 함수

	void initChar() {
		char alpha = 0; // 지역변수는 자동 초기화
		DASI: for (int i = 0; i < getsu * getsu;) {

			// 임의의 알파벳 만들기

			if (i % 2 == 0) {
				alpha = (char) ('A' + (int) (Math.random() * 26));
				for (int row = 0; row < answer.length; row++) {
					for (int col = 0; col < answer[row].length; col++) {
						if (answer[row][col] == alpha) {
							continue DASI;
						}
					}
				}
			}
			// 임의의 자리에 알파벳 넣기
			boolean ok = false;
			do {
				int row = (int) (Math.random() * getsu);
				int col = (int) (Math.random() * getsu);
				if (answer[row][col] == '0') {
					answer[row][col] = alpha;
					i++;
					ok = true;
				}
			} while (!ok);
		}
	}

	// answer에 각각의 값을 각 버튼에 지정
	void showAnswer() { // 버튼 지정
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				la[i][j].setText(String.valueOf(answer[i][j]));

			}
		}
//		try {// 예외 발생 구문 !!!
//			Thread.sleep(1000);
//		} catch (Exception e) {
//		}
//		for (int i = 0; i < answer.length; i++) { // 버튼 초기화
//			for (int j = 0; j < answer.length; j++) {
//				la[i][j].setText(null);
//
//			}
//		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton) e.getSource();
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				if (obj == la[i][j]) {
					// 첫번째 버튼인지
					if (firstClick == null) {
						firstClick = obj;
						firstRow = i;
						firstCol = j;
						firstClick.setBackground(new Color(200, 150, 0)); // red.green.blue
					} else {
						if (answer[firstRow][firstCol] == answer[i][j]) {
							count++;
							JOptionPane.showMessageDialog(null, "딩동 다음!");
							obj.setBackground(new Color(200, 150, 0));
							firstClick.setEnabled(false);
							obj.setEnabled(false);
							if (count == 8) {
								JOptionPane.showMessageDialog(null, "수고염!");
								exit();
							}
						} else {
							firstClick.setBackground(null);
						}
						firstClick = null;
					}
				}
			}
		}
	}

	void exit() {
		System.exit(0);
	}

}

public class NumberGame {

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.initChar();
		f.showAnswer();

	}

}
