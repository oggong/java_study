package z_practice;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Best extends JPanel {
	
//	static Menupan parrent;
	//Menupan에서 받은 버튼들로 탭 구성
	Best(JButton a, JButton b, JButton c) {
		super(new GridLayout(1, 2));
		add(a);
		JPanel p = new JPanel(new GridLayout(2,1));
		p.add(b);
		p.add(c);
		add(p);
	}
}
