package khbucket;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class BucketList extends JFrame {

	// 멤버 변수 생성 3x3 버튼 생성
	int getsu = 3;
	JButton[][] la = new JButton[getsu][getsu];

	// Label 변수 생성
	JLabel jl, jl_result, jl_price;

	// 결과 버튼 변수 생성
	JButton jb_limit;
	TextField tf_sum = new TextField(50);
	TextField tf_price = new TextField(30);

	int day = 75750; // 일급
	long s_day;
	int month = 1500000; // 월급
	long s_month;
	int year = 18000000; // 연봉
	long s_year;

	// int의 숫자 한계로 long 다차원 배열 생성
	long[][] price = { { 200000L, 800000L, 2000000000L }, { 80000000L, 3000000L, 1000000L },
			{ 4000000L, 1000000L, 500000000L } };
	// 가격 텍스트 필드
	String[][] price1 = { { "200,000원", "800,000원", "2,000,000,000원" }, { "80,000,000원", "3,000,000원", "1,000,000원" },
			{ "4,000,000원", "1,000,000원", "5,000,000,000원" } };
	// long 형 총액 결과 값
	long total;

	public BucketList() {
		// 객체 생성
		// 이미지 아이콘 버튼 생성
		ImageIcon airpot = new ImageIcon("src/img/1.jpg");
		ImageIcon airpot1 = new ImageIcon("src/img/2.png");
		ImageIcon airpot2 = new ImageIcon("src/img/3.png");
		ImageIcon airpot3 = new ImageIcon("src/img/4.png");
		ImageIcon airpot4 = new ImageIcon("src/img/5.png");
		ImageIcon airpot5 = new ImageIcon("src/img/6.png");
		ImageIcon airpot6 = new ImageIcon("src/img/7.png");
		ImageIcon airpot7 = new ImageIcon("src/img/8.png");
		ImageIcon airpot8 = new ImageIcon("src/img/9.png");

		la[0][0] = new JButton(airpot);
		la[0][1] = new JButton(airpot1);
		la[0][2] = new JButton(airpot2);
		la[1][0] = new JButton(airpot3);
		la[1][1] = new JButton(airpot4);
		la[1][2] = new JButton(airpot5);
		la[2][0] = new JButton(airpot6);
		la[2][1] = new JButton(airpot7);
		la[2][2] = new JButton(airpot8);

		new JFrame("기혁이 버킷리스트");

		jl = new JLabel("기혁이 버킷리스트 ", JLabel.LEFT);
		jl.setFont(new Font("", Font.BOLD, 57));
		jl.setForeground(Color.GREEN);

		jl_result = new JLabel("총액");
		jl_result.setFont(new Font("", Font.BOLD, 25));

		jb_limit = new JButton("결제");

		jl_price = new JLabel("제품 가격");

	}

	// 화면 붙이기 및 출력
	void addLayout() {
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		p.setLayout(new GridLayout(3, 4)); // 레이아웃 지정
		p2.add(jl, "NORTH");
		for (int i = 0; i < getsu; i++) {
			for (int j = 0; j < la[i].length; j++) {
				p.add(la[i][j]);

				p3.add(jl_price);
				p3.add(tf_price);
				p3.add(jl_result);
				p3.add(tf_sum);
				p3.add(jb_limit);

			}
		}
		// 프레임영역에 붙이기
		setLayout(new BorderLayout(4, 3));

		add(p, BorderLayout.CENTER);
		add(p2, BorderLayout.NORTH);
		add(p3, BorderLayout.SOUTH);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 4. 이벤트 등록 및 처리
	void eventProc() {
		MyHdlr cb = new MyHdlr();
		jb_limit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "한도초과 ( 500년 일해야합니다 ");

			}
		});
		for (int i = 0; i < getsu; i++) {
			for (int j = 0; j < getsu; j++) {
				la[i][j].addActionListener(cb);
			}
		}
	} // end of eventProc

	// 이벤트 핸들러 - 액션 리스너 사용
	class MyHdlr implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton obj = (JButton) e.getSource();
			// 물건의 단위 마다 점을 찍어주기 위해서
			DecimalFormat form = new DecimalFormat("#,###");
			// 물건의 누를때마다 이벤트를 발생 시키고
			for (int i = 0; i < getsu; i++) {
				for (int j = 0; j < getsu; j++) {
					if (obj == la[i][j]) {
						total += price[i][j]; // 총합 계산

						s_day = total / day;
						s_month = total / month;
						s_year = total / year;

						String s_total = form.format(total);
						tf_sum.setText(s_total);
						JOptionPane.showMessageDialog(null,
								"기혁이는 " + s_year + "년 을 일하고, 개월 수로는" + s_month + "개월, 일수로는" + s_day + "일을 더 해야한다");
					}
					// 클릭한 물건의 값을 가격 텍스트필드에 띄우기
					if (obj == la[i][j]) {
						tf_price.setText(price1[i][j]);
					}
				}
			}

		}
	}// end of MyHdlr

	public static void main(String[] args) {
		BucketList f = new BucketList();
		f.addLayout();
		f.eventProc();

	} // end of main
}// end of Bucket
