package guiLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ServerHandler;
import gui.AggregateGUI;

public class LogicGUI { // the class that contains all gui logic in order to follow the 3-layer model 
	private AggregateGUI AG; // new object of the class that binds the gui together
	ServerHandler SH = new ServerHandler(); //object of Server Handler class 
	private String overallUserID; // string to handle userID
	private String overallUserName;
	private int overallAdminCheck;

	public LogicGUI() throws SQLException {
		AG = new AggregateGUI();
		initializeListeners();
	}

	public void startApp() {
		AG.show(AggregateGUI.loginScreen);
		AG.setVisible(true);
	}

	private class logIn implements ActionListener { //log in method 
		public void actionPerformed(ActionEvent e) {

			String emailInput = AG.getLI().getEmailTextField().getText(); //gets data from user input and sets it to the String
			String passwordInput = AG.getLI().getPasswordField().getText(); //gets data from user input and sets it to the String
			if (SH.userCheck(emailInput, passwordInput).equals("1")) { //if statement to check if it is = 1 
				setAllKnowingUsername(emailInput); //sets the variable to the one information the user logged in as 
				AG.show(AggregateGUI.mainMenu); // displays main menu
				AG.getLI().getEmailTextField().setText(""); // set text box empty once again
				AG.getLI().getPasswordField().setText(""); // set text box empty once again
				AG.getMM().getQuoteText1().setText(SH.quoteCheck());
				AG.getMM().getWeatherLabel().setText(SH.weatherCheck());

				setWeekView();
				setQuote();
				setWeather();
				// setDayView();
			} else {
				JOptionPane.showMessageDialog(null,
						"Wrong username / password", "Information",
						JOptionPane.INFORMATION_MESSAGE); // error message if users credentials were not in database

			}

		}

	}

	private class logOut implements ActionListener { // method that shows login screen when clicking logout
		public void actionPerformed(ActionEvent e) {
			AG.show(AggregateGUI.loginScreen);

		}

	}

	private void setWeekView() { // sets the week view of the users plans

		String[][] weekDate = SH.getEventsFromUSerWeek(overallUserName); //using the credentials from what users input to determine what to show
		int arrayCounter = weekDate[0].length;

		int arrayChecker = 0;
		int arrayCheckerPlus = 0;
		for (int reset = 1; reset < 99; reset++) {

			// Sets every field in a Jtable equals nothing
			AG.getMM().getWeekTable().setValueAt(null, reset, 0);
			AG.getMM().getWeekTable().setValueAt(null, reset, 1);
			AG.getMM().getWeekTable().setValueAt(null, reset, 2);
			AG.getMM().getWeekTable().setValueAt(null, reset, 3);
			AG.getMM().getWeekTable().setValueAt(null, reset, 4);
		}

		while (arrayChecker < arrayCounter) { // while loop for getting everything in the table array
			try {
				if (!weekDate[0][arrayChecker].isEmpty()) {
					
					AG.getMM()
							.getWeekTable()
							.setValueAt(weekDate[0][arrayChecker],
									arrayCheckerPlus, 0);
					AG.getMM()
							.getWeekTable()
							.setValueAt(weekDate[1][arrayChecker],
									arrayCheckerPlus, 1);
					AG.getMM()
							.getWeekTable()
							.setValueAt(weekDate[2][arrayChecker],
									arrayCheckerPlus, 2);
					AG.getMM()
							.getWeekTable()
							.setValueAt(weekDate[3][arrayChecker],
									arrayCheckerPlus, 3);
					AG.getMM()
							.getWeekTable()
							.setValueAt(weekDate[4][arrayChecker],
									arrayCheckerPlus, 4);
					arrayChecker++;
					arrayCheckerPlus++;
				}
			} catch (Exception e) {
				
				arrayChecker++;
			}
		}
	}

	private void getCalendars() {
		String[][] calendarData = SH.getCalendarsFromAll();
		System.out.println(calendarData[1][1]);
		int arrayCounter = calendarData[0].length;
		int arrayChecker = 0;
		int arrayCheckerPlus = 0;
		for (int reset = 1; reset < 99; reset++) {
			
			// Sets every field in a Jtable equals nothing
			AG.getCV().getCalendarTable().setValueAt(null, reset, 0);
			AG.getCV().getCalendarTable().setValueAt(null, reset, 1);
			AG.getCV().getCalendarTable().setValueAt(null, reset, 2);
			AG.getCV().getCalendarTable().setValueAt(null, reset, 3);
			AG.getCV().getCalendarTable().setValueAt(null, reset, 4);
		}

		while (arrayChecker < arrayCounter) {
			try {
				if (!calendarData[0][arrayChecker].isEmpty()) {
					System.out.println("Vi er inde i while-loop "
							+ arrayChecker + ". gang");
					AG.getCV()
							.getCalendarTable()
							.setValueAt(calendarData[0][arrayChecker],
									arrayCheckerPlus, 0);
					AG.getCV()
							.getCalendarTable()
							.setValueAt(calendarData[1][arrayChecker],
									arrayCheckerPlus, 1);
					AG.getCV()
							.getCalendarTable()
							.setValueAt(calendarData[2][arrayChecker],
									arrayCheckerPlus, 2);
					AG.getCV()
							.getCalendarTable()
							.setValueAt(calendarData[3][arrayChecker],
									arrayCheckerPlus, 3);
					AG.getCV()
							.getCalendarTable()
							.setValueAt(calendarData[4][arrayChecker],
									arrayCheckerPlus, 4);
					arrayChecker++;
					arrayCheckerPlus++;
				}
			} catch (Exception e) {
				System.out.println("Well... We Try again");
				arrayChecker++;
			}
		}

	}

	// private void setDayView()
	// {
	// String[][] dayDate = SH.getEventsFromUSerDay(overallUserName);
	// int arrayCounter = dayDate[0].length;
	// int arrayChecker = 0;
	// int arrayCheckerPlus = 0;
	// for (int reset = 1; reset < 99; reset++) {
	// System.out.println("Vi er inde i for-loop " + reset + ". gang");
	// // Sets every field in a Jtable equals nothing
	// AG.getMM().getDayTable().setValueAt(null, reset, 0);
	// AG.getMM().getDayTable().setValueAt(null, reset, 1);
	// AG.getMM().getDayTable().setValueAt(null, reset, 2);
	// AG.getMM().getDayTable().setValueAt(null, reset, 3);
	// AG.getMM().getDayTable().setValueAt(null, reset, 4);
	// }
	//
	//
	// while (arrayChecker < arrayCounter) {
	// try
	// {
	// if(!dayDate[0][arrayChecker].isEmpty())
	// {
	// System.out.println("Vi er inde i while-loop " + arrayChecker+ ". gang");
	// AG.getMM().getDayTable().setValueAt(dayDate[0][arrayChecker],
	// arrayCheckerPlus, 0);
	// AG.getMM().getDayTable().setValueAt(dayDate[1][arrayChecker],
	// arrayCheckerPlus, 1);
	// AG.getMM().getDayTable().setValueAt(dayDate[2][arrayChecker],
	// arrayCheckerPlus, 2);
	// AG.getMM().getDayTable().setValueAt(dayDate[3][arrayChecker],
	// arrayCheckerPlus, 3);
	// AG.getMM().getDayTable().setValueAt(dayDate[4][arrayChecker],
	// arrayCheckerPlus, 4);
	// arrayChecker++;
	// arrayCheckerPlus++;
	// }
	// }
	// catch(Exception e)
	// {
	// System.out.println("Well... We Try again");
	// arrayChecker++;
	// }
	// }
	// }
	private void setQuote() { // method to display the quote in the main menu
		String quoteText = SH.quoteCheck();
		int quoteLength = quoteText.length();
		// if quote is longer than 100 chars, jump to next field.
		if (quoteLength > 100) {
			CharSequence firstHalf = quoteText.subSequence(0, 100) + "-";
			CharSequence secondHalf = quoteText.subSequence(100, quoteLength);
			String firstHalfString = firstHalf.toString();
			String secondHalfString = secondHalf.toString();

			AG.getMM().getQuoteText1().setText(firstHalfString);
			AG.getMM().getQuoteText2().setText(secondHalfString);
		} else {
			AG.getMM().getQuoteText1().setText(quoteText);
		}
	}

	private void setWeather() { // sets the weather 
		String weatherText = SH.getWeather();
		AG.getMM().getWeatherLabel().setText(weatherText);
	}

	private class subscribeToCalendar implements ActionListener { // subscribe to calendar
		public void actionPerformed(ActionEvent e) {
			String calendarName = AG.getCV().getSubscribeField().getText();
			SH.useToCalendar(overallUserName, calendarName);
		}
	}

	private class createCalendar implements ActionListener { // create calendar
		public void actionPerformed(ActionEvent e) {
			String calendarName = AG.getCV().getCreateField().getText();
			String comboText = AG.getCV().getCreateCombo().getSelectedItem()
					.toString();
			int PP = 0;
			System.out.println(comboText);
			if (comboText.equals("Private")) {
				PP = 2;
			} else {
				PP = 1;
			}
			System.out.println(PP);
			SH.createCalendar(calendarName, PP, overallUserName);
		}
	}

	private class deleteCalendar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String calendarName = AG.getCV().getDeleteField().getText();
			if (!calendarName.equals("")) {
				SH.deleteCalendar(calendarName, overallUserName);
			} else {
				AG.getCV().getDeleteField().setText("");
				JOptionPane.showMessageDialog(null,
						"You have to enter the name of a calendar to delete",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private class btnToMainMenu implements ActionListener {
		// When button pushed, show login screen
		public void actionPerformed(ActionEvent e) {
			AG.show(AggregateGUI.mainMenu);
		}
	}

	private class Events implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AG.show(AggregateGUI.eventGUI);
			setComboDates();
		}
	}

	private class addEvents implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	public void setComboDates() {
		for (int yCount = 2014; yCount < 2038; yCount++) {

			AG.getEG().getStartYear().addItem(yCount);
			AG.getEG().getEndYear().addItem(yCount);
		}
		for (int moCount = 1; moCount < 13; moCount++) {
			AG.getEG().getStartMonth().addItem(moCount);
			AG.getEG().getEndMonth().addItem(moCount);
		}
		for (int dCount = 1; dCount < 32; dCount++) {
			AG.getEG().getStartDay().addItem(dCount);
			AG.getEG().getEndDay().addItem(dCount);
		}
		for (int hCount = 1; hCount < 25; hCount++) {
			AG.getEG().getStartHour().addItem(hCount);
			AG.getEG().getEndhour().addItem(hCount);
		}
		for (int miCount = 1; miCount < 60; miCount++) {
			AG.getEG().getStartMinute().addItem(miCount);
			AG.getEG().getEndMinute().addItem(miCount);
		}
	}

	private class clearFields implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			AG.getEG().getNameField().setText("Enter Event Name");
			AG.getEG().getTypeCombo().setSelectedItem("Choose Type");

		}
	}

	private class toEventView implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AG.show(AggregateGUI.eventView);
		}
	}

	private class toCalendarView implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AG.show(AggregateGUI.calendarView);
			getCalendars();

		}
	}

	private class viewNote implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String eventID = JOptionPane
					.showInputDialog("Enter EventID of note to see");
			String note = SH.getNote(eventID);
			JOptionPane.showMessageDialog(null, note, "Note View",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	private class getNoteText implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String eventID = AG.getNV().getEventIDField().getText();
			if (!eventID.equals("")) {
				String note = SH.getNoteText(eventID);
				AG.getNV().getNoteTextArea().setText(note);
				AG.getNV().getUpdateNoteBtn().setEnabled(true);
			} else {
				AG.getNV().getEventIDField().setText("");
				JOptionPane.showMessageDialog(null,
						"You have to enter an Event ID", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private class updateNotes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String eventID = AG.getNV().getEventIDField().getText();
			String noteText = AG.getNV().getNoteTextArea().getText();
			String stringToBeReturned = SH.updateNote(eventID, noteText,
					overallUserName);

			AG.getNV().getUpdateNoteBtn().setEnabled(false);
		}
	}

	private class subscribeOtherUser implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userName = AG.getCV().getCalendarField().getText();
			String calendarName = AG.getCV().getUsernameField().getText();

			if (!userName.equals("") || !calendarName.equals("")) {
				SH.subscribeOtherUser(overallUserName, userName, calendarName);

			} else {
				System.out
						.println("You have to enter both an user and calendar!");
			}
		}
	}

	private class createEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String eventName = AG.getEG().getNameField().getText();
			String eventLocation = AG.getEG().getTxtChooseLocation().getText();
			String eventInfo = AG.getEG().getInfoBox().getText();
			String eventTypeCombo = AG.getEG().getTypeCombo().getSelectedItem()
					.toString();
			String startYear = AG.getEG().getStartYear().getSelectedItem()
					.toString();
			String startMonth = AG.getEG().getStartMonth().getSelectedItem()
					.toString();
			String startDay = AG.getEG().getStartDay().getSelectedItem()
					.toString();
			String startHour = AG.getEG().getStartHour().getSelectedItem()
					.toString();
			String startMinute = AG.getEG().getStartMinute().getSelectedItem()
					.toString();
			String endYear = AG.getEG().getEndYear().getSelectedItem()
					.toString();
			String endMonth = AG.getEG().getEndMonth().getSelectedItem()
					.toString();
			String endDay = AG.getEG().getEndDay().getSelectedItem().toString();
			String endHour = AG.getEG().getEndhour().getSelectedItem()
					.toString();
			String endMinute = AG.getEG().getEndMinute().getSelectedItem()
					.toString();
			String Calendar = AG.getEG().getCalendarCombo().getSelectedItem()
					.toString();

			String checkJson = SH.createEvent(eventName, eventLocation,
					eventInfo, eventTypeCombo, startYear, startMonth, startDay,
					startHour, startMinute, endYear, endMonth, endDay, endHour,
					endMinute, Calendar);

			JOptionPane.showMessageDialog(null, checkJson);
		}
	}

	
	//getters and setters

	public void setAllKnowingUsername(String allKnowingUsername) {
		this.overallUserName = allKnowingUsername;
	}

	public String getOverAllUserID() {
		return overallUserID;
	}

	public void setAllKnowingUserID(String allKnowingUserID) {
		this.overallUserID = allKnowingUserID;
	}

	public int getOverAllAdmin() {
		return overallAdminCheck;
	}

	public void setAllKnowingAdmin(int allKnowingAdmin) {
		this.overallAdminCheck = allKnowingAdmin;
	}

	private void initializeListeners() { // listeners for entire program 
		AG.getLI().addActionListenerWelcomeScreen(new logIn());
		AG.getMM().addActionListenerLogOut(new logOut());
		AG.getMM().addActionListenerEvents(new Events());
		AG.getEG().createEventListener(new createEvent());
		AG.getEG().clearFieldListener(new clearFields());
		AG.getEG().backListener(new btnToMainMenu());
		AG.getMM().calendarListener(new toCalendarView());
		AG.getCV().subscribeListener(new subscribeToCalendar());
		AG.getCV().deleteCalendarListener(new deleteCalendar());
		AG.getCV().createCalendarListener(new createCalendar());
		AG.getCV().goToMainMenu(new btnToMainMenu());
		AG.getMM().eventListener(new toEventView());
		AG.getCV().otherUserSubscribe(new subscribeOtherUser());

	}
}