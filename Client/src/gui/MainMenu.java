package gui;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

public class MainMenu extends JPanel {
	private JButton btnLogout;
	private JLabel lblMainMenu;
	private JLabel lblTodaysWeather;
	private JLabel lblTodaysQuote;
	private JTextArea weatherTextArea;
	private JTextArea quoteTextArea1;
	private JLabel lblYourCalendar;
	private JTextArea calendarTextArea;
	private JButton btnViewEvents;
	private JButton btnViewNotes;
	private JButton btnViewFullCalendar;
	
	
	public MainMenu() {
		setLayout(null);
		setPreferredSize(new Dimension(1366, 768));
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(582, 670, 202, 62);
		add(btnLogout);
		
		lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Arial", Font.BOLD, 34));
		lblMainMenu.setBounds(595, 17, 175, 40);
		add(lblMainMenu);
		
		lblTodaysWeather = new JLabel("Today's Weather:");
		lblTodaysWeather.setFont(new Font("Arial", Font.BOLD, 16));
		lblTodaysWeather.setBounds(273, 285, 133, 19);
		add(lblTodaysWeather);
		
		lblTodaysQuote = new JLabel("Today's Quote:");
		lblTodaysQuote.setFont(new Font("Arial", Font.BOLD, 16));
		lblTodaysQuote.setBounds(273, 482, 133, 19);
		add(lblTodaysQuote);
		
		weatherTextArea = new JTextArea();
		weatherTextArea.setBounds(35, 339, 778, 62);
		add(weatherTextArea);
		
		quoteTextArea1 = new JTextArea();
		quoteTextArea1.setBounds(35, 523, 778, 62);
		add(quoteTextArea1);
		
		lblYourCalendar = new JLabel("Your Calendar:");
		lblYourCalendar.setFont(new Font("Arial", Font.BOLD, 16));
		lblYourCalendar.setBounds(1074, 240, 133, 19);
		add(lblYourCalendar);
		
		calendarTextArea = new JTextArea();
		calendarTextArea.setBounds(874, 339, 486, 244);
		add(calendarTextArea);
		
		btnViewEvents = new JButton("View Events");
		btnViewEvents.setBounds(582, 72, 202, 62);
		add(btnViewEvents);
		
		btnViewNotes = new JButton("View Notes");
		btnViewNotes.setBounds(582, 146, 202, 62);
		add(btnViewNotes);
		
		btnViewFullCalendar = new JButton("View Full Calendar");
		btnViewFullCalendar.setBounds(582, 220, 202, 62);
		add(btnViewFullCalendar);
	}
	

	public JTextArea getWeatherTextArea() {
		return weatherTextArea;
	}

	public void setWeatherTextArea(JTextArea weatherTextArea) {
		this.weatherTextArea = weatherTextArea;
	}

	public JTextArea getQuoteTextArea1() {
		return quoteTextArea1;
	}

	public void setQuoteTextArea1(JTextArea quoteTextArea1) {
		this.quoteTextArea1 = quoteTextArea1;
	}

	public JTextArea getTextArea() {
		return calendarTextArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.calendarTextArea = textArea;
	}

	public JButton getBtnViewEvents() {
		return btnViewEvents;
	}

	public JButton getBtnViewNotes() {
		return btnViewNotes;
	}

	public JButton getBtnViewFullCalendar() {
		return btnViewFullCalendar;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	public void addActionListenerEvents(ActionListener l){
		btnViewEvents.addActionListener(l);
	}
	public void addActionListenerLogOut(ActionListener l){
		btnLogout.addActionListener(l);
	}
}

