package Gestion.Employee.Models.Employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Gestion.Employee.Models.Main.Register;
import Gestion.Employee.Models.Main.UserLogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Listformation extends JFrame {

	private JPanel contentPane;
	Connection conn;
	PreparedStatement stmt;
	PreparedStatement stmt2;
	JTable table;
	private JTextField textField;

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
	private boolean checkUsername(String code)
	{
	PreparedStatement ps;
	ResultSet rs;
	String query = "SELECT * FROM formation where code =?";
	boolean checkUser = true;

	try {
	 ps = Register.getConnection().prepareStatement(query);
	 ps.setString(1, code);
	 rs = ps.executeQuery();	      
	 	 
	 if(rs.next())
	{
	  checkUser = false;
	}
	} catch (SQLException ex) {
	ex.printStackTrace();
	}
	return checkUser;
	}
	public Listformation(String login) {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Of Formations\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(336, 278, 517, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblWelcome = new JLabel("WELCOME To Our App\r\n" );
		lblWelcome.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(336, 113, 517, 52);
		contentPane.add(lblWelcome);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 443, 1079, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				
				new Object[][] {
				},
				new String[] {
					"ID", "Code", "Lib�lle", "Description"
				}
	){

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(500);
		scrollPane.setViewportView(table);
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
		btnNewButton_1.setBounds(10, 21, 154, 43);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_1_1 = new JButton("JOIN\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code_formation = textField.getText();
				String Request = "InComplate";
				try {

                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionformations",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) con
                        .prepareStatement("UPDATE employ� SET code_formation=?,Request=? WHERE login=?");

                    st.setString(1, code_formation);
                    st.setString(2, Request);
                    st.setString(3, login);
                    if(textField.getText().equals("")) {
                    	JOptionPane.showMessageDialog(btnNewButton_1_1, "Please add code formation");
                    }else if (checkUsername(code_formation)) {
                    	JOptionPane.showMessageDialog(btnNewButton_1_1, "This code not on the list");
					}else {
	                    st.executeUpdate();
	                    JOptionPane.showMessageDialog(btnNewButton_1_1, "formation has been successfully added please wait for responsable to accepte");
	                    textField.setText("");
					}

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            
			}
		});
		
		btnNewButton_1_1.setBounds(752, 670, 154, 43);
		contentPane.add(btnNewButton_1_1);
		
		textField = new JTextField();
		textField.setEditable(true);
		textField.setEnabled(true);
		textField.setBounds(427, 670, 245, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_2 = new JButton("List Of Request");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		dispose();
        		ListofRequest lr = new ListofRequest(login);
        		lr.setTitle("REQUEST");
        		lr.setVisible(true);
			}
		});
		btnNewButton_1_2.setBounds(983, 670, 154, 43);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yassi\\Documents\\Eclipse\\project final\\src\\icon.png"));
		lblNewLabel_1.setBounds(190, 17, 54, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To Join Please add code of formation :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(55, 670, 343, 43);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1_1_1 = new JButton("SEE MAP\r\n");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "http://localhost:3000/map/";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnNewButton_1_1_1.setBounds(1033, 21, 154, 43);
		contentPane.add(btnNewButton_1_1_1);
		
		
	}

	private void Display() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");					
			 conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");					 										 
			 stmt = conn.prepareStatement("SELECT * FROM formation");	
			 ResultSet result = stmt.executeQuery();
			 DefaultTableModel df = (DefaultTableModel)table.getModel();					 
			 df.setRowCount(0);					 
			 while(result.next()) {
				int id_formation = result.getInt("id_formation");
				String code = result.getString("code");
				String libell� = result.getString("libell�");
				String description = result.getString("description");
//				String typ = result.getString("Validation");
                df.addRow(new Object[] {id_formation,code,libell�,description});                       
			 }
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				
	}		
	private void Display1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");					
			 conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");					 										 
			 stmt = conn.prepareStatement("SELECT * FROM formation");						
			 ResultSet result = stmt.executeQuery();
			 DefaultTableModel df = (DefaultTableModel)table.getModel();					 
			 df.setRowCount(0);					 
			 while(result.next()) {
				String code = result.getString("code");
                df.addRow(new Object[] {code});                       
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
