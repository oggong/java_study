package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.VideoModel;
import model.vo.Video;

public class VideoView extends JPanel {
	// member field
	JTextField tfVideoNum, tfVideoTitle, tfVideoDirector, tfVideoActor;
	JComboBox comVideoJanre;
	JTextArea taVideoContent;

	JCheckBox cbMultiInsert;
	JTextField tfInsertCount;

	JButton bVideoInsert, bVideoModify, bVideoDelete;

	JComboBox comVideoSearch;
	JTextField tfVideoSearch;
	JTable tableVideo; // view 역할만

	VideoTableModel tbModelVideo;

	VideoModel db;

	// ##############################################
	// constructor method
	public VideoView() {
		addLayout(); // 화면설계
		initStyle();
		eventProc();
		connectDB(); // DB연결
	}

	public void connectDB() { // DB연결
		try {
			db = new VideoModel();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eventProc() {
		ButtonEventHandler hdlr = new ButtonEventHandler();
		bVideoInsert.addActionListener(hdlr);
		bVideoModify.addActionListener(hdlr);
		bVideoDelete.addActionListener(hdlr);
		tfVideoSearch.addActionListener(hdlr); // 버튼 아니어도 이벤트 가능

		cbMultiInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInsertCount.setEditable(cbMultiInsert.isSelected());
				// 체크박스가 선택이 되서 true 가 되면 편집가능
				// 체크박스가 선택이 되서 false 가 되면 편집 불가능

			}
		}); // 액션리스너를 상속받아 이름없는 클래스를 선언함과 동시에 객체 생성

		// JTable 비디오 검색을 클릭 했을때
		tableVideo.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = tableVideo.getSelectedRow();
				int vNum = (Integer)tableVideo.getValueAt(row, col); // 1.5 버전 이후로 casting
//				JOptionPane.showMessageDialog(null,vNum);
				
				// 1. 선택한 비디오 번호를 모델단의 selectByPK() 호출시 인자로 보내기
				// 2. 넘겨 받은 Video 에서 해당 값들 화면 출력하기 
				Video vo;
				try {
					vo = db.selectByPk(vNum);
					tfVideoNum.setText(String.valueOf(vo.getVideoNo()));
					comVideoJanre.setSelectedItem(vo.getGenre());
					tfVideoTitle.setText(vo.getVideoName());
					tfVideoDirector.setText(vo.getDirector());
					tfVideoActor.setText(vo.getActor());
					// 나머지도
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}

	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			Object o = ev.getSource();

			if (o == bVideoInsert) {
				registVideo(); // 비디오 등록
			} else if (o == bVideoModify) {
				modifyVideo(); // 비디오 정보 수정
			} else if (o == bVideoDelete) {
				deleteVideo(); // 비디오 정보 삭제
			} else if (o == tfVideoSearch) {
				searchVideo(); // 비디오 검색
			}
		}
	}

	// 입고 클릭시 - 비디오 정보 등록
	public void registVideo() {
		Video vo = new Video();
//		JOptionPane.showMessageDialog(null, "입고");
		// 1.화면의 입력 및 선택 값들 얻어오기 -> Video(=vo) 객체로 생성 \

//		vo.setVideoNo(Integer.parseInt(tfVideoNum.getText()));
		vo.setGenre((String) comVideoJanre.getSelectedItem());
		vo.setVideoName(tfVideoTitle.getText());
		vo.setDirector(tfVideoDirector.getText());
		vo.setActor(tfVideoActor.getText());
		vo.setExp(taVideoContent.getText());
		int count = Integer.parseInt(tfInsertCount.getText());

		// 2. 모델단의 메소드 1번값들 전송
		try {
			db.insertVideo(vo, count);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initStyle() { // 입력하지 못하게 만듬.
		tfVideoNum.setEditable(false); // setEnable 은 값도 못가져오게 됨
		tfInsertCount.setEditable(false);
		tfInsertCount.setHorizontalAlignment(JTextField.RIGHT);
	}

	// 수정 클릭시 - 비디오 정보 수정
	public void modifyVideo() {
		JOptionPane.showMessageDialog(null, "수정");
	}

	// 삭제 클릭시 - 비디오 정보 삭제
	public void deleteVideo() {

		JOptionPane.showMessageDialog(null, "삭제");
	}

	// 비디오현황검색
	public void searchVideo() {
//		JOptionPane.showMessageDialog(null, "검색");
		// 글씨보다 index 처리해서 받아오려 한다.
		int sel = comVideoSearch.getSelectedIndex();

		String word = tfVideoSearch.getText();
		try {
			// 검색 결과를 화면 JTable의 내용을 담당하는 TableModel 안의 data에 지정
			tbModelVideo.data = db.SearchVideo(sel, word);
			tbModelVideo.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 화면설계 메소드
	public void addLayout() {
		// 멤버변수의 객체 생성
		tfVideoNum = new JTextField();
		tfVideoTitle = new JTextField();
		tfVideoDirector = new JTextField();
		tfVideoActor = new JTextField();

		String[] cbJanreStr = { "멜로", "엑션", "스릴", "코미디" };
		comVideoJanre = new JComboBox(cbJanreStr);
		taVideoContent = new JTextArea();

		cbMultiInsert = new JCheckBox("다중입고");
		tfInsertCount = new JTextField("1", 5);

		bVideoInsert = new JButton("입고");
		bVideoModify = new JButton("수정");
		bVideoDelete = new JButton("삭제");

		String[] cbVideoSearch = { "제목", "감독" };
		comVideoSearch = new JComboBox(cbVideoSearch);
		tfVideoSearch = new JTextField(15);

		tbModelVideo = new VideoTableModel();
		tableVideo = new JTable(tbModelVideo);

		// *********************************************************************
		// 화면 구성

		// 왼쪽 영역
		JPanel p_west = new JPanel();
//		p_west.setBorder(new TitledBorder("WEST")); // title
		p_west.setLayout(new BorderLayout());
		// 왼쪽- 메인 영역
		JPanel p_west_c = new JPanel();
		p_west_c.setLayout(new BorderLayout());

		// 왼쪽-메인 - 중앙
		JPanel p_west_c_c = new JPanel();
		p_west_c_c.setBorder(new TitledBorder("비디오정보입력"));
		p_west_c.add(p_west_c_c, BorderLayout.CENTER);

		// 비디오 정보 입력 부분
		JPanel p_w_c_c_1 = new JPanel();
		p_w_c_c_1.setLayout(new GridLayout(5, 2));
		p_w_c_c_1.add(new JLabel("비디오 번호"));
		p_w_c_c_1.add(tfVideoNum);
		p_w_c_c_1.add(new JLabel("장르"));
		p_w_c_c_1.add(comVideoJanre);
		p_w_c_c_1.add(new JLabel("제목"));
		p_w_c_c_1.add(tfVideoTitle);
		p_w_c_c_1.add(new JLabel("감독"));
		p_w_c_c_1.add(tfVideoDirector);
		p_w_c_c_1.add(new JLabel("배우"));
		p_w_c_c_1.add(tfVideoActor);

		// 비디오 설명 입력 부분
		JPanel p_w_c_c_2 = new JPanel();
		p_w_c_c_2.setLayout(new BorderLayout());
		p_w_c_c_2.add(new JLabel("설명"), BorderLayout.WEST);
		p_w_c_c_2.add(taVideoContent, BorderLayout.CENTER);

		p_west_c_c.setLayout(new GridLayout(2, 1));
		p_west_c_c.add(p_w_c_c_1);
		p_west_c_c.add(p_w_c_c_2);

		// 왼쪽-메인 -아래
		JPanel p_west_c_s = new JPanel();
		p_west_c_s.setBorder(new TitledBorder("다중입고시 선택하시오"));
		p_west_c_s.add(cbMultiInsert);
		p_west_c_s.add(tfInsertCount);
		p_west_c_s.add(new JLabel("개"));

		p_west_c.add(p_west_c_s, BorderLayout.SOUTH);

		p_west.add(p_west_c, BorderLayout.CENTER);
		// 왼쪽 - 버튼 영역
		JPanel p_west_south = new JPanel();
		p_west_south.add(bVideoInsert);
		p_west_south.add(bVideoModify);
		p_west_south.add(bVideoDelete);
		p_west.add(p_west_south, BorderLayout.SOUTH);

		p_west_south.setLayout(new GridLayout(1, 3));

		// 오른쪽 영역
		JPanel p_east = new JPanel();
		p_east.setBorder(new TitledBorder("비디오검색")); // title
		p_east.setLayout(new BorderLayout());

		JPanel p_east_north = new JPanel();
		p_east_north.add(comVideoSearch);
		p_east_north.add(tfVideoSearch);

		p_east.add(p_east_north, BorderLayout.NORTH);
		p_east.add(new JScrollPane(tableVideo), BorderLayout.CENTER); // tableVideo 는 뷰만 제공

		// 전체 영역 붙히기
		setLayout(new GridLayout(1, 2));
		add(p_west);
		add(p_east);
	}

	// 화면에 테이블 붙이는 메소드
	class VideoTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "비디오번호", "제목", "장르", "감독", "배우" };

		// =============================================================
		// 1. 기본적인 TabelModel 만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

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
