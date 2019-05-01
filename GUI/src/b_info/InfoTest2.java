package b_info;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

public class InfoTest2 {
	// 1. 멤버 변수 선언
	JFrame f;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
	JTextArea ta;
	JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;

	ArrayList<Person> list = new ArrayList<Person>();

	// 2. 멤버 객체 생성
	InfoTest2() {
		f = new JFrame("DBTest");
		bAdd = new JButton("Add", new ImageIcon("src/img/insta.png"));
		bAdd.setRolloverIcon(new ImageIcon("src/img/facebook.png"));
		bAdd.setPressedIcon(new ImageIcon("src/img/twit.png"));
		bAdd.setToolTipText("디비에 입력합니다.");
		bAdd.setMnemonic('i'); // alt+ i
		bAdd.setVerticalTextPosition(JButton.BOTTOM);
		bAdd.setHorizontalTextPosition(JButton.CENTER);

		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
		ta = new JTextArea();
		tfName = new JTextField(15);
		tfId = new JTextField();
		tfTel = new JTextField();
		tfSex = new JTextField();
		tfAge = new JTextField();
		tfHome = new JTextField();

	}

	// 3. 화면 붙이기 및 화면 출력
	void addLayout() {
		// South 영역
		JPanel p_south = new JPanel();
		p_south.setLayout(new GridLayout(1, 6));
		p_south.add(bAdd);
		p_south.add(bShow);
		p_south.add(bSearch);
		p_south.add(bDelete);
		p_south.add(bCancel);
		p_south.add(bExit);

		// West 영역
		JPanel p_west = new JPanel();
		p_west.setLayout(new GridLayout(6, 2));
		p_west.add(new JLabel("이름"));
		p_west.add(tfName);
		p_west.add(new JLabel("ID"));
		p_west.add(tfId);
		p_west.add(new JLabel("Tel"));
		p_west.add(tfTel);
		p_west.add(new JLabel("Sex"));
		p_west.add(tfSex);
		p_west.add(new JLabel("Age"));
		p_west.add(tfAge);
		p_west.add(new JLabel("Home"));
		p_west.add(tfHome);

		// textArea

		// 프레임 영역에 붙이기
		f.setLayout(new BorderLayout());
		f.add(p_south, BorderLayout.SOUTH);
		f.add(p_west, BorderLayout.WEST);
		f.add(ta, BorderLayout.CENTER);

		f.setSize(700, 500);
		f.setVisible(true);

	}

	// 4. 이벤트 등록
	void eventProc() {
		BtnHdlr bh = new BtnHdlr();

		// 버튼과 이벤트핸들러 연결
		bAdd.addActionListener(bh);
		bShow.addActionListener(bh);
		bSearch.addActionListener(bh);
		bDelete.addActionListener(bh);
		bCancel.addActionListener(bh);
		bExit.addActionListener(bh);

		// 전화번호 텍스트 필드 엔터 이벤트
//		TfHdlr th = new TfHdlr();
//		tfTel.addActionListener(th); 
		tfTel.addActionListener(new TfHdlr());

		// 전화번호 텍스트 필드 포커스 이벤트
		tfId.addFocusListener(new IdFocus());
	} // end of eventProc()

	class IdFocus implements FocusListener {

		public void focusGained(FocusEvent e) {

		}

		public void focusLost(FocusEvent e) {
			// focus 를 잃었을때
			String id = tfId.getText();
			char sung = id.charAt(7);

			char chul = id.charAt(8);

			String home = "";
			switch (chul) {
			case '0':
				tfHome.setText("서울");
				break;
			case '1':
				tfHome.setText("인천/부산");
				break;
			case '2':
				tfHome.setText("경기");
				break;
			case '9':
				tfHome.setText("제주");
				break;
			default:
				tfHome.setText("한국인");
			}

			String nai = id.substring(0, 2);

			int nai1 = Integer.parseInt(nai);

			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);

			if (sung == '1' | sung == '3') {
				tfSex.setText("남자");
			} else {
				tfSex.setText("여자");
			}

			if (sung == '1' | sung == '2') {
				tfAge.setText(String.valueOf(year - (1900 + nai1) + 1));
			} else if (sung == '3' | sung == '4') {
				tfAge.setText(String.valueOf(year - (2000 + nai1) + 1));

			}

//			System.out.println("포커스 잃음");
		}

	}

	class TfHdlr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			searchTel();
		} // action Performed

	} // end of TfHdlr

	void searchTel() {
		System.out.println("전화번호이벤트");
		// (1) 사용자가 입력한 전화번호 얻어오기
		String tel = tfTel.getText();
		// (2) ArrayList 의 각 Person의 tel과 비교해서 같은지
		for (Person p : list) {
			if (p.getTel().equals(tel)) {
				// (3) 해당 Person의 멤버값들을 각각 텍스트 필드에 출력
				tfName.setText(p.getName());
				tfId.setText(p.getId());
				tfTel.setText(p.getTel());
				tfSex.setText(p.getGender());
				tfAge.setText(String.valueOf(p.getAge())); // int 를 string 으로
				tfHome.setText(p.getHome());
			}
		}
	}

	class BtnHdlr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			System.out.println("이벤트 발생");
			Object evt = e.getSource();
			if (evt == bAdd) {// 입력 버튼이 눌려졌을때
				insert(); // 함수 하나 빼서 호출!
				clearTextField();
			} else if (evt == bShow) {
				showInfo();
			} else if (evt == bSearch) {
				searchTel();
			} else if (evt == bDelete) {
				DeleteInfo();
			} else if (evt == bCancel) {
				clearTextField();
			} else if (evt == bExit) {
//				System.exit(0); // 종료 버튼이 눌렀을 때 강제프로그램 종료 (System.exit(0);)
				exit();
			}
		}
	}

	void insert() {
		// (1) 각 텍스트 필드의 입력값을 얻어오기
		// (2) 1번값들을 Person 멤버 지정 (1- 생성자 / 2- setter)
		// (3) ArrayList에 2번 객체를 추가

//		String name = tfName.getText(); // 사용자 입력 값을 저장
//		// 나머지도 같은 방식으로
//		p.setName(name);
//		list.add(p);

		Person p = new Person();
		p.setName(tfName.getText());
		p.setId(tfId.getText());
		p.setTel(tfTel.getText());
		p.setGender(tfSex.getText());
		p.setAge(Integer.parseInt(tfAge.getText()));
		p.setHome(tfHome.getText());
		list.add(p);

	}

	void clearTextField() {
		tfName.setText(null);
		tfId.setText(null);
		tfTel.setText(null);
		tfSex.setText(null);
		tfAge.setText(null);
		tfHome.setText(null);
	}

	void DeleteInfo() {
		// (1) 사용자 입력한 전화번호 얻어오기
		String tel = tfTel.getText();
		// (2) ArrayList의 각 Person 의 tel 과 비교해서 같은지
		for (Person p : list) {
			if (p.getTel().equals(tel)) {
				list.remove(p);
				break;
			} // 한개 값을 넣고 한개 값을 지울 때 지워지지 않는 이유는 1.향상된 for문의 문제거나 remove의 문제 일 가능성이 높음!
		}
	}

	void showInfo() {
		ta.setText("======================전체 보기 ====================\n\n");
		for (Person p : list) {
//			System.out.println(p); // 자동으로 string 을 불러주기 때문에 에러 놉

			ta.append(p.toString());
		}
	}

	void exit() { // exit 메소드로 만들어줘서 밖에 서술해주기 (정리 )
		int result = JOptionPane.showConfirmDialog(null, "정말로 나가실 겁니까?");
		if (result == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		InfoTest2 it = new InfoTest2();
		it.addLayout();
		it.eventProc();
	}

}
