package model;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


public class Calendar implements java.io.Serializable {

	public Calendar() {
		// TODO Auto-generated constructor stub
	}
	private String title;
	private String startDate; 
	private String endDate;
	private String note;
	private String location;
	private boolean activity;
	private String email;
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	} 
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setActivity(boolean activity) {
		this.activity = activity;
	} 
	public boolean getActivity() {
		return activity;
	}

}