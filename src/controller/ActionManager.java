package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private OpenWorkspaceAction openWorkspaceAction;
	
	private AboutAction aboutAction;
	
	private NewProjectAction newProjectAction;
	
	private NewDocumentAction newDocumentAction;
	private OpenDocumentAction openDocumentAction;
	
	private SaveAction saveAction;
	
	private ActionManager() {
		openWorkspaceAction = new OpenWorkspaceAction();
		
		aboutAction = new AboutAction();
		
		newProjectAction = new NewProjectAction();
		
		newDocumentAction = new NewDocumentAction();
		openDocumentAction = new OpenDocumentAction();
		
		saveAction = new SaveAction();
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
	
	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}
	
	public OpenDocumentAction getOpenDocumentAction() {
		return openDocumentAction;
	}

	public SaveAction getSaveAction() {
		return saveAction;
	}
	
	public static ActionManager getInstance() {
		if(instance==null) {
			instance=new ActionManager();
		}
		return instance;
	}
}
