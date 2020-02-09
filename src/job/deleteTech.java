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

public class deleteTech extends JFrame {

	private JPanel contentPane;
	private JTextField techid;
	private Connection connection;
	protected java.sql.Statement Statement; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteTech frame = new deleteTech();
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
	public deleteTech() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDeleteTech = new JLabel("Delete Technician");
		lblDeleteTech.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeleteTech.setBounds(177, 11, 165, 39);
		panel.add(lblDeleteTech);
		
		JLabel lblTechId = new JLabel("Technician ID :");
		lblTechId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTechId.setBounds(145, 60, 99, 23);
		panel.add(lblTechId);
		
		techid = new JTextField();
		techid.setColumns(10);
		techid.setBounds(254, 61, 86, 20);
		panel.add(techid);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String inTechid = techid.getText().toString();
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					String queryBay = "delete from technician where tid=" + inTechid;
					ResultSet rs = Statement.executeQuery(queryBay.toString());
				}
				catch(Exception e6) {
					System.out.println(e6);
					System.out.println("Tech delete error");
				}
				JOptionPane.showMessageDialog(null, "Technician Deleted\nRestart required");
				setVisible(false);
			}
		});
		btnDelete.setBounds(228, 104, 63, 23);
		panel.add(btnDelete);
	}

}
