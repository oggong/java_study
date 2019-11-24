package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.StockModel;
//import model.StockModel;
import model.vo.Stock;

//import ch.randelshofer.quaqua.JBrowser;

public class StockView extends JPanel {
	// 멤버 변수 선언
	
	String vNum;
	JTable tableStock;
	JScrollPane jpane;
	StockTableModel tbStockTable;

	JButton Balju;
	StockModel db;

	// 멤버 객체 선언
	public StockView() {
		addLayout();
		connectDB();
		eventProc();
		StockList();

	}

	public void eventProc() {
		// 이벤트 등록
		ButtonEventHandler hdlr = new ButtonEventHandler();
		Balju.addActionListener(hdlr);
		tableStock.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = tableStock.getSelectedRow();
				vNum = (String) tableStock.getValueAt(row, col);
//				JOptionPane.showMessageDialog(null, vNum);
				
				Stock vo;
//				vo = db.Sele
			}
			
			
		});

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
			int  a = Integer.parseInt(JOptionPane.showInputDialog(null,"입력"));
			try {
				db.InsertBalju(vNum, a);
				JOptionPane.showMessageDialog(null, "제품번호(" + ""+ vNum+")   " +a +"개" +"  발주가 완료 되었습니다");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	public void StockList() {
		try {
			tbStockTable.data = db.SearchStock();
			tbStockTable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void connectDB() {
		// DB연결
		try {
			db = new StockModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		p_north.setBorder(new TitledBorder("재고"));
	
		
		p_north.setLayout(new BorderLayout());
		p_north.add(jpane = new JScrollPane(tableStock));
		jpane.setPreferredSize(new Dimension(1024,470));
		// 아래쪽 테이블
		JPanel p_south = new JPanel();
		p_south.setBorder(new TitledBorder("발주"));
		p_south.setLayout(new BorderLayout());
		p_south.add(Balju);
		Balju.setPreferredSize(new Dimension(300,160));

		// 전체 영역 붙히기
		setLayout(new BorderLayout());
		add(p_north, BorderLayout.NORTH);
		add(p_south, BorderLayout.SOUTH);
	}

	// 화면에 테이블 붙이는 메소드
	class StockTableModel extends AbstractTableModel {

		// 기본적인 TableModel 만들기
		ArrayList data = new ArrayList();
		String[] columnNames = {  "제품 번호", "제품 명", "잔여 수량" };

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
