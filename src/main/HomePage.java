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
		ImageIcon img = new ImageIcon("images/background.png");
		
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
		progressBar.setBounds(10, 190, 145, 20);
		frame.getContentPane().add(progressBar);
		
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setStringPainted(true);
		progressBar_1.setValue(55);
		progressBar_1.setBounds(10, 215, 145, 20);
		frame.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setValue(65);
		progressBar_2.setStringPainted(true);
		progressBar_2.setBounds(10, 235, 145, 20);
		frame.getContentPane().add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setValue(75);
		progressBar_3.setStringPainted(true);
		progressBar_3.setBounds(10, 260, 145, 20);
		frame.getContentPane().add(progressBar_3);
		
		
		JLabel lblNewLabel = new JLabel("",img, JLabel.CENTER);
		lblNewLabel.setBounds(0, 0, 500, 320);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 500, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
