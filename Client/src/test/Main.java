package test;

import guiLogic.LogicGUI;

public class Main {

	public static void main(String[] args) { // main class of the program.

		try { // try to start guilogic and display the gui for the user
			LogicGUI lGUI = new LogicGUI();
			lGUI.startApp();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
