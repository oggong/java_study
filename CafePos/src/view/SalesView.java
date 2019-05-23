package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import jfreechart.ChartA;

public class SalesView extends JPanel {
	// 멤버 변수 선언
	JComboBox comDay;
	JTextField tfcomDay;
	
	JComboBox comWeeks;
	JTextField tfcomWeeks;
	
	JComboBox comMonth;
	JTextField tfcomMonth;
	
	
	 ChartA demo = new ChartA(); 
	 JFreeChart chart = demo.getChart();     
     ChartPanel chartPanel=new ChartPanel(chart); 

	// 멤버 객체 선언
	public SalesView() {
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
		//멤버 변수의 객체 생성
		tfcomDay = new JTextField();
		tfcomWeeks = new JTextField();
		tfcomMonth = new JTextField();
		
		String [] comDaystr = {"1","2","3"};
		comDay = new JComboBox(comDaystr);
		
		String [] comWeekstr = {"1주","2주","3주","4주"};
		comWeeks = new JComboBox(comWeekstr);
		
		String [] comMonthstr = {"1월","2월","3월","4월","5월"};
		comMonth = new JComboBox(comMonthstr);
		
		
		// 화면 붙이기 및 화면 출력
		JPanel p_north = new JPanel();
		p_north.setBorder(new TitledBorder("north"));
		p_north.setLayout(new GridLayout(3,3));
		
		p_north.add(new JLabel("일간",SwingConstants.CENTER));
		p_north.add(new JLabel("주간",SwingConstants.CENTER));
		p_north.add(new JLabel("월간",SwingConstants.CENTER));
		p_north.add(comDay);
		p_north.add(comWeeks);
		p_north.add(comMonth);
		
		p_north.add(tfcomDay);
		p_north.add(tfcomWeeks);
		p_north.add(tfcomMonth);

		// 아래쪽 테이블
		JPanel p_south = new JPanel();
		p_south.setBorder(new TitledBorder("south"));
		p_south.setLayout(new BorderLayout());
		p_south.add(chartPanel);

		// 전체 영역 붙히기
		setLayout(new GridLayout(2, 1));
		add(p_north, BorderLayout.NORTH);
		add(p_south, BorderLayout.CENTER);

	}
}
