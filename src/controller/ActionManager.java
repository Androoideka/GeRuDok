package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private OpenWorkspaceAction openWorkspaceAction;
	
	private AboutAction aboutAction;
	
	private NewProjectAction newProjectAction;
	private OpenProjectAction openProjectAction;
	
	private NewDocumentAction newDocumentAction;
	private OpenDocumentAction openDocumentAction;
	
	private SaveProjectAction saveAction;
	private RenameAction renameAction;
	private DeleteAction deleteAction;
	
	private PopupListener popupListener;
	
	private AddTabsAction addTabsAction;
	
	private ActionManager() {
		openWorkspaceAction = new OpenWorkspaceAction();
		
		aboutAction = new AboutAction();
		
		newProjectAction = new NewProjectAction();
		openProjectAction = new OpenProjectAction();
		
		newDocumentAction = new NewDocumentAction();
		openDocumentAction = new OpenDocumentAction();
		
		saveAction = new SaveProjectAction();
		renameAction = new RenameAction();
		deleteAction = new DeleteAction();
		
		popupListener = new PopupListener();
		
		addTabsAction = new AddTabsAction();
	}
	
	public OpenWorkspaceAction getOpenWorkspaceAction() {
		return openWorkspaceAction;
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

	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}
	
	public OpenDocumentAction getOpenDocumentAction() {
		return openDocumentAction;
	}

	public SaveProjectAction getSaveAction() {
		return saveAction;
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
	}

	public static ActionManager getInstance() {
		if(instance==null) {
			instance=new ActionManager();
		}
		return instance;
	}
}
