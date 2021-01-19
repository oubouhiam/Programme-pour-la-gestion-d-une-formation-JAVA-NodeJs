package Gestion.Employee.Models.Main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import Gestion.Employee.Models.Admin.*;
import Gestion.Employee.Models.Employee.*;
import Gestion.Employee.Models.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import Gestion.Employee.Models.Admin.Main;

import java.awt.SystemColor;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class Register extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField fname;
    private JTextField lname;
    private JTextField matricu;
    private JTextField log;
    private JTextField vill;
    private JPasswordField pass;
    private JButton btnNewButton;
    private JLabel lblNewLabel_1;
    private JButton btnLogin;
	Connection conn;
	PreparedStatement stmt;
	private JPasswordField confirmpass;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
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
private boolean checkUsername(String login)
{
PreparedStatement ps;
ResultSet rs;
String query = "SELECT * FROM employé where login =?";
boolean checkUser = false;

try {
 ps = Register.getConnection().prepareStatement(query);
 ps.setString(1, login);				
 rs = ps.executeQuery();	      
 	 
 if(rs.next())
{
  checkUser = true;
}
} catch (SQLException ex) {
ex.printStackTrace();
}
return checkUser;
}
    public Register() {
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1221, 790);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Welcome to Your Future");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(310, 51, 436, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lablefname = new JLabel("First name");
        lablefname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lablefname.setBounds(58, 152, 99, 43);
        contentPane.add(lablefname);

        JLabel lablelname = new JLabel("Last name");
        lablelname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lablelname.setBounds(58, 243, 110, 29);
        contentPane.add(lablelname);

        JLabel labelmatricule = new JLabel("Matricule");
        labelmatricule.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelmatricule.setBounds(58, 324, 124, 36);
        contentPane.add(labelmatricule);

        fname = new JTextField();
        fname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        fname.setBounds(214, 151, 228, 50);
        contentPane.add(fname);
        fname.setColumns(10);

        lname = new JTextField();
        lname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lname.setBounds(214, 235, 228, 50);
        contentPane.add(lname);
        lname.setColumns(10);

        matricu = new JTextField();

        matricu.setFont(new Font("Tahoma", Font.PLAIN, 32));
        matricu.setBounds(214, 320, 228, 50);
        contentPane.add(matricu);
        matricu.setColumns(10);

        log = new JTextField();
        log.setFont(new Font("Tahoma", Font.PLAIN, 32));
        log.setBounds(707, 151, 228, 50);
        contentPane.add(log);
        log.setColumns(10);

        JLabel usernamlbl = new JLabel("Username");
        usernamlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        usernamlbl.setBounds(542, 159, 99, 29);
        contentPane.add(usernamlbl);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Ville");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 398, 139, 26);
        contentPane.add(lblMobileNumber);

        vill = new JTextField();
        vill.setFont(new Font("Tahoma", Font.PLAIN, 32));
        vill.setBounds(707, 389, 228, 50);
        contentPane.add(vill);
        vill.setColumns(10);

        pass = new JPasswordField();
        pass.setFont(new Font("Tahoma", Font.PLAIN, 32));
        pass.setBounds(707, 235, 228, 50);
        contentPane.add(pass);
    
      	
        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nom = fname.getText();
				String prénom = lname.getText();
				String matricule = matricu.getText();
				String ville = vill.getText();
				String login = log.getText();
				String mot_de_passe = pass.getText();
				String confimPass = confirmpass.getText();
				String type = "Employee";
				String Request = "NotYet";
				String code_formation = "";
                String msg = "" + matricule;
                msg += " \n";
                if(fname.getText().equals("")) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please add First Name");
                }else if(lname.getText().equals("")) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please add Last Name");
                }else if(matricu.getText().equals("")) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please add Matricule");
                }else if(checkUsername(login)) {
                	JOptionPane.showMessageDialog(btnNewButton, "This Username Already Exist");
                }else if(pass.getText().equals("")) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please add Password");
                }else if(!(pass.getText().equals(confirmpass.getText()))) {
                	JOptionPane.showMessageDialog(btnNewButton, "Your passwords do not match");
                }
                else if(log.getText().equals("")) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please add login");
//                }else if() {
//                	JOptionPane.showMessageDialog(btnNewButton, "Please add login");
//                }else if(vill.getText().equals("")) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please add Ville");
                }                 
                else {
              	
				

                try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations", "root", "");

					 stmt = conn.prepareStatement("insert into employé(nom,prénom,matricule,ville,login,mot_de_passe,type,Request,code_formation)values(?,?,?,?,?,?,?,?,?)");
					 stmt.setString(1,nom);
					 stmt.setString(2,prénom);
					 stmt.setString(3,matricule);
					 stmt.setString(4,ville);
					 stmt.setString(5,login);
					 stmt.setString(6,mot_de_passe);
					 stmt.setString(7,type);
					 stmt.setString(8,Request);
					 stmt.setString(9,code_formation);
		             stmt.execute();
		                 fname.setText("");
	       				 lname.setText("");
	       				 matricu.setText("");
	       				 vill.setText("");
	       				 log.setText("");
	       				 pass.setText("");
	       				 dispose();
	       				UserLogin ul = new UserLogin();
	       				ul.setTitle("Welcome");
	       				ul.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "Account ADDED Seccusfuly");

					 

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
                }
                
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(395, 467, 259, 74);
        contentPane.add(btnNewButton);
        
        lblNewLabel_1 = new JLabel("If u Already have an account Click Here");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblNewLabel_1.setBounds(214, 595, 721, 50);
        contentPane.add(lblNewLabel_1);
        
        btnLogin = new JButton("LogIn");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				 dispose();
				 UserLogin us = new UserLogin();
				 us.setTitle("Login");
				 us.setVisible(true);
        	}
        });
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnLogin.setBounds(395, 669, 259, 74);
        contentPane.add(btnLogin);
        
        JLabel lblConfirmPassword = new JLabel("Confirm Password\r\n");
        lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblConfirmPassword.setBounds(542, 330, 160, 24);
        contentPane.add(lblConfirmPassword);
        
        confirmpass = new JPasswordField();
        confirmpass.setFont(new Font("Tahoma", Font.PLAIN, 32));
        confirmpass.setBounds(707, 320, 228, 50);
        contentPane.add(confirmpass);
        

    }
}