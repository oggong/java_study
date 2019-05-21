package z_practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Menupan extends JFrame {
	//멤버변수 선언
	Best b;
	Anju a;
	Ttang t;
	JButton [] menu = new JButton [9];
	JButton add, total, cancel, order;
	JTextField tf;
	JLabel won;
	HashMap <JButton, Integer> price = new HashMap <JButton, Integer>();
	int [] pr = {17000, 12000, 16000, 14000, 18000, 17000, 20000, 15000, 14000};
	String [] me = {"한신닭발", "한신통닭", "치즈돼지고추장바베큐", "오돌뼈", "낙지볶음", "새우알찜", "김치전골", "고추장찌개", "오뎅탕"};
	int count [] = new int [9];
	String s = "";
	ArrayList <JButton> list = new ArrayList <JButton>();
	
	//버튼에 메뉴 사진 추가~
	Menupan(){
		super("한신포차");
		for(int i = 0; i < menu.length; i++) {
			menu[i] = new JButton(new ImageIcon("src/img/" + (i+5) + ".PNG"));
			price.put(menu[i], pr[i]);
			count[i] = 0;
		}
		
		//각 탭마다 해당 메뉴 부여
		b = new Best(menu[0], menu[1], menu[2]);
		a = new Anju(menu[3], menu[4], menu[5]);
		t = new Ttang(menu[6], menu[7], menu[8]);
		
		//추가, 취소, 총 가격, 주문 버튼 생성
		add = new JButton("Add");
		cancel = new JButton("Cancel");
		total = new JButton("Total");
		order = new JButton("Order");
		tf = new JTextField(50);
		won = new JLabel("원");
	}
	//화면 구성
	void addLayout() {
		//각 탭들 붙이기
		setLayout(new BorderLayout());
		JTabbedPane  pan = new JTabbedPane();
		pan.add("대표메뉴", b);
		pan.add("안주메뉴", a);
		pan.add("탕 메뉴", t);
		add(pan, BorderLayout.CENTER);
		
		//만든 버튼들 Panel에 붙여서 아래에 붙이기
		JPanel p = new JPanel(new FlowLayout());
		p.add(tf);
		p.add(add);
		p.add(cancel);
		p.add(total);
		p.add(won);
		p.add(order);
		add(p, BorderLayout.SOUTH);
		
		//메뉴판 사이즈 설정
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(3);
		
	}
	// 각 버튼들마다 이벤트 등록
	void eventProc() {
		BtnHdlr bh = new BtnHdlr();
		
		for(int i = 0; i < menu.length; i++) {
			menu[i].addActionListener(bh);
		}
		add.addActionListener(bh);
		cancel.addActionListener(bh);
		total.addActionListener(bh);
		order.addActionListener(bh);
	}
	//메뉴 추가
	void addList() {
		for(int i = 0; i < menu.length; i++) {
			if(count[i] == 1) {
				list.add(menu[i]);
				menu[i].setBorder(null);
				count[i] = 0;
				s += me[i] + " ";
			}
		}
		tf.setText(s);
	}
	// 주문 메뉴 총 가격 보여주기
	void totalPrice() {
		int sum = 0;
		for(JButton jb : list) {
			sum += price.get(jb);
		}
		won.setText(String.valueOf(sum)+"원");
	}
	// 마지막에 시킨 주문 취소하기
	void cancelList() {
		StringTokenizer st = new StringTokenizer(s, " ");
		int a = st.countTokens();
		s = "";
		while(a > 1) {
			s += st.nextToken() + " ";
			a--;
		}
		if(list.size() >= 1) list.remove(list.size() - 1);
		tf.setText(s);
	}
// 이벤트핸들러 클래스 
class BtnHdlr implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton)e.getSource();
		for(int i = 0; i < menu.length; i++) {
			if(obj == menu[i] && count[i] == 0) {
				menu[i].setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 5));
				count[i]++;
			}else if(obj == menu[i] && count[i] == 1) {
				menu[i].setBorder(null);
				count[i] = 0;
			}
		}if(obj == add) {
			addList();
		}else if(obj == total) {
			totalPrice();
		}else if(obj == cancel) {
			cancelList();
		}else if(obj == order) {
			int i = JOptionPane.showConfirmDialog(null, "주문하시겠습니까?");
			if(i == 0) {
				JOptionPane.showMessageDialog(null, "주문 완료~");
				list.removeAll(list);
				s = "";
			}
		}
		
	}
	
}
	public static void main(String[] args) {
		Menupan p = new Menupan();
		p.addLayout();
		p.eventProc();
	}

}
