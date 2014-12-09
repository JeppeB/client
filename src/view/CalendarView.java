package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import utilities.Actions;
import controller.ActionEventHandler;

import javax.swing.JLabel;

import function.ServerManager;
import model.Events;
import model.Calendar;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class CalendarView extends JPanel{

	private ActionEventHandler actionEventHandler;
	private JLabel lbldate;
	private JLabel Background;
	private JLabel lblAppointments;
	private JButton btnLogOut;
	private JButton btnDayOverview;
	private JButton btnM;
	private JButton btnOpret;
	private JLabel lblEvents;
	private JTextField textFieldTitle;
	private JTextField textFieldNote;
	private JTextField textFieldStartDate;
	private JTextField textFieldEndDate;
	private JTextField textFieldLocation;
	private JLabel labelStatus;
	
	   Font italicFont = new Font("Helvetica Neue", Font.ITALIC | Font.PLAIN, 14);
	   Font boldFont = new Font("Helvetica Neue", Font.BOLD | Font.PLAIN, 16);
	   Font plainFont = new Font("Helvetica Neue", Font.PLAIN | Font.PLAIN, 14);
	private JPanel panelDates;
	  

	public CalendarView(ActionEventHandler actionEventHandler) {
		
		setLayout(null);
		
		this.actionEventHandler = actionEventHandler;
		
		
		labelStatus = new JLabel("");
		labelStatus.setBounds(536, 351, 192, 16);
		labelStatus.setForeground(Color.black);
		labelStatus.setFont(plainFont);
		add(labelStatus);
		
		btnOpret = new JButton("Opret");
		btnOpret.setBounds(582, 310, 117, 29);
		btnOpret.addActionListener( this.actionEventHandler);
		btnOpret.setActionCommand(Actions.CreateEvent);
		add(btnOpret);
		
		textFieldLocation = new JTextField("");
		textFieldLocation.setBounds(572,264,134,28);
		add(textFieldLocation);
		
		textFieldEndDate = new JTextField("");
		textFieldEndDate.setBounds(572, 186, 134, 28);
		add(textFieldEndDate);
		
		textFieldStartDate = new JTextField("");
		textFieldStartDate.setBounds(572, 146, 134, 28);
		add(textFieldStartDate); 
		
		textFieldNote = new JTextField("");
		textFieldNote.setBounds(572, 226, 134, 28);
		add(textFieldNote);
		
		
		textFieldTitle = new JTextField("");
		textFieldTitle.setBounds(572, 106, 134, 28);
		add(textFieldTitle);
		
		
		lblEvents = new JLabel("");
		lblEvents.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
		lblEvents.setHorizontalAlignment(SwingConstants.LEFT);
		lblEvents.setBounds(56, 141, 415, 167);
		//add(lblEvents);
		
		panelDates = new JPanel();
		panelDates.setBounds(147, 67, 250, 233);
		panelDates.setLayout(new BoxLayout(panelDates, BoxLayout.PAGE_AXIS));
		panelDates.setOpaque(false);
		add(panelDates);
	
		lbldate = new JLabel("");
		lbldate.setBounds(299, 19, 0, 0);
		add(lbldate);
		
		lblAppointments = new JLabel("Dine aftaler for i dag");
		lblAppointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointments.setForeground(Color.white);
		lblAppointments.setFont(boldFont);
		lblAppointments.setBounds(-124, 19, 728, 16);
		add(lblAppointments);
		
		
		// Standard Swing components
		
		btnLogOut = new JButton("Log af");
		btnLogOut.setBounds(605, 11, 117, 29);
		btnLogOut.addActionListener(this.actionEventHandler);
		btnLogOut.setActionCommand(Actions.Logout);
		add(btnLogOut);
		
		Background = new JLabel("");
		Background.setBounds(0, 0, 728, 400);
		add(Background);	
		
	}
	

	public void setDailyEve(String username)
	
	{

		lblEvents.setText(username);
			
	}
	
	public void setLblEvents(Calendar[] calendars) {
				
		for(int i = 0; i< calendars.length; i++)
		{
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel lblTitle = new JLabel("Title:"+calendars[i].getTitle());
			panel.add(lblTitle);
			JLabel lblDate = new JLabel("Date:"+calendars[i].getStartDate()+" to "+calendars[i].getEndDate());
			panel.add(lblDate);
			JLabel lblNote = new JLabel("Note:"+calendars[i].getNote());
			panel.add(lblNote);
			JLabel lblLocation = new JLabel("Location:"+calendars[i].getLocation());
			panel.add(lblLocation);
			panelDates.add(panel);
		}		
	} 
	
	public String getTitle() {
		return textFieldTitle.getText();
	}
	public String getNote() {
		return textFieldNote.getText();
	}
	public String getStartDate() {

		return textFieldStartDate.getText();

	}
	public String getEndDate()  {
		return textFieldEndDate.getText();
	}
	
	public String getLokation() {
		return textFieldLocation.getText();
	}

	public void setStatus(String message) {
		labelStatus.setText(message);
	}
	public void setUserEvents(String events){
		lblEvents.setText(events);
	}
}