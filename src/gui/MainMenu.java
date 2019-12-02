package gui;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import controller.ActionManager;

public class MainMenu extends JMenuBar {
	public MainMenu() {
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");

		for(AbstractAction a : ActionManager.getInstance().getFileActions()) {
			file.add(a);
		}
		
		for(AbstractAction a : ActionManager.getInstance().getEditActions()) {
			edit.add(a);
		}
		
		for(AbstractAction a : ActionManager.getInstance().getHelpActions()) {
			help.add(a);
		}
		
		add(file);
		add(edit);
		add(help);
	}
}
