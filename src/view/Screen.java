package view;

import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Events;
import model.CreateEvent;
import model.ShowEvents;
import utilities.Views;
import controller.ActionEventHandler;
import controller.Controller;


/**
 * The Class Screen.
 */
public class Screen extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Windows properties
	/** The Constant WIDTH. */
	public static final int WIDTH = 689	;
	
	/** The Constant HEIGHT. */
	public static final int HEIGHT = 380;
	
	
	
	//Declare our JPanels
	///** The action event handler. */
	//private ActionEventHandler actionEventHandler;
	
	/** The login. */ // login
	private Login login;
		
	
	private CalendarView calendarDay;
	
	private model.User currentUser;
	
	private model.ShowEvents email;
		
	/** get events. */
	private Events calendarDate;
	

	
	/** The root panel. */
	private JPanel rootPanel;

	private ActionEventHandler actionEventHandler;
	
	/** The c. */
	CardLayout c;
	
	public Screen(Controller calendarController)
	{

		//Add the properties to the windows
		setTitle("Kalender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		
		rootPanel = new JPanel();
		rootPanel.setLayout(new CardLayout(0,0));
		
		//Initiate a new actionEventHandler
		this.actionEventHandler = new ActionEventHandler(calendarController, this);
		
		//Instanser af JPanels
		login = new Login(actionEventHandler);
		calendarDay = new CalendarView(actionEventHandler);
				
		//Add the panels to the rootPanel
		rootPanel.add(login, Views.Login);
		rootPanel.add(calendarDay, Views.CalendarDay);

		
		setContentPane(rootPanel);
		
		c = (CardLayout) getContentPane().getLayout();
	}
	
	/**
	 * Gets the mouse event handler.
	 *
	 * @return the mouse event handler
	 */
	public ActionEventHandler getActionEventHandler() {
		return actionEventHandler;
	}
	
	/**
	 * Sets the action event handler.
	 *
	 * @param actionEventHandler the new action event handler
	 */
	public void setActionEventHandler(ActionEventHandler actionEventHandler) {
		this.actionEventHandler = actionEventHandler;
	}
	
	public void show(String card) {
		c.show(rootPanel,  card);
	}
	
	public Login getLoginView(){
		return login;
	}

	public CalendarView getCalendarDay() {

		return calendarDay;
	}

	public model.User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(model.User currentUser) {
		this.currentUser = currentUser;
	}

	public Events getDailyEvents () {
		return calendarDate;
	}

	public void setDailyEvents(Events calendarDate) {
		this.calendarDate = calendarDate;
	}
	public ShowEvents getRequest () {
		return email;
	}
	public void setRequest(ShowEvents email) {
		this.email = email;
	}
	
}