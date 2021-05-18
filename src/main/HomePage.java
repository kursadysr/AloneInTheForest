package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class HomePage {

	private JFrame frame;
	private JTextField txtAcasdfasd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("images/background.jpeg");
		
		JButton btnNewButton = new JButton("Inventory");
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(370, 245, 130, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Explore");
		btnNewButton_1.setBounds(370, 215, 130, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Move");
		btnNewButton_2.setBounds(370, 185, 130, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sleep");
		btnNewButton_3.setBounds(245, 245, 130, 30);
		frame.getContentPane().add(btnNewButton_3);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setToolTipText("");
		progressBar.setStringPainted(true);
		progressBar.setValue(45);
		progressBar.setBounds(10, 170, 145, 20);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("",img, JLabel.CENTER);
		lblNewLabel.setBounds(0, 0, 510, 320);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		

		frame.setBounds(100, 100, 500, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
