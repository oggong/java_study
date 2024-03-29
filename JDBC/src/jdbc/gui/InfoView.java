package jdbc.gui;

/*
 * Java GUI를 구성하는 application을 만든 후 
 * DataBase에 입력 / 수정 / 삭제 / 검색을 하는 프로그램을 작성하는 예제
 * 
 * 또한 이 프로그램은 Java Swing으로 GUI를 구성하였음
 *
 *		테이블명 : temp
 *		name	varchar(10)
 *		id		char(14)
 *		tel		varchar(13)
 *		sex		varchar(10)
 *		age		number
 *		home	varchar(10)
 *	
 */

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.SelectableChannel;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

class InfoView implements ActionListener {

	// -----------------------------------------
	// 화면에 관련한 변수 선언
	// -----------------------------------------
	JFrame frame;
	JTextField tf_name, tf_id, tf_tel, tf_age, tf_gender, tf_home;
	JButton b_add, b_show, b_modify, b_delete, b_cancel, b_exit;
	JTextArea ta;

	// ########################################
	// 1. business logic를 실행하는 클래스 변수 선언

	InfoModelImpl db = null; // null 값을 줘도 되고 안줘도 된다. InfoModelImpl 을 변수로 선언
//	InfoMySQLImpl db = null;

	// -----------------------------------------
	// 생성자 함수
	// : 위의 멤버 변수에 선언된 클래스 객체 생성
	// -----------------------------------------
	public InfoView() {

		frame = new JFrame("DBTest");

		tf_name = new JTextField(15);
		tf_id = new JTextField(15);
		tf_tel = new JTextField(15);
		tf_age = new JTextField(15);
		tf_gender = new JTextField(15);
		tf_home = new JTextField(15);

		/*
		 * 버튼 생성 ( 이미지 버튼 ) 1. Text과 ImageIcon를 갖는 버튼 생성 2. Text를 그림 아래 위치 3. Text를 가운데
		 * 정렬 4. 버튼의 보더 지정 : 버튼의 모양이 위로 올라와 보이게 5. 버튼의 튤팁을 지정
		 */
		b_add = new JButton("Add", new ImageIcon("img/add.gif"));
		b_add.setVerticalTextPosition(SwingConstants.BOTTOM);
		b_add.setHorizontalTextPosition(SwingConstants.CENTER);
		b_add.setBorder(new BevelBorder(BevelBorder.RAISED));
		b_add.setToolTipText("추가");

		b_show = new JButton("Show");
		b_modify = new JButton("Modify");
		b_delete = new JButton("Delete");
		b_cancel = new JButton("Cancel");
		b_exit = new JButton("Exit");
		ta = new JTextArea(20, 50);

		// #########################################
		// 2. business logic 역할을 하는 클래스 객체 생성

		try {
			db = new InfoModelImpl();
//			db = new InfoMySQLImpl();
			ta.setText("디비 연결 성공");

		} catch (Exception ex) {
			ta.setText("현재 네트워크 오류가 발생하여 프로그램이 정상적이 않습니다. 양해부탁드립니다."); // 사용자 화면에 상태 확인
			ex.printStackTrace();
		} //

	}

	// --------------------------------------------------
	// --------------------------------------------------
	void setup() {

		JPanel p_center = new JPanel();
		JPanel p_west = new JPanel();
		JPanel p_south = new JPanel();

		// 화면출력만 하는 라벨 생성 및 붙이기
		JLabel ll_name = new JLabel("Name", new ImageIcon("img/cute/1.gif"), JLabel.CENTER);
		JLabel ll_id = new JLabel("ID", new ImageIcon("img/cute/2.gif"), SwingConstants.CENTER);
		JLabel ll_tel = new JLabel("Tel", new ImageIcon("img/cute/3.gif"), SwingConstants.CENTER);
		JLabel ll_sex = new JLabel("Sex", new ImageIcon("img/cute/4.gif"), SwingConstants.CENTER);
		JLabel ll_age = new JLabel("Age", new ImageIcon("img/cute/5.gif"), SwingConstants.CENTER);
		JLabel ll_home = new JLabel("Home", new ImageIcon("img/cute/6.gif"), SwingConstants.CENTER);

		// west영역 붙이기
		p_west.setLayout(new GridLayout(6, 2));
		p_west.add(ll_name);
		p_west.add(tf_name);
		p_west.add(ll_id);
		p_west.add(tf_id);
		p_west.add(ll_tel);
		p_west.add(tf_tel);
		p_west.add(ll_sex);
		p_west.add(tf_gender);
		p_west.add(ll_age);
		p_west.add(tf_age);
		p_west.add(ll_home);
		p_west.add(tf_home);

		// center 영역
		p_center.setLayout(new BorderLayout());
		p_center.add("Center", ta);

		// south 영역
		p_south.setLayout(new GridLayout(1, 6));
		p_south.add(b_add);
		p_south.add(b_show);
		p_south.add(b_modify);
		p_south.add(b_delete);
		p_south.add(b_cancel);
		p_south.add(b_exit);

		// 전체 영역 붙이기 및 화면 출력
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add("West", p_west);
		frame.getContentPane().add("Center", p_center);
		frame.getContentPane().add("South", p_south);

		frame.pack();
		frame.setTitle("DBTest");
		frame.setVisible(true);

	}

	// --------------------------------------------------
	// 각 버튼을 이벤트에 등록
	// --------------------------------------------------
	public void eventProc() {

		b_add.addActionListener(this);
		b_show.addActionListener(this);
		b_modify.addActionListener(this);
		b_delete.addActionListener(this);
		b_cancel.addActionListener(this);
		b_exit.addActionListener(this);

		tf_id.addActionListener(this);
		tf_tel.addActionListener(this);
	}

	// -------------------------------------------------
	// ActionListener에 등록한 컴포넌트에서 이벤트 발생시
	// JVM에 의해 호출되는 메소드
	// -------------------------------------------------
	public void actionPerformed(ActionEvent ev) {

		if (ev.getSource() == b_add) {
			// ######################################################
			// Add 버튼이 눌렸을 때
			// 1. 각 텍스트필드에서 값을 얻어옴
			// 3. Database 파일의 insert() 함수의 인자로 값을 넘겨줌
//			JOptionPane.showMessageDialog(frame, "추가버튼 눌림");

			// 입력 버튼을 눌렀을 때 가져오기
			insertData();
		}

		else if (ev.getSource() == b_show) {
			// ######################################################
			// 전체 보기 버튼이 눌렸을 때
			// 1. Database 파일의 selectAll() 호출하여 Vector로 리턴받음
			// 2. 리턴받은 Vector에서 Record 객체를 하나씩 얻어온후
			// 3. 그 Record 객체 안의 toString() 메소드 호출하여 TextArea에 출력
			selectAlldata();

//			JOptionPane.showMessageDialog(frame, "전체보기버튼 눌림");
		}

		else if (ev.getSource() == b_modify) {
			// ######################################################
			// Modify 버튼이 눌렸을 때
			// 1. 각 텍스트필드에서 값을 얻어옴
			// 3. Database 파일의 modify() 함수의 인자로 값을 넘겨줌

			modifyData();

//			JOptionPane.showMessageDialog(frame, "수정버튼 눌림");

		}

		else if (ev.getSource() == b_delete) {
			// ######################################################
			// 삭제버튼 눌렸을 때
			// 1. 주민번호 텍스트 필드의 입력값 얻어옴
			// 2. Database의 delete() 함수의 인자로 넘겨줌
			deleteData();

//			JOptionPane.showMessageDialog(frame, "삭제버튼 눌림");

			// 전화번호 텍스트필드에서 엔터 쳤을때
		} else if (ev.getSource() == tf_tel) {
			selectByTel();
		} else if (ev.getSource() == tf_id) {
			selectById();
		}
	}

	void selectByTel() { // 입력값을 tel 에 저장 하고 InfoVO vo 에 담아 화면에 띄우기
		String tel = tf_tel.getText();
		try {
			InfoVO vo = db.selectByTel(tel);

			tf_name.setText(vo.getName()); // 이름 값을 얻어와서 화면에 출력
			tf_id.setText(vo.getId());
			tf_tel.setText(vo.getTel());
			tf_gender.setText(vo.getGender());
			tf_age.setText(String.valueOf(vo.getAge()));
			tf_home.setText(vo.getHome());
		} catch (Exception ex) {
			ta.setText("검색실패:" + ex.getMessage());
		}
	}

	void selectById() { // 입력값을 id 에 저장 하고 InfoVO vo 에 담아 화면에 띄우기
		String id = tf_id.getText();
		try {
			InfoVO vo = db.selectById(id);

			tf_name.setText(vo.getName()); // 이름 값을 얻어와서 화면에 출력
			tf_id.setText(vo.getId());
			tf_tel.setText(vo.getTel());
			tf_gender.setText(vo.getGender());
			tf_age.setText(String.valueOf(vo.getAge()));
			tf_home.setText(vo.getHome());
		} catch (Exception ex) {
			ta.setText("검색실패:" + ex.getMessage());
		}
	}

	// 1. Database 파일의 selectAllData() 호출하여ArrayList로 리턴받음
	// 2. 리턴받은 ArrayList에서 InfoVO 객체를 하나씩 얻어온후
	// 3. 그 InfoVO 객체 안의 toString() 메소드 호출하여 TextArea에 출력

	public void selectAlldata() {
		try {
			ArrayList<InfoVO> list = db.selectAllData(); // db.안에 있는 selectAllData

			ta.setText("===============검색결과\n\n");
			// for 문 사용으로 list의 데이터 뽑아오기

			for (InfoVO vo : list) {
				ta.append(vo.toString());
			}
		} catch (SQLException ex) {
			ta.setText("데이터 검색 실패 :" + ex.getMessage());

		}
	}// end of selectAlldata()
		// 1. 각 텍스트필드에서 값을 얻어옴
		// 3. Database 파일의 insert() 함수의 인자로 값을 넘겨줌

	// Modify 버튼이 눌렸을 때
	// 1. 각 텍스트필드에서 값을 얻어옴
	// 3. Database 파일의 modify() 함수의 인자로 값을 넘겨줌
	public void modifyData() {
		InfoVO vo = new InfoVO();

		vo.name = tf_name.getText();
		vo.id = tf_id.getText();
		vo.tel = tf_tel.getText();
		vo.gender = tf_gender.getText();
		vo.age = Integer.parseInt(tf_age.getText());
		vo.home = tf_home.getText();
		try {
			db.modify(vo);
		} catch (Exception e) {
			ta.setText("입력이 실패하였습니다." + e.getMessage());
		}
		clearTextField();
	}

	public void deleteData() {
		InfoVO vo = new InfoVO();

		vo.tel = tf_tel.getText();

		try {
			db.delete(vo);
		} catch (Exception e) {
			ta.setText("입력이 실패하였습니다." + e.getMessage());
		}
		clearTextField();
	}

	public void insertData() {
		InfoVO vo = new InfoVO();

		vo.name = tf_name.getText();
		vo.id = tf_id.getText();
		vo.tel = tf_tel.getText();
		vo.gender = tf_gender.getText();
		vo.age = Integer.parseInt(tf_age.getText());
		vo.home = tf_home.getText();

		// InfoModelImpl 에서 throws exception 을 받아서 try catch 로 예외 처리 해주기 !!
		try {
			db.insert(vo);
		} catch (Exception e) {
			ta.setText("입력이 실패하였습니다." + e.getMessage());
		} // ta.setText 로 사용자 화면에 입력실패 화면을 띄워주고 개발자 입장에서 원인을 분석 하기 위해 e.getMessage로 실패 원인
			// 간략하게 띄우기

		clearTextField();
	} // 사용자가 입력한 값을 가져와서 변수에 넣기

	void clearTextField() {
		tf_name.setText(null);
		tf_id.setText(null);
		tf_tel.setText(null);
		tf_gender.setText(null);
		tf_age.setText(null);
		tf_home.setText(null);
	}

	public static void main(String args[]) {
		System.out.println("Starting DBTest...");
		InfoView mainFrame = new InfoView();
		mainFrame.setup();
		mainFrame.eventProc();
	}
}
