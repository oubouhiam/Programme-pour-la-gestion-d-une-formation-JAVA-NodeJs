package Gestion.Employee.Models.Employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Gestion.Employee.Models.Main.Register;
import Gestion.Employee.Models.Main.UserLogin;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class ListofRequest extends JFrame {

	private JPanel contentPane;
	JTable table;
	Connection conn;
	PreparedStatement stmt;
	JTable table2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 public static Connection getConnection(){
	     
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        
	        return con;
	    }
	 private void CheckSession() {
			try {

	            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionformations",
	                "root", "");

	            PreparedStatement st = (PreparedStatement) con
	                .prepareStatement("SELECT * FROM Session");
	            PreparedStatement st2 = (PreparedStatement) con
	                    .prepareStatement("SELECT * FROM employ�");
	            ResultSet result = stmt.executeQuery();
				 DefaultTableModel df = (DefaultTableModel)table.getModel();					 
				 df.setRowCount(0);
				
					 
				
				 while(result.next()) {
					String id_employee = result.getString("id_employee");
					String id = result.getString("id_session");
					String code = result.getString("code");
					String libell� = result.getString("libell�");
					String formation = result.getString("formation");
					String Mois = result.getString("Mois");
					String annee = result.getString("annee");
	               df.addRow(new Object[] {id_employee,id,code,libell�,formation,Mois,annee});                       
	            	
				 }
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	        }
					
		}
	public ListofRequest(String login) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
					try {										 	
			             Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionformations","root", "");

			             PreparedStatement st = (PreparedStatement) connection
			                 .prepareStatement("SELECT * FROM employ� WHERE login=?");
			             st.setString(1, login);
			             ResultSet rs = st.executeQuery();
						 DefaultTableModel df = (DefaultTableModel)table.getModel();					 
						 df.setRowCount(0);					 
						 while(rs.next()) {
							String nom = rs.getString("nom");
							String code_formation = rs.getString("code_formation");
							String Request = rs.getString("Request");
							if (Request.equals("InComplate")) {
								df.addRow(new Object[] {nom,code_formation,Request});       
							}else if(Request.equals("Complate")){
								df.addRow(new Object[] {nom,code_formation,Request});   
							}else {
								JOptionPane.showMessageDialog(contentPane, "You Have No request");
							}

				                
						 }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
					
			try {										 	
	             Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionformations","root", "");

	             PreparedStatement st = (PreparedStatement) connection
	                 .prepareStatement("SELECT * FROM session");
	             PreparedStatement st2 = (PreparedStatement) connection
		                 .prepareStatement("SELECT * FROM employ� where login=?");
	             st2.setString(1, login);
	             ResultSet rs = st.executeQuery();
	             ResultSet rs2 = st2.executeQuery();
				 DefaultTableModel df = (DefaultTableModel)table2.getModel();					 
				 df.setRowCount(0);	
				 
				 while(rs.next()) {
							while (rs2.next()) {
								String Request = rs2.getString("Request");
								if (Request.equals("Complate")) {
									String code = rs.getString("code");
									String libell� = rs.getString("libell�");
									String formation = rs.getString("formation");
									String Mois = rs.getString("Mois");
									String annee = rs.getString("annee");
									df.addRow(new Object[] {code,libell�,formation,Mois,annee});
								
								}

							}	
		                
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
		}	

		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1221, 790);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListOfFormations = new JLabel("List Of Formations Available\r\n");
		lblListOfFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfFormations.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblListOfFormations.setBounds(311, 80, 559, 52);
		contentPane.add(lblListOfFormations);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 170, 1079, 197);
		contentPane.add(scrollPane);
		
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
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				
				new Object[][] {
				},
				new String[] {
					"Nom", "Code de fomrmation", "Request"
				}
	){

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		scrollPane.setViewportView(table);
		btnNewButton_1.setBounds(10, 10, 154, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("HOME");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();
                Listformation lf = new Listformation(getName());
                lf.setTitle("List formation");
                lf.setVisible(true);
			}
		});
		
		btnNewButton_1_2.setBounds(976, 669, 154, 43);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblVotreSession = new JLabel("Votre Session");
		lblVotreSession.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotreSession.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblVotreSession.setBounds(311, 398, 559, 52);
		contentPane.add(lblVotreSession);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(51, 483, 1079, 130);
		contentPane.add(scrollPane_1);
		table2 = new JTable();
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setFont(new Font("Tahoma", Font.BOLD, 12));
		table2.setModel(new DefaultTableModel(
				
				new Object[][] {
				},
				new String[] {
						"Code", "Lib�lle", "Description","mois","year"
				}
	){

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
		});
		table2.getColumnModel().getColumn(0).setResizable(false);
		table2.getColumnModel().getColumn(1).setPreferredWidth(20);
		scrollPane_1.setViewportView(table2);
		
		JButton btnNewButton_1_2_1 = new JButton("DETAILS\r\n");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionformations","root", "");

		             PreparedStatement st = (PreparedStatement) connection
		                 .prepareStatement("SELECT * FROM employ� where login=?");
		             st.setString(1, login);
		             ResultSet rs = st.executeQuery();
						while (rs.next()) {
							String id_employee = rs.getString("id_employee");	
							String Request = rs.getString("Request");
							if (Request.equals("Complate")) {
						String url = "http://localhost:3000/session/"+id_employee;
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
							}else if (Request.equals("Incomplate")) {
								JOptionPane.showMessageDialog(contentPane, "Request InComplate");
							}
						}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				
	}	
		});
		btnNewButton_1_2_1.setBounds(51, 623, 154, 43);
		contentPane.add(btnNewButton_1_2_1);
		
	}
}
