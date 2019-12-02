package gui;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import controller.ActionManager;
import model.workspace.Document;
import model.workspace.Project;
import model.workspace.Workspace;

public class TreePopupMenu extends JPopupMenu {

	public TreePopupMenu(Object node) {
		super();
		/*if(node instanceof Workspace) {
			add(ActionManager.getInstance().getNewProjectAction());
			addSeparator();
		}
		if(node instanceof Project) {
			add(ActionManager.getInstance().getNewDocumentAction());
			addSeparator();
		}
		if(node instanceof Document) {
		}*/
		
		add(ActionManager.getInstance().getNewAction());
		for(AbstractAction a : ActionManager.getInstance().getEditActions()) {
			add(a);
		}
		//add(ActionManager.getInstance().getDeleteAction());
		//add(ActionManager.getInstance().getRenameAction());
	}
}
