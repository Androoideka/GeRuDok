package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar {
	public MainMenu() {
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		JMenuItem About = new JMenuItem("About");
		help.add(About);
		
		add(file);
		add(edit);
		add(help);
	}
}
