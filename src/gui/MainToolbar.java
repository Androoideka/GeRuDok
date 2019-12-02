package gui;

import javax.swing.AbstractAction;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class MainToolbar extends JToolBar {
	public MainToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		for(AbstractAction a : ActionManager.getInstance().getFileActions()) {
			add(a);
		}
		
		addSeparator();
		
		for(AbstractAction a : ActionManager.getInstance().getEditActions()) {
			add(a);
		}
	}
}
