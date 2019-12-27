package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

import designmode.controller.CircleAction;
import designmode.controller.DeleteSlotAction;
import designmode.controller.RectangleAction;
import designmode.controller.SelectAction;
import designmode.controller.TriangleAction;
import document.controller.CloseAction;
import workspace.controller.DeleteAction;
import workspace.controller.NewAction;
import workspace.controller.OpenAction;
import workspace.controller.RenameAction;
import workspace.controller.SaveAction;
import workspace.controller.SaveAsAction;
import workspace.controller.SwitchWorkspaceAction;

public class ActionManager {
	private static ActionManager instance=null;
	
	private AbstractAction newAction;
	private List<AbstractAction> fileActions = new ArrayList<>();
	private List<AbstractAction> editActions = new ArrayList<>();
	private List<AbstractAction> helpActions = new ArrayList<>();
	private List<AbstractAction> viewActions = new ArrayList<>();
	private List<AbstractAction> paletteActions = new ArrayList<>();
	
	private ActionManager() {
		newAction = new NewAction();
				
		fileActions.add(new NewAction());
		
		fileActions.add(new OpenAction());
		
		fileActions.add(new SwitchWorkspaceAction());
		
		fileActions.add(new SaveAsAction());
		
		fileActions.add(new SaveAction());
		
		editActions.add(new RenameAction());
		editActions.add(new DeleteAction());
		
		viewActions.add(new CloseAction());
		
		helpActions.add(new AboutAction());
		
		paletteActions.add(new SelectAction());
		paletteActions.add(new RectangleAction());
		paletteActions.add(new CircleAction());
		paletteActions.add(new TriangleAction());
		paletteActions.add(new DeleteSlotAction());
	}

	public List<AbstractAction> getFileActions() {
		return fileActions;
	}

	public List<AbstractAction> getEditActions() {
		return editActions;
	}
	
	public List<AbstractAction> getViewActions() {
		return viewActions;
	}

	public List<AbstractAction> getHelpActions() {
		return helpActions;
	}
	
	public List<AbstractAction> getPaletteActions() {
		return paletteActions;
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
