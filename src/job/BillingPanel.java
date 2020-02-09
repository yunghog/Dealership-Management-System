package job;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
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

public class BillingPanel extends JFrame {

	private JPanel contentPane;
	private JTextField bnotext;
	private JTextField jnotext;
	private JTextField amtext;
	private Connection connection;
	protected java.sql.Statement Statement; 
	private JTextField ownertext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillingPanel frame = new BillingPanel(10);
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
	public BillingPanel(int jno) {
		setType(Type.POPUP);
		setTitle("Billing Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBillno = new JLabel("Bill.no :");
		lblBillno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBillno.setBounds(38, 28, 107, 30);
		panel.add(lblBillno);
		
		JLabel lblJobno = new JLabel("Job.no :");
		lblJobno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJobno.setBounds(38, 69, 107, 30);
		panel.add(lblJobno);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAmount.setBounds(38, 110, 107, 30);
		panel.add(lblAmount);
		
		bnotext = new JTextField();
		bnotext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bnotext.setBounds(167, 28, 107, 30);
		panel.add(bnotext);
		bnotext.setColumns(10);
		
		jnotext = new JTextField();
		jnotext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jnotext.setColumns(10);
		jnotext.setBounds(167, 69, 107, 30);
		panel.add(jnotext);
		
		amtext = new JTextField();
		amtext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amtext.setColumns(10);
		amtext.setBounds(167, 110, 107, 30);
		panel.add(amtext);

		JLabel lblPaidBy = new JLabel("Paid by :");
		lblPaidBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaidBy.setBounds(364, 28, 107, 30);
		panel.add(lblPaidBy);
		
		ownertext = new JTextField();
		ownertext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ownertext.setColumns(10);
		ownertext.setBounds(364, 69, 169, 30);
		panel.add(ownertext);
		
		try {
				
				connection = DataBaseConnection.getConnection();
				Statement = connection.createStatement();
				String billQuery = "select b.*,v.owner from  bill b,job j,vehicle v where b.jno =" + jno + " and b.jno=j.jno and j.vid=v.vid"  ;
				ResultSet rs = Statement.executeQuery(billQuery);
				if(rs.next()) {
					bnotext.setText(rs.getString(1));
					jnotext.setText(rs.getString(2));
					amtext.setText(rs.getString(3));
					ownertext.setText(rs.getString(4));
				}
				connection.close();
		}
		catch(Exception be) {
			System.out.println(be);
			System.out.println("Billing Exception");			
		}
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOk.setBounds(197, 151, 52, 30);
		panel.add(btnOk);
		
	}

}
