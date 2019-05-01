package Example;

/* (1) 버튼 15개 이벤트 처리 확인
 (2) 이벤트에서 1 - 숫자인 경우 
 				숫자 버튼의 숫자 값을 텍스트 필드에 출력 
 				
	        2 - 연산자인 경우
	        	멤버 변수 int su에 텍스트 필드 값을 저장 
	        	멤버 변수 char op에 연산자 버튼의 문자를 저장
	        	텍스트 필드 값을 지우기
	        	
			3 - '=' 인 경우
			텍스트필드의 숫자값 얻어오기
			op의 문자에 연산 (switch 문 이용)
			결과값을 다시 텍스트 필드에 출력 
					
*
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorEx {
	// 멤버 변수 선언
	JFrame f;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
	JButton bPlus, bMinus, bMultple, bDivision, bEqual;
	JTextField tf;
	JButton[] b = new JButton[15];

	// 멤버 객체 생성
	CalculatorEx() {
		f = new JFrame("유치원 계산기");

		for (int i = 1; i < 10; i++) {
			b[i - 1] = new JButton(String.valueOf(i));
		}
		b[9] = new JButton("+");
		b[10] = new JButton("0");
		b[11] = new JButton("=");
		b[12] = new JButton("-");
		b[13] = new JButton("*");
		b[14] = new JButton("/");

		tf = new JTextField();

	}

	// 3. 화면 붙이기 및 화면 출력
	void addLayout() {
		// 버튼
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5, 3));
		for (int i = 0; i < b.length; i++) {
			p.add(b[i]);
		}

		// North 영역
		JPanel p_North = new JPanel();
		p_North.setLayout(new BorderLayout());
		p_North.add(tf);

		// 프레임 영역에 붙이기

		f.setLayout(new BorderLayout());
		f.add(p, BorderLayout.CENTER);
		f.add(p_North, BorderLayout.NORTH);
		f.setSize(500, 400);
		f.setVisible(true);

	}

	// 핸들러 객체 생성
	void eventProc() {
		BtnHdlr bh = new BtnHdlr();

		for (int i = 0; i < b.length; i++) {
			b[i].addActionListener(bh);
		}

	}

	// 이벤트 핸들러
	class BtnHdlr implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton evt = (JButton) e.getSource();
			for (int i = 0; i < b.length; i++) {
				if (evt == b[i]) {
					if ((i > 0 & i < 8) || i == 10) {
						tf.setText(b[i].getText());
					} else if (i == 9 | i == 12 | i == 13 | i == 14) {
						tf.setText(b[i].getText());
					} else if (i == 11) {
						tf.setText(b[i].getText());
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		CalculatorEx cal = new CalculatorEx();
		cal.addLayout();
		cal.eventProc();
	}

}
