package controller;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

public class ActionManager {
	private static ActionManager instance=null;
	
	private AbstractAction newAction;
	private List<AbstractAction> fileActions = new ArrayList<>();
	private List<AbstractAction> editActions = new ArrayList<>();
	private List<AbstractAction> helpActions = new ArrayList<>();
	private List<MouseAdapter> mouseListeners = new ArrayList<>();
	
	private ActionManager() {
		newAction = new NewAction();
		
		fileActions.add(new OpenWorkspaceAction());
		
		fileActions.add(new NewProjectAction());
		fileActions.add(new OpenProjectAction());
		
		fileActions.add(new NewDocumentAction());
		fileActions.add(new OpenDocumentAction());
		
		fileActions.add(new SaveAction());
		//fileActions.add(new SaveAsAction());
		
		editActions.add(new RenameAction());
		editActions.add(new DeleteAction());
		
		mouseListeners.add(new PopupListener());
		mouseListeners.add(new AddTabsAction());
		
		helpActions.add(new AboutAction());
	}

	public List<AbstractAction> getFileActions() {
		return fileActions;
	}

	public List<AbstractAction> getEditActions() {
		return editActions;
	}

	public List<AbstractAction> getHelpActions() {
		return helpActions;
	}

	public List<MouseAdapter> getMouseListeners() {
		return mouseListeners;
	}

	public AbstractAction getNewAction() {
		return newAction;
	}

	public static ActionManager getInstance() {
		if(instance==null) {
			instance=new ActionManager();
		}
		return instance;
	}
}
