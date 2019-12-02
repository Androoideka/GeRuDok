package gui;

import javax.swing.AbstractAction;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class MainToolbar extends JToolBar {
	public MainToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		//add(ActionManager.getInstance().getNewProjectAction());
		//add(ActionManager.getInstance().getOpenProjectAction());
		
		for(AbstractAction a : ActionManager.getInstance().getFileActions()) {
			add(a);
		}
		
		addSeparator();
		
		//add(ActionManager.getInstance().getNewDocumentAction());
		//add(ActionManager.getInstance().getOpenDocumentAction());
		
		for(AbstractAction a : ActionManager.getInstance().getEditActions()) {
			add(a);
		}
		
		//addSeparator();
		
		//add(ActionManager.getInstance().getSavePrjAction());
		//add(ActionManager.getInstance().getRenameAction());
		//add(ActionManager.getInstance().getDeleteAction());
	}
}
