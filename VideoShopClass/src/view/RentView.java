package  view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.RentModel;



public class RentView extends JPanel 
{
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;
	
	JTextField tfReturnVideoNum;
	JButton bReturn;
	
	JTable tableRecentList;
	
	RentTableModel rentTM;
	
	RentModel db;

	
	//==============================================
	//	 생성자 함수
	public RentView(){
		addLayout();	//화면구성
		eventProc();	//DB연결
		connectDB();
	}
	
	// DB 연결
	void connectDB(){
		try {
			db = new RentModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 이벤트 등록
	public void eventProc(){

		                         
	}
	
	/*	객체 생성 및 화면 구성   */
	void addLayout(){
		// 멤버 변수의 객체 생성
		tfRentTel = new JTextField();
		tfRentCustName = new JTextField(15);
		tfRentVideoNum = new JTextField(15);
		bRent = new JButton("대여");
		
		tfReturnVideoNum = new JTextField(15);
		bReturn = new JButton("반납");
		
		rentTM = new RentTableModel();
		tableRecentList = new JTable(rentTM);
		
		// ************************************************
		//화면 구성 
		//north 영역
		JPanel p_north = new JPanel();
//		p_north.setBorder(new TitledBorder("north"));
		p_north.setLayout(new GridLayout(1,2));
		
		
		// north 왼쪽 영역 
		JPanel p_north_west = new JPanel();
		p_north_west.setLayout(new GridLayout(4,2));
		p_north_west.setBorder(new TitledBorder("대여"));
		p_north_west.add(new JLabel("전화번호"));
		p_north_west.add(tfRentTel);
		p_north_west.add(new JLabel("고객명"));
		p_north_west.add(tfRentCustName);
		p_north_west.add(new JLabel("비디오 번호"));
		p_north_west.add(tfRentVideoNum);
		p_north_west.add(bRent);
		p_north.add(p_north_west);
		
		// north 오른쪽 영역
		JPanel p_north_east = new JPanel();
		p_north_east.setLayout(new FlowLayout());
		p_north_east.setBorder(new TitledBorder("반납"));
		p_north_east.add(new JLabel("비디오 번호"));
		p_north_east.add(tfReturnVideoNum);
		p_north_east.add(bReturn);
		
		p_north.add(p_north_east);
		
		//south 영역
		JPanel p_south = new JPanel();
//		p_south.setBorder(new TitledBorder("south"));
		p_south.setLayout(new BorderLayout());
		
		p_south.add(new JScrollPane(tableRecentList));
		//전체영역 붙히기
		setLayout(new BorderLayout());
		
		add(p_north, BorderLayout.NORTH);
		add(p_south, BorderLayout.CENTER);
		
		
	}

	class RentTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"비디오번호","제목","고객명","전화번호","반납예정일","반납여부"};

			public int getColumnCount() { 
		        return columnNames.length; 
		    } 
		     
		    public int getRowCount() { 
		        return data.size(); 
		    } 

		    public Object getValueAt(int row, int col) { 
				ArrayList temp = (ArrayList)data.get( row );
		        return temp.get( col ); 
		    }
		    
		    public String getColumnName(int col){
		    	return columnNames[col];
		    }
	}

	

	
}
