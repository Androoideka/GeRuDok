package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ActionManager;

public class MainMenu extends JMenuBar {
	public MainMenu() {
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		JMenu fileNew = new JMenu("New");
		JMenuItem newProject = new JMenuItem("Project");
		
		file.add(fileNew);
		
		fileNew.add(newProject);
		
		
		file.add(ActionManager.getInstance().getOpenWorkspaceAction());
		
		help.add(ActionManager.getInstance().getAboutAction());
		
		add(file);
		add(edit);
		add(help);
	}
}
