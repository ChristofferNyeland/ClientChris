package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;



public class LoginGUI extends JPanel {
	private JLabel lblEmail = new JLabel("Email");
	private JLabel lblPassword = new JLabel("Password");
	private JTextField emailTextField = new JTextField();
	private JTextField passwordTextField = new JTextField();
	private JLabel lblLogin;
	private JButton btnLogin = new JButton("Login");
	private JButton btnLogOut = new JButton ("LogOut");
	
	public LoginGUI() {
		setLayout(null);
		setPreferredSize(new Dimension(1366, 768));
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(402, 277, 54, 24);
		add(lblEmail);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblPassword.setBounds(402, 364, 120, 40);
		add(lblPassword);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(551, 265, 263, 40);
		add(emailTextField);
		emailTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(551, 364, 263, 40);
		add(passwordTextField);
		passwordTextField.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 34));
		lblLogin.setBounds(636, 6, 93, 40);
		add(lblLogin);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		btnLogin.setBounds(582, 628, 202, 62);
		add(btnLogin);
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setBounds(0, 0, 1376, 768);
		lblBackground.setIcon(new ImageIcon(LoginGUI.class.getResource("/img/MetalBackground.jpg")));
		lblBackground.setBackground(new Color(245, 245, 245));
		lblBackground.setForeground(new Color(245, 255, 250));
		lblBackground.setOpaque(true);
		add(lblBackground);
		
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}
	public void addActionListenerLogOut(ActionListener l){
		btnLogin.addActionListener(l);
	}
	public void addActionListenerWelcomeScreen(ActionListener l){
		btnLogin.addActionListener(l);
	}
	
	}