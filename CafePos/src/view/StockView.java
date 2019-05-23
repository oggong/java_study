package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import ch.randelshofer.quaqua.JBrowser;

public class StockView extends JPanel {
	// 멤버 변수 선언

	JTable tableStock;

	StockTableModel tbStockTable;

	JButton Balju;

	// 멤버 객체 선언
	public StockView() {
		addLayout();
		connectDB();
		eventProc();

	}

	public void eventProc() {
		// 이벤트 등록
		ButtonEventHandler hdlr = new ButtonEventHandler();
		Balju.addActionListener(hdlr);

	}

	class ButtonEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == Balju) {

				callBaljuDialog();
			}
		}

	}

	public void callBaljuDialog() {
		int i = JOptionPane.showConfirmDialog(null, "발주 하시겠습니까?");
		if (i == 0) {
//			JOptionPane.showMessageDialog(null, "발주를 하겠습니다.");
			JOptionPane.showInputDialog(null,"입력");
		}
	}

	public void connectDB() {
		// DB연결
	}

	public void addLayout() {
		// 화면 붙이기 및 화면 출력
		tbStockTable = new StockTableModel();
		tableStock = new JTable(tbStockTable);

		Balju = new JButton(new ImageIcon("src/img/balju.png"));

		// ************************************
		// 화면 구성
		// 위쪽 테이블
		JPanel p_north = new JPanel();
//		p_north.setBorder(new TitledBorder("north"));
		p_north.setLayout(new BorderLayout());
		p_north.add(new JScrollPane(tableStock), BorderLayout.CENTER);
		// 아래쪽 테이블
		JPanel p_south = new JPanel();
		p_south.setBorder(new TitledBorder("south"));
		p_south.setLayout(new BorderLayout());
		p_south.add(Balju);

		// 전체 영역 붙히기
		setLayout(new GridLayout(2, 1));
		add(p_north, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);

	}

	// 화면에 테이블 붙이는 메소드
	class StockTableModel extends AbstractTableModel {

		// 기본적인 TableModel 만들기
		ArrayList data = new ArrayList();
		String[] columnNames = { "제품 번호", "제품 명", "잔여 수량", "거래처", "비고 1", "비고 2" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
}
