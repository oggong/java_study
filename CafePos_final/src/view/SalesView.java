package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import jfreechart.ChartA;
import jfreechart.ChartB;
import jfreechart.ChartC;
import model.dao.SalesModel;

public class SalesView extends JPanel implements ActionListener {
	// 멤버 변수 선언

	JButton monthrate, productrate;

	ChartA demoA = new ChartA();
	JFreeChart charta = demoA.getChart();
	ChartPanel chartPanelA = new ChartPanel(charta);
	
	ChartB demob = new ChartB();
	JFreeChart chartb = demob.getChart();
	ChartPanel chartPanelB = new ChartPanel(chartb);

	ChartC democ = new ChartC();
	JFreeChart chartc = democ.getChart();
	ChartPanel chartPanelC = new ChartPanel(chartc);
	
	SalesModel db;
	Font f = new Font("맑은 고딕",Font.BOLD,15);

	// 멤버 객체 선언
	public SalesView() {
		addLayout();
		connectDB();
		eventProc();

	}

	public void connectDB() {
		// DB연결
		try {
			db = new SalesModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eventProc() { // 이벤트 등록
		monthrate.addActionListener(this);
		productrate.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == monthrate) {

		} else if (ev.getSource() == productrate) {

		}
	}

	void salesRate() {

	}

	public void addLayout() {
		// 멤버 변수의 객체 생성
		monthrate = new JButton(new ImageIcon("src/img/click.png"));
		productrate = new JButton(new ImageIcon("src/img/click.png"));

		// 화면 붙이기 및 화면 출력
		JPanel p_north = new JPanel();
		p_north.setBorder(new TitledBorder("판매량"));
		p_north.setLayout(new GridLayout(2, 2));

		p_north.add(new JLabel("월별", SwingConstants.CENTER));
		p_north.add(new JLabel("제품별", SwingConstants.CENTER));

		p_north.add(monthrate);
		p_north.add(productrate);

		
		JTabbedPane pane = new JTabbedPane();
		
		// 아래쪽 테이블
		JPanel p_south = new JPanel();
		p_south.setBorder(new TitledBorder("판매량 차트"));
		p_south.setLayout(new BorderLayout());

		JPanel p_south_n = new JPanel();
//		p_south_n.setBorder(new TitledBorder("제품별 차트"));
		p_south_n.setLayout(new BorderLayout());
		
		p_south_n.add(chartPanelA);
		
		JPanel p_south_s = new JPanel();
//		p_south_s.setBorder(new TitledBorder("월별 차트"));
		p_south_s.setLayout(new BorderLayout());
		
		p_south_s.add(chartPanelB);
		
		JPanel p_south_c = new JPanel();
//		p_south_s.setBorder(new TitledBorder("월별 차트"));
		p_south_c.setLayout(new BorderLayout());
		
		p_south_c.add(chartPanelC);
		
		pane.addTab("제품별", p_south_n);
		pane.addTab("월별",p_south_s);
		pane.addTab("일별", p_south_c);

//		p_south.add(p_south_n);
//		p_south.add(p_south_s);
		
		p_south.add("Center",pane);
		// 전체 영역 붙히기
		setLayout(new BorderLayout());
		add(p_north, BorderLayout.NORTH);
		add(p_south, BorderLayout.CENTER);

	}

}
