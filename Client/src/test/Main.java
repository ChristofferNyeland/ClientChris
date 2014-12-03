package test;

import guiLogic.LogicGUI;

public class Main {

	public static void main(String[] args) {

		try {
			LogicGUI lGUI = new LogicGUI();
			lGUI.startApp();
			System.out.println("TEST");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
