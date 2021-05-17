package main;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frmAloneInThe;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAloneInThe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAloneInThe = new JFrame();
		frmAloneInThe.setTitle("Alone In The Forest");
		frmAloneInThe.setResizable(false);
		frmAloneInThe.getContentPane().setLayout(null);
		frmAloneInThe.setSize(500, 320);
		ImageIcon img = new ImageIcon("images/background.png");
		Image image = img.getImage().getScaledInstance(500, 320, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(image);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(145, 143, 80, 20);
		frmAloneInThe.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setOpaque(true);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(145, 181, 80, 20);
		frmAloneInThe.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setOpaque(true);
		
		textField = new JTextField();
		textField.setBounds(237, 140, 130, 25);
		frmAloneInThe.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 178, 130, 25);
		frmAloneInThe.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign-In");
		btnNewButton.setBounds(140, 215, 110, 30);
		frmAloneInThe.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log-In");
		btnNewButton_1.setBounds(260, 215, 110, 30);
		frmAloneInThe.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("",img, JLabel.CENTER);
		lblNewLabel.setBounds(0, 0, 500, 320);
		frmAloneInThe.getContentPane().add(lblNewLabel);
		frmAloneInThe.setBounds(100, 100, 500, 320);
		frmAloneInThe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
