package thread.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ex4_CounterTest extends JFrame {
	private JPanel p1, p2;
	private JButton btn;
	private JTextArea ta;
	private JLabel lb;
	private boolean inputChk;

	public Ex4_CounterTest() {
		setTitle("단일 스레드 테스트!");
		p1 = new JPanel();
		p1.add(btn = new JButton("Click"));
		p1.add(lb = new JLabel("Count!"));// 추가
		add(p1, "North");

		p2 = new JPanel();
		p2.add(ta = new JTextArea(20, 50));
		add(p2);

		setBounds(200, 200, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 1- 카운트 다운을 시작하는 스레드
				new Thread(new Runnable() {
					// event 축약형 잡았을때 처럼 선언까지 해야 함!(객체 생성까지 해야함)
					public void run() {
						for (int i = 10; i > 0; i--) {
							if (inputChk) {
								lb.setText("빙고");
								inputChk = false;
								break; // 반복문만 벗어나겠다
								// return // run 메소드 자체를 벗어나겠다
							}
							lb.setText(String.valueOf(i));
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
							}
						}
					}
				}).start();
// 				Runnable 	
//				1. Thread 상속(Runnable 구현)
//    			-run() 오버라이딩
//    			2. start() 호출 -> run() 호출됨    위는 ----- > 한번에 다 호출 

				// 2- 입력값을 받아서 JTextArea에 붙이는 작업
				new Thread(new Runnable() { // Runnable 을 구현한 이름없는 클래스
					public void run() {
						String input = JOptionPane.showInputDialog("값을 입력");
						ta.append(input);
						inputChk = true;

					}
				}).start();

			}
		});
	}

	public static void main(String[] args) {
		new Ex4_CounterTest();
	}
}
