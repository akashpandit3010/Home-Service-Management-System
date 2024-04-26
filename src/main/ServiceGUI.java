package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ServiceGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginGUI l=new LoginGUI();
			l.setVisible(true);
		}catch(Exception e) {}
		//LoginGUI l=new LoginGUI();
		//username = l.getUsername();
	}
}

