package Gestion.Employee.Models.Admin;
import Gestion.Employee.Models.Admin.*;
import Gestion.Employee.Models.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.JPasswordField;
import Gestion.Employee.Models.Main.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Employ� extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField matricul;
	private JTextField log;
	private JTextField lname;
	private JTextField vill;
	JTable table;
	Connection conn;
	PreparedStatement stmt;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employ� frame = new Employ�();
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
	public Employ�() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Display();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1221, 790);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagmentEmployee = new JLabel("Managment Employee\r\n");
		lblManagmentEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagmentEmployee.setFont(new Font("Rockwell", Font.BOLD, 31));
		lblManagmentEmployee.setBounds(391, 10, 459, 69); 
		contentPane.add(lblManagmentEmployee);
		
		JButton btnNewButton_1 = new JButton("LOGOUT\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btnNewButton_1, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
                dispose();
                UserLogin obj = new UserLogin();

                obj.setTitle("Login");
                obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 10, 154, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Home\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                Main main = new Main();
                main.setTitle("HOME");
                main.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(10, 700, 154, 43);
		contentPane.add(btnNewButton_1_1);
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.BOLD, 13));
		fname.setColumns(10);
		fname.setBounds(288, 112, 251, 40);
		contentPane.add(fname);
		
		JLabel lblFirstName = new JLabel("First Name\r\n");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(137, 112, 153, 40);
		contentPane.add(lblFirstName);
		
		matricul = new JTextField();
		matricul.setFont(new Font("Tahoma", Font.BOLD, 13));
		matricul.setColumns(10);
		matricul.setBounds(288, 197, 251, 40);
		contentPane.add(matricul);
		
		log = new JTextField();
		log.setFont(new Font("Tahoma", Font.BOLD, 13));
		log.setColumns(10);
		log.setBounds(288, 277, 251, 40);
		contentPane.add(log);
		
		JLabel lblMatricule = new JLabel("Matricule");
		lblMatricule.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatricule.setBounds(137, 187, 261, 50);
		contentPane.add(lblMatricule);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogin_1.setBounds(137, 272, 261, 50);
		contentPane.add(lblLogin_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setBounds(759, 112, 153, 40);
		contentPane.add(lblLastName);
		
		JLabel lblLogin = new JLabel("Ville");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogin.setBounds(759, 187, 261, 50);
		contentPane.add(lblLogin);
		
		JLabel lblPrice_1_1 = new JLabel("Password\r\n");
		lblPrice_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice_1_1.setBounds(759, 272, 261, 50);
		contentPane.add(lblPrice_1_1);
		
		lname = new JTextField();
		lname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lname.setColumns(10);
		lname.setBounds(910, 112, 251, 40);
		contentPane.add(lname);
		
		vill = new JTextField();
		vill.setFont(new Font("Tahoma", Font.BOLD, 13));
		vill.setColumns(10);
		vill.setBounds(910, 197, 251, 40);
		contentPane.add(vill);
		JLabel lblLogin_1_1 = new JLabel("Type\r\n");
		lblLogin_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogin_1_1.setBounds(137, 332, 113, 50);
		contentPane.add(lblLogin_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Type", "Admin", "Employee"}));
		comboBox.setBounds(288, 337, 251, 40);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("LIST\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 34));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(506, 453, 179, 50);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 493, 1079, 197);
		contentPane.add(scrollPane);
		//table(((((((((((((((((((((((((((((((((((((((((((((((((
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				 fname.setText(df.getValueAt(selectedIndex, 1).toString());
				 lname.setText(df.getValueAt(selectedIndex, 2).toString());
				 vill.setText(df.getValueAt(selectedIndex, 3).toString());
				 matricul.setText(df.getValueAt(selectedIndex, 4).toString());
				 log.setText(df.getValueAt(selectedIndex, 5).toString());
				 password.setText(df.getValueAt(selectedIndex, 6).toString());
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"ID", "FirstName", "LastName", "matricule", "Ville", "Login", "Password", "Type"
			}
		) {

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		table.getColumnModel().getColumn(5).setPreferredWidth(107);
		table.getColumnModel().getColumn(5).setPreferredWidth(112);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = fname.getText();
				String pr�nom = lname.getText();
				String matricule = matricul.getText();
				String ville = vill.getText();
				String login = log.getText();
				String mot_de_passe = password.getText();
				String type = comboBox.getSelectedItem().toString();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");
					 stmt = conn.prepareStatement("insert into employ�(nom,pr�nom,matricule,ville,login,mot_de_passe,type)values(?,?,?,?,?,?,?)");
					 stmt.setString(1,nom);
					 stmt.setString(2,pr�nom);
					 stmt.setString(3,matricule);
					 stmt.setString(4,ville);
					 stmt.setString(5,login);
					 stmt.setString(6,mot_de_passe);
					 stmt.setString(7,type);
					 stmt.execute();
							 JOptionPane.showMessageDialog(btnAdd, "Employee Added Successfully");
							 fname.setText("");
							 lname.setText("");
							 matricul.setText("");
							 vill.setText("");
							 log.setText("");
							 password.setText("");
							 comboBox.setSelectedIndex(0);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				Display();
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(264, 405, 159, 38);
		contentPane.add(btnAdd);
		
		JButton btnOrder = new JButton("DISPLAY\r\n");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display();
			}
		});
		btnOrder.setForeground(Color.WHITE);
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrder.setBackground(Color.BLACK);
		btnOrder.setBounds(446, 405, 159, 38);
		contentPane.add(btnOrder);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ??!!", "Delete", JOptionPane.YES_NO_OPTION);
				if(msg==0) {									
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();				
			     try {
					int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
						 Class.forName("com.mysql.cj.jdbc.Driver");	
						 conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");
					     stmt = conn.prepareStatement("DELETE from employ�  where id_employee = '" + id + "'");
						 stmt.executeUpdate();	  
						 JOptionPane.showMessageDialog(btnAdd, "Employee Deleted Successfully");	 
						 fname.setText("");
						 lname.setText("");
						 matricul.setText("");
						 vill.setText("");
						 log.setText("");
						 password.setText("");
						 fname.requestFocus();	
						 Display();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setBounds(625, 405, 159, 38);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();							     
					try {												
						int id_employee = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());	
						String nom = fname.getText();
						String pr�nom = lname.getText();
						String matricule = matricul.getText();
						String ville = vill.getText();
						String login = log.getText();
						String mot_de_passe = password.getText();	
						String type = comboBox.getSelectedItem().toString();
						Class.forName("com.mysql.cj.jdbc.Driver");						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");						 		 						 												 														
							 stmt = conn.prepareStatement("UPDATE employ� SET " + "nom = '" + nom + "', pr�nom = '" + pr�nom + "', matricule = '" + matricule + "', ville = '" + ville + "', login = '" + login + "', mot_de_passe = '" +mot_de_passe + "',type = '" + type + "' where id_employee = '" + id_employee + "'");
							 stmt.executeUpdate();							  
								 JOptionPane.showMessageDialog(btnAdd, "Employee edited Successfully");
								 fname.setText("");
								 lname.setText("");
								 matricul.setText("");
								 vill.setText("");
								 log.setText("");
								 password.setText("");
								 fname.requestFocus();	
								 comboBox.setSelectedIndex(0);
								 Display();																 	 
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(794, 405, 159, 38);
		contentPane.add(btnUpdate);
		
		password = new JPasswordField();
		password.setBounds(910, 276, 251, 41);
		contentPane.add(password);
		

		
		
		
	}

				
	private void Display() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");					
			 conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");					 										 
			 stmt = conn.prepareStatement("SELECT * FROM employ�");						
			 ResultSet result = stmt.executeQuery();
			 DefaultTableModel df = (DefaultTableModel)table.getModel();					 
			 df.setRowCount(0);					 
			 while(result.next()) {
				int id_employee = result.getInt("id_employee");
				String nom = result.getString("nom");
				String pr�nom = result.getString("pr�nom");
				String matricule = result.getString("matricule");
				String ville = result.getString("ville");
				String login = result.getString("login");
				String mot_de_passe = result.getString("mot_de_passe");
				String typ = result.getString("type");
                df.addRow(new Object[] {id_employee,nom,pr�nom,matricule,ville,login,mot_de_passe,typ});                       
             }						 
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				
	}	
}

