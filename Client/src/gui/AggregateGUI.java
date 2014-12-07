package gui;

import java.awt.CardLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.NoteView;



public class AggregateGUI extends JFrame{
	
	public static final String loginScreen = "LoginScreen";
	public static final String mainMenu = "MainMenu";
	public static final String quoteAndWeather = "QuoteAndWeather";
	public static final String eventGUI = "EventGUI";
	public static final String dayView = "DayView";
	public static final String weekView = "WeekView";
	public static final String calendarView = "CalendarView";
	public static final String eventView = "EventView";
	public static final String noteView = "NoteView";
	
	
	private static JPanel contentPane;
	CardLayout c;
	
	private LoginGUI LI;
	private MainMenu MM;
	private EventGUI EG;
	private CalendarView CV;
	private NoteView NV;
	
	public AggregateGUI() throws SQLException{
		
		setTitle("Client software");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 799);
		setResizable(false);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		c = (CardLayout) getContentPane().getLayout();
		
		LI = new LoginGUI();
		contentPane.add(LI,loginScreen);
		
		MM = new MainMenu();
		contentPane.add(MM, mainMenu);
		
		
		EG = new EventGUI();
		contentPane.add(EG, eventGUI);
	
		
		CV = new CalendarView();
		contentPane.add(CV, calendarView);
		
		NV = new NoteView();
		contentPane.add(NV, noteView);
		
		
		
		
	}

	public LoginGUI getLI() {
		return LI;
	}

	public MainMenu getMM() {
		return MM;
	}
	
	
	public EventGUI getEG(){
		return EG;
	}
	public NoteView getNV() {
		return NV;
	}
	
	
	public CalendarView getCV() {
		return CV;
	}
	public void show(String card){
		c.show(getContentPane(), card);
	}


}
