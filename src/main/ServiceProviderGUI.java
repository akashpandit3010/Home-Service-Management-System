package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ServiceProviderGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	JRadioButton user, sp;

	public ServiceProviderGUI() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Service Provider Page");
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		user = new JRadioButton("View All Users");
		user.setBounds(49, 22, 159, 21);
		getContentPane().add(user);
		user.addActionListener(this);

		sp = new JRadioButton("View all Service Providers");
		sp.setBounds(222, 22, 173, 21);
		getContentPane().add(sp);
		sp.addActionListener(this);

		ButtonGroup bg = new ButtonGroup();
		bg.add(user);
		bg.add(sp);
	}

	public void actionPerformed(ActionEvent e) {
		if (sp.isSelected()) {
			viewServiceProvider();
		}
	}
	DefaultTableModel model = new DefaultTableModel();
	public void viewServiceProvider() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "admin");
			String query = "SELECT sid from serviceprovider where stype=? and occupancy='A'";
			PreparedStatement ps = con.prepareStatement(query);
			String provide = "select *from serviceprovider";
			ps = con.prepareStatement(provide);
			ResultSet rs = ps.executeQuery();
			System.out.println("--------Service Providers List-----------");

			
			model.addColumn("Provider ID");
			model.addColumn("Name");
			model.addColumn("Type");
			model.addColumn("Mobile Number");

			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String stype = rs.getString(3);
				String smob = rs.getString(4);

				Object[] rowdata = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) };
				model.addRow(rowdata);

				System.out.println("Provider ID: " + sid + "\nService Provider Name: " + sname
						+ "\nService Provider Type: " + stype + "\nMobile Number: " + smob + "\n\n");
			}
		} catch (Exception e) {
			System.out.println(e + " There is are no service providers!");
			
		}
		table = new JTable(model);
		table.setBounds(49, 51, 1, 1);
		getContentPane().add(table);
		table.setVisible(true);
		
	}

}
