package gui;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

public class MainMenu extends JPanel {
	private JButton btnLogout = new JButton("Log Out");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable weekTable = new JTable();
	private final JScrollPane scrollPaneDay = new JScrollPane();
	private JLabel lblMainMenu;
	private JLabel lblTodaysWeather;
	private JLabel lblTodaysQuote;
	private JLabel lblYourCalendar;
	private final JTable dayTable = new JTable();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private JButton btnEvents;
	private JButton btnViewNotes;
	private JButton btnCalendar;
	private JLabel weatherLabel = new JLabel("");
	private JLabel quoteText1 = new JLabel("");
	private JLabel quoteText2 = new JLabel("");
	private JButton btnNotes;
	private JLabel lblDailyCalendar;

	public MainMenu() {
		setLayout(null);
		setPreferredSize(new Dimension(1366, 768));

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(622, 667, 202, 62);
		add(btnLogout);

		lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Arial", Font.BOLD, 34));
		lblMainMenu.setBounds(632, 20, 175, 40);
		add(lblMainMenu);

		lblTodaysWeather = new JLabel("Today's Weather:");
		lblTodaysWeather.setFont(new Font("Arial", Font.BOLD, 16));
		lblTodaysWeather.setBounds(21, 72, 133, 19);
		add(lblTodaysWeather);

		lblTodaysQuote = new JLabel("Today's Quote:");
		lblTodaysQuote.setFont(new Font("Arial", Font.BOLD, 16));
		lblTodaysQuote.setBounds(21, 182, 133, 19);
		add(lblTodaysQuote);

		lblYourCalendar = new JLabel("Weekly Calendar:");
		lblYourCalendar.setFont(new Font("Arial", Font.BOLD, 16));
		lblYourCalendar.setBounds(1053, 72, 133, 19);
		add(lblYourCalendar);

		btnEvents = new JButton("View Events");
		btnEvents.setBounds(622, 72, 202, 62);
		add(btnEvents);

		btnViewNotes = new JButton("View Notes");
		btnViewNotes.setBounds(622, 301, 202, 62);
		add(btnViewNotes);
		
		btnNotes = new JButton("Notes");
		btnNotes.setBounds(622, 220, 202, 62);
		add(btnNotes);

		btnCalendar = new JButton("View Full Calendar");
		btnCalendar.setBounds(622, 146, 202, 62);
		add(btnCalendar);
		scrollPane.setLocation(836, 112);
		scrollPane.setSize(507, 620);

		add(scrollPane);
		setBounds(100, 100, 200, 200);
		weekTable.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, }, new String[] {
				"Lec./Exc.", "Room", "Start", "End",
				"Subject", "Notes" }));

		scrollPane.setViewportView(weekTable);

		add(scrollPane);
		
		scrollPane.setViewportView(dayTable);
		scrollPane_1.setBounds(21, 341, 549, 389);
		
		add(scrollPane_1);
		weekTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));

		weatherLabel.setBounds(21, 97, 589, 22);
		add(weatherLabel);

		quoteText1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		quoteText1.setBounds(21, 221, 589, 23);
		add(quoteText1);
		quoteText2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quoteText2.setBounds(21, 273, 589, 23);

		add(quoteText2);
		
		lblDailyCalendar = new JLabel("Daily Calendar:");
		lblDailyCalendar.setFont(new Font("Arial", Font.BOLD, 16));
		lblDailyCalendar.setBounds(231, 310, 133, 19);
		add(lblDailyCalendar);
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setBounds(0, 0, 1376, 768);
		lblBackground.setIcon(new ImageIcon(LoginGUI.class.getResource("/img/MetalBackground.jpg")));
		lblBackground.setBackground(new Color(245, 245, 245));
		lblBackground.setForeground(new Color(245, 255, 250));
		lblBackground.setOpaque(true);
		add(lblBackground);
		
	
	

	}

	public JLabel getQuoteText1() {
		return quoteText1;
	}

	public void setQuoteText1(JLabel quoteText1) {
		this.quoteText1 = quoteText1;
	}

	public JLabel getQuoteText2() {
		return quoteText2;
	}

	public void setQuoteText2(JLabel quoteText2) {
		this.quoteText2 = quoteText2;
	}

	public JLabel getWeatherLabel() {
		return weatherLabel;
	}

	public void setWeatherLabel(JLabel weatherLabel) {
		this.weatherLabel = weatherLabel;
	}


	public JButton getBtnViewEvents() {
		return btnEvents;
	}

	public JButton getBtnViewNotes() {
		return btnViewNotes;
	}

	public JButton getBtnViewFullCalendar() {
		return btnCalendar;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public void addActionListenerEvents(ActionListener l) {
		btnEvents.addActionListener(l);
	}

	public void addActionListenerLogOut(ActionListener l) {
		btnLogout.addActionListener(l);
	}
	
	public void viewNoteListener (ActionListener l)
	{
		btnViewNotes.addActionListener(l);
	}
	
	public void noteViewListener (ActionListener l)
	{
		btnNotes.addActionListener(l);
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void calendarListener(ActionListener l) {
		btnCalendar.addActionListener(l);
	}

	public void eventListener(ActionListener l) {
		btnEvents.addActionListener(l);
	}

	public JTable getWeekTable() {
		return weekTable;
	}

	public JScrollPane getScrollPaneDay() {
		return scrollPaneDay;
	}
	public JTable getDayTable() {
		return dayTable;
	}
}
