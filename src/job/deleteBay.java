package job;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class deleteBay extends JFrame {

	private JPanel contentPane;
	private JTextField bayid;
	private Connection connection;
	protected java.sql.Statement Statement; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteBay frame = new deleteBay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public deleteBay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 275);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDeleteBay = new JLabel("Delete Bay");
		lblDeleteBay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeleteBay.setBounds(208, 11, 103, 39);
		panel.add(lblDeleteBay);
		
		JLabel lblBayId = new JLabel("Bay ID:");
		lblBayId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBayId.setBounds(188, 60, 56, 23);
		panel.add(lblBayId);
		
		bayid = new JTextField();
		bayid.setColumns(10);
		bayid.setBounds(254, 61, 86, 20);
		panel.add(bayid);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.info);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String inBayid = bayid.getText().toString();
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					String queryBay = "delete from bay where bid=" + inBayid;
					ResultSet rs = Statement.executeQuery(queryBay.toString());
				}
				catch(Exception e6) {
					System.out.println(e6);
					System.out.println("Bay delete error");
				}
				JOptionPane.showMessageDialog(null, "Bay Deleted \n restart required");
				setVisible(false);
			}
		});
		btnDelete.setBounds(228, 104, 63, 23);
		panel.add(btnDelete);
	}

}
