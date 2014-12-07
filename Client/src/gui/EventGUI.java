package gui;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;

public class EventGUI extends JPanel{

	//Buttons
	private JButton mainMenuBtn = new JButton("Back");
	private JButton btnCreateEvent = new JButton("Add Event");
	private JButton btnClearFields = new JButton("Clear Fields");
	//Elements to create event
	private JTextField nameField = new JTextField();
	private JTextPane infoBox = new JTextPane();
	private JComboBox<Object> typeCombo = new JComboBox<Object>();
	private JComboBox<Object> startMinute = new JComboBox<Object>();
	private JComboBox<Object> startYear = new JComboBox<Object>();
	private JComboBox<Object> startHour = new JComboBox<Object>();
	private JComboBox<Object> startDay = new JComboBox<Object>();
	private JComboBox<Object> startMonth = new JComboBox<Object>();
	private JComboBox<Object> endMinute = new JComboBox<Object>();
	private JComboBox<Object> endYear = new JComboBox<Object>();
	private JComboBox<Object> endhour = new JComboBox<Object>();
	private JComboBox<Object> endDay = new JComboBox<Object>();
	private JComboBox<Object> endMonth = new JComboBox<Object>();
	private JComboBox<Object> calendarCombo = new JComboBox<Object>();
	private JLabel lbl = new JLabel();
	private JTextField txtChooseLocation = new JTextField();

	/**
	 * Create the panel.
	 */
	
	public EventGUI() {
		setLayout(null);
		setBounds(0,0,1366,768);
		
		/*
		 * Jlabels
		 */
		JLabel lblAddEvent = new JLabel("Add Event");
		lblAddEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEvent.setForeground(Color.WHITE);
		lblAddEvent.setFont(new Font("Arial", Font.BOLD, 78));
		lblAddEvent.setBounds(313, 27, 618, 90);
		add(lblAddEvent);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 18));
		lblName.setBounds(439, 146, 51, 22);
		add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblType.setBounds(439, 189, 43, 22);
		add(lblType);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Arial", Font.BOLD, 18));
		lblLocation.setBounds(439, 224, 75, 22);
		add(lblLocation);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Arial", Font.BOLD, 18));
		lblStartDate.setBounds(438, 263, 86, 22);
		add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Arial", Font.BOLD, 18));
		lblEndDate.setBounds(438, 294, 86, 22);
		add(lblEndDate);
		
		JLabel lblCalendar = new JLabel("Calendar");
		lblCalendar.setFont(new Font("Arial", Font.BOLD, 18));
		lblCalendar.setBounds(436, 329, 78, 22);
		add(lblCalendar);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Arial", Font.BOLD, 18));
		lblInformation.setBounds(436, 367, 100, 22);
		add(lblInformation);
		
		/*
		 * Jbuttons
		 */
		mainMenuBtn.setForeground(Color.WHITE);
		mainMenuBtn.setFont(new Font("Arial", Font.BOLD, 30));
		mainMenuBtn.setContentAreaFilled(false);
		mainMenuBtn.setBorder(new CompoundBorder(new BevelBorder(

						BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,

								0), new Color(255, 255, 255), new Color(0, 0, 0)),

						new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255),

								new Color(0, 0, 0), new Color(255, 255, 255),

								new Color(0, 0, 0))));
		mainMenuBtn.setBounds(543, 647, 163, 43);
		add(mainMenuBtn);
		
		
		btnCreateEvent.setForeground(Color.WHITE);
		btnCreateEvent.setFont(new Font("Arial", Font.BOLD, 30));
		btnCreateEvent.setContentAreaFilled(false);
		btnCreateEvent.setBorder(new CompoundBorder(new BevelBorder(


								BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,


										0), new Color(255, 255, 255), new Color(0, 0, 0)),


								new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255),


										new Color(0, 0, 0), new Color(255, 255, 255),


										new Color(0, 0, 0))));
		btnCreateEvent.setBounds(436, 576, 179, 43);
		add(btnCreateEvent);
		
		
		btnClearFields.setForeground(Color.WHITE);
		btnClearFields.setFont(new Font("Arial", Font.BOLD, 30));
		btnClearFields.setContentAreaFilled(false);
		btnClearFields.setBorder(new CompoundBorder(new BevelBorder(


								BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,


										0), new Color(255, 255, 255), new Color(0, 0, 0)),


								new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255),


										new Color(0, 0, 0), new Color(255, 255, 255),


										new Color(0, 0, 0))));
		btnClearFields.setBounds(650, 576, 179, 43);
		add(btnClearFields);
		
		/*
		 * TextFields 
		 */
		nameField.setText("Enter Event Name");
		nameField.setBounds(560, 146, 266, 22);
		add(nameField);
		nameField.setColumns(10);
		
		infoBox.setText("If any, enter further information here...");
		infoBox.setBounds(439, 402, 391, 118);
		add(infoBox);
		/*
		 * JComboBox
		 */
		typeCombo.setModel(new DefaultComboBoxModel(new String[] {"Choose Type", "Lecture", "Excercise", "Other"}));
		typeCombo.setBounds(560, 189, 266, 22);
		add(typeCombo);
		
		startMinute.setBounds(889, 259, 85, 22);
		startMinute.addItem("MM");
		add(startMinute);
		
		startYear.setBounds(536, 259, 85, 22);
		startYear.addItem("YYYY");
		add(startYear);
		
		startHour.setBounds(803, 259, 85, 22);
		startHour.addItem("HH");
		add(startHour);
		
		startDay.setBounds(704, 259, 85, 22);
		startDay.addItem("DD");
		add(startDay);
		
		startMonth.setBounds(621, 259, 85, 22);
		startMonth.addItem("MM");
		add(startMonth);
		
		endMinute.setBounds(889, 296, 85, 22);
		endMinute.addItem("MM");
		add(endMinute);
		
		endYear.setBounds(536, 296, 85, 22);
		endYear.addItem("YYYY");
		add(endYear);
		
		endhour.setBounds(803, 296, 85, 22);
		endhour.addItem("HH");
		add(endhour);
		
		endDay.setBounds(714, 296, 85, 22);
		endDay.addItem("DD");
		add(endDay);
		
		endMonth.setBounds(619, 295, 85, 22);
		endMonth.addItem("MM");
		add(endMonth);
		calendarCombo.setModel(new DefaultComboBoxModel(new String[] {"Choose Calendar", "Ledelse af IS - forandring, innovation og viden (XA)", "Ledelse af IS - forandring, innovation og viden (LA)", "Ledelse af IS - forandring, innovation og viden (XB)", "Makro\u00F8konomi (LA)", "Makro\u00F8konomi (XA)", "Makro\u00F8konomi (XB)", "Virksomhedens \u00F8konomiske styring (3) (LA)", "Distribuerede systemer (LA)"}));
		
		calendarCombo.setBounds(560, 330, 266, 22);
		calendarCombo.addItem("Choose Calendar");
		add(calendarCombo);
		lbl.setIcon(new ImageIcon(LoginGUI.class.getResource("/img/MetalBackground.jpg")));
		
		JLabel lblNewLabel = new JLabel("");
		lbl.setIcon(new ImageIcon(LoginGUI.class.getResource("/img/MetalBackground.jpg")));
		lblNewLabel.setBounds(12, 697, 250, 59);
		add(lblNewLabel);
		
		txtChooseLocation.setText("Choose Location");
		txtChooseLocation.setBounds(560, 222, 266, 28);
		add(txtChooseLocation);
		txtChooseLocation.setColumns(10);
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setBounds(0, 0, 1376, 768);
		lblBackground.setIcon(new ImageIcon(LoginGUI.class.getResource("/img/MetalBackground.jpg")));
		lblBackground.setBackground(new Color(245, 245, 245));
		lblBackground.setForeground(new Color(245, 255, 250));
		lblBackground.setOpaque(true);
		add(lblBackground);
	}
	public JButton getBtnClearFields() {
		return btnClearFields;
	}
	public void setBtnClearFields(JButton btnClearFields) {
		this.btnClearFields = btnClearFields;
	}
	
	public void backListener(ActionListener l) {
		mainMenuBtn.addActionListener(l);
	}
	public void createEventListener (ActionListener l)
	{
		btnCreateEvent.addActionListener(l);
	}
	public void clearFieldListener (ActionListener l)
	{
		btnClearFields.addActionListener(l);
	}
	/*
	 * Getters and setters
	 */
	public JTextField getNameField() {
		return nameField;
	}
	public JTextPane getInfoBox() {
		return infoBox;
	}
	public JComboBox<Object> getTypeCombo() {
		return typeCombo;
	}
	public JComboBox<Object> getStartMinute() {
		return startMinute;
	}
	public JComboBox<Object> getStartYear() {
		return startYear;
	}
	public JComboBox<Object> getStartHour() {
		return startHour;
	}
	public JComboBox<Object> getStartDay() {
		return startDay;
	}
	public JComboBox<Object> getStartMonth() {
		return startMonth;
	}
	public JComboBox<Object> getEndMinute() {
		return endMinute;
	}
	public JComboBox<Object> getEndYear() {
		return endYear;
	}
	public JComboBox<Object> getEndhour() {
		return endhour;
	}
	public JComboBox<Object> getEndDay() {
		return endDay;
	}
	public JComboBox<Object> getEndMonth() {
		return endMonth;
	}
	public JComboBox<Object> getCalendarCombo() {
		return calendarCombo;
	}
	public JTextField getTxtChooseLocation() {
		return txtChooseLocation;
	}
	public JButton getMainMenuBtn() {
		return mainMenuBtn;
	}
	
}