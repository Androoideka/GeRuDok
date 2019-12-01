package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private OpenWorkspaceAction openWorkspaceAction;
	
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
		openWorkspaceAction = new OpenWorkspaceAction();
		
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
	}

	public static ActionManager getInstance() {
		if(instance==null) {
			instance=new ActionManager();
		}
		return instance;
	}
}
