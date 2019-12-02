package controller;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;

public class ActionManager {
	private static ActionManager instance=null;
	
	/*private OpenWorkspaceAction openWorkspaceAction;
	private SaveWorkspaceAction saveWorkspaceAction;
	
	private AboutAction aboutAction;
	
	private NewProjectAction newProjectAction;
	private OpenProjectAction openProjectAction;
	private SaveProjectAction saveProjectAction;
	
	private NewDocumentAction newDocumentAction;
	private OpenDocumentAction openDocumentAction;
	private SaveDocumentAction saveDocumentAction;
	
	private RenameAction renameAction;
	private DeleteAction deleteAction;
	
	private PopupListener popupListener;
	
	private AddTabsAction addTabsAction;
	
	private ActionManager() {
		/*openWorkspaceAction = new OpenWorkspaceAction();
		saveWorkspaceAction = new SaveWorkspaceAction();
		
		aboutAction = new AboutAction();
		
		newProjectAction = new NewProjectAction();
		openProjectAction = new OpenProjectAction();
		saveProjectAction = new SaveProjectAction();
		
		newDocumentAction = new NewDocumentAction();
		openDocumentAction = new OpenDocumentAction();
		saveDocumentAction = new SaveDocumentAction();
		
		renameAction = new RenameAction();
		deleteAction = new DeleteAction();
		
		popupListener = new PopupListener();
		
		addTabsAction = new AddTabsAction();
	}
	
	/*public OpenWorkspaceAction getOpenWorkspaceAction() {
		return openWorkspaceAction;
	}
	
	public SaveWorkspaceAction getSaveWorkspaceAction() {
		return saveWorkspaceAction;
	}
	
	public AboutAction getAboutAction() {
		return aboutAction;
	}
	
	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}
	
	public OpenProjectAction getOpenProjectAction() {
		return openProjectAction;
	}
	public SaveProjectAction getSavePrjAction() {
		return saveProjectAction;
	}
	
	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}
	
	public OpenDocumentAction getOpenDocumentAction() {
		return openDocumentAction;
	}
	
	public SaveDocumentAction getSaveDocumentAction() {
		return saveDocumentAction;
	}
	
	public RenameAction getRenameAction() {
		return renameAction;
	}

	public DeleteAction getDeleteAction() {
		return deleteAction;
	}

	public PopupListener getPopupListener() {
		return popupListener;
	}
	
	public AddTabsAction getAddTabsAction() {
		return addTabsAction;
	}*/
	
	private AbstractAction newAction;
	private List<AbstractAction> fileActions = new ArrayList<>();
	private List<AbstractAction> editActions = new ArrayList<>();
	private List<AbstractAction> helpActions = new ArrayList<>();
	private List<MouseAdapter> mouseListeners = new ArrayList<>();
	
	private ActionManager() {
		newAction = new NewAction();
		
		fileActions.add(new OpenWorkspaceAction());
		fileActions.add(new SaveWorkspaceAction());
		
		fileActions.add(new NewProjectAction());
		fileActions.add(new OpenProjectAction());
		
		fileActions.add(new NewDocumentAction());
		fileActions.add(new OpenDocumentAction());
		
		//fileActions.add(new SaveAction());
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
