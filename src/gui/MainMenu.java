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
		
		file.add(ActionManager.getInstance().getOpenWorkspaceAction());
		
		help.add(ActionManager.getInstance().getAboutAction());
		
		add(file);
		add(edit);
		add(help);
	}
}
