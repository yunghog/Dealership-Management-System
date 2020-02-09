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
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

public class insertTech extends JFrame {
	private Connection connection;
	protected java.sql.Statement Statement; 
	private JPanel contentPane;
	private JTextField techname;
	private JTextField skill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertTech frame = new insertTech();
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
	public insertTech() {
		setAlwaysOnTop(true);
		setBackground(SystemColor.text);
		setForeground(Color.BLACK);
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
		
		JLabel lblInsertBay = new JLabel("Insert Technician");
		lblInsertBay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertBay.setBounds(191, 11, 165, 39);
		panel.add(lblInsertBay);
		
		JLabel lbltechname = new JLabel("Technician Name :");
		lbltechname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltechname.setBounds(162, 66, 119, 23);
		panel.add(lbltechname);
		
		techname = new JTextField();
		techname.setBounds(291, 69, 86, 20);
		panel.add(techname);
		techname.setColumns(10);
		
		JLabel lblskill = new JLabel("Skill :");
		lblskill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblskill.setBounds(242, 110, 39, 23);
		panel.add(lblskill);
		
		skill = new JTextField();
		skill.setColumns(10);
		skill.setBounds(291, 113, 86, 20);
		panel.add(skill);
		
		
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setForeground(SystemColor.controlText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inskill = skill.getText().toString();
				String intechname = techname.getText().toString();
				if(intechname.length()!=0 && inskill.length()!=0) {
				try {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					String queryBay = "insert into technician values(" + null + ",'" + intechname + "','" + inskill + "')";
					ResultSet rs = Statement.executeQuery(queryBay.toString());
					JOptionPane.showMessageDialog(null, "Technician inserted");
					}
			
				catch(Exception e6) {
					System.out.println(e6);
					System.out.println("Technician insert error");
				}
				}
				else
					JOptionPane.showMessageDialog(null, "Enter valid details\nTechnician not inserted");
				setVisible(false);
			}
		});
		btnNewButton.setBounds(229, 144, 89, 23);
		panel.add(btnNewButton);
	}
}
