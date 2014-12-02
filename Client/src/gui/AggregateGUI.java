package gui;

import java.awt.CardLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class AggregateGUI extends JFrame{
	
	public static final String loginScreen = "LoginScreen";
	public static final String mainMenu = "MainMenu";
	public static final String quoteAndWeather = "QuoteAndWeather";
	public static final String eventGUI = "EventGUI";
	
	
	private static JPanel contentPane;
	CardLayout c;
	
	private LoginGUI LI;
	private MainMenu MM;
	private QuoteAndWeather QAW;
	private EventGUI EG;
	
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
		
		QAW = new QuoteAndWeather();
		contentPane.add(QAW, quoteAndWeather);
		
		EG = new EventGUI();
		contentPane.add(EG, eventGUI);
		
	}

	public LoginGUI getLI() {
		return LI;
	}

	public MainMenu getMM() {
		return MM;
	}
	public QuoteAndWeather getQAW(){
		return QAW;
	}
	
	public EventGUI getEG(){
		return EG;
	}
	
	public void show(String card){
		c.show(getContentPane(), card);
	}


}
