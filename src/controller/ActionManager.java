package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private AboutAction aboutAction;
	
	private NewProjectAction newProjectAction;
	
	private NewDocumentAction newDocumentAction;
	private OpenDocumentAction openDocumentAction;
	
	private SaveAction saveAction;
	
	private ActionManager() {
		aboutAction=new AboutAction();
		
		newProjectAction=new NewProjectAction();
		
		newDocumentAction=new NewDocumentAction();
		openDocumentAction = new OpenDocumentAction();
		
		saveAction = new SaveAction();
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
