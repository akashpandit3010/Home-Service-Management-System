package main;
import com.mypackage.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfusername;
	private JTextField tfaddress;
	private JTextField tfmobile;
	private JTextField tfmail;
	private JPasswordField tfpassword;
	
	public RegisterGUI() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Register Page");
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(70, 159, 64, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(70, 191, 64, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile");
		lblNewLabel_3.setBounds(70, 224, 64, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(70, 259, 64, 13);
		getContentPane().add(lblNewLabel_4);
		
		tfusername = new JTextField();
		tfusername.setBounds(153, 124, 200, 19);
		getContentPane().add(tfusername);
		tfusername.setColumns(10);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(154, 188, 200, 19);
		getContentPane().add(tfaddress);
		tfaddress.setColumns(10);
		
		tfmobile = new JTextField();
		tfmobile.setBounds(154, 221, 200, 19);
		getContentPane().add(tfmobile);
		tfmobile.setColumns(10);
		
		tfmail = new JTextField();
		tfmail.setBounds(154, 256, 199, 19);
		getContentPane().add(tfmail);
		tfmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(70, 127, 64, 13);
		getContentPane().add(lblNewLabel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfusername.getText();
				String password = new String(tfpassword.getPassword());
				String address = tfaddress.getText();
				String mobile = tfmobile.getText();
				String email = tfmail.getText();
				Authenticate a = new Authenticate();
				a.registerUser(name, password, address, mobile, email);
				dispose();
				LoginGUI l=new LoginGUI("User Registered! Please Login");
				l.setVisible(true);
			}
		});
		btnRegister.setBounds(312, 329, 85, 21);
		getContentPane().add(btnRegister);
		
		tfpassword = new JPasswordField();
		tfpassword.setBounds(163, 156, 190, 19);
		getContentPane().add(tfpassword);
	}
}
