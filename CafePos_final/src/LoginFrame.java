import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.dao.LoginModel;
//import model.LoginModel;
import model.vo.Login;

public class LoginFrame extends JFrame implements ActionListener {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "GodTwo";
	String pass = "1234";
	Connection con;

	BufferedImage img = null;
	JTextField loginTextField;
	JTextField passwordField;
	JButton bt;

	CoffeShop cs;
	LoginModel db;
	Font f = new Font("맑은 고딕", Font.BOLD, 20);

	JButton btn;

	// 생성자

	public LoginFrame() {
		try {
//    			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel"); // 맥 스타일
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // 윈도우 스타일

			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			System.out.println("gdgasd");
		}

		setTitle("CafePos LOGIN SYSTEM");
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 레이아웃 설정
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1024, 768);
		layeredPane.setLayout(null);

		// 패널1
		// 이미지 받아오기
		try {
			img = ImageIO.read(new File("D:\\mywork\\java\\workspace\\CafePos_final\\src\\img\\loginframe.png"));
		} catch (IOException e) {
			System.out.println("이미지 불러오기 실패" + e.getMessage());
			e.printStackTrace();

			System.exit(0);
		}

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1024, 768);

		// 로그인 필드
		loginTextField = new JTextField(15);
//            loginTextField.setBounds(731, 399, 280, 30);
		loginTextField.setBounds(380, 424, 250, 30);
		loginTextField.setFont(f);
		layeredPane.add(loginTextField);
		loginTextField.setOpaque(false);
		loginTextField.setForeground(Color.BLACK);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// 패스워드
		passwordField = new JPasswordField(15);
//            passwordField.setBounds(731, 529, 280, 30);
		passwordField.setBounds(380, 494, 250, 30);
		passwordField.setFont(f);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);

		// 로그인버튼 추가
//    		bt = new JButton("LOGIN");
		btn = new JButton("LOGIN");
		btn.setBounds(410, 550, 150, 60);
		// 버튼 투명처리
		btn.updateUI();
//    		bt.updateUI();
//    		bt.setBorderPainted(false);
//    		bt.setFocusPainted(false);
//    		bt.setContentAreaFilled(false);

//    		layeredPane.add(bt);
		layeredPane.add(btn);
		// 마지막 추가들
		layeredPane.add(panel);
		layeredPane.updateUI();
		add(layeredPane);
		setVisible(true);
//    		cs.setVisible(false);
//    		cs.setEnabled(false);
	}

	public void eventProc() {
		// 이벤트 등록
		btn.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ev) {

		Login login;
		login = new Login();
		// Login[] str= new Login[2];
		String id = loginTextField.getText();
		String pass = passwordField.getText();

		try {
			db = new LoginModel();
			login = db.LoginCheck(id, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ev.getSource() == btn) {
////		JOptionPane.showMessageDialog(null,"로그인");

			// 로그인 참 거짓 여부를 판단
//	            boolean existLogin = LoginModel.LoginCheck(id, password);
			try {
				if (login.getEID().equals(id)) {
					if (login.getEPASS().equals(pass)) {
						JOptionPane.showMessageDialog(null, "로그인 성공");
						if (id.equals("GodTwo")) {
							cs = new CoffeShop();
//			                cs.setEnabled(true);
							cs.setVisible(true);
							this.setVisible(false);
						} else {
							cs = new CoffeShop();
//				                cs.setEnabled(true);
							cs.setVisible(true);
							this.setVisible(false);

//				                cs.pane = null;
//				                cs.pane.setVisible(false);
//				                cs.pane.set

//		            	

//			                cs.setEnabled(true);

						}
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "로그인 실패");
				ex.printStackTrace();
			}
		}

	}

	// 메인
	public static void main(String[] args) {
		LoginFrame lf = new LoginFrame();
		lf.eventProc();
		lf.connectDB();

	}

	public void connectDB() {
		try {
			db = new LoginModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

}