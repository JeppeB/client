package controller;

import javax.swing.JFrame;

import utilities.Views;
import view.Screen;


public class Controller {

	/** The screen. */
	private Screen screen;
	
	public Controller() {
		this.screen = new Screen(this);
	}

	public void run() {
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
		screen.setLocationRelativeTo(null);
		screen.show(Views.Login);
	}

}