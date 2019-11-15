package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import controller.ActionManager;

public class MainMenu extends JMenuBar {
	public MainMenu() {
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		JMenu fileNew = new JMenu("New");
		
		file.add(fileNew);
		
		fileNew.add(ActionManager.getInstance().getNewProjectAction());
		
		file.add(ActionManager.getInstance().getOpenWorkspaceAction());
		
		help.add(ActionManager.getInstance().getAboutAction());
		
		add(file);
		add(edit);
		add(help);
	}
}
