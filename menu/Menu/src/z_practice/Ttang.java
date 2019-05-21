package z_practice;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Ttang extends JPanel {
	//Menupan에서 받은 버튼들로 탭 구성
	Ttang(JButton a, JButton b, JButton c){
		super(new GridLayout(1, 3));
		add(a);
		add(b);
		add(c);
	}
}
