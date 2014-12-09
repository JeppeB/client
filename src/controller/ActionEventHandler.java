package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import function.ServerManager;
import model.Events;
import model.Calendar;
import model.User;
import utilities.Actions;
import utilities.Views;
import view.CalendarView;
import view.Login;
import view.Screen;

public class ActionEventHandler implements ActionListener {
	/** The calendar controller. */
	private Controller calendarController;
	
	/** The screen. */
	private Screen screen;

	private User currentUser;

	/**
	 * Instantiates a new action event handler.
	 *
	 * @param atmController the atm controller
	 * @param screen the screen
	 */
	public ActionEventHandler(Controller calendarController, Screen screen) {
		this.calendarController = calendarController;
		this.screen = screen;
	}
	
	public void actionPerformed(ActionEvent e) {
		//Find the actions id, as a different ActionCommand is set for each functionality
		String cmd = e.getActionCommand();

		if (cmd.equals(Actions.Login)) {
			
			String username = screen.getLoginView().getUserName();
			String password = screen.getLoginView().getPassword();
			
			try {
				screen.setCurrentUser(ServerManager.Login(username, password));
				screen.show(Views.CalendarDay);
			} catch (Exception e1) {
				screen.getLoginView().setStatus(e1.getMessage());
			}		
		}
		else if(cmd.equals(Actions.Logout)){
			screen.getLoginView().resetView();
			screen.setCurrentUser(null);
			
			screen.show(Views.Login);
		}
		else if(cmd.equals(Actions.CalendarDay)){
			
			String userName = screen.getLoginView().getUserName();
			try {	
				Calendar[] calendars = ServerManager.RequestCalendar(userName);
				screen.getCalendarDay().setLblEvents(calendars);
				
			} catch (Exception e1) {
				screen.getCalendarDay().setStatus(e1.getMessage());
			}
			
			
			
			screen.show(Views.CalendarDay);
		}
		else if(cmd.equals(Actions.CalendarOverview)){
			screen.show(Views.CalendarOverview);
		}
		else if(cmd.equals(Actions.MainMenu)){
			screen.show(Views.MainMenu);
		}
		else if(cmd.equals(Actions.CreateEvent)){
			
			
			String titel = screen.getCalendarDay().getTitle();
			String note = screen.getCalendarDay().getNote();
			String lokation = screen.getCalendarDay().getLokation();
			String startDate = screen.getCalendarDay().getStartDate();
			String endDate = screen.getCalendarDay().getEndDate();
			String userName = screen.getLoginView().getUserName();
			try {		
				screen.setDailyEvents(ServerManager.CreateCalendar(titel, startDate, endDate, note, lokation, userName));
			} catch (Exception e1) {
				screen.getCalendarDay().setStatus(e1.getMessage());
			}
			
			
		}
		
	}

	public User getCurrentUser() {
		return currentUser;
	}
}