package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mypackage.Appointment;
import javax.swing.SwingConstants;

public class UserGUI extends JFrame implements ActionListener {

	private static String username;
	private static final long serialVersionUID = 1L;
	private JTable table, table1;
	private JRadioButton rdbtnBapp, rdbtnDapp;
	private JButton changePassword;
	private JButton updateButton;
	private JLabel lblNewLabel;
	private JRadioButton eapl;
	private JRadioButton kapl;
	private JRadioButton hmsal;
	private JRadioButton hscln;
	private JRadioButton grdn;
	private JPasswordField newPwd;
	//Appointment ap = new Appointment();
	private JLabel appt;
	private JButton getAppt;
	private JTextField dapptid;
	private JLabel lbdappt;
	private JButton dapptbtn;
	private JTable table_1, table_2;

	public UserGUI() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("User Page");
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		LoginGUI l = new LoginGUI();
		username = l.getUsername();

		
		
		JLabel demo = new JLabel("New label");
		demo.setBounds(41, 10, 133, 13);
		getContentPane().add(demo);
		demo.setText("Welcome " + username);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "admin");
			String appoint = "select *from user where username=?";
			PreparedStatement pstmt3 = con.prepareStatement(appoint);
			pstmt3.setString(1, username);
			ResultSet ap = pstmt3.executeQuery();
			ap.next();
			String add = ap.getString(3);
			String mob = ap.getString(4);
			String email = ap.getString(5);
			System.out.println(
					"\n\n--------------------------User Details--------------------------------------------: \nUsername: "
							+ username + "\nAddress: " + add + "\nMobile Number: " + mob + "\nEmail: " + email
							+ "\n\n");
			String[][] data = { { "Username", "Address", "Mobile", "Email" }, { username, add, mob, email } };
			String[] columnNames = { "Username", "Address", "Mobile", "Email" };
			table = new JTable(data, columnNames);
			getContentPane().add(table);
			table.setBounds(41, 33, 418, 34);

		} catch (Exception e) {
			System.out.println(e + "No User with this uername found:");
		}

		rdbtnBapp = new JRadioButton("Book Appointment");
		rdbtnBapp.setBounds(41, 159, 145, 21);
		getContentPane().add(rdbtnBapp);
		rdbtnBapp.addActionListener(this);

		rdbtnDapp = new JRadioButton("Delete Appointment");
		rdbtnDapp.setBounds(267, 159, 155, 21);
		getContentPane().add(rdbtnDapp);
		rdbtnDapp.addActionListener(this);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnBapp);
		bg.add(rdbtnDapp);

		changePassword = new JButton("Change Password");
		changePassword.setBounds(320, 82, 156, 21);
		getContentPane().add(changePassword);
		changePassword.addActionListener(this);

		updateButton = new JButton("Update Password");
		updateButton.setBounds(320, 80, 127, 21);
		getContentPane().add(updateButton);
		updateButton.addActionListener(this);
		updateButton.setVisible(false);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(26, 82, 187, 13);
		getContentPane().add(lblNewLabel);

		eapl = new JRadioButton("Electrical Appliances Repairing");
		eapl.setBounds(41, 216, 203, 21);
		getContentPane().add(eapl);
		eapl.addActionListener(this);
		eapl.setVisible(false);

		kapl = new JRadioButton("Kitchen Appliances Repairing");
		kapl.setBounds(41, 239, 218, 21);
		getContentPane().add(kapl);
		kapl.addActionListener(this);
		kapl.setVisible(false);

		hmsal = new JRadioButton("Home Saloon");
		hmsal.setBounds(41, 262, 156, 21);
		getContentPane().add(hmsal);
		hmsal.addActionListener(this);
		hmsal.setVisible(false);

		hscln = new JRadioButton("House Cleaning Services");
		hscln.setBounds(41, 285, 172, 21);
		getContentPane().add(hscln);
		hscln.addActionListener(this);
		hscln.setVisible(false);

		grdn = new JRadioButton("Gardening");
		grdn.setBounds(41, 308, 103, 21);
		getContentPane().add(grdn);
		grdn.addActionListener(this);
		grdn.setVisible(false);

		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(eapl);
		bg1.add(kapl);
		bg1.add(hmsal);
		bg1.add(hscln);
		bg1.add(grdn);

		newPwd = new JPasswordField();
		newPwd.setEchoChar('*');
		newPwd.setBounds(237, 82, 73, 19);
		getContentPane().add(newPwd);
		newPwd.setVisible(false);

		appt = new JLabel("");
		appt.setVerticalAlignment(SwingConstants.TOP);
		appt.setBounds(186, 335, 236, 74);
		getContentPane().add(appt);
		appt.setVisible(false);

		getAppt = new JButton("Get Appointment");
		getAppt.setBounds(41, 331, 133, 21);
		getContentPane().add(getAppt);
		getAppt.setVisible(false);
		getAppt.addActionListener(this);
		
		dapptid = new JTextField();
		dapptid.setBounds(292, 205, 96, 19);
		getContentPane().add(dapptid);
		dapptid.setColumns(10);
		dapptid.setVisible(false);
		
		lbdappt = new JLabel("Enter Appointment ID you want to Delete");
		lbdappt.setVerticalAlignment(SwingConstants.TOP);
		lbdappt.setBounds(55, 208, 236, 29);
		getContentPane().add(lbdappt);
		lbdappt.setVisible(false);
		
		dapptbtn = new JButton("Delete Appointment");
		dapptbtn.setBounds(155, 243, 172, 21);
		getContentPane().add(dapptbtn);
		
		
		dapptbtn.setVisible(false);
		dapptbtn.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changePassword) {
			changePassword.setVisible(false);
			updateButton.setVisible(true);
			newPwd.setVisible(true);
		}
		if (e.getSource() == updateButton) {
			String pwd = new String(newPwd.getPassword());
			if (pwd.equals("")) {
				
			} else {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root",
							"admin");
					String query = "update user set password = ? where username= ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, pwd);
					pstmt.setString(2, username);
					pstmt.executeUpdate();
					System.out.println("Password Changed Successful! ");
					lblNewLabel.setText("Password Changed Successful! ");
				} catch (Exception e1) {
					System.out.println(e1 + "Password change Failed!");
				}
			}

		}
		if (rdbtnBapp.isSelected()) {
			eapl.setVisible(true);
			kapl.setVisible(true);
			hmsal.setVisible(true);
			hscln.setVisible(true);
			grdn.setVisible(true);
			appt.setVisible(true);
			getAppt.setVisible(true);
			lbdappt.setVisible(false);
			dapptbtn.setVisible(false);
			dapptid.setVisible(false);
		}
		
		if (rdbtnDapp.isSelected()) {
			eapl.setVisible(false);
			kapl.setVisible(false);
			hmsal.setVisible(false);
			hscln.setVisible(false);
			grdn.setVisible(false);
			appt.setVisible(false);
			getAppt.setVisible(false);
			lbdappt.setText("Enter Appointment ID you want to Delete");
			lbdappt.setVisible(true);
			dapptbtn.setText("Delete Appointment");
			dapptbtn.setVisible(true);
			dapptid.setVisible(true);
		
			String apptid=dapptid.getText();
			if(e.getSource()==dapptbtn)
			{
				if(apptid.equals(""))
				{
					lbdappt.setText("Appointment ID cannot be null!");
					dapptid.setText("");
				}
				else {
					int app=Integer.parseInt(apptid);
					deleteAppointment(app);
				}
			}
		
		}

		if (e.getSource() == getAppt) {
			if (eapl.isSelected()) {
				getAppointment("Electrical Appliances", username);
				eapl.setSelected(false);
			}
			if (kapl.isSelected()) {
				getAppointment("Kitchen Appliances", username);
				kapl.setSelected(false);
			}
			if (hmsal.isSelected()) {
				getAppointment("Saloon", username);
				hmsal.setSelected(false);
			}
			if (hscln.isSelected()) {
				getAppointment("House cleaning", username);
				hscln.setSelected(false);
			}
			if (grdn.isSelected()) {
				getAppointment("Gardening", username);
				grdn.setSelected(false);
			}

		}
		

	}
	
	public void getAppointment(String service, String user) {

		int sid = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "admin");
			String query = "SELECT sid from serviceprovider where stype=? and occupancy='A'";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, service);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				sid = rs.getInt("sid");

				String getMaxAid = "select max(aid) from appointment";
				PreparedStatement ps = con.prepareStatement(getMaxAid);
				ResultSet rsrs = ps.executeQuery();
				rsrs.next();
				int maxaid = rsrs.getInt(1);
				String query1 = "Insert into appointment values(?,?,?)";
				PreparedStatement pstmt1 = con.prepareStatement(query1);
				pstmt1.setInt(1, ++maxaid);
				pstmt1.setString(2, user);
				pstmt1.setInt(3, sid);
				pstmt1.executeUpdate();
				System.out.println("Appointment Taken Succesfully!");
				appt.setText("Appointment Taken Succesfully!");
				

				String query2 = "update serviceprovider set occupancy = 'N' where sid = ?";
				PreparedStatement pstmt2 = con.prepareStatement(query2);
				pstmt2.setInt(1, sid);
				pstmt2.executeUpdate();

				String appoint = "select *from appointment where aid=?";
				PreparedStatement pstmt3 = con.prepareStatement(appoint);
				pstmt3.setInt(1, maxaid);
				ResultSet ap = pstmt3.executeQuery();
				ap.next();
				int aid = ap.getInt(1);
				String uid = ap.getString(2);
				int ssid = ap.getInt(3);

				String detail = "select *from serviceprovider where sid=?";
				PreparedStatement pstmt4 = con.prepareStatement(detail);
				pstmt4.setInt(1, ssid);
				ResultSet ap1 = pstmt4.executeQuery();
				ap1.next();
				ssid = ap1.getInt(1);
				String sname = ap1.getString(2);
				String smob = ap1.getString(4);
				System.out.println("----------------------Appointment Details--------------------- \nAppoinment ID: "
						+ aid + "\nService Provider ID: " + ssid + "\nService Provider Name: " + sname
						+ "\nMobile Number: " + smob);
				String said=String.valueOf(aid);
				String sssid=String.valueOf(ssid);
				String[][] data = { { "Appointment ID", "Service Provider ID ", "Name", "Mobile Number" },{said,sssid,sname,smob} };
				String[] columnNames = { "Username", "Address", "Mobile", "Email" };
				table_1 = new JTable(data, columnNames);
				table_1.setBounds(41, 381, 418, 34);
				getContentPane().add(table_1);
				table_1.setVisible(true);

			} else {
				System.out.println("Oops! We are very sorry, \nAll our service providers for " + service
						+ " are occupied today!, \nTry Again Tomorrow.");
				appt.setText("\"Oops! We are very sorry, All our service providers for are occupied today! Try Again Tomorrow.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void checkAppointment(int appt) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "admin");
			String appoint = "select *from appointment where aid=?";
			PreparedStatement pstmt3 = con.prepareStatement(appoint);
			pstmt3.setInt(1, appt);
			ResultSet ap = pstmt3.executeQuery();
			while (ap.next()) {
				int aid = ap.getInt(1);
				String uid = ap.getString(2);
				int ssid = ap.getInt(3);

				String detail = "select *from serviceprovider where sid=?";
				PreparedStatement pstmt4 = con.prepareStatement(detail);
				pstmt4.setInt(1, ssid);
				ResultSet ap1 = pstmt4.executeQuery();
				ap1.next();
				ssid = ap1.getInt(1);
				String sname = ap1.getString(2);
				String smob = ap1.getString(4);
				System.out.println(
						"\n\n--------------------------Appointment Details--------------------------------------------: \nAppoinment ID: "
								+ aid + "\nService Provider ID: " + ssid + "\nService Provider Name: " + sname
								+ "\nMobile Number: " + smob + "\n\n");
				String said=String.valueOf(aid);
				String sssid=String.valueOf(ssid);
				String[][] data = { { "Appointment ID", "Service Provider ID ", "Name", "Mobile Number" },{said,sssid,sname,smob} };
				String[] columnNames = { "Username", "Address", "Mobile", "Email" };
				table_2 = new JTable(data, columnNames);
				table_2.setBounds(41, 381, 418, 34);
				getContentPane().add(table_2);
				table_2.setVisible(true);
				table_1.setVisible(false);
			}

		} catch (Exception e) {
			System.out.println("No Appointments for this uername:");
		}

	}


	public void deleteAppointment(int aid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "admin");
			String appoint = "delete from appointment where aid=?";
			PreparedStatement pstmt3 = con.prepareStatement(appoint);
			pstmt3.setInt(1, aid);
			int n = pstmt3.executeUpdate();
			System.out.println("Appointment Deleted Successfully!");
			lbdappt.setText("Appointment Deleted Successfully!");
		} catch (Exception e) {
			System.out.println("No existing Appointments for this Appointment ID: " + aid);
			lbdappt.setText("No existing Appointments for this Appointment ID: " + aid);
		}
	}
}
