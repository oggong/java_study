import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import view.CafePosView;

public class CoffeLogin extends JFrame {
	CafePosView cafepos;
	// JFrame 상속해서 세팅
	// 레이아웃 잡기
	// 각각의 패널과 컴포넌트 설정(이미지패널 , 텍스트필드 , 버튼)

	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt;
	
	
	public static void main(String[] args) {
		new CoffeLogin();

	} // end of main

	public CoffeLogin() {

		setTitle("테스트");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 안에 들어갈 내용물들 ,레이아웃,패널설정,컴포넌트들

		// 레이아웃
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1600, 900);
		layeredPane.setLayout(null);
		
		// 패널 1
		// 이미지 받아오기
		
		try {
			img = ImageIO.read(new File("img/"));
		} catch (IOException e) {
			System.out.println("이미지 불러오기 실패");
		}
		
		cafepos = new CafePosView();
		cafepos.setBounds(0,0,1600,900);
		
		// 로그인 필드
		
		loginTextField = new JTextField(15);
		loginTextField.setBounds(731,399,280,30);
		layeredPane.add(loginTextField);
		loginTextField.setOpaque(false);
		loginTextField.setForeground(Color.green);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		// 패스워드
		passwordField = new JPasswordField();
		passwordField.setBounds(731, 529, 280, 30);
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.green);
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        layeredPane.add(passwordField);
        
        // 로그인버튼 추가
        bt = new JButton(new ImageIcon(""));
        bt.setBounds(755, 689, 104, 48);
        
        // 버튼 투명처리
        bt.setBorderPainted(false);
        bt.setFocusPainted(false);
        bt.setContentAreaFilled(false);
        
        layeredPane.add(bt);
		 
		
	
        layeredPane.add(cafepos);
		add(layeredPane);
		
		setVisible(true);
		
	} // end of Constructor(CoffeLogin)

}// end of Class
