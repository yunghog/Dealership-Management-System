package job;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class MainPanel extends JFrame {
	
	private JPanel contentPane;
	private JTextField regno;
	private JTextField jobno;
	private JTextField oname;
	private JTextField man;
	private JTextField model;
	private JTextField datein;
	private Connection connection;
	protected java.sql.Statement Statement; 
	private JTable table;
	public Object[][] data = new Object[30][6];
	public Object[][] Techdata = new Object[30][3];
	public Object[][] Baydata = new Object[30][3];
	public Object[][] Vehdata = new Object[30][4];
	public Object[][] Billdata = new Object[30][3];
	public String[] columns = new String[] { "Job.no", "Reg.no", "Service", "Technician ID", "Bay ID", "Date.in"};
	public String[] Vehcolumn = new String[] {"Reg.no", "Owner", "Manufacturer", "Model"};
	public String[] Techcol = new String[] { "TID", "Name", "Skill"};
	public String[] Baycol = new String[] { "BID", "Type", "Name"};
	public String[] Billcol = new String[] { "BNO", "JNO", "Amount"};
	private JTextField optionalTextField;
	private JTextField optionalTextFieldV;
	public String ist;
	private JTextField deleteBy;
	private JTextField optionalTextFieldVeh;
	private JTable VehicleTable;
	public String inVehSearchType;
	private JTextField totalJobs;
	int JobCount;
	private JTable table_1;
	private JTable table_2;
	private JTextField UJnotextField;
	private JTextField UvaltextField;
	private JTextField jnotextField;
	private JTextField Sparescost;
	private JTextField labourcost;
	private JTextField othercost;
	private JTextField totalamt;
	public  int intotalamt;
	public int injno2;
	int tid,bid;
	private JTable billTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainPanel frame = new MainPanel();
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
	public MainPanel() {
		setBackground(Color.WHITE);
		setTitle("Garage Job Managemrnt");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Job", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane_1, BorderLayout.CENTER);
		
		techIds ti = new techIds();
		ti.getTech();
		
		bayIds bi = new bayIds();
		bi.getBay();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Create", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblCreateJob = new JLabel("Create Job");
		lblCreateJob.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblCreateJob.setBounds(571, 11, 111, 65);
		panel_4.add(lblCreateJob);
		
		JLabel lblVehicleRegno = new JLabel("Vehicle Reg.no :");
		lblVehicleRegno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVehicleRegno.setBounds(261, 88, 138, 26);
		panel_4.add(lblVehicleRegno);
		
		JLabel lblJobOrderno = new JLabel("Job Order.no :");
		lblJobOrderno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJobOrderno.setBounds(261, 139, 138, 26);
		panel_4.add(lblJobOrderno);
		
		JLabel lblOwnerName = new JLabel("Owner Name :");
		lblOwnerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOwnerName.setBounds(261, 187, 138, 26);
		panel_4.add(lblOwnerName);
		
		JLabel lblManufacturer = new JLabel("Manufacturer :");
		lblManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblManufacturer.setBounds(261, 242, 138, 26);
		panel_4.add(lblManufacturer);
		
		JLabel lblModel = new JLabel("Model :");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModel.setBounds(653, 88, 138, 26);
		panel_4.add(lblModel);
		
		JLabel lblDateIn = new JLabel("Date in :");
		lblDateIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateIn.setBounds(653, 139, 138, 26);
		panel_4.add(lblDateIn);
		
		JLabel lblJobDesc = new JLabel("Technician  ID :");
		lblJobDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJobDesc.setBounds(653, 187, 138, 26);
		panel_4.add(lblJobDesc);
		
		JLabel lblBayId = new JLabel("Bay ID :");
		lblBayId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBayId.setBounds(653, 242, 138, 26);
		panel_4.add(lblBayId);
		
		regno = new JTextField();
		regno.setBounds(409, 88, 185, 26);
		panel_4.add(regno);
		regno.setColumns(10);
		
		jobno = new JTextField();
		jobno.setBackground(UIManager.getColor("Button.background"));
		jobno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Job.no will be generated automatically");
			}});
		jobno.setColumns(10);
		jobno.setBounds(409, 139, 185, 26);
		panel_4.add(jobno);
		
		oname = new JTextField();
		oname.setColumns(10);
		oname.setBounds(409, 187, 185, 26);
		panel_4.add(oname);
		
		man = new JTextField();
		man.setColumns(10);
		man.setBounds(409, 242, 185, 26);
		panel_4.add(man);
		
		model = new JTextField();
		model.setColumns(10);
		model.setBounds(801, 88, 185, 26);
		panel_4.add(model);
		
		datein = new JTextField();
		datein.setColumns(10);
		datein.setBounds(801, 139, 185, 26);
		panel_4.add(datein);
		
		JLabel lblJobDescription = new JLabel("Job Description :");
		lblJobDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJobDescription.setBounds(261, 298, 138, 26);
		panel_4.add(lblJobDescription);
		
		JComboBox stype = new JComboBox();
		stype.setBackground(SystemColor.info);
		stype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stype.setModel(new DefaultComboBoxModel(new String[] {"Free Service", "Paid Service", "Body Wash", "Damage Repair", "General Checkup"}));
		stype.setBounds(409, 298, 185, 26);
		panel_4.add(stype);
		JComboBox tlist = new JComboBox();
		tlist.setModel(new DefaultComboBoxModel(ti.strTech));
		tlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tlist.setBackground(SystemColor.info);
		tlist.setBounds(801, 187, 185, 26);
		panel_4.add(tlist);
		JComboBox blist = new JComboBox();
		blist.setModel(new DefaultComboBoxModel(bi.strBay));
		blist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		blist.setBackground(SystemColor.info);
		blist.setBounds(801, 242, 185, 26);
		panel_4.add(blist);
		
		JButton btnjcreate = new JButton("Submit");
		btnjcreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					ResultSet rsjno = Statement.executeQuery("select max(jno)+1 from job");
					while(rsjno.next()) {
						int inijno = rsjno.getInt(1);
						System.out.println("JNO seq = " + inijno);
					}
				}
				catch(Exception ex){
					System.out.println(ex);
				}
				//String injobno = jobno.getText();
				String inregno = regno.getText().toUpperCase();
				String inoname = oname.getText();
				String inman = man.getText();
				String inmodel = model.getText();
				String injdesc = stype.getSelectedItem().toString();
				String inbid = blist.getSelectedItem().toString();
				String intid = tlist.getSelectedItem().toString();
				String indatein = datein.getText();
				
				try {
					try {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					String tidQuery = "select tid,bid from technician,bay where tname='" + intid + "'" + "and bname='" + inbid + "'";
					ResultSet rslist = Statement.executeQuery(tidQuery);
					while(rslist.next()) {
						tid=rslist.getInt(1);
						bid=rslist.getInt(2);
					}
					}
					catch(Exception e4) {
						System.out.println(e4);
						System.out.println("error in list");
					}
					
				String qVehicle = "insert into vehicle values('" + inregno + "','" + inoname + "','" + inman + "','" + inmodel + "')";
				String qJob = "insert into job values(" + null + ",'" + inregno + "','" + injdesc + "'," + tid + "," + bid + ",'" + indatein + "')";
				System.out.print(qVehicle);
				System.out.print(qJob);
				connection = DataBaseConnection.getConnection();
				Statement = connection.createStatement();
				if(inregno.length()!=0&&inoname.length()!=0&&inman.length()!=0&&inmodel.length()!=0) {
					try {
					
							ResultSet rsVehicle = Statement.executeQuery(qVehicle.toString());
						
					}
					catch(Exception v) {
						System.out.println("Vehicle exists");
					}
					try {
						
							ResultSet rsJob = Statement.executeQuery(qJob.toString());
						}
						catch(Exception j) {
							System.out.println("job error");
							System.out.print(j);
						}
					jobno.setText(null);
					regno.setText(null);
					oname.setText(null);
					model.setText(null);
					man.setText(null);
					datein.setText(null);
				
				}
				else
					JOptionPane.showMessageDialog(null, "Enter valid details\nData not inserted");
				}
				catch(Exception se) {
					System.out.println(se);
				}
				
								
			}
		});
		btnjcreate.setForeground(Color.BLACK);
		btnjcreate.setBackground(SystemColor.info);
		btnjcreate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnjcreate.setBounds(534, 355, 185, 26);
		panel_4.add(btnjcreate);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.menu);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(626, 87, 17, 237);
		panel_4.add(separator);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane_1.addTab("View", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblViewJob = new JLabel("View Job");
		lblViewJob.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblViewJob.setBounds(578, 11, 97, 65);
		panel_5.add(lblViewJob);
		
		JLabel lblSearchBy = new JLabel("Search By :");
		lblSearchBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchBy.setBounds(33, 50, 98, 26);
		panel_5.add(lblSearchBy);
		
		optionalTextField = new JTextField();
		optionalTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		optionalTextField.setBounds(141, 87, 138, 26);
		optionalTextField.setColumns(10);
		panel_5.add(optionalTextField);
		optionalTextField.setVisible(false);

		JComboBox searchtype = new JComboBox();
		searchtype.setBackground(SystemColor.info);
		searchtype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchtype.setModel(new DefaultComboBoxModel(new String[] {"All", "Job.no", "Reg.no", "Date.in", "Technician", "Bay", "Service"}));
		searchtype.setSelectedIndex(0);
		searchtype.setBounds(141, 50, 138, 26);
		panel_5.add(searchtype);
		searchtype.setSelectedItem("All");
		searchtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++)
					for(int j=0;j<table.getColumnCount();j++)
						data[i][j]=null;
				String  insearchtype = searchtype.getSelectedItem().toString();
				System.out.print(insearchtype);
				table.repaint();
				if(insearchtype=="All")
					optionalTextField.setVisible(false);
				else
					optionalTextField.setVisible(true);
					ist=insearchtype;
			}
		});


		totalJobs = new JTextField();
		totalJobs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalJobs.setBounds(1040, 50, 51, 26);
		panel_5.add(totalJobs);
		totalJobs.setColumns(10);

		JButton btnNewButton = new JButton("search");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					int rowCount = 0;
					String viewQuery; //= "select * from job";
					String countQuery; //=  "select COUNT(*) from job";
					System.out.println(ist);
					switch(ist) {
					case "Job.no" : viewQuery = "select * from job where jno=" + optionalTextField.getText();
								  countQuery =  "select COUNT(*) from job where jno=" + optionalTextField.getText();
								  System.out.println(viewQuery);
								   break;
					case "Reg.no" : viewQuery = "select * from job where vid='" + optionalTextField.getText().toUpperCase() + "'";
									countQuery =  "select COUNT(*) from job where vid='" + optionalTextField.getText().toUpperCase() + "'";
									System.out.println(viewQuery);
									break;
					case "Technician" : viewQuery = "select * from job where tid=" + optionalTextField.getText();
										countQuery =  "select COUNT(*) from job where tid=" + optionalTextField.getText();
										System.out.println(viewQuery);
										break;
					case "Bay" : viewQuery = "select * from job where bid=" + optionalTextField.getText();
										countQuery =  "select COUNT(*) from job where bid=" + optionalTextField.getText();
										System.out.println(viewQuery);
										break;
					case "Service" : viewQuery = "select * from job where jdesc='" + optionalTextField.getText() + "'";
										countQuery =  "select COUNT(*) from job where jdesc='" + optionalTextField.getText() + "'";
										System.out.println(viewQuery);
										break;
					case "Date.in" : viewQuery = "select * from job where datein='" + optionalTextField.getText() + "'";
										countQuery =  "select COUNT(*) from job where datein='" + optionalTextField.getText() + "'";
										System.out.println(viewQuery);
										break;
					default : viewQuery = "select * from job";
								  countQuery =  "select COUNT(*) from job";
								  System.out.println("Default");
					}
					System.out.println(optionalTextField.getText());
					ResultSet rsone = Statement.executeQuery(countQuery);
					while (rsone.next()) {
						rowCount = rsone.getInt(1);
					}
					totalJobs.setText("" + rowCount);
					ResultSet rstwo = Statement.executeQuery(viewQuery);
					ResultSetMetaData meta = rstwo.getMetaData();
					int colCount = meta.getColumnCount();

					if (rowCount == 0)
						JOptionPane.showMessageDialog(null, "No Results to Display");
					else {
						JOptionPane.showMessageDialog(null, "Entries Found");
						System.out.println("Result set \nRow Count :" + rowCount + "\nColumn Count:" +colCount);
						for (int i = 0; i < rowCount; i++) {
							int k = 1;
							if (rstwo.next()) {
								for (int j = 0; j < colCount; j++) {
									data[i][j] = rstwo.getString(k++);
								}
							}
						}
					}
					table.getAutoCreateColumnsFromModel();
					connection.close();
					
					optionalTextField.setText(null);
	
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setIcon(new ImageIcon(MainPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		btnNewButton.setBounds(311, 50, 38, 26);
		panel_5.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 159, 1234, 455);
		panel_5.add(scrollPane_1);
		
		
		table = new JTable(data, columns);
		scrollPane_1.setViewportView(table);
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(231, 72, 76)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		
		JLabel lblTotalJobs = new JLabel("Total Jobs :");
		lblTotalJobs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalJobs.setBounds(933, 50, 97, 26);
		panel_5.add(lblTotalJobs);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_6.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Delete", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblDeleteJob = new JLabel("Delete Job");
		lblDeleteJob.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblDeleteJob.setBounds(571, 0, 108, 65);
		panel_6.add(lblDeleteJob);
		
		JLabel lblDeleteBy = new JLabel("Delete By :");
		lblDeleteBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteBy.setBounds(419, 124, 138, 26);
		panel_6.add(lblDeleteBy);
		
		JComboBox deleteType = new JComboBox();
		deleteType.setModel(new DefaultComboBoxModel(new String[] {"Job.no", "Reg.no", "Date.in", "Technician", "Bay", "Service"}));
		deleteType.setSelectedIndex(0);
		deleteType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteType.setBackground(SystemColor.info);
		deleteType.setBounds(535, 124, 138, 26);
		panel_6.add(deleteType);
		
		
		deleteBy = new JTextField();
		deleteBy.setBounds(683, 124, 138, 26);
		panel_6.add(deleteBy);
		deleteBy.setColumns(10);
		
		JButton btnDelete = new JButton("");
		btnDelete.setBackground(Color.RED);
		btnDelete.setIcon(new ImageIcon(MainPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					String indeleteType=deleteType.getSelectedItem().toString();
					int rowCount = 0;
					String viewQuery=""; //= "select * from job";
					System.out.println(indeleteType);
					if(deleteBy.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Enter expression");
					else {
					switch(indeleteType) {
					case "Job.no" : viewQuery = "delete from job where jno=" + deleteBy.getText();
								  System.out.println(viewQuery);
								   break;
					case "Reg.no" : viewQuery = "delete from job where vid='" + deleteBy.getText() + "'";
									System.out.println(viewQuery);
									break;
					case "Technician" : viewQuery = "delete from job where tid=" + deleteBy.getText();
										System.out.println(viewQuery);
										break;
					case "Bay" : viewQuery = "delete from job where bid=" + deleteBy.getText();
										System.out.println(viewQuery);
										break;
					case "Service" : viewQuery = "delete from job where jdesc='" + deleteBy.getText() + "'";
										System.out.println(viewQuery);
										break;
					case "Date.in" : viewQuery = "delete from job where datein='" + deleteBy.getText() + "'";
										System.out.println(viewQuery);
										break;
					default : JOptionPane.showMessageDialog(null, "select an  option");;
								System.out.println("Default");
					}
					System.out.println(deleteBy.getText());
					ResultSet rstwo = Statement.executeQuery(viewQuery);
					JOptionPane.showMessageDialog(null, "Deleted");
					deleteBy.setText(null);
					connection.close();
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setSelectedIcon(null);
		btnDelete.setBounds(831, 124, 35, 26);
		panel_6.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Records", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Vehicles", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblVehicleList = new JLabel("Vehicle List");
		lblVehicleList.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblVehicleList.setBounds(567, 11, 119, 65);
		panel_7.add(lblVehicleList);
		
		JComboBox VehSearchType = new JComboBox();
		VehSearchType.setModel(new DefaultComboBoxModel(new String[] {"All", "Reg.no", "Owner", "Model", "Manufacturer"}));
		VehSearchType.setSelectedIndex(0);
		VehSearchType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VehSearchType.setBackground(SystemColor.info);
		VehSearchType.setBounds(199, 50, 138, 26);
		VehSearchType.setSelectedItem("All");
		VehSearchType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inVehSearchTypeX = VehSearchType.getSelectedItem().toString();
				for(int i=0;i<VehicleTable.getRowCount();i++)
					for(int j=0;j<VehicleTable.getColumnCount();j++)
						Vehdata[i][j]=null;
				
				System.out.println(inVehSearchTypeX);

				if(inVehSearchTypeX=="All")
					optionalTextFieldVeh.setVisible(false);
				else
					optionalTextFieldVeh.setVisible(true);
				inVehSearchType = inVehSearchTypeX;
			}
		});
		
		panel_7.add(VehSearchType);
		
		JLabel label = new JLabel("Search By :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(64, 50, 98, 26);
		panel_7.add(label);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(MainPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					int rowCount = 0;
					String viewQuery; //= "select * from job";
					String countQuery; //=  "select COUNT(*) from job";
					System.out.println(inVehSearchType);
					switch(inVehSearchType) {
					case "Reg.no" : viewQuery = "select * from vehicle where vid='" + optionalTextFieldVeh.getText() + "'";
					  countQuery =  "select COUNT(*) from vehicle where vid='" + optionalTextFieldVeh.getText() + "'";
					  System.out.println(viewQuery);
					  System.out.println(countQuery);
					  break;
					case "Owner" : viewQuery = "select * from vehicle where owner='" + optionalTextFieldVeh.getText() + "'";
					  countQuery =  "select COUNT(*) from vehicle where owner='" + optionalTextFieldVeh.getText() + "'";
					  System.out.println(viewQuery);
					  System.out.println(countQuery);
					   break;
					case "Manufacturer" : viewQuery = "select * from vehicle where manufacturer='" + optionalTextFieldVeh.getText() + "'";
					  countQuery =  "select COUNT(*) from vehicle where manufacturer='" + optionalTextFieldVeh.getText() + "'";
					  System.out.println(viewQuery);
					  System.out.println(countQuery);

					  break;
					case "Model" : viewQuery = "select * from vehicle where model='" + optionalTextFieldVeh.getText() + "'";
					  countQuery =  "select COUNT(*) from vehicle where model='" + optionalTextFieldVeh.getText() + "'";
					  System.out.println(viewQuery);
					  System.out.println(countQuery);
					   break;
						default : viewQuery = "select * from vehicle";
								  countQuery =  "select COUNT(*) from vehicle";
								  System.out.println(viewQuery);
								  System.out.println(countQuery);
					}
					System.out.println(optionalTextField.getText());
					ResultSet rsone = Statement.executeQuery(countQuery);
					while (rsone.next()) {
						rowCount = rsone.getInt(1);
					}

					ResultSet rstwo = Statement.executeQuery(viewQuery);
					ResultSetMetaData meta = rstwo.getMetaData();
					int colCount = meta.getColumnCount();

					if (rowCount == 0)
						JOptionPane.showMessageDialog(null, "No Results to Display");
					else {
						System.out.println("Result set \nRow Count :" + rowCount + "\nColumn Count:" +colCount);
						for (int i = 0; i < rowCount; i++) {
							int k = 1;
							if (rstwo.next()) {
								for (int j = 0; j < colCount; j++) {
									Vehdata[i][j] = rstwo.getString(k++);
								}
							}
						}
					}
				connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSearch.setBounds(345, 50, 37, 26);
		panel_7.add(btnSearch);
		
		optionalTextFieldVeh = new JTextField();
		optionalTextFieldVeh.setBounds(199, 87, 138, 26);
		panel_7.add(optionalTextFieldVeh);
		optionalTextFieldVeh.setColumns(10);
		optionalTextFieldVeh.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 1234, 426);
		panel_7.add(scrollPane);
		VehicleTable = new JTable(Vehdata,Vehcolumn);
		VehicleTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(VehicleTable);
		VehicleTable.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.menu));
		VehicleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		VehicleTable.setFillsViewportHeight(true);
		VehicleTable.setColumnSelectionAllowed(true);
		VehicleTable.setCellSelectionEnabled(true);
			
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Technicians", null, panel_8, null);
		panel_8.setLayout(null);

			try {
				connection = DataBaseConnection.getConnection();
				Statement = connection.createStatement();
				int rowCount = 0;
				ResultSet rsone = Statement.executeQuery("select COUNT(*) from technician");
				while (rsone.next()) {
					rowCount = rsone.getInt(1);
				}

				ResultSet rstwo = Statement.executeQuery("select * from technician");
				ResultSetMetaData meta = rstwo.getMetaData();
				int colCount = meta.getColumnCount();

				if (rowCount == 0)
					JOptionPane.showMessageDialog(null, "No Results to Display");
				else {
					System.out
							.println("Result set Size is :" + rowCount + "\nColumn Count:" +colCount);
					for (int i = 0; i < rowCount; i++) {
						int k = 1;
						if (rstwo.next()) {
							for (int j = 0; j < colCount; j++) {
								Techdata[i][j] = rstwo.getString(k++);
							}
						}
					}
				}
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		JLabel lblOurTechnicians = new JLabel("Our Technicians");
		lblOurTechnicians.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblOurTechnicians.setBounds(540, 11, 174, 65);
		panel_8.add(lblOurTechnicians);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(null);
		scrollPane_2.setBounds(264, 184, 726, 372);
		panel_8.add(scrollPane_2);
		
		table_1 = new JTable(Techdata,Techcol);
		table_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.menu));
		
		scrollPane_2.setViewportView(table_1);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertTech it = new insertTech();
				it.setVisible(true);
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.setBounds(459, 591, 89, 23);
		panel_8.add(btnInsert);
		
		JButton btnDelete_2 = new JButton("Delete");
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTech dt = new deleteTech();
				dt.setVisible(true);
			}
		});
		btnDelete_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_2.setBounds(696, 591, 89, 23);
		panel_8.add(btnDelete_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Bays", null, panel_9, null);
		panel_9.setLayout(null);
		
		JLabel lblBays = new JLabel("Bays");
		lblBays.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblBays.setBounds(598, 11, 57, 65);
		panel_9.add(lblBays);
		try {
			connection = DataBaseConnection.getConnection();
			Statement = connection.createStatement();
			int rowCount = 0;
			ResultSet rsone = Statement.executeQuery("select COUNT(*) from bay");
			while (rsone.next()) {
				rowCount = rsone.getInt(1);
			}

			ResultSet rstwo = Statement.executeQuery("select * from bay");
			ResultSetMetaData meta = rstwo.getMetaData();
			int colCount = meta.getColumnCount();

			if (rowCount == 0)
				JOptionPane.showMessageDialog(null, "No Results to Display");
			else {
				System.out
						.println("Result set Size is :" + rowCount + "\nColumn Count:" +colCount);
				for (int i = 0; i < rowCount; i++) {
					int k = 1;
					if (rstwo.next()) {
						for (int j = 0; j < colCount; j++) {
							Baydata[i][j] = rstwo.getString(k++);
						}
					}
				}
			}
			connection.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(286, 139, 682, 343);
		panel_9.add(scrollPane_3);
		
		table_2 = new JTable(Baydata,Baycol);
		table_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.menu));
		scrollPane_3.setViewportView(table_2);
		
		JButton btnNewButton_2 = new JButton("Insert");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertBay IB  = new insertBay();
						IB.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(464, 532, 89, 23);
		panel_9.add(btnNewButton_2);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBay dB = new deleteBay();
				dB.setVisible(true);
			}
		});
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_1.setBounds(683, 532, 89, 23);
		panel_9.add(btnDelete_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Adminstration", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane_3, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane_3.addTab("Update", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblUpdateTechnicianbay = new JLabel("Update Technician/Bay");
		lblUpdateTechnicianbay.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblUpdateTechnicianbay.setBounds(502, 11, 250, 65);
		panel_3.add(lblUpdateTechnicianbay);
		
		JLabel lblUpdateJobno = new JLabel("Update --> Job.no :");
		lblUpdateJobno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpdateJobno.setBounds(385, 87, 177, 26);
		panel_3.add(lblUpdateJobno);
		
		UJnotextField = new JTextField();
		UJnotextField.setBounds(572, 87, 46, 26);
		panel_3.add(UJnotextField);
		UJnotextField.setColumns(10);
		
		JComboBox Utype = new JComboBox();
		Utype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Utype.setBackground(SystemColor.info);
		Utype.setModel(new DefaultComboBoxModel(new String[] {"Technician :", "Bay :"}));
		Utype.setSelectedIndex(0);
		Utype.setBounds(642, 87, 119, 26);
		panel_3.add(Utype);
		
		UvaltextField = new JTextField();
		UvaltextField.setBounds(778, 87, 46, 26);
		panel_3.add(UvaltextField);
		UvaltextField.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
					int rowCount = 0;
					String viewQuery; //= "select * from job";
					String countQuery; //=  "select COUNT(*) from job";
					String inUtype = Utype.getSelectedItem().toString();
					System.out.println(inUtype);
					switch(inUtype) {
					case "Technician :" : viewQuery = "update job set tid=" + UvaltextField.getText() + " where jno=" + UJnotextField.getText();
					  System.out.println(viewQuery);
					  break;
					case "Bay :" : viewQuery = "update job set bid=" + UvaltextField.getText() + " where jno=" + UJnotextField.getText();
					  System.out.println(viewQuery);
					  break;
						default : viewQuery = "select * from job";
									JOptionPane.showMessageDialog(null, "Enter valid Job.no and TID/BID");
					}
					System.out.println(UvaltextField.getText());
					ResultSet rstwo = Statement.executeQuery(viewQuery);
					JOptionPane.showMessageDialog(null, "Updated successfully");

					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Invalid TID/BID");

				}
			}
		});
		btnUpdate.setIcon(new ImageIcon(MainPanel.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		btnUpdate.setBackground(SystemColor.info);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(560, 145, 133, 26);
		panel_3.add(btnUpdate);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		tabbedPane_3.addTab("Billing", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel lblGenerateBill = new JLabel("Generate Bill");
		lblGenerateBill.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblGenerateBill.setBounds(556, 11, 142, 65);
		panel_11.add(lblGenerateBill);
		
		JLabel lblJobno = new JLabel("Job.no :");
		lblJobno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJobno.setBounds(526, 101, 98, 26);
		panel_11.add(lblJobno);
		
		JLabel lblSparePartsCost = new JLabel("Spare Parts cost :");
		lblSparePartsCost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSparePartsCost.setBounds(477, 138, 147, 26);
		panel_11.add(lblSparePartsCost);
		
		JLabel lblLabourCharges = new JLabel("Labour Charges :");
		lblLabourCharges.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLabourCharges.setBounds(477, 175, 147, 26);
		panel_11.add(lblLabourCharges);
		
		JLabel lblOtherCharges = new JLabel("Other Charges :");
		lblOtherCharges.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOtherCharges.setBounds(477, 215, 147, 26);
		panel_11.add(lblOtherCharges);
		
		jnotextField = new JTextField();
		jnotextField.setBounds(664, 101, 111, 20);
		panel_11.add(jnotextField);
		jnotextField.setColumns(10);
		
		Sparescost = new JTextField();
		Sparescost.setColumns(10);
		Sparescost.setBounds(664, 138, 111, 20);
		panel_11.add(Sparescost);
		
		labourcost = new JTextField();
		labourcost.setColumns(10);
		labourcost.setBounds(664, 175, 111, 20);
		panel_11.add(labourcost);
		
		othercost = new JTextField();
		othercost.setColumns(10);
		othercost.setBounds(664, 215, 111, 20);
		panel_11.add(othercost);
		
		JLabel lblTotalAmount = new JLabel("Total amount :");
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalAmount.setBounds(477, 252, 147, 26);
		panel_11.add(lblTotalAmount);
		
		totalamt = new JTextField();
		totalamt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sjno2 = jnotextField.getText().toString();
				injno2 = Integer.parseInt(sjno2);
				String sSparescost = Sparescost.getText().toString();
				int inSparescost= Integer.parseInt(sSparescost);
				String slabourcost = labourcost.getText().toString();
				int inlabourcost = Integer.parseInt(slabourcost);
				String sothercost = othercost.getText().toString();
				int inothercost = Integer.parseInt(sothercost);
				intotalamt = inSparescost+inlabourcost+inothercost;
				System.out.println("Total = " +  intotalamt);
				String Stotal = "Rs. " + intotalamt; 
					System.out.println(Stotal);
					totalamt.setText(Stotal.toString());
			}
		});
		totalamt.setEditable(false);
		totalamt.setColumns(10);
		totalamt.setBounds(664, 252, 111, 20);
		panel_11.add(totalamt);
		
		JButton btnNewButton_1 = new JButton("Generate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String qBill = "insert into bill values(" + null + "," + injno2 + "," + intotalamt + ")";
					System.out.println(qBill);
					connection = DataBaseConnection.getConnection();
					Statement = connection.createStatement();
						try {
						ResultSet rsBill = Statement.executeQuery(qBill.toString());
						}
						catch(Exception v) {
							System.out.println(v);
						}
						totalamt.setText(null);
						labourcost.setText(null);
						Sparescost.setText(null);
						othercost.setText(null);
						jnotextField.setText(null);
						JOptionPane.showMessageDialog(null, "Bill Generated Successfully");
					
					}
					catch(Exception se) {
						System.out.println(se);
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(561, 311, 131, 23);
		panel_11.add(btnNewButton_1);
		
		JButton btnPrintBill = new JButton("Print Bill");
		btnPrintBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillingPanel BP = new BillingPanel(injno2);
				BP.setVisible(true);
			}
		});
		btnPrintBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrintBill.setBounds(561, 357, 131, 23);
		panel_11.add(btnPrintBill);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		tabbedPane_3.addTab("View Bills", null, panel_12, null);
		panel_12.setLayout(null);
		
		JLabel lblViewBills = new JLabel("View Bills");
		lblViewBills.setFont(new Font("Futura-Bold", Font.PLAIN, 20));
		lblViewBills.setBounds(573, 11, 108, 65);
		panel_12.add(lblViewBills);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(318, 126, 618, 358);
		panel_12.add(scrollPane_4);
		
		billTable = new JTable(Billdata,Billcol);
		billTable.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.menu));
		scrollPane_4.setViewportView(billTable);
		
		try {
			connection = DataBaseConnection.getConnection();
			Statement = connection.createStatement();
			int rowCount = 0;
			ResultSet rsone = Statement.executeQuery("select COUNT(*) from bill");
			while (rsone.next()) {
				rowCount = rsone.getInt(1);
			}

			ResultSet rstwo = Statement.executeQuery("select * from bill");
			ResultSetMetaData meta = rstwo.getMetaData();
			int colCount = meta.getColumnCount();

			if (rowCount == 0)
				JOptionPane.showMessageDialog(null, "No Results to Display");
			else {
				System.out
						.println("Result set Size is :" + rowCount + "\nColumn Count:" +colCount);
				for (int i = 0; i < rowCount; i++) {
					int k = 1;
					if (rstwo.next()) {
						for (int j = 0; j < colCount; j++) {
							Billdata[i][j] = rstwo.getString(k++);
						}
					}
				}
			}
			connection.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
