package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mypackage.Authenticate;
import javax.swing.JPasswordField;

//import MyFrame.Welcome2;

public class LoginGUI extends JFrame implements ActionListener {
	
	static String username, password;
	private static final long serialVersionUID = 1L;
	// private JPanel contentPane;
	private JTextField textField;
	private JButton btnLogin, btnRegister;
	private JLabel warninglabel;
	private JRadioButton rdbtnUser;
	private JRadioButton rdbtnSP;
	private ButtonGroup bg;
	private JPasswordField passwordField;

	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Page");
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		// setLayout(new FlowLayout());
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(100, 85, 86, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(100, 120, 73, 13);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(200, 82, 134, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(101, 178, 85, 21);
		btnRegister.addActionListener(this);
		getContentPane().add(btnRegister);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(249, 178, 85, 21);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);

		warninglabel = new JLabel("");
		warninglabel.setBackground(Color.PINK);
		warninglabel.setBounds(10, 209, 476, 44);

		getContentPane().add(warninglabel);
		
		rdbtnUser = new JRadioButton("User");
		rdbtnUser.setBounds(143, 151, 66, 21);
		getContentPane().add(rdbtnUser);
		
		rdbtnSP = new JRadioButton("Service Provider");
		rdbtnSP.setBounds(210, 151, 126, 21);
		getContentPane().add(rdbtnSP);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(200, 117, 134, 19);
		getContentPane().add(passwordField);
	}
	public LoginGUI(String msg) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Page");
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		// setLayout(new FlowLayout());
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(100, 85, 86, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(100, 120, 73, 13);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(200, 82, 134, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(101, 178, 85, 21);
		btnRegister.addActionListener(this);
		getContentPane().add(btnRegister);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(249, 178, 85, 21);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);

		warninglabel = new JLabel(msg);
		warninglabel.setBackground(Color.PINK);
		warninglabel.setBounds(10, 209, 476, 44);

		getContentPane().add(warninglabel);
		
		rdbtnUser = new JRadioButton("User");
		rdbtnUser.setBounds(143, 151, 66, 21);
		getContentPane().add(rdbtnUser);
		
		rdbtnSP = new JRadioButton("Service Provider");
		rdbtnSP.setBounds(210, 151, 126, 21);
		getContentPane().add(rdbtnSP);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(200, 117, 134, 19);
		getContentPane().add(passwordField);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			username = textField.getText();
			password = new String(passwordField.getPassword());
			Authenticate a = new Authenticate();
			if (a.authenticate(username, password))
			{
				
				dispose();
				this.setVisible(false);
				if(rdbtnUser.isSelected())
					{
						UserGUI u=new UserGUI();
						u.setVisible(true);
					}
					
				if(rdbtnSP.isSelected())
					new ServiceProviderGUI();
				//new Welcome2();
			}
			else {
				warninglabel.setText("Incorrect Username/Password");
			}
		}
		if (e.getSource() == btnRegister) {
			dispose();
			new RegisterGUI();
			
		}
	}
	String getUsername()
	{
		return username;
	}
}
