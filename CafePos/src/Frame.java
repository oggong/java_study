import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Frame extends JFrame{
	
	private CardLayout cards = new CardLayout();
	
	public Frame() {
		setSize(330, 100);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		getContentPane().add("One", new P_One(this));
		getContentPane().add("Two", new P_Two(this));

		setVisible(true);

	}

	public void changePanel() {
		cards.next(this.getContentPane());
	}

}
