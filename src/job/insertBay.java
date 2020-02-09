package job;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class insertBay extends JFrame {
	private Connection connection;
	protected java.sql.Statement Statement; 
	private JPanel contentPane;
	private JTextField baytype;
	private JTextField bayname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertBay frame = new insertBay();
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
	public insertBay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInsertBay = new JLabel("Insert Bay");
		lblInsertBay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertBay.setBounds(228, 11, 91, 39);
		panel.add(lblInsertBay);
		
		JLabel lblBayType = new JLabel("Bay Type :");
		lblBayType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBayType.setBounds(198, 66, 83, 23);
		panel.add(lblBayType);
		
		baytype = new JTextField();
		baytype.setBounds(291, 69, 86, 20);
		panel.add(baytype);
		baytype.setColumns(10);
		
		JLabel lblBayName = new JLabel("Bay name :");
		lblBayName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBayName.setBounds(198, 110, 83, 23);
		panel.add(lblBayName);
		
		bayname = new JTextField();
		bayname.setColumns(10);
		bayname.setBounds(291, 113, 86, 20);
		panel.add(bayname);
		
		
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String inBayname = bayname.getText().toString();
					String inBaytype = baytype.getText().toString();
					if(inBayname.length()!=0 && inBaytype.length()!=0) {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					String queryBay = "insert into bay values(" + null + ",'" + inBaytype + "','" + inBayname + "')";
					ResultSet rs = Statement.executeQuery(queryBay.toString());
					JOptionPane.showMessageDialog(null, "Bay inserted");
					}
					else
						JOptionPane.showMessageDialog(null, "Bay not inserted\nEnter valid details");
				}
				catch(Exception e6) {
					System.out.println(e6);
					System.out.println("Bay insert error");
				}
				setVisible(false);
			}
		});
		btnNewButton.setBounds(229, 144, 89, 23);
		panel.add(btnNewButton);
	}
}
