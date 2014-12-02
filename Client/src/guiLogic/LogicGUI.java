package guiLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import connection.ServerHandler;
import gui.AggregateGUI;
import gui.EventGUI;
import gui.LoginGUI;
import gui.QuoteAndWeather;

public class LogicGUI {
	private AggregateGUI AG;
	private EventGUI EG;
	ServerHandler SH = new ServerHandler();
	private String checkUsername;
	private String checkUserID;
	private String checkAdmin;

	public LogicGUI() throws SQLException {
		AG = new AggregateGUI();
		initializeListeners();
	}

	public void startApp() {
		AG.show(AggregateGUI.loginScreen);
		AG.setVisible(true);
	}

	private class logIn implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String emailInput = AG.getLI().getEmailTextField().getText();
			String passwordInput = AG.getLI().getPasswordTextField().getText();
			if (SH.userCheck(emailInput, passwordInput).equals("1")) {
				AG.show(AggregateGUI.mainMenu);
				AG.getMM().getQuoteTextArea1().setText(SH.quoteCheck());
				AG.getMM().getWeatherTextArea().setText(SH.weatherCheck());
			}
			else{
				JOptionPane.showMessageDialog(null,  "Wrong username / password", "Information", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}

	}
	private class logOut implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			AG.show(AggregateGUI.loginScreen);
		
			
		}
		
	}
	
	private class btnToMainMenu implements ActionListener {
		// When button pushed, show login screen
		public void actionPerformed(ActionEvent e) {
			AG.show(AggregateGUI.mainMenu);
		}
		}
	private class Events implements ActionListener{
		public void actionPerformed(ActionEvent e){
			AG.show(AggregateGUI.eventGUI);
			setComboDates();
		}
	}
	
	private class addEvents implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
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
	
	private class clearFields implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
	 AG.getEG().getNameField().setText("Enter Event Name");
	 AG.getEG().getTypeCombo().setSelectedItem("Choose Type");
	 
	 
			
		}
	}
	private class createEvent implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		
			
			
			
	
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
			
			String checkJson = SH.createEvent(eventName, eventLocation, eventInfo, eventTypeCombo, startYear, startMonth, startDay, startHour, startMinute, endYear, endMonth, endDay, endHour, endMinute, Calendar);
			
			JOptionPane.showMessageDialog(null, checkJson);
		}
	}

	private void initializeListeners() {
		AG.getLI().addActionListenerWelcomeScreen(new logIn());
		AG.getMM().addActionListenerLogOut(new logOut());
		AG.getMM().addActionListenerEvents(new Events());
		AG.getEG().createEventListener(new createEvent());
		AG.getEG().clearFieldListener(new clearFields());
		AG.getEG().backListener(new btnToMainMenu());
		
	}
}