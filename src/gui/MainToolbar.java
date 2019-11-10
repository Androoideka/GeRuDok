package gui;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class MainToolbar extends JToolBar {
	public MainToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		add(ActionManager.getInstance().getNewProjectAction());
		
		addSeparator();
		
		add(ActionManager.getInstance().getNewDocumentAction());
		add(ActionManager.getInstance().getOpenDocumentAction());
		
		addSeparator();
		
		add(ActionManager.getInstance().getSaveAction());
		add(ActionManager.getInstance().getRenameAction());
		add(ActionManager.getInstance().getDeleteAction());
	}
}
