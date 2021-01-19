package Gestion.Employee.Models.Main;
import Gestion.Employee.Models.Admin.*;
import Gestion.Employee.Models.Employee.*;
import Gestion.Employee.Models.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
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
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1221, 790);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setBounds(505, 56, 273, 93);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(354, 219, 501, 68);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(354, 334, 501, 68);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(107, 209, 193, 52);
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(107, 342, 193, 52);
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        contentPane.add(lblPassword);
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 27));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"TYPE :", "Admin", "Employee"}));
        comboBox.setBounds(354, 444, 501, 67);
        contentPane.add(comboBox);
        
        JLabel lblType = new JLabel("Type");
        lblType.setForeground(Color.BLACK);
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblType.setBackground(Color.CYAN);
        lblType.setBounds(107, 443, 193, 52);
        contentPane.add(lblType);

        btnNewButton = new JButton("Login");
        btnNewButton.setBounds(354, 577, 236, 73);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                String type = (String) comboBox.getSelectedItem();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestionformations","root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select login, mot_de_passe,type from employé where login=? and mot_de_passe=? and type=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    st.setString(3, type);
                    
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {

                        if (type.equals("Admin")) {
                            dispose();
                            Main ah = new Main();
                            ah.setTitle("Welcome");
                            ah.setVisible(true);
                            JLabel lblll = new JLabel("Welcome back Admin :"+userName);
                            lblll.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                            lblll.setBounds(254, 21, 191, 52);
                            ah.getContentPane().add(lblll);
                        } else if (type.equals("Employee")) {
                    		dispose();
                    		Listformation lf = new Listformation(userName);
                            lf.setTitle("Employee");
                            lf.setVisible(true);
                            JLabel lblll = new JLabel("Welcome :"+userName);
                            lblll.setFont(new Font("Times New Roman", Font.PLAIN, 22));
                            lblll.setBounds(254, 21, 191, 52);
                            lf.getContentPane().add(lblll);
                        } else {
                        	JOptionPane.showMessageDialog(btnNewButton, "Wrong TYPE");
                        }

                    } else {
                    	JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password & TYPE");
                    }
  
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButton);
        
        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                dispose();
                Register ah = new Register();
                ah.setTitle("Register");
                ah.setVisible(true);
        	}
        });
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnRegister.setBounds(616, 577, 236, 73);
        contentPane.add(btnRegister);
        

    }
}