import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class LoginFrame extends JFrame implements ActionListener {
 
    BufferedImage img = null;
    JTextField loginTextField;
    JPasswordField passwordField;
    JButton bt;
    
    CoffeShop cs = new CoffeShop();
  
 
    
 
    // 생성자
    public LoginFrame() {
        setTitle("로그인 테스트");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // 레이아웃 설정
        setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1600, 900);;
        layeredPane.setLayout(null);
 
        // 패널1
        // 이미지 받아오기
        try {
            img = ImageIO.read(new File("D:\\mywork\\java\\workspace\\CafePos\\src\\img\\login.png"));
        } catch (IOException e) {
            System.out.println("이미지 불러오기 실패"+ e.getMessage());
            e.printStackTrace();
            
           
            System.exit(0);
        }
         
        MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 1600, 900);
         
 
        // 로그인 필드
        loginTextField = new JTextField(15);
        loginTextField.setBounds(731, 399, 280, 30);
        layeredPane.add(loginTextField);
        loginTextField.setOpaque(false);
        loginTextField.setForeground(Color.green);
        loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        // 패스워드
        passwordField = new JPasswordField(15);
        passwordField.setBounds(731, 529, 280, 30);
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.green);
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        layeredPane.add(passwordField);
 
        // 로그인버튼 추가
        bt = new JButton(new ImageIcon("D:\\mywork\\java\\workspace\\CafePos\\src\\img\\btLogin_hud.png"));
        bt.setBounds(755, 689, 104, 48);
 
        // 버튼 투명처리
        bt.setBorderPainted(false);
        bt.setFocusPainted(false);
        bt.setContentAreaFilled(false);
 
        layeredPane.add(bt);
 
        // 마지막 추가들
        layeredPane.add(panel);
        add(layeredPane);
        setVisible(true);
        cs.setVisible(false);
    }
    public void eventProc() {
		// 이벤트 등록
    	bt.addActionListener(this);
		
		
	}
    public void actionPerformed(ActionEvent ev) {
    	
    
    	if(ev.getSource() == bt) {
//    		JOptionPane.showMessageDialog(null,"로그인");
    		cs.setVisible(true);
    	}
    }
    

	public void connectDB() {
		// DB연결
	}
     	
    // 메인
    public static void main(String[] args) {
        LoginFrame lf = new LoginFrame();
        lf.eventProc();
        lf.connectDB();
        
        
    }
    	
    class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
 
}