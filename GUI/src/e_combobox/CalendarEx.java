package e_combobox;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class CalendarEx {
	// 1. 멤버변수 선언
	JFrame f;
	JComboBox cbY, cbM, cbD;
	JButton b;
	JLabel la;

	int[] lastDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 2. 멤버 변수 객체 생성
	CalendarEx() {

		f = new JFrame("날짜");
		// 년 : 2015~ 2025
		// 월 : 1~12

		Integer[] ysu = new Integer[11];
		for (int i = 0, year = 2015; i < ysu.length; i++, year++) {
			ysu[i] = year;
		}

		Integer[] msu = new Integer[12];
		for (int i = 0; i < msu.length; i++) {
			msu[i] = i + 1;
		}

		cbY = new JComboBox(ysu);
		cbM = new JComboBox(msu);
		cbD = new JComboBox();
		b = new JButton(">");
		la = new JLabel("요일");

	}

	// 3. 화면 붙이기 및 화면 보이기
	void addLayout() {

		f.setLayout(new FlowLayout());

		f.add(cbY);
		f.add(new JLabel("년"));
		f.add(cbM);
		f.add(new JLabel("월"));
		f.add(cbD);
		f.add(new JLabel("일"));

		f.add(b);

		f.add(la);

		f.setSize(400, 300);
		f.setVisible(true);

	}

	void initDate() { // addLayout 이후 시작.
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		cbY.setSelectedItem(y); // 현재 년도 띄우기

		int m = c.get(Calendar.MONTH);
		cbM.setSelectedItem(m + 1); // 현재 월 띄우기

		setDay(); // 일

		int d = c.get(Calendar.DATE);
		cbD.setSelectedItem(d); // 현재 일 띄우기

		setDate(); // 요일
	}

	// 4. 이벤트 등록 및 처리
	void eventProc() {
		CbHdlr cb = new CbHdlr();
		cbY.addActionListener(cb);
		cbM.addActionListener(cb);
		b.addActionListener(cb);
	}

	class CbHdlr implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == cbY | obj == cbM) {
				setDay();

			} else if (obj == b) {
				setDate();
			}
		}

	}

	void setDay() {
		// 윤년이라면 lastDays[1] = 29 로 지정
		// 평년이라면 lastDays[1] = 28 로 지정
		// [확인] 2016 -2
		int year = (Integer) cbY.getSelectedItem();

		if (year % 4 == 0 && year % 100 != 100 || year % 400 == 0) {
			lastDays[1] = 29;
		} else {
			lastDays[1] = 28;
		}

//		System.out.println("콤보박스 이벤트");
		int month = cbM.getSelectedIndex();
		cbD.removeAllItems(); // reset 해서 다시 추가
		for (int i = 1; i <= lastDays[month]; i++) {
			cbD.addItem(i);
		}
	}

	void setDate() {

		int y = (Integer) cbY.getSelectedItem(); // get메소드는 리턴값을 몰라서 초기에 object로 설정되어 있어서 변형 해줘야 쓸수 있음.
		int m = (Integer) cbM.getSelectedItem();
		int d = (Integer) cbD.getSelectedItem();
//		System.out.println("버튼 이벤트");
		Calendar c = Calendar.getInstance();

// 사용자가 지정한 날짜 가지고와야 함! 년/월/일 값 가지고 오기
		c.set(y, m - 1, d);

		int date = c.get(Calendar.DAY_OF_WEEK); // 일 = 1 , 월 = 2 , 로 됨
		String[] strDate = { " 일", " 월", " 화", " 수", " 목", " 금", " 토" };
		la.setText(strDate[date - 1] + "요일");

	}

	public static void main(String[] args) {
		CalendarEx c = new CalendarEx();
		c.addLayout(); // 화면 붙이기 및 출력
		c.initDate(); // 날짜 초기화
		c.eventProc(); // 이벤트 처리

	}

}
