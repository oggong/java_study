package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.dao.Posmodel;
import model.vo.pos;
import view.CafePosView.OrderTableModel;

public class CafePosView extends JPanel implements ActionListener {
	// 멤버 변수 선언
	JButton bAmericano, bCafelatte, bCafemoca, bLemonade;
	JButton bBagel, bMilk, bCake, bWater, bBeer;
	JScrollPane jpane;
	
	JTextArea taOrderPrice;
	JButton bPayment, bCancel;
	
	JTable tableOrder;
	OrderTableModel tbOrderTable;
	
	Font f = new Font("맑은 고딕", Font.BOLD, 15);
	
	ArrayList payment = new ArrayList() ; 
	ArrayList list = new ArrayList() ; 
	
	String ame = "0001";
	String latte = "0002";
	String moca = "0003";
	String lemon = "0004";
	String bagel = "0005";
	String milk = "0006";
	String cake = "0007";
	String water = "0008";
	String beer = "0009";
	
	Posmodel posmodel;

	// 멤버 객체 선언
	public CafePosView() {
		addLayout();
		connectDB();
		eventProc();
		try {
			posmodel = new Posmodel();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void eventProc() {
		// 이벤트 등록
		bAmericano.addActionListener(this);
		bCafelatte.addActionListener(this);
		bCafemoca.addActionListener(this);
		bLemonade.addActionListener(this);
		bBagel.addActionListener(this);
		bMilk.addActionListener(this);
		bCake.addActionListener(this);
		bWater.addActionListener(this);
		bBeer.addActionListener(this);
		bPayment.addActionListener(this);
		bCancel.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ev) {	// 액션 리스너

		if (ev.getSource() == bAmericano) {
			list.add(ame);
			p_List(ame);
		}else if(ev.getSource() == bCafelatte) {
			list.add(latte);
			p_List(latte);
		}else if(ev.getSource() == bCafemoca) {
			list.add(moca);
			p_List(moca);
		}else if(ev.getSource() == bLemonade) {
			list.add(lemon);
			p_List(lemon);
		}else if(ev.getSource() == bBagel) {
			list.add(bagel);
			p_List(bagel);
		}else if(ev.getSource() == bMilk) {
			list.add(milk);
			p_List(milk);
		}else if(ev.getSource() == bCake) {
			list.add(cake);
			p_List(cake);
		}else if(ev.getSource() == bWater) {
			list.add(water);
			p_List(water);
		}else if(ev.getSource() == bBeer) {
			list.add(beer);
			p_List(beer);			
		}else if(ev.getSource() == bPayment) {
			// 결제 메서드 실행
			int i = JOptionPane.showConfirmDialog(null, "적립 하십니까?");
			if (i == 0) {
				String memberNum = JOptionPane.showInputDialog(null,"회원번호를 입력 하세요");
				MemberNum(memberNum);	// 회원번호 입력 메서드 실행
				Payment(); // 결제 메서드 실행
				JOptionPane.showMessageDialog(null, "결제 진행합니다..1");
				JOptionPane.showMessageDialog(null, "결제완료");
			} else if (i == 1) {
				Payment();
				JOptionPane.showMessageDialog(null, "결제 진행합니다..2");
				JOptionPane.showMessageDialog(null, "결제완료");
				
			}
			
		}else if(ev.getSource() == bCancel) {
			
//			DefaultTableModel defaultModel = new DefaultTableModel();
//			defaultModel = (DefaultTableModel)tbOrderTable.getModel();
//			defaultModel.setNumRows(0);
//			tbOrderTable.fireTableRowsUpdated(0, 20);
			tbOrderTable.Clear();
			JOptionPane.showMessageDialog(null, "취소되었습니다");
			
		}

	}
	
	
	
	public void Payment() {	// 결제 버튼을 눌렀을 경우
		
		try {
			System.out.println("-----");
			posmodel.InsertPayment(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void Payment1() {	// 결제 버튼을 눌렀을 경우
		
		try {
			posmodel.InsertPayment1(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void p_List(String pno) {
		try {
			tbOrderTable.data.add(posmodel.PaymentList(pno));
			tbOrderTable.fireTableDataChanged();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
//	public void Cancel() {
//		tbOrderTable.removeTableModelListener(l);
//	}
	
	public void MemberNum(String MemberNum) {	// 회원번호 받아와서 전송
		
		try {
			posmodel.InsertMemberNum(MemberNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	

	
	public void connectDB() {
		// DB연결
		try {
			posmodel = new Posmodel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addLayout() {
		// 화면 붙이기 및 화면 출력

		// 멤버 변수의 객체 생성
		bAmericano = new JButton(new ImageIcon("src/img/bamericano.png"));
		bCafelatte = new JButton(new ImageIcon("src/img/bcafelatte.png"));
		bCafemoca = new JButton(new ImageIcon("src/img/bcafemoca.png"));
		bLemonade = new JButton(new ImageIcon("src/img/blemonade.png"));
		bBagel = new JButton(new ImageIcon("src/img/bbagel.png"));
		bMilk = new JButton(new ImageIcon("src/img/bmilk.png"));
		bCake = new JButton(new ImageIcon("src/img/bcake.png"));
		bWater = new JButton(new ImageIcon("src/img/bwater.png"));
		bBeer = new JButton(new ImageIcon("src/img/bbeer.png"));
		
//		taOrderPrice = new JTextArea();
		tbOrderTable = new OrderTableModel();
		tableOrder = new JTable(tbOrderTable);
		

		bPayment = new JButton("결제");
		bCancel = new JButton("취소");

		// *****************************************************************
		// 화면 구성
		// 왼쪽 영역 - 상품
		JPanel p_west = new JPanel();
//		JPanel p_north = new JPanel();
		p_west.setLayout(new BorderLayout());
//		p_north.setLayout(new GridLayout(1, 2));
//		p_north.setBorder(new TitledBorder("test"));

		// 왼쪽영역
		p_west.setLayout(new BorderLayout());
		p_west.setBorder(new TitledBorder("메뉴"));
		p_west.add(new JLabel(new ImageIcon("src/img/menu.png")));
		
		// 아래쪽 영역 - 주문,결제
		JPanel p_east = new JPanel();
		p_east.setLayout(new BorderLayout());
//		p_south.setBorder(new TitledBorder("south"));
		
		// 우측 상단
		JPanel p_east_north = new JPanel();
		p_east_north.setLayout(new GridLayout(6, 3));
		p_east_north.setBorder(new TitledBorder("상품"));

		p_east_north.add(new JLabel("아메리카노", SwingConstants.CENTER)); // 라벨 들어갈 내용 중앙 정렬
		p_east_north.add(new JLabel("카페라떼", SwingConstants.CENTER));
		p_east_north.add(new JLabel("카페 모카", SwingConstants.CENTER));
		p_east_north.add(bAmericano, new ImageIcon());
		p_east_north.add(bCafelatte);
		p_east_north.add(bCafemoca);
		p_east_north.add(new JLabel("레몬에이드", SwingConstants.CENTER));
		p_east_north.add(new JLabel("베이글", SwingConstants.CENTER));
		p_east_north.add(new JLabel("밀크티", SwingConstants.CENTER));
		p_east_north.add(bLemonade);
		p_east_north.add(bBagel);
		p_east_north.add(bMilk);
		p_east_north.add(new JLabel("케이크", SwingConstants.CENTER));
		p_east_north.add(new JLabel("물(아리수)", SwingConstants.CENTER));
		p_east_north.add(new JLabel("맥주", SwingConstants.CENTER));
		p_east_north.add(bCake);
		p_east_north.add(bWater);
		p_east_north.add(bBeer);
		
		// 아래쪽 영역 - 주문
		JPanel p_east_middle = new JPanel();

		p_east_middle.setBorder(new TitledBorder("주문"));
		p_east_middle.add(new JScrollPane(tableOrder));
//		jpane.setPreferredSize(new Dimension(495,320));

		// 아래쪽 영역 - 결제 버튼
		JPanel p_east_south = new JPanel();
		p_east_south.setBorder(new TitledBorder("결제"));
		p_east_south.setLayout(new GridLayout(1, 3));

		p_east_south.add(bPayment);
		p_east_south.add(bCancel);

		p_east.add(p_east_north, BorderLayout.NORTH);
		p_east.add(p_east_middle, BorderLayout.CENTER);
		p_east.add(p_east_south, BorderLayout.SOUTH);
		
		// 전체 영역 붙히기
//		setLayout(new GridLayout(2, 1));
		setLayout(new BorderLayout());
		add(p_west, BorderLayout.WEST);
		add(p_east, BorderLayout.EAST);

	}
	class OrderTableModel extends AbstractTableModel {

		// 기본적인 TableModel 만들기
		ArrayList data = new ArrayList();
		String[] columnNames = { "제품번호", "제품명", "가격" };

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
		
		public void Clear() {
			data.clear();
			fireTableDataChanged();
		}
	}

}



		

	


