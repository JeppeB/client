package function;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Calendar;
import model.CreateEvent;
import model.Events;
import model.Login;
import model.Events;
import model.ShowEvents;
import model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerManager {

	
	public static User Login(String username, String password) throws Exception{
		Gson gson = new GsonBuilder().create();
		Login login = new Login();
		User user;
		
		// Krypter password før det sendes over netværk.
		String encryptedPassword = Encryption.encrypt(password);	
		
		login.setAuthUserPassword(encryptedPassword);
		login.setAuthUserEmail(username);

		String gsonString = gson.toJson(login);
		String result = GetJsonFromServer(gsonString);

		user = (User)gson.fromJson(result, User.class);
		if(user.isError())
		{
			throw new Exception(user.getErrorMessage());		
		}

		return user;
	}
	

	private static String GetJsonFromServer(String jsonInput){
	
		String result = "Error";
		try {
			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = jsonInput.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			System.out.println(encrypted);
			outToServer.write(encrypted);
			outToServer.flush();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			result = inFromServer.readLine();
			clientSocket.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}
	
	
	public static Events CreateCalendar(String titel, String startDate, String endDate, String note, String location, String userName) {
		Gson gson = new GsonBuilder().create();
		//Appointment[] appointments = new Appointment[1];
	//	Appointment appointment = new Appointment();
	//	appointments[0] = appointment;
	
		CreateEvent createCalendar = new CreateEvent();
		Events appointment;
		
		createCalendar.setTitle(titel);
		createCalendar.setNote(note);
		createCalendar.setStartDate(startDate);
		createCalendar.setEndDate(endDate);
		createCalendar.setLocation(location);
		createCalendar.setEmail(userName);
		
		String gsonString = gson.toJson(createCalendar);
		String result = GetCalendar(gsonString);
		
		appointment = (Events)gson.fromJson(result, Events.class);
		
		return appointment;
		
	}	
	
	private static String GetCalendar(String jsonInput){
		
		String result = "Error";
		try {
			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = jsonInput.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			System.out.println(encrypted);
			outToServer.write(encrypted);
			outToServer.flush();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			result = inFromServer.readLine();
			clientSocket.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	} 

	
	public static Calendar[] RequestCalendar(String userName) {

		Gson gsons = new GsonBuilder().create();
		//User user;
		ShowEvents showCalendar = new ShowEvents();
		System.out.println(userName);
		showCalendar.setEmail(userName);

		String gsonString = gsons.toJson(showCalendar);
		String result = GetJsonFromServer(gsonString);
		System.out.println(result);
		
		Calendar[] calendars = gsons.fromJson(result, Calendar[].class);
		return calendars;
	}	
	
	public static String ImpCalendar(String jsonInput){
		String Returned = "";
		String result = "Error";
		System.out.println(jsonInput);
		try {
			System.out.println(jsonInput);
			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = jsonInput.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			System.out.println(encrypted);
			outToServer.write(encrypted);
			outToServer.flush();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			Returned = inFromServer.readLine();
			clientSocket.close();
			return Returned;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}
	
}