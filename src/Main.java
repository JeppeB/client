import function.ServerManager;
import controller.Controller;


public class Main {
	
	public static void main(String[] args) {
		
		ServerManager sm = new ServerManager();
		
		Controller calendarController = new Controller();
		//Run the program
		calendarController.run();
	}

}