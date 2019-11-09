package controller;


public class ActionManager {
	private static ActionManager instance=null;
	
	private AboutAction aboutAction;
	
	private NewProjectAction newProjectAction;
	private NewDocumentAction newDocumentAction;
	
	private ActionManager() {
		aboutAction=new AboutAction();
		newDocumentAction=new NewDocumentAction();
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
	
	public static ActionManager getInstance() {
		if(instance==null) {
			instance=new ActionManager();
		}
		return instance;
	}
}
