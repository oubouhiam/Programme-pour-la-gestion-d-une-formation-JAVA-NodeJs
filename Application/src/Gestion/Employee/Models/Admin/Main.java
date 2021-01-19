package Gestion.Employee.Models.Admin;
import Gestion.Employee.Models.Admin.*;
import Gestion.Employee.Models.*;
import Gestion.Employee.Models.Main.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1221, 790);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO DASHBOARD\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 31));
		lblNewLabel.setBounds(390, 76, 459, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblChooseWhatYou = new JLabel("CHOOSE WHAT YOU WANT TO EDITE\r\n\r\n");
		lblChooseWhatYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseWhatYou.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblChooseWhatYou.setBounds(390, 155, 459, 69);
		contentPane.add(lblChooseWhatYou);
		
		JButton btnNewButton = new JButton("employ\u00E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                Employé emp = new Employé();
                emp.setTitle("Employee");
                emp.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Snap ITC", Font.PLAIN, 34));
		btnNewButton.setBounds(200, 234, 257, 57);
		contentPane.add(btnNewButton);
		
		JButton btnSession = new JButton("Session\r\n");
		btnSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Session sess = new Session();
				sess.setTitle("Session");
				sess.setVisible(true);
			}
		});
		btnSession.setFont(new Font("Snap ITC", Font.PLAIN, 34));
		btnSession.setBounds(491, 234, 257, 57);
		contentPane.add(btnSession);
		
		JButton btnFormation = new JButton("Formation ");
		btnFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Formation form = new Formation();
				form.setTitle("Formations");
				form.setVisible(true);
			}
		});
		btnFormation.setFont(new Font("Snap ITC", Font.PLAIN, 34));
		btnFormation.setBounds(786, 234, 257, 57);
		contentPane.add(btnFormation);
		
		JButton btnNewButton_1 = new JButton("LOGOUT\r\n");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
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
		btnNewButton_1.setBounds(10, 25, 154, 43);
		contentPane.add(btnNewButton_1);
		
		JLabel lblYourTown = new JLabel("Formation Request\r\n");
		lblYourTown.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourTown.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblYourTown.setBounds(390, 332, 459, 69);
		contentPane.add(lblYourTown);
		
		JButton btnListOfRequest = new JButton("List of Request");
		btnListOfRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListeRequest lr = new ListeRequest();
				lr.setTitle("Liste Request");
				lr.setVisible(true);
			}
		});
		btnListOfRequest.setFont(new Font("Snap ITC", Font.PLAIN, 34));
		btnListOfRequest.setBounds(432, 411, 374, 57);
		contentPane.add(btnListOfRequest);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yassi\\Documents\\Eclipse\\project final\\src\\icon.png"));
		lblNewLabel_1.setBounds(180, 18, 54, 50);
		contentPane.add(lblNewLabel_1);
	}
}
