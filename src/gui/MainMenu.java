package gui;

import javax.swing.JMenu;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AboutAction;
import controller.ActionManager;

public class MainMenu extends JMenuBar {
	public MainMenu() {
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		/*JMenuItem About = new JMenuItem("About");
		About.addActionListener(new AboutActionListener());
		help.add(About);*/
		
		help.add(ActionManager.getInstance().getAboutAction());
		
		add(file);
		add(edit);
		add(help);
		
	}
}
