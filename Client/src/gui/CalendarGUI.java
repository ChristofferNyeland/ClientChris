package gui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class CalendarGUI extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	public CalendarGUI() {
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(550, 201, 10, 100);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}
