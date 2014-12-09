package view;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ActionEventHandler;

import javax.swing.JButton;

import utilities.Actions;

import java.awt.Color;
import java.awt.Font;

public class Login extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private ActionEventHandler actionEventHandler;
	private JPasswordField textFieldPassword;
	private JTextField textFieldUserName;
	private JLabel labelStatus;
	private JButton btnLogin;
	private JLabel lblEnterDetails;
	private JLabel Background;
	private JLabel lblEnterEmail;

	
	public Login(ActionEventHandler actionEventHandler) {
		
		this.actionEventHandler = actionEventHandler;
		setLayout(null);
		
		labelStatus = new JLabel("");
		labelStatus.setBounds(300, 241, 124, 16);
		labelStatus.setForeground(Color.white);
		add(labelStatus);
		
	
		// Swing components
		
		lblEnterDetails = new JLabel("Indtast dine informationer");
		lblEnterDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails.setBounds(-112, 30, 721, 16);
		lblEnterDetails.setForeground(Color.white);
		add(lblEnterDetails);
		
		lblEnterEmail = new JLabel();
		lblEnterEmail.setBounds(288, 19, 0, 0);
		lblEnterEmail.setForeground(Color.white);
		add(lblEnterEmail);
		
		
		btnLogin = new JButton("Log ind");
		btnLogin.setBounds(211, 194, 91, 29);
		btnLogin.addActionListener( this.actionEventHandler);
		btnLogin.setActionCommand(Actions.Login);
		add(btnLogin);
		
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(183, 73, 134, 28);
		textFieldUserName.setToolTipText("Password");
		textFieldUserName.setColumns(10);
		add(textFieldUserName);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(183, 128, 134, 28);
		textFieldPassword.setToolTipText("Email");
		textFieldPassword.setColumns(10);
		add(textFieldPassword);
		
		
		// JLabel as background
		
		Background = new JLabel("");
		Background.setBounds(0, 0, 500, 350);
		add(Background);
		
					
		
		setTempDate();
	}
	
	private void setTempDate(){
		textFieldUserName.setText("bruger@bruger.dk");
		textFieldPassword.setText("1234");
	}

	public String getUserName() {
		return textFieldUserName.getText();
	}
	
	public String getPassword() {
		return textFieldPassword.getText();
	}
	
	public void setStatus(String message) {
		labelStatus.setText(message);
	}
	
	public void resetView(){
		labelStatus.setText("");
		textFieldPassword.setText("");
		textFieldUserName.setText("");
	}
}