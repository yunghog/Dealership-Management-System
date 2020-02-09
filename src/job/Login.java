package job;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	
	int xx,xy;
	private JTextField uname;
	private JPasswordField pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Garage Job Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Futura Lt BT", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setBounds(36, 382, 274, 27);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Login.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(0, 0, 346, 371);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(Login.class.getResource("/images/imgLogin.jpg")));
		panel.add(label);
	
		Button login = new Button("Login");
		
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(241, 57, 83));
		login.setBounds(395, 363, 283, 36);
		contentPane.add(login);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(395, 200, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(395, 272, 96, 14);
		contentPane.add(lblPassword);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JLabel lblWorkshopLogin = new JLabel("Workshop Login");
		lblWorkshopLogin.setForeground(SystemColor.menu);
		lblWorkshopLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkshopLogin.setFont(new Font("Audiowide", Font.PLAIN, 24));
		lblWorkshopLogin.setBounds(395, 23, 283, 59);
		contentPane.add(lblWorkshopLogin);
		
		uname = new JTextField();
		uname.setBounds(395, 225, 283, 36);
		contentPane.add(uname);
		uname.setColumns(10);
		
		pswd = new JPasswordField();
		pswd.setBounds(395, 298, 283, 36);
		contentPane.add(pswd);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inUname = uname.getText();
				String inPswd = pswd.getText();
				System.out.println(inUname + "\n" + inPswd);
				if(inUname.equals("admin")&&inPswd.equals("password")) {
					JOptionPane.showMessageDialog(null, "Login Successfull");
					MainPanel MP = new MainPanel();
					MP.setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid user/password");
				}
				uname.setText(null);
				pswd.setText(null);
				
			}
		});
	}
}
