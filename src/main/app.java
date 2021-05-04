package main;

import javax.swing.JButton;
import javax.swing.JFrame;

public class app {

	public static void main(String[] args) {
		JFrame f = new JFrame("test");
		
		JButton btn = new JButton();
		btn.setText("gonder");
		btn.setBounds(300, 100, 100, 30);
		
		JButton btn2 = new JButton();
		btn2.setText("Move");
		btn2.setBounds(300, 50, 100, 30);
		
		f.add(btn);
		f.add(btn2);
		f.setSize(500, 300);
		f.setLayout(null);
		f.setVisible(true);
		//test comment
		//??
		//333

	}

}
