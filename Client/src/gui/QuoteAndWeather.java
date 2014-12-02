package gui;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class QuoteAndWeather extends JPanel {
	private JLabel lblQuoteAndWeather;
	private JTextArea quoteTextArea;
	private JTextArea weatherTextArea;
	private JButton btnBackButton;
	private JLabel quoteLabel;
	private JLabel weatherLabel;
	public QuoteAndWeather() {
		setLayout(null);
		
		quoteTextArea = new JTextArea();
		quoteTextArea.setBounds(49, 184, 352, 45);
		add(quoteTextArea);
		
		lblQuoteAndWeather = new JLabel("Quote and Weather");
		lblQuoteAndWeather.setBounds(165, 5, 119, 16);
		add(lblQuoteAndWeather);
		
		weatherTextArea = new JTextArea();
		weatherTextArea.setBounds(49, 88, 352, 45);
		add(weatherTextArea);
		
		btnBackButton = new JButton("New button");
		btnBackButton.setBounds(167, 265, 117, 29);
		add(btnBackButton);
		
		quoteLabel = new JLabel("Quote");
		quoteLabel.setBounds(194, 60, 61, 16);
		add(quoteLabel);
		
		weatherLabel = new JLabel("Weather");
		weatherLabel.setBounds(194, 145, 61, 16);
		add(weatherLabel);
	}
	public JTextArea getQuoteTextArea() {
		return quoteTextArea;
	}
	public JTextArea getWeatherTextArea() {
		return weatherTextArea;
	}
	public JButton getBtnBackButton() {
		return btnBackButton;
	}

	
}
