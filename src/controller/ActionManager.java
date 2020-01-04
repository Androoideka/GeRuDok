package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.text.BadLocationException;

import designmode.controller.BoldAction;
import designmode.controller.ChangeFontAction;
import designmode.controller.ChangeFontSizeAction;
import designmode.controller.CircleAction;
import designmode.controller.CopyAction;
import designmode.controller.CutAction;
import designmode.controller.DeleteSlotAction;
import designmode.controller.ItalicAction;
import designmode.controller.PasteAction;
import designmode.controller.RectangleAction;
import designmode.controller.RedoAction;
import designmode.controller.SelectAction;
import designmode.controller.TriangleAction;
import designmode.controller.UnderlineAction;
import designmode.controller.UndoAction;
import document.controller.CloseAction;
import workspace.controller.DeleteAction;
import workspace.controller.LinkAction;
import workspace.controller.NewAction;
import workspace.controller.OpenAction;
import workspace.controller.RenameAction;
import workspace.controller.SaveAction;
import workspace.controller.SaveAsAction;
import workspace.controller.SwitchWorkspaceAction;
import workspace.controller.UnlinkAction;

public class ActionManager {
	private static ActionManager instance=null;
	
	private AbstractAction newAction;
	private List<AbstractAction> fileActions = new ArrayList<>();
	private List<AbstractAction> commandActions = new ArrayList<>();
	private List<AbstractAction> manipulateActions = new ArrayList<>();
	private List<AbstractAction> documentActions = new ArrayList<>();
	private List<AbstractAction> helpActions = new ArrayList<>();
	private List<AbstractAction> viewActions = new ArrayList<>();
	private List<AbstractAction> paletteActions = new ArrayList<>();
	private List<AbstractAction> textEditorActions = new ArrayList<>();
	
	private ActionManager() {
		newAction = new NewAction();
				
		fileActions.add(new NewAction());
		
		fileActions.add(new OpenAction());
		
		fileActions.add(new SwitchWorkspaceAction());
		
		fileActions.add(new SaveAsAction());
		
		fileActions.add(new SaveAction());
		
		commandActions.add(new UndoAction());
		commandActions.add(new RedoAction());
		
		commandActions.add(new CutAction());
		commandActions.add(new CopyAction());
		commandActions.add(new PasteAction());
		
		manipulateActions.add(new RenameAction());
		manipulateActions.add(new DeleteAction());
		
		documentActions.add(new LinkAction());
		documentActions.add(new UnlinkAction());
		
		viewActions.add(new CloseAction());
		
		helpActions.add(new AboutAction());
		
		paletteActions.add(new SelectAction());
		paletteActions.add(new RectangleAction());
		paletteActions.add(new CircleAction());
		paletteActions.add(new TriangleAction());
		paletteActions.add(new DeleteSlotAction());
		
		textEditorActions.add(new ChangeFontAction());
		textEditorActions.add(new ChangeFontSizeAction());
		textEditorActions.add(new BoldAction());
		textEditorActions.add(new ItalicAction());
		textEditorActions.add(new UnderlineAction());
	}

	public List<AbstractAction> getFileActions() {
		return fileActions;
	}

	public List<AbstractAction> getCommandActions() {
		return commandActions;
	}

	public List<AbstractAction> getManipulateActions() {
		return manipulateActions;
	}

	public List<AbstractAction> getDocumentActions() {
		return documentActions;
	}

	public List<AbstractAction> getEditActions() {
		ArrayList<AbstractAction> editActions = new ArrayList<>();
		editActions.addAll(commandActions);
		editActions.addAll(manipulateActions);
		editActions.addAll(documentActions);
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
	
	public List<AbstractAction> getTextEditorActions(){
		return textEditorActions;
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
